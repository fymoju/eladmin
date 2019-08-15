package me.zhengjie.modules.system.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import me.zhengjie.modules.system.dao.AppModelRepository;
import me.zhengjie.modules.system.dojo.AppModel;
import me.zhengjie.modules.system.service.AppModelService;
import me.zhengjie.modules.system.service.dto.AppModelQueryCriteria;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.QueryHelp;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AppModelServiceImpl implements AppModelService {
    public Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AppModelRepository appModelRepository;
    @Autowired
    private RepositoryService repositoryService;
    @Override
    public Object queryAll(AppModelQueryCriteria criteria, Pageable pageable) {
        Page<AppModel> page = appModelRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return PageUtil.toPage(page);
    }

    @Override
    public Model carete(AppModel appModel) throws UnsupportedEncodingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode editorNode = objectMapper.createObjectNode();
        editorNode.put("id", "canvas");
        editorNode.put("resourceId", "canvas");
        ObjectNode stencilSetNode = objectMapper.createObjectNode();
        stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
        editorNode.put("stencilset", stencilSetNode);
        Model modelData = repositoryService.newModel();


        modelData.setKey(StringUtils.defaultString(appModel.getKey()));
        modelData.setName(appModel.getName());
        modelData.setCategory(appModel.getCategory());
        modelData.setVersion(Integer.parseInt(String.valueOf(repositoryService.createModelQuery().modelKey(modelData.getKey()).count()+1)));


        ObjectNode modelObjectNode = objectMapper.createObjectNode();
        modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, appModel.getName());
        modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, modelData.getVersion());
//        modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);

        modelData.setMetaInfo(modelObjectNode.toString());

        repositoryService.saveModel(modelData);
        repositoryService.addModelEditorSource(modelData.getId(), editorNode.toString().getBytes("utf-8"));
        return modelData;
    }

    @Override
    public String deploy(String id) {
        String message = "";
        try {
            Model modelData = repositoryService.getModel(id);
            BpmnJsonConverter jsonConverter = new BpmnJsonConverter();
            ObjectNode editorNode = null;
            editorNode = (ObjectNode) new ObjectMapper().readTree(repositoryService.getModelEditorSource(modelData.getId()));
            BpmnModel bpmnModel = jsonConverter.convertToBpmnModel(editorNode);
            BpmnXMLConverter xmlConverter = new BpmnXMLConverter();
            byte[] bpmnBytes = xmlConverter.convertToXML(bpmnModel);

            String processName = modelData.getName();
            if (!StringUtils.endsWith(processName, ".bpmn20.xml")){
                processName += ".bpmn20.xml";
            }
            ByteArrayInputStream in = new ByteArrayInputStream(bpmnBytes);
            Deployment deployment = repositoryService.createDeployment().name(modelData.getName())
                    .addInputStream(processName, in).deploy();
            List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).list();
            for (ProcessDefinition processDefinition : list) {
                repositoryService.setProcessDefinitionCategory(processDefinition.getId(), modelData.getCategory());
                message = "部署成功，流程ID=" + processDefinition.getId();
            }
            if (list.size() == 0){
                message = "部署失败，没有流程。";
            }
        } catch (IOException e) {
            throw new ActivitiException("设计模型图不正确，检查模型正确性，模型ID="+id, e);
        }
        return message;

}
    @Override
    public void deleteMoleder(String id) {
        repositoryService.deleteModel(id);
    }
}

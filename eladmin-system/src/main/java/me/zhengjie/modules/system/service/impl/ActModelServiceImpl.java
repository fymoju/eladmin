package me.zhengjie.modules.system.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import me.zhengjie.modules.system.dao.ActModelRepository;
import me.zhengjie.modules.system.dojo.ModelA;
import me.zhengjie.modules.system.service.ActModelService;
import me.zhengjie.modules.system.service.dto.ModelDto;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.QueryHelp;
import org.activiti.engine.RepositoryService;


import org.activiti.engine.repository.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;


@Service
@Transactional
public class ActModelServiceImpl implements ActModelService {

    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private ActModelRepository actModelRepository;

    @Override
    public Object queryAll(ModelDto criteria, Pageable pageable) {
        //ModelQuery modelQuery = repositoryService.createModelQuery().latestVersion().orderByLastUpdateTime().desc();
        Page<ModelA> page = actModelRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page);
    }

    @Override
    public Model create(ModelA resources) throws UnsupportedEncodingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode editorNode = objectMapper.createObjectNode();
        editorNode.put("id", "canvas");
        editorNode.put("resourceId", "canvas");
        ObjectNode stencilSetNode = objectMapper.createObjectNode();
        stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
        editorNode.put("stencilset", stencilSetNode);
        org.activiti.engine.repository.Model modelData = repositoryService.newModel();

        //   description = StringUtils.defaultString(description);

      /*  modelData.setKey(StringUtils.defaultString(key));
        modelData.setName(name);
        modelData.setCategory(category);
        modelData.setVersion(Integer.parseInt(String.valueOf(repositoryService.createModelQuery().modelKey(modelData.getKey()).count()+1)));

        ObjectNode modelObjectNode = objectMapper.createObjectNode();
        modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, name);
        modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, modelData.getVersion());
        // modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
        modelData.setMetaInfo(modelObjectNode.toString());*/

        repositoryService.saveModel(modelData);
        repositoryService.addModelEditorSource(modelData.getId(), editorNode.toString().getBytes("utf-8"));
        return modelData;
    }

    /*@Override
    public Model create(String name, String key, String category) throws UnsupportedEncodingException {

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode editorNode = objectMapper.createObjectNode();
        editorNode.put("id", "canvas");
        editorNode.put("resourceId", "canvas");
        ObjectNode stencilSetNode = objectMapper.createObjectNode();
        stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
        editorNode.put("stencilset", stencilSetNode);
        org.activiti.engine.repository.Model modelData = repositoryService.newModel();

     //   description = StringUtils.defaultString(description);
        modelData.setKey(StringUtils.defaultString(key));
        modelData.setName(name);
        modelData.setCategory(category);
        modelData.setVersion(Integer.parseInt(String.valueOf(repositoryService.createModelQuery().modelKey(modelData.getKey()).count()+1)));

        ObjectNode modelObjectNode = objectMapper.createObjectNode();
        modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, name);
        modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, modelData.getVersion());
       // modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
        modelData.setMetaInfo(modelObjectNode.toString());

        repositoryService.saveModel(modelData);
        repositoryService.addModelEditorSource(modelData.getId(), editorNode.toString().getBytes("utf-8"));

        //return modelData;
        return modelData;
    }*/
}

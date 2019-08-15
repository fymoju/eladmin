package me.zhengjie.modules.system.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.system.dojo.AppModel;
import me.zhengjie.modules.system.service.AppModelService;
import me.zhengjie.modules.system.service.dto.AppModelQueryCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("api")
public class AppModelController {
    public Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AppModelService appModelService;
    @Log("查询常用流程模型")
    @GetMapping("/modeler")
    @PreAuthorize("hasAnyRole('ADMIN','AppFrom_All','AppFrom_SELECT')")
    public ResponseEntity getAppFrom(AppModelQueryCriteria criteria, Pageable pageable) {
        logger.info("这里你走了嘛？？？");
        logger.warn("输出一下：=="+appModelService.queryAll(criteria, pageable));
        return new ResponseEntity(appModelService.queryAll(criteria, pageable), HttpStatus.OK);
    }


    @Log("新增流程模型")
    @PostMapping("/modeler")
    @PreAuthorize("hasAnyRole('ADMIN','AppFrom_All','AppFrom_CREATE')")
    public ResponseEntity create(@Validated @RequestBody AppModel resources) throws UnsupportedEncodingException {
        logger.warn("新增的时候传参="+resources);
        return new ResponseEntity(appModelService.carete(resources), HttpStatus.CREATED);
    }

    @Log("部署流程")
    @PostMapping(value = "/modeler/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','AppFrom_All','AppFrom_CREATE')")
    public ResponseEntity deploy(@PathVariable String id){
        logger.warn("部署时传过来的id是："+id);
        String message = appModelService.deploy(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Log("删除流程")
    @DeleteMapping(value = "/modeler/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','AppFrom_All','AppFrom_CREATE')")
    public ResponseEntity deleteMoleder(@PathVariable String id){
        logger.warn("传过来的id是什么："+id);
        appModelService.deleteMoleder(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @Log("现在设计图")
    @PostMapping(value = "/appmodeler")
    @PreAuthorize("hasAnyRole('ADMIN','AppFrom_All','AppFrom_CREATE')")
    public ResponseEntity appmodeler(@Validated @RequestBody Object params){
        logger.warn("传过来的id是什么："+params);
//        appModelService.deleteMoleder(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

package me.zhengjie.modules.system.rest;

import me.zhengjie.aop.log.Log;

import me.zhengjie.modules.system.dojo.ModelA;
import me.zhengjie.modules.system.dojo.Order;
import me.zhengjie.modules.system.service.ActModelService;

import me.zhengjie.modules.system.service.dto.ModelDto;
import org.activiti.engine.RepositoryService;
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
public class ActModelController {

    @Autowired
    private ActModelService actModelService;



    @Log("查询流程")
    @GetMapping("/act")
    @PreAuthorize("hasAnyRole('ADMIN','ACT_ALL','ACT_SELECT')")
    public ResponseEntity getOrder(ModelDto criteria, Pageable pageable){
        return new ResponseEntity(actModelService.queryAll(criteria,pageable), HttpStatus.OK);

    }

    @Log("新增流程")
    @PostMapping("/act")
    @PreAuthorize("hasAnyRole('ADMIN','ACT_ALL','ACT_CREATE')")
    public ResponseEntity create(@Validated @RequestBody ModelA resources) throws UnsupportedEncodingException {
        System.out.println(111);
        return new ResponseEntity(actModelService.create(resources),HttpStatus.CREATED);
    }

}

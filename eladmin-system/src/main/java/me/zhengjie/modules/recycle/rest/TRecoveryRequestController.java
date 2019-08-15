package me.zhengjie.modules.recycle.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.recycle.domain.TRecoveryRequest;
import me.zhengjie.modules.recycle.service.TRecoveryRequestService;
import me.zhengjie.modules.recycle.service.dto.TRecoveryRequestQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

/**
* @author jie
* @date 2019-08-15
*/
@Api(tags = "TRecoveryRequest管理")
@RestController
@RequestMapping("api")
public class TRecoveryRequestController {

    @Autowired
    private TRecoveryRequestService tRecoveryRequestService;

    @Log("查询TRecoveryRequest")
    @ApiOperation(value = "查询TRecoveryRequest")
    @GetMapping(value = "/tRecoveryRequest")
    @PreAuthorize("hasAnyRole('ADMIN','TRECOVERYREQUEST_ALL','TRECOVERYREQUEST_SELECT')")
    public ResponseEntity getTRecoveryRequests(TRecoveryRequestQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(tRecoveryRequestService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增TRecoveryRequest")
    @ApiOperation(value = "新增TRecoveryRequest")
    @PostMapping(value = "/tRecoveryRequest")
    @PreAuthorize("hasAnyRole('ADMIN','TRECOVERYREQUEST_ALL','TRECOVERYREQUEST_CREATE')")
    public ResponseEntity create(@Validated @RequestBody TRecoveryRequest resources){
        return new ResponseEntity(tRecoveryRequestService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改TRecoveryRequest")
    @ApiOperation(value = "修改TRecoveryRequest")
    @PutMapping(value = "/tRecoveryRequest")
    @PreAuthorize("hasAnyRole('ADMIN','TRECOVERYREQUEST_ALL','TRECOVERYREQUEST_EDIT')")
    public ResponseEntity update(@Validated @RequestBody TRecoveryRequest resources){
        tRecoveryRequestService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除TRecoveryRequest")
    @ApiOperation(value = "删除TRecoveryRequest")
    @DeleteMapping(value = "/tRecoveryRequest/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','TRECOVERYREQUEST_ALL','TRECOVERYREQUEST_DELETE')")
    public ResponseEntity delete(@PathVariable Long id){
        tRecoveryRequestService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
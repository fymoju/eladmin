package me.zhengjie.modules.recycle.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.recycle.domain.TRecoveryInto;
import me.zhengjie.modules.recycle.service.TRecoveryIntoService;
import me.zhengjie.modules.recycle.service.dto.TRecoveryIntoQueryCriteria;
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
@Api(tags = "TRecoveryInto管理")
@RestController
@RequestMapping("api")
public class TRecoveryIntoController {

    @Autowired
    private TRecoveryIntoService tRecoveryIntoService;

    @Log("查询TRecoveryInto")
    @ApiOperation(value = "查询TRecoveryInto")
    @GetMapping(value = "/tRecoveryInto")
    @PreAuthorize("hasAnyRole('ADMIN','TRECOVERYINTO_ALL','TRECOVERYINTO_SELECT')")
    public ResponseEntity getTRecoveryIntos(TRecoveryIntoQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(tRecoveryIntoService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增TRecoveryInto")
    @ApiOperation(value = "新增TRecoveryInto")
    @PostMapping(value = "/tRecoveryInto")
    @PreAuthorize("hasAnyRole('ADMIN','TRECOVERYINTO_ALL','TRECOVERYINTO_CREATE')")
    public ResponseEntity create(@Validated @RequestBody TRecoveryInto resources){
        return new ResponseEntity(tRecoveryIntoService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改TRecoveryInto")
    @ApiOperation(value = "修改TRecoveryInto")
    @PutMapping(value = "/tRecoveryInto")
    @PreAuthorize("hasAnyRole('ADMIN','TRECOVERYINTO_ALL','TRECOVERYINTO_EDIT')")
    public ResponseEntity update(@Validated @RequestBody TRecoveryInto resources){
        tRecoveryIntoService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除TRecoveryInto")
    @ApiOperation(value = "删除TRecoveryInto")
    @DeleteMapping(value = "/tRecoveryInto/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','TRECOVERYINTO_ALL','TRECOVERYINTO_DELETE')")
    public ResponseEntity delete(@PathVariable Long id){
        tRecoveryIntoService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
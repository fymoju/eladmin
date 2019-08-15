package me.zhengjie.modules.recycle.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.recycle.domain.TCompanyFreight;
import me.zhengjie.modules.recycle.service.TCompanyFreightService;
import me.zhengjie.modules.recycle.service.dto.TCompanyFreightQueryCriteria;
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
@Api(tags = "TCompanyFreight管理")
@RestController
@RequestMapping("api")
public class TCompanyFreightController {

    @Autowired
    private TCompanyFreightService tCompanyFreightService;

    @Log("查询TCompanyFreight")
    @ApiOperation(value = "查询TCompanyFreight")
    @GetMapping(value = "/tCompanyFreight")
    @PreAuthorize("hasAnyRole('ADMIN','TCOMPANYFREIGHT_ALL','TCOMPANYFREIGHT_SELECT')")
    public ResponseEntity getTCompanyFreights(TCompanyFreightQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(tCompanyFreightService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增TCompanyFreight")
    @ApiOperation(value = "新增TCompanyFreight")
    @PostMapping(value = "/tCompanyFreight")
    @PreAuthorize("hasAnyRole('ADMIN','TCOMPANYFREIGHT_ALL','TCOMPANYFREIGHT_CREATE')")
    public ResponseEntity create(@Validated @RequestBody TCompanyFreight resources){
        return new ResponseEntity(tCompanyFreightService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改TCompanyFreight")
    @ApiOperation(value = "修改TCompanyFreight")
    @PutMapping(value = "/tCompanyFreight")
    @PreAuthorize("hasAnyRole('ADMIN','TCOMPANYFREIGHT_ALL','TCOMPANYFREIGHT_EDIT')")
    public ResponseEntity update(@Validated @RequestBody TCompanyFreight resources){
        tCompanyFreightService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除TCompanyFreight")
    @ApiOperation(value = "删除TCompanyFreight")
    @DeleteMapping(value = "/tCompanyFreight/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','TCOMPANYFREIGHT_ALL','TCOMPANYFREIGHT_DELETE')")
    public ResponseEntity delete(@PathVariable Long id){
        tCompanyFreightService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
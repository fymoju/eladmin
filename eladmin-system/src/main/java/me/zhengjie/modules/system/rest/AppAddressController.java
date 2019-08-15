package me.zhengjie.modules.system.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.system.domain.AppAddress;
import me.zhengjie.modules.system.service.AppAddressService;
import me.zhengjie.modules.system.service.dto.AppAddressQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
* @author jie
* @date 2019-08-12
*/
@Api(tags = "AppAddress管理")
@RestController
@RequestMapping("api")
public class AppAddressController {

    @Autowired
    private AppAddressService appAddressService;

    @Log("查询AppAddress")
    @ApiOperation(value = "查询AppAddress")
    @GetMapping(value = "/appAddress")
    @PreAuthorize("hasAnyRole('ADMIN','APPADDRESS_ALL','APPADDRESS_SELECT')")
    public ResponseEntity getAppAddresss(AppAddressQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(appAddressService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增AppAddress")
    @ApiOperation(value = "新增AppAddress")
    @PostMapping(value = "/appAddress")
    @PreAuthorize("hasAnyRole('ADMIN','APPADDRESS_ALL','APPADDRESS_CREATE')")
    public ResponseEntity create(@Validated @RequestBody AppAddress resources){
        return new ResponseEntity(appAddressService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改AppAddress")
    @ApiOperation(value = "修改AppAddress")
    @PutMapping(value = "/appAddress")
    @PreAuthorize("hasAnyRole('ADMIN','APPADDRESS_ALL','APPADDRESS_EDIT')")
    public ResponseEntity update(@Validated @RequestBody AppAddress resources){
        appAddressService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除AppAddress")
    @ApiOperation(value = "删除AppAddress")
    @DeleteMapping(value = "/appAddress/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','APPADDRESS_ALL','APPADDRESS_DELETE')")
    public ResponseEntity delete(@PathVariable Long id){
        appAddressService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
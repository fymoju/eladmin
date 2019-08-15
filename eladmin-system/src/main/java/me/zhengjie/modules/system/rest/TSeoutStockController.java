package me.zhengjie.modules.system.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.system.dojo.TSeoutStock;
import me.zhengjie.modules.system.service.TSeoutStockService;
import me.zhengjie.modules.system.service.dto.TSeoutStockQueryCriteria;
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
* @date 2019-08-13
*/
@Api(tags = "TSeoutStock管理")
@RestController
@RequestMapping("api")
public class TSeoutStockController {

    @Autowired
    private TSeoutStockService tSeoutStockService;

    @Log("查询TSeoutStock")
    @ApiOperation(value = "查询TSeoutStock")
    @GetMapping(value = "/tSeoutStock")
    @PreAuthorize("hasAnyRole('ADMIN','TSEOUTSTOCK_ALL','TSEOUTSTOCK_SELECT')")
    public ResponseEntity getTSeoutStocks(TSeoutStockQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(tSeoutStockService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增TSeoutStock")
    @ApiOperation(value = "新增TSeoutStock")
    @PostMapping(value = "/tSeoutStock")
    @PreAuthorize("hasAnyRole('ADMIN','TSEOUTSTOCK_ALL','TSEOUTSTOCK_CREATE')")
    public ResponseEntity create(@Validated @RequestBody TSeoutStock resources){
        return new ResponseEntity(tSeoutStockService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改TSeoutStock")
    @ApiOperation(value = "修改TSeoutStock")
    @PutMapping(value = "/tSeoutStock")
    @PreAuthorize("hasAnyRole('ADMIN','TSEOUTSTOCK_ALL','TSEOUTSTOCK_EDIT')")
    public ResponseEntity update(@Validated @RequestBody TSeoutStock resources){
        tSeoutStockService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除TSeoutStock")
    @ApiOperation(value = "删除TSeoutStock")
    @DeleteMapping(value = "/tSeoutStock/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','TSEOUTSTOCK_ALL','TSEOUTSTOCK_DELETE')")
    public ResponseEntity delete(@PathVariable Long id){
        tSeoutStockService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
package me.zhengjie.modules.test.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.test.domain.TbOrder;
import me.zhengjie.modules.test.service.TbOrderService;
import me.zhengjie.modules.test.service.dto.TbOrderQueryCriteria;
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
* @date 2019-08-09
*/
@Api(tags = "TbOrder管理")
@RestController
@RequestMapping("api")
public class TbOrderController {

    @Autowired
    private TbOrderService tbOrderService;

    @Log("查询TbOrder")
    @ApiOperation(value = "查询TbOrder")
    @GetMapping(value = "/tbOrder")
    @PreAuthorize("hasAnyRole('ADMIN','TBORDER_ALL','TBORDER_SELECT')")
    public ResponseEntity getTbOrders(TbOrderQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(tbOrderService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增TbOrder")
    @ApiOperation(value = "新增TbOrder")
    @PostMapping(value = "/tbOrder")
    @PreAuthorize("hasAnyRole('ADMIN','TBORDER_ALL','TBORDER_CREATE')")
    public ResponseEntity create(@Validated @RequestBody TbOrder resources){
        return new ResponseEntity(tbOrderService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改TbOrder")
    @ApiOperation(value = "修改TbOrder")
    @PutMapping(value = "/tbOrder")
    @PreAuthorize("hasAnyRole('ADMIN','TBORDER_ALL','TBORDER_EDIT')")
    public ResponseEntity update(@Validated @RequestBody TbOrder resources){
        tbOrderService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除TbOrder")
    @ApiOperation(value = "删除TbOrder")
    @DeleteMapping(value = "/tbOrder/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','TBORDER_ALL','TBORDER_DELETE')")
    public ResponseEntity delete(@PathVariable Integer id){
        tbOrderService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
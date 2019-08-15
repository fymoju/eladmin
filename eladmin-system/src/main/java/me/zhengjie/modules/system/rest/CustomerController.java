package me.zhengjie.modules.system.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Log("查询客户")
    @GetMapping(value = "/customer")
    @PreAuthorize("hasAnyRole('ADMIN','CUSTOMER_ALL','CUSTOMER_SELECT')")
    public ResponseEntity getCustomer(){
        return new ResponseEntity(customerService.findAll(), HttpStatus.OK);

    }


}

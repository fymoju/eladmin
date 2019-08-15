package me.zhengjie.modules.system.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.system.domain.EmailConfigA;
import me.zhengjie.modules.system.domain.Job;
import me.zhengjie.modules.system.service.EmailConfigServie;
import me.zhengjie.modules.system.service.dto.EmailConfigDTO;
import me.zhengjie.modules.system.service.dto.EmailConfigQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api")
public class EmailConfigController {

    @Autowired
    private EmailConfigServie emailConfigServie;

    private static final String ENTITY_NAME = "email_config";

    @Log("查询")
    @GetMapping("/emailConfig")
    @PreAuthorize("hasAnyRole('ADMIN','EMAIL_ALL','EMAIL_SELECT')")
    /*public ResponseEntity getEmail(EmailConfigDTO resources, Pageable pageable){
        return new ResponseEntity(emailConfigServie.queryAll(resources,pageable), HttpStatus.OK);

    }*/
    public ResponseEntity getEmail(EmailConfigQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(emailConfigServie.queryAll(criteria,pageable), HttpStatus.OK);

    }

    @Log("新增邮件")
    @PostMapping("/emailConfig")
    @PreAuthorize("hasAnyRole('ADMIN','EMAIL_ALL','EMAIL_CREATE')")
    public ResponseEntity create(@Validated @RequestBody EmailConfigA resources){
        return new ResponseEntity(emailConfigServie.create(resources),HttpStatus.CREATED);
    }

    @Log("删除邮件")
    @DeleteMapping(value = "/emailConfig/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','EMAIL_ALL','EMAIL_DELETE')")
    public ResponseEntity delete(@PathVariable Long id){
        emailConfigServie.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @Log("修改邮件")
    @PutMapping(value = "/emailConfig")
    @PreAuthorize("hasAnyRole('ADMIN','EMAIL_ALL','EMAIL_EDIT')")
    public ResponseEntity update(@Validated(EmailConfigA.Update.class) @RequestBody EmailConfigA resources){
        emailConfigServie.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}

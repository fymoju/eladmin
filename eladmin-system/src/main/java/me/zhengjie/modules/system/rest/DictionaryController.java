package me.zhengjie.modules.system.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.modules.system.service.DictionaryService;
import me.zhengjie.modules.system.service.dto.DictionaryQueryCriteria;
import me.zhengjie.modules.system.service.dto.OrderQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class DictionaryController {


    @Autowired
    private DictionaryService dictionaryService;

    private static final String ENTITY_NAME = "dictionary";


    @Log("查询字典类型")
    @GetMapping("/dictionary")
    @PreAuthorize("hasAnyRole('ADMIN','DICTIONARY_ALL','DICTIONARY_SELECT')")
    public ResponseEntity getOrder(){
        return new ResponseEntity(dictionaryService.findAll(), HttpStatus.OK);

    }

}

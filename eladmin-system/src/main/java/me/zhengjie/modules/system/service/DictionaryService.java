package me.zhengjie.modules.system.service;

import me.zhengjie.modules.system.service.dto.DictionaryDTO;
import me.zhengjie.modules.system.service.dto.DictionaryQueryCriteria;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

import java.util.List;

@CacheConfig(cacheNames = "dictionary")
public interface DictionaryService {


   /*  Object queryAll(DictionaryQueryCriteria criteria, Pageable pageable);*/

    Object findAll();

    //Object findDictionariesByMiddleId(Integer middle_id);


}

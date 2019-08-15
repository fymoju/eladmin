package me.zhengjie.modules.system.service;


import me.zhengjie.modules.system.domain.EmailConfigA;
import me.zhengjie.modules.system.service.dto.EmailConfigDTO;
import me.zhengjie.modules.system.service.dto.EmailConfigQueryCriteria;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Pageable;

@CacheConfig(cacheNames = "email")
public interface EmailConfigServie {

   // Object queryAll(EmailConfigDTO emailConfig, Pageable pageable);
    Object queryAll(EmailConfigQueryCriteria criteria, Pageable pageable);

    @CacheEvict(allEntries = true)
    EmailConfigDTO create(EmailConfigA resources);

    @CacheEvict(allEntries = true)
    void delete(Long id);

    @CacheEvict(allEntries = true)
    void update(EmailConfigA resources);
}

package me.zhengjie.modules.recycle.service;

import me.zhengjie.modules.recycle.domain.TRecoveryInto;
import me.zhengjie.modules.recycle.service.dto.TRecoveryIntoDTO;
import me.zhengjie.modules.recycle.service.dto.TRecoveryIntoQueryCriteria;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author jie
* @date 2019-08-15
*/
//@CacheConfig(cacheNames = "tRecoveryInto")
public interface TRecoveryIntoService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(TRecoveryIntoQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(TRecoveryIntoQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    //@Cacheable(key = "#p0")
    TRecoveryIntoDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    TRecoveryIntoDTO create(TRecoveryInto resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(TRecoveryInto resources);

    /**
     * delete
     * @param id
     */
    //@CacheEvict(allEntries = true)
    void delete(Long id);
}
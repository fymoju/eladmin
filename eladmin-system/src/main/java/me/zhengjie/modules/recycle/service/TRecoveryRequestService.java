package me.zhengjie.modules.recycle.service;

import me.zhengjie.modules.recycle.domain.TRecoveryRequest;
import me.zhengjie.modules.recycle.service.dto.TRecoveryRequestDTO;
import me.zhengjie.modules.recycle.service.dto.TRecoveryRequestQueryCriteria;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author jie
* @date 2019-08-15
*/
//@CacheConfig(cacheNames = "tRecoveryRequest")
public interface TRecoveryRequestService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(TRecoveryRequestQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(TRecoveryRequestQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    //@Cacheable(key = "#p0")
    TRecoveryRequestDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    TRecoveryRequestDTO create(TRecoveryRequest resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(TRecoveryRequest resources);

    /**
     * delete
     * @param id
     */
    //@CacheEvict(allEntries = true)
    void delete(Long id);
}
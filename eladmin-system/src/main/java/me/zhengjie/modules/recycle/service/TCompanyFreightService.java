package me.zhengjie.modules.recycle.service;

import me.zhengjie.modules.recycle.domain.TCompanyFreight;
import me.zhengjie.modules.recycle.service.dto.TCompanyFreightDTO;
import me.zhengjie.modules.recycle.service.dto.TCompanyFreightQueryCriteria;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author jie
* @date 2019-08-15
*/
//@CacheConfig(cacheNames = "tCompanyFreight")
public interface TCompanyFreightService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(TCompanyFreightQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(TCompanyFreightQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    //@Cacheable(key = "#p0")
    TCompanyFreightDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    TCompanyFreightDTO create(TCompanyFreight resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(TCompanyFreight resources);

    /**
     * delete
     * @param id
     */
    //@CacheEvict(allEntries = true)
    void delete(Long id);
}
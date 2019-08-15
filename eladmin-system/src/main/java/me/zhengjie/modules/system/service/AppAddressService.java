package me.zhengjie.modules.system.service;

import me.zhengjie.modules.system.domain.AppAddress;
import me.zhengjie.modules.system.service.dto.AppAddressDTO;
import me.zhengjie.modules.system.service.dto.AppAddressQueryCriteria;
import org.springframework.data.domain.Pageable;

//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;

/**
* @author jie
* @date 2019-08-12
*/
//@CacheConfig(cacheNames = "appAddress")
public interface AppAddressService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(AppAddressQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(AppAddressQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    //@Cacheable(key = "#p0")
    AppAddressDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    AppAddressDTO create(AppAddress resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(AppAddress resources);

    /**
     * delete
     * @param id
     */
    //@CacheEvict(allEntries = true)
    void delete(Long id);
}
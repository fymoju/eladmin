package me.zhengjie.modules.system.service;

import me.zhengjie.modules.system.dojo.TSeoutStock;
import me.zhengjie.modules.system.service.dto.TSeoutStockDTO;
import me.zhengjie.modules.system.service.dto.TSeoutStockQueryCriteria;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author jie
* @date 2019-08-13
*/
//@CacheConfig(cacheNames = "tSeoutStock")
public interface TSeoutStockService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(TSeoutStockQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(TSeoutStockQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    //@Cacheable(key = "#p0")
    TSeoutStockDTO findById(Long id);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    TSeoutStockDTO create(TSeoutStock resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(TSeoutStock resources);

    /**
     * delete
     * @param id
     */
    //@CacheEvict(allEntries = true)
    void delete(Long id);

    void save(TSeoutStock tSeoutStock);
}
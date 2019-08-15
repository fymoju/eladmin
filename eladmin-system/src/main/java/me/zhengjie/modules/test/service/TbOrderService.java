package me.zhengjie.modules.test.service;

import me.zhengjie.modules.test.domain.TbOrder;
import me.zhengjie.modules.test.service.dto.TbOrderDTO;
import me.zhengjie.modules.test.service.dto.TbOrderQueryCriteria;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author jie
* @date 2019-08-09
*/
//@CacheConfig(cacheNames = "tbOrder")
public interface TbOrderService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(TbOrderQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(TbOrderQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    //@Cacheable(key = "#p0")
    TbOrderDTO findById(Integer id);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    TbOrderDTO create(TbOrder resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(TbOrder resources);

    /**
     * delete
     * @param id
     */
    //@CacheEvict(allEntries = true)
    void delete(Integer id);
}
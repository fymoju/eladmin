package me.zhengjie.modules.system.service;

import me.zhengjie.modules.system.dojo.Order;
import me.zhengjie.modules.system.service.dto.OrderDTO;
import me.zhengjie.modules.system.service.dto.OrderQueryCriteria;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Pageable;

import java.util.List;

@CacheConfig(cacheNames = "order")
public interface OrderService {


    Object queryAll(OrderQueryCriteria criteria, Pageable pageable);

    @CacheEvict(allEntries = true)
    void delete(Long id);

    @CacheEvict(allEntries = true)
    OrderDTO create(Order resources);

    @CacheEvict(allEntries = true)
    void update(Order resources);

    @CacheEvict(allEntries = true)
    List<Order> findById(Long id);

    @CacheEvict(allEntries = true)
    ProcessInstance start(String userName);

    Object startVac(String username,Order order,String processInstance);


    Object passAudit(String username, Long id, String processInstance);
}

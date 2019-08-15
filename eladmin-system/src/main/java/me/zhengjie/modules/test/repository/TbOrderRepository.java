package me.zhengjie.modules.test.repository;

import me.zhengjie.modules.test.domain.TbOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author jie
* @date 2019-08-09
*/
public interface TbOrderRepository extends JpaRepository<TbOrder, Integer>, JpaSpecificationExecutor {
}
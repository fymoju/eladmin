package me.zhengjie.modules.system.dao;

import me.zhengjie.modules.system.dojo.TSeoutStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author jie
* @date 2019-08-13
*/
public interface TSeoutStockRepository extends JpaRepository<TSeoutStock, Long>, JpaSpecificationExecutor {
}
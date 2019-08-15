package me.zhengjie.modules.recycle.repository;

import me.zhengjie.modules.recycle.domain.TRecoveryInto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author jie
* @date 2019-08-15
*/
public interface TRecoveryIntoRepository extends JpaRepository<TRecoveryInto, Long>, JpaSpecificationExecutor {
}
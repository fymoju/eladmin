package me.zhengjie.modules.recycle.repository;

import me.zhengjie.modules.recycle.domain.TRecoveryRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author jie
* @date 2019-08-15
*/
public interface TRecoveryRequestRepository extends JpaRepository<TRecoveryRequest, Long>, JpaSpecificationExecutor {
}
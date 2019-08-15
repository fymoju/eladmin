package me.zhengjie.modules.system.repository;

import me.zhengjie.modules.system.domain.AppAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author jie
* @date 2019-08-12
*/
public interface AppAddressRepository extends JpaRepository<AppAddress, Long>, JpaSpecificationExecutor {
}
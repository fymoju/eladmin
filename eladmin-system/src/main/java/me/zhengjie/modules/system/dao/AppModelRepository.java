package me.zhengjie.modules.system.dao;

import me.zhengjie.modules.system.dojo.AppModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AppModelRepository extends JpaRepository<AppModel,Long>, JpaSpecificationExecutor {
}

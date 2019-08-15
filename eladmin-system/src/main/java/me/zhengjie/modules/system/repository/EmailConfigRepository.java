package me.zhengjie.modules.system.repository;


import me.zhengjie.modules.system.domain.EmailConfigA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmailConfigRepository extends JpaRepository<EmailConfigA,Long> ,JpaSpecificationExecutor{
}

package me.zhengjie.modules.system.dao;

import me.zhengjie.modules.system.dojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer,Long>,JpaSpecificationExecutor{

    @Query(value = "select company_name from Customer where id=?1" ,nativeQuery = true)
    String findCompanyNameById(Long id);



}

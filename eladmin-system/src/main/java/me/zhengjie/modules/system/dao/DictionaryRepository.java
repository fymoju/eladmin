package me.zhengjie.modules.system.dao;

import me.zhengjie.modules.system.dojo.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface DictionaryRepository extends JpaRepository<Dictionary,Integer>,JpaSpecificationExecutor {

    @Query(value = "select name from dictionary where id = ?1",nativeQuery = true)
    String findNameById(Integer id);





}

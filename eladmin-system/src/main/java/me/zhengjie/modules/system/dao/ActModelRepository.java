package me.zhengjie.modules.system.dao;





import me.zhengjie.modules.system.dojo.ModelA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ActModelRepository extends JpaRepository<ModelA,String>,JpaSpecificationExecutor {
}

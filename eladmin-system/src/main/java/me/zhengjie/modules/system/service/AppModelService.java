package me.zhengjie.modules.system.service;

import me.zhengjie.modules.system.dojo.AppModel;
import me.zhengjie.modules.system.service.dto.AppModelQueryCriteria;
import org.activiti.engine.repository.Model;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Pageable;

import java.io.UnsupportedEncodingException;


@CacheConfig(cacheNames = "appmodeler")
public interface AppModelService {
    Object queryAll(AppModelQueryCriteria criteria, Pageable pageable);

    /**
     * 新建流程
     * @param appModel
     * @return
     */
    @CacheEvict(allEntries = true)
    Model carete(AppModel appModel) throws UnsupportedEncodingException;

    /**
     * 部署流程
     * @param id
     * @return
     */
    @CacheEvict(allEntries = true)
    String deploy(String id);

    /**
     * 删除模型
     * @param id
     */
    @CacheEvict(allEntries = true)
    void deleteMoleder(String id);
}

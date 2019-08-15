package me.zhengjie.modules.system.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import me.zhengjie.modules.system.domain.AppAddress;
import me.zhengjie.modules.system.repository.AppAddressRepository;
import me.zhengjie.modules.system.service.AppAddressService;
import me.zhengjie.modules.system.service.dto.AppAddressDTO;
import me.zhengjie.modules.system.service.dto.AppAddressQueryCriteria;
import me.zhengjie.modules.system.service.mapper.AppAddressMapper;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.QueryHelp;
import me.zhengjie.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
* @author jie
* @date 2019-08-12
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AppAddressServiceImpl implements AppAddressService {

    @Autowired
    private AppAddressRepository appAddressRepository;

    @Autowired
    private AppAddressMapper appAddressMapper;

    @Override
    public Object queryAll(AppAddressQueryCriteria criteria, Pageable pageable){
        Page<AppAddress> page = appAddressRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(appAddressMapper::toDto));
    }

    @Override
    public Object queryAll(AppAddressQueryCriteria criteria){
        return appAddressMapper.toDto(appAddressRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public AppAddressDTO findById(Long id) {
        Optional<AppAddress> appAddress = appAddressRepository.findById(id);
        ValidationUtil.isNull(appAddress,"AppAddress","id",id);
        return appAddressMapper.toDto(appAddress.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AppAddressDTO create(AppAddress resources) {
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        resources.setId(snowflake.nextId()); 
        return appAddressMapper.toDto(appAddressRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(AppAddress resources) {
        Optional<AppAddress> optionalAppAddress = appAddressRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalAppAddress,"AppAddress","id",resources.getId());
        AppAddress appAddress = optionalAppAddress.get();
        appAddress.copy(resources);
        appAddressRepository.save(appAddress);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        appAddressRepository.deleteById(id);
    }
}
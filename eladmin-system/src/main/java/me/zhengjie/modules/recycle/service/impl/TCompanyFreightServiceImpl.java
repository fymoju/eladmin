package me.zhengjie.modules.recycle.service.impl;

import me.zhengjie.modules.recycle.domain.TCompanyFreight;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.recycle.repository.TCompanyFreightRepository;
import me.zhengjie.modules.recycle.service.TCompanyFreightService;
import me.zhengjie.modules.recycle.service.dto.TCompanyFreightDTO;
import me.zhengjie.modules.recycle.service.dto.TCompanyFreightQueryCriteria;
import me.zhengjie.modules.recycle.service.mapper.TCompanyFreightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.QueryHelp;

/**
* @author jie
* @date 2019-08-15
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TCompanyFreightServiceImpl implements TCompanyFreightService {

    @Autowired
    private TCompanyFreightRepository tCompanyFreightRepository;

    @Autowired
    private TCompanyFreightMapper tCompanyFreightMapper;

    @Override
    public Object queryAll(TCompanyFreightQueryCriteria criteria, Pageable pageable){
        Page<TCompanyFreight> page = tCompanyFreightRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(tCompanyFreightMapper::toDto));
    }

    @Override
    public Object queryAll(TCompanyFreightQueryCriteria criteria){
        return tCompanyFreightMapper.toDto(tCompanyFreightRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public TCompanyFreightDTO findById(Long id) {
        Optional<TCompanyFreight> tCompanyFreight = tCompanyFreightRepository.findById(id);
        ValidationUtil.isNull(tCompanyFreight,"TCompanyFreight","id",id);
        return tCompanyFreightMapper.toDto(tCompanyFreight.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TCompanyFreightDTO create(TCompanyFreight resources) {
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        resources.setId(snowflake.nextId()); 
        return tCompanyFreightMapper.toDto(tCompanyFreightRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TCompanyFreight resources) {
        Optional<TCompanyFreight> optionalTCompanyFreight = tCompanyFreightRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalTCompanyFreight,"TCompanyFreight","id",resources.getId());
        TCompanyFreight tCompanyFreight = optionalTCompanyFreight.get();
        tCompanyFreight.copy(resources);
        tCompanyFreightRepository.save(tCompanyFreight);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        tCompanyFreightRepository.deleteById(id);
    }
}
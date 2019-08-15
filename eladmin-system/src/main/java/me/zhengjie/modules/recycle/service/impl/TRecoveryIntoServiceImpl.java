package me.zhengjie.modules.recycle.service.impl;

import me.zhengjie.modules.recycle.domain.TRecoveryInto;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.recycle.repository.TRecoveryIntoRepository;
import me.zhengjie.modules.recycle.service.TRecoveryIntoService;
import me.zhengjie.modules.recycle.service.dto.TRecoveryIntoDTO;
import me.zhengjie.modules.recycle.service.dto.TRecoveryIntoQueryCriteria;
import me.zhengjie.modules.recycle.service.mapper.TRecoveryIntoMapper;
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
public class TRecoveryIntoServiceImpl implements TRecoveryIntoService {

    @Autowired
    private TRecoveryIntoRepository tRecoveryIntoRepository;

    @Autowired
    private TRecoveryIntoMapper tRecoveryIntoMapper;

    @Override
    public Object queryAll(TRecoveryIntoQueryCriteria criteria, Pageable pageable){
        Page<TRecoveryInto> page = tRecoveryIntoRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(tRecoveryIntoMapper::toDto));
    }

    @Override
    public Object queryAll(TRecoveryIntoQueryCriteria criteria){
        return tRecoveryIntoMapper.toDto(tRecoveryIntoRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public TRecoveryIntoDTO findById(Long id) {
        Optional<TRecoveryInto> tRecoveryInto = tRecoveryIntoRepository.findById(id);
        ValidationUtil.isNull(tRecoveryInto,"TRecoveryInto","id",id);
        return tRecoveryIntoMapper.toDto(tRecoveryInto.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TRecoveryIntoDTO create(TRecoveryInto resources) {
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        resources.setId(snowflake.nextId()); 
        return tRecoveryIntoMapper.toDto(tRecoveryIntoRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TRecoveryInto resources) {
        Optional<TRecoveryInto> optionalTRecoveryInto = tRecoveryIntoRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalTRecoveryInto,"TRecoveryInto","id",resources.getId());
        TRecoveryInto tRecoveryInto = optionalTRecoveryInto.get();
        tRecoveryInto.copy(resources);
        tRecoveryIntoRepository.save(tRecoveryInto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        tRecoveryIntoRepository.deleteById(id);
    }
}
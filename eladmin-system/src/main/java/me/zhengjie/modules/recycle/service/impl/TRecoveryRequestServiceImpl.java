package me.zhengjie.modules.recycle.service.impl;

import me.zhengjie.modules.recycle.domain.TRecoveryRequest;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.recycle.repository.TRecoveryRequestRepository;
import me.zhengjie.modules.recycle.service.TRecoveryRequestService;
import me.zhengjie.modules.recycle.service.dto.TRecoveryRequestDTO;
import me.zhengjie.modules.recycle.service.dto.TRecoveryRequestQueryCriteria;
import me.zhengjie.modules.recycle.service.mapper.TRecoveryRequestMapper;
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
public class TRecoveryRequestServiceImpl implements TRecoveryRequestService {

    @Autowired
    private TRecoveryRequestRepository tRecoveryRequestRepository;

    @Autowired
    private TRecoveryRequestMapper tRecoveryRequestMapper;

    @Override
    public Object queryAll(TRecoveryRequestQueryCriteria criteria, Pageable pageable){
        Page<TRecoveryRequest> page = tRecoveryRequestRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(tRecoveryRequestMapper::toDto));
    }

    @Override
    public Object queryAll(TRecoveryRequestQueryCriteria criteria){
        return tRecoveryRequestMapper.toDto(tRecoveryRequestRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public TRecoveryRequestDTO findById(Long id) {
        Optional<TRecoveryRequest> tRecoveryRequest = tRecoveryRequestRepository.findById(id);
        ValidationUtil.isNull(tRecoveryRequest,"TRecoveryRequest","id",id);
        return tRecoveryRequestMapper.toDto(tRecoveryRequest.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TRecoveryRequestDTO create(TRecoveryRequest resources) {
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        resources.setId(snowflake.nextId()); 
        return tRecoveryRequestMapper.toDto(tRecoveryRequestRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TRecoveryRequest resources) {
        Optional<TRecoveryRequest> optionalTRecoveryRequest = tRecoveryRequestRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalTRecoveryRequest,"TRecoveryRequest","id",resources.getId());
        TRecoveryRequest tRecoveryRequest = optionalTRecoveryRequest.get();
        tRecoveryRequest.copy(resources);
        tRecoveryRequestRepository.save(tRecoveryRequest);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        tRecoveryRequestRepository.deleteById(id);
    }
}
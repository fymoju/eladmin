package me.zhengjie.modules.test.service.impl;

import me.zhengjie.modules.test.domain.TbOrder;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.test.repository.TbOrderRepository;
import me.zhengjie.modules.test.service.TbOrderService;
import me.zhengjie.modules.test.service.dto.TbOrderDTO;
import me.zhengjie.modules.test.service.dto.TbOrderQueryCriteria;
import me.zhengjie.modules.test.service.mapper.TbOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.QueryHelp;

/**
* @author jie
* @date 2019-08-09
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TbOrderServiceImpl implements TbOrderService {

    @Autowired
    private TbOrderRepository tbOrderRepository;

    @Autowired
    private TbOrderMapper tbOrderMapper;

    @Override
    public Object queryAll(TbOrderQueryCriteria criteria, Pageable pageable){
        Page<TbOrder> page = tbOrderRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(tbOrderMapper::toDto));
    }

    @Override
    public Object queryAll(TbOrderQueryCriteria criteria){
        return tbOrderMapper.toDto(tbOrderRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public TbOrderDTO findById(Integer id) {
        Optional<TbOrder> tbOrder = tbOrderRepository.findById(id);
        ValidationUtil.isNull(tbOrder,"TbOrder","id",id);
        return tbOrderMapper.toDto(tbOrder.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TbOrderDTO create(TbOrder resources) {
        return tbOrderMapper.toDto(tbOrderRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TbOrder resources) {
        Optional<TbOrder> optionalTbOrder = tbOrderRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalTbOrder,"TbOrder","id",resources.getId());
        TbOrder tbOrder = optionalTbOrder.get();
        tbOrder.copy(resources);
        tbOrderRepository.save(tbOrder);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        tbOrderRepository.deleteById(id);
    }
}
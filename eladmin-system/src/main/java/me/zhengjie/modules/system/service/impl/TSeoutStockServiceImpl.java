package me.zhengjie.modules.system.service.impl;

import me.zhengjie.modules.system.dao.CustomerRepository;
import me.zhengjie.modules.system.dao.DictionaryRepository;
import me.zhengjie.modules.system.dao.TSeoutStockRepository;
import me.zhengjie.modules.system.dojo.TSeoutStock;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.system.service.TSeoutStockService;
import me.zhengjie.modules.system.service.dto.TSeoutStockDTO;
import me.zhengjie.modules.system.service.dto.TSeoutStockQueryCriteria;
import me.zhengjie.modules.system.service.mapper.TSeoutStockMapper;
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
* @date 2019-08-13
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TSeoutStockServiceImpl implements TSeoutStockService {

    @Autowired
    private TSeoutStockRepository tSeoutStockRepository;

    @Autowired
    private TSeoutStockMapper tSeoutStockMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Override
    public Object queryAll(TSeoutStockQueryCriteria criteria, Pageable pageable){
        Page<TSeoutStock> page = tSeoutStockRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        for (TSeoutStock tSeoutStock : page.getContent()) {
            tSeoutStock.setCompanyName(customerRepository.findCompanyNameById(tSeoutStock.getCustomerId()));
            tSeoutStock.setDocument(dictionaryRepository.findNameById(tSeoutStock.getDocumentType().intValue()));
        }

        return PageUtil.toPage(page);
        //return PageUtil.toPage(page.map(tSeoutStockMapper::toDto));
    }

    @Override
    public Object queryAll(TSeoutStockQueryCriteria criteria){
        return tSeoutStockMapper.toDto(tSeoutStockRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public TSeoutStockDTO findById(Long id) {
        Optional<TSeoutStock> tSeoutStock = tSeoutStockRepository.findById(id);
        ValidationUtil.isNull(tSeoutStock,"TSeoutStock","id",id);
        return tSeoutStockMapper.toDto(tSeoutStock.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TSeoutStockDTO create(TSeoutStock resources) {
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        resources.setId(snowflake.nextId()); 
        return tSeoutStockMapper.toDto(tSeoutStockRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TSeoutStock resources) {
        Optional<TSeoutStock> optionalTSeoutStock = tSeoutStockRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalTSeoutStock,"TSeoutStock","id",resources.getId());
        TSeoutStock tSeoutStock = optionalTSeoutStock.get();
        tSeoutStock.copy(resources);
        tSeoutStockRepository.save(tSeoutStock);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        tSeoutStockRepository.deleteById(id);
    }

    @Override
    public void save(TSeoutStock tSeoutStock) {
        tSeoutStockRepository.save(tSeoutStock);
    }
}
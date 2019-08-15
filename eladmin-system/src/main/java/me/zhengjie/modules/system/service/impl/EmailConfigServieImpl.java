package me.zhengjie.modules.system.service.impl;


import me.zhengjie.modules.system.domain.EmailConfigA;
import me.zhengjie.modules.system.domain.Job;
import me.zhengjie.modules.system.repository.EmailConfigRepository;
import me.zhengjie.modules.system.service.EmailConfigServie;
import me.zhengjie.modules.system.service.dto.EmailConfigDTO;
import me.zhengjie.modules.system.service.dto.EmailConfigQueryCriteria;
import me.zhengjie.modules.system.service.dto.JobDTO;
import me.zhengjie.modules.system.service.mapper.EmailMapper;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.QueryHelp;
import me.zhengjie.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class EmailConfigServieImpl implements EmailConfigServie {

    @Autowired
    private EmailConfigRepository emailConfigRepository;

    @Autowired
    private EmailMapper emailMapper;

   /* @Override
    public Object queryAll(EmailConfigDTO emailConfig, Pageable pageable) {
        Page<EmailConfigA> page = emailConfigRepository.findAll((root, query, cb) -> QueryHelp.getPredicate(root, emailConfig, cb), pageable);
        return PageUtil.toPage(page.map(emailMapper::toDto));

    }*/

    @Override
    public Object queryAll(EmailConfigQueryCriteria criteria, Pageable pageable) {
        Page<EmailConfigA> page = emailConfigRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(emailMapper::toDto));
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public EmailConfigDTO create(EmailConfigA resources) {
        return emailMapper.toDto(emailConfigRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        emailConfigRepository.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(EmailConfigA resources) {
        Optional<EmailConfigA> optionalEmailConfigA = emailConfigRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalEmailConfigA,"EmailConfigA","id",resources.getId());
        EmailConfigA emailConfigA = optionalEmailConfigA.get();
        resources.setId(emailConfigA.getId());
        emailConfigRepository.save(resources);
    }


}

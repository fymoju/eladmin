package me.zhengjie.modules.system.service.impl;

import me.zhengjie.modules.system.dao.DictionaryRepository;
import me.zhengjie.modules.system.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryRepository dictionaryRepository;


   /* @Override
    public Object findDictionariesByMiddleId(Integer middle_id) {
        return dictionaryRepository.findDictionariesByMiddleId(middle_id);
    }*/

    @Override
    public Object findAll() {
        return dictionaryRepository.findAll();
    }


}

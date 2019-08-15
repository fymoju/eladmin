package me.zhengjie.modules.system.service.impl;

import me.zhengjie.modules.system.dao.CustomerRepository;
import me.zhengjie.modules.system.dojo.Customer;
import me.zhengjie.modules.system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}

package me.zhengjie.modules.system.service.impl;

import me.zhengjie.modules.system.dao.TSeoutStockRepository;
import me.zhengjie.modules.system.dao.CustomerRepository;
import me.zhengjie.modules.system.dao.DictionaryRepository;
import me.zhengjie.modules.system.dao.OrderRepository;
import me.zhengjie.modules.system.dojo.Order;
import me.zhengjie.modules.system.service.OrderService;
import me.zhengjie.modules.system.service.dto.OrderDTO;
import me.zhengjie.modules.system.service.dto.OrderQueryCriteria;
import me.zhengjie.modules.system.service.mapper.OrderMapper;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.QueryHelp;
import me.zhengjie.utils.ValidationUtil;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {
    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TSeoutStockRepository tSeoutStockRepository;

 /*   @Resource
    private TSeoutStock tSeoutStock;*/

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Resource
    private TaskService taskService;
    @Autowired
    private OrderMapper orderMapper;
    private static final String PROCESS_DEFINE_KEY = "vacationProcess";//定义常量用来存储流程id
    @Resource
    private RuntimeService runtimeService;
    @Resource
    private IdentityService identityService;

    @Override
    public ProcessInstance start(String userName) {
        //流程发起前设置发起人，记录在流程历史中
        identityService.setAuthenticatedUserId(userName);
        // 开始流程 传入流程的id(xml中的id)
        ProcessInstance vacationInstance = runtimeService.startProcessInstanceByKey(PROCESS_DEFINE_KEY);
        //获取执行流程的任务id
        System.out.println("当前任务的id==" + vacationInstance.getId());
        return vacationInstance;
    }

    @Override
    public Object startVac(String userName, Order order, String processInstance) {
        System.out.println("当前任务的id1==" + processInstance);
        // 查询当前任务
        Task currentTask = taskService.createTaskQuery().processInstanceId(processInstance).singleResult();
        // 申明任务
        taskService.claim(currentTask.getId(), userName);
        Map<String, Object> vars = new HashMap<>(4);

//        logger.warn("当前登录进来的用户是："+userName);
        vars.put("applyUser", userName);//当前登录进来的人
        vars.put("id", order.getId());
        vars.put("document_type", order.getDocument_type());
        vars.put("order_type", order.getOrder_type());
        vars.put("order_no", order.getOrder_no());
        vars.put("creattime", order.getCreattime());
        vars.put("endtime", order.getEndtime());
        vars.put("agreement", order.getAgreement());
        vars.put("note", order.getNote());

        taskService.complete(currentTask.getId(), vars);
        return true;
    }

    @Override
    public Object passAudit(String username, Long id, String processInstance) {

        Task task=taskService.createTaskQuery().processInstanceId(processInstance).singleResult();
        taskService.claim(task.getId(),username);
        taskService.complete(task.getId());
        return true;

    }


    @Override
    public Object queryAll(OrderQueryCriteria criteria, Pageable pageable) {
        //System.out.println(criteria+":11111");
        Page<Order> page = orderRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        for (Order order : page.getContent()) {
            order.setDocument(dictionaryRepository.findNameById(order.getDocument_type().intValue())); //单据类型
            order.setOrdern(dictionaryRepository.findNameById(order.getOrder_type().intValue()));  //订单类型
            order.setHetong(dictionaryRepository.findNameById(order.getAgreement().intValue()));   //合同
            order.setStatus(dictionaryRepository.findNameById(order.getStatus_id().intValue()));      //审核状态
            order.setCompany_name(customerRepository.findCompanyNameById(order.getCustomer_key())); //客户
        }
        return PageUtil.toPage(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderDTO create(Order resources) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        int i = new Random().nextInt(900) + 100;
        resources.setOrder_no("XSDD" + Long.toString(System.currentTimeMillis()));
        resources.setStatus_id(24L);
        return orderMapper.toDto(orderRepository.save(resources));
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Order resources) {
        Optional<Order> optionalOrder = orderRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalOrder, "Order", "id", resources.getId());
        Order order = optionalOrder.get();
        resources.setId(order.getId());
        orderRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Order> findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        logger.warn("order的Optional=="+order);
        order.get().setStatus_id(25L);
        orderRepository.save(order.get());
        List<Order> orders=toList(order);
        logger.warn("orders的List="+orders);
       /* TSeoutStock tSeoutStock = new TSeoutStock();
        tSeoutStock.setOrderNo(order.get().getOrder_no());
        tSeoutStockRepository.save(tSeoutStock);*/
        return orders;
    }
    public static <T> List<T> toList(Optional<T> option) {
        return option.
                map(Collections::singletonList).
                orElse(Collections.emptyList());
    }
   /* @Override
    public List<Order> orderMap() {
        return orderRepository.findAll();
    }*/
}
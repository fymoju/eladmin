package me.zhengjie.modules.system.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class OrderDTO implements Serializable {
/*
    @Query(type = Query.Type.INNER_LIKE)
    private Long id;


    private Long document_type;

    private Long order_type;//订单类型
    private String order_no;//单据编号
    @CreationTimestamp
    private Timestamp creattime;//日期
    @CreationTimestamp
    private Timestamp endtime;//租赁到期
    private Long agreement;//合同情况
    private String note;//合同回执说明

    private DictionaryDTO dictionary;//单据类型


    private String status;

    private CustomerDTO customer;//外键（客户表）*/

  /*  @OneToOne
    @JoinColumn(name = "key")
    private Dictionary dictionary;//外键（字典表）*/

    private Long id;

    private Long document_type;

    private String document;

    private Long order_type;//订单类型

    private String ordern;


    private String order_no;//单据编号
    @CreationTimestamp
    private Timestamp creattime;//日期
    @CreationTimestamp
    private Timestamp endtime;//租赁到期
    private Long agreement;//合同情况
    private String hetong;

    private String note;//合同回执说明

    private Long status_id;
    private String status;

    private Long customer_key;

    private String company_name;

    private String processInstance;
}

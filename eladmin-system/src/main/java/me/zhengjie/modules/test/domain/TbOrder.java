package me.zhengjie.modules.test.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author jie
* @date 2019-08-09
*/
@Entity
@Data
@Table(name="tb_order")
public class TbOrder implements Serializable {

    // 主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // 单据类型
    @Column(name = "document_type")
    private Long documentType;

    // 订单类型
    @Column(name = "order_type")
    private Long orderType;

    // 单据编号
    @Column(name = "order_no")
    private String orderNo;

    // 日期
    @Column(name = "creattime")
    private Timestamp creattime;

    // 租赁到期
    @Column(name = "endtime")
    private Timestamp endtime;

    // 合同情况
    @Column(name = "agreement")
    private Long agreement;

    // 合同回执说明
    @Column(name = "note")
    private String note;

    // 外键（客户表）
    @Column(name = "customer_key")
    private Long customerKey;

    @Column(name = "dictionary_key")
    private String dictionaryKey;

    // 状态
    @Column(name = "status_id")
    private Long statusId;

    @Column(name = "document")
    private String document;

    @Column(name = "ordern")
    private String ordern;

    @Column(name = "hetong")
    private String hetong;

    @Column(name = "status")
    private String status;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "t_process_instance")
    private String processInstance;

    public void copy(TbOrder source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
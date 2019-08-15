package me.zhengjie.modules.test.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;


/**
* @author jie
* @date 2019-08-09
*/
@Data
public class TbOrderDTO implements Serializable {

    // 主键
    private Integer id;

    // 单据类型
    private Long documentType;

    // 订单类型
    private Long orderType;

    // 单据编号
    private String orderNo;

    // 日期
    private Timestamp creattime;

    // 租赁到期
    private Timestamp endtime;

    // 合同情况
    private Long agreement;

    // 合同回执说明
    private String note;

    // 外键（客户表）
    private Long customerKey;

    private String dictionaryKey;

    // 状态
    private Long statusId;

    private String document;

    private String ordern;

    private String hetong;

    private String status;

    private String companyName;

    private String processInstance;
}
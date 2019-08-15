package me.zhengjie.modules.system.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;


/**
* @author jie
* @date 2019-08-13
*/
@Data
public class TSeoutStockDTO implements Serializable {

    // 主键id
    // 处理精度丢失问题
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    private String companyName;

    // 关联客户id
    private Long customerId;

    // 单据类型
    private Integer documentType;

    // 发货类型
    private Integer stockType;

    // 单据编号
    private String orderNo;

    // 日期
    private Timestamp leaseTime;

    // 产品类型
    private Integer productType;

    // 公司特批
    private Integer comApprove;

    // 收款方式
    private Integer paymentMethod;

    // 备注
    private String remark;

    // 物流备注
    private String logisticsRemark;

    // 购货单位
    private Integer fCustId;

    // 退料原因
    private String fNote;

    // 订货机构
    private Integer fRelateBr;

    // 关联单据号码
    private String fRelationBillno;

    // 关联单据类型
    private Integer fRelationTranType;

    // 销售发票号
    private Integer fSalBillInterId;

    // 销售方式
    private Integer fSalType;

    // 结算方式
    private Integer fSettleId;

    // 收货仓库
    private Integer fStockId;

    // 传输状态
    private Integer fTranStatus;
}
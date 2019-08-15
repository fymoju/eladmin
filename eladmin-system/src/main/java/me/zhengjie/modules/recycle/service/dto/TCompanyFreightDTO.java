package me.zhengjie.modules.recycle.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.io.Serializable;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;


/**
* @author jie
* @date 2019-08-15
*/
@Data
public class TCompanyFreightDTO implements Serializable {

    // 主键id
    // 处理精度丢失问题
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    // 单据编号
    private String fOrderNo;

    // 原单类型
    private Integer fOriginalType;

    // 数据状态
    private Integer fDataState;

    // 客户
    private String fCustomer;

    // 日期
    private Timestamp fDate;

    // 仓库
    private String fWarehouse;

    // 物流公司
    private String fLogisticsCompany;

    // 运费比率
    private BigDecimal fFreightRate;

    // 物流类型
    private Integer fLogisticsType;

    // 运费类型
    private Integer fFreightType;

    // 原单编号
    private String fOriginalNumber;

    // 公司承担运费
    private BigDecimal fCompanyFreight;

    // 大区
    private String fRegion;

    // 销售组织
    private String fMarketOrg;

    // 打印次数
    private Integer fPrintNumber;

    // 费用类型
    private Integer fExpenseType;

    // 吨位
    private BigDecimal fTonnage;

    // 代收金额
    private BigDecimal fCollectAmount;

    // 物流备注
    private String fLogisticsRemark;

    // 备注
    private String fRemark;

    // 省份
    private String fProvince;

    // 城市
    private String fCity;

    // 应收单单号
    private String fReceiptNumber;

    // 扩展字段
    private String fBaK1;

    // 扩展字段
    private String fBaK2;

    // 扩展字段
    private String fBaK3;

    // 扩展字段
    private String fBaK4;

    // 上级订单id
    private Long fParentId2;
}
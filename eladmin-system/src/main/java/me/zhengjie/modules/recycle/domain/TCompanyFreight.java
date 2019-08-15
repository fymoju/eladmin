package me.zhengjie.modules.recycle.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.io.Serializable;

/**
* @author jie
* @date 2019-08-15
*/
@Entity
@Data
@Table(name="t_company_freight")
public class TCompanyFreight implements Serializable {

    // 主键id
    @Id
    @Column(name = "id")
    private Long id;

    // 单据编号
    @Column(name = "f_order_no")
    private String fOrderNo;

    // 原单类型
    @Column(name = "f_original_type")
    private Integer fOriginalType;

    // 数据状态
    @Column(name = "f_data_state")
    private Integer fDataState;

    // 客户
    @Column(name = "f_customer")
    private String fCustomer;

    // 日期
    @Column(name = "f_date",nullable = false)
    private Timestamp fDate;

    // 仓库
    @Column(name = "f_warehouse")
    private String fWarehouse;

    // 物流公司
    @Column(name = "f_logistics_company")
    private String fLogisticsCompany;

    // 运费比率
    @Column(name = "f_freight_rate")
    private BigDecimal fFreightRate;

    // 物流类型
    @Column(name = "f_logistics_type")
    private Integer fLogisticsType;

    // 运费类型
    @Column(name = "f_freight_type")
    private Integer fFreightType;

    // 原单编号
    @Column(name = "f_original_number")
    private String fOriginalNumber;

    // 公司承担运费
    @Column(name = "f_company_freight")
    private BigDecimal fCompanyFreight;

    // 大区
    @Column(name = "f_region")
    private String fRegion;

    // 销售组织
    @Column(name = "f_market_org")
    private String fMarketOrg;

    // 打印次数
    @Column(name = "f_print_number")
    private Integer fPrintNumber;

    // 费用类型
    @Column(name = "f_expense_type")
    private Integer fExpenseType;

    // 吨位
    @Column(name = "f_tonnage")
    private BigDecimal fTonnage;

    // 代收金额
    @Column(name = "f_collect_amount")
    private BigDecimal fCollectAmount;

    // 物流备注
    @Column(name = "f_logistics_remark")
    private String fLogisticsRemark;

    // 备注
    @Column(name = "f_remark")
    private String fRemark;

    // 省份
    @Column(name = "f_province")
    private String fProvince;

    // 城市
    @Column(name = "f_city")
    private String fCity;

    // 应收单单号
    @Column(name = "f_receipt_number")
    private String fReceiptNumber;

    // 扩展字段
    @Column(name = "f_ba_k1")
    private String fBaK1;

    // 扩展字段
    @Column(name = "f_ba_k2")
    private String fBaK2;

    // 扩展字段
    @Column(name = "f_ba_k3")
    private String fBaK3;

    // 扩展字段
    @Column(name = "f_ba_k4")
    private String fBaK4;

    // 上级订单id
    @Column(name = "f_parent_id2")
    private Long fParentId2;

    public void copy(TCompanyFreight source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
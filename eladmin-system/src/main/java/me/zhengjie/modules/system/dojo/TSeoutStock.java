package me.zhengjie.modules.system.dojo;


import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
 * @author jie
 * @date 2019-08-13
 */
@Entity
@Data
@Table(name="t_seout_stock")
public class TSeoutStock implements Serializable {

    // 主键id
    @Id
    @Column(name = "id")
    private Long id;

    // 关联客户id
    @Column(name = "customer_id")
    private Long customerId;

    // 单据类型
    @Column(name = "document_type")
    private Integer documentType;

    private String document;

    // 发货类型
    @Column(name = "stock_type")
    private Integer stockType;

    // 单据编号
    @Column(name = "order_no")
    private String orderNo;

    // 日期
    @Column(name = "lease_time",nullable = false)
    private Timestamp leaseTime;

    // 产品类型
    @Column(name = "product_type")
    private Integer productType;

    // 公司特批
    @Column(name = "com_approve")
    private Integer comApprove;

    // 收款方式
    @Column(name = "payment_method")
    private Integer paymentMethod;

    // 备注
    @Column(name = "remark")
    private String remark;

    // 物流备注
    @Column(name = "logistics_remark")
    private String logisticsRemark;

    // 购货单位
    @Column(name = "f_cust_id")
    private Integer fCustId;

    // 退料原因
    @Column(name = "f_note")
    private String fNote;

    // 订货机构
    @Column(name = "f_relate_br")
    private Integer fRelateBr;

    // 关联单据号码
    @Column(name = "f_relation_billno")
    private String fRelationBillno;

    // 关联单据类型
    @Column(name = "f_relation_tran_type")
    private Integer fRelationTranType;

    // 销售发票号
    @Column(name = "f_sal_bill_inter_id")
    private Integer fSalBillInterId;

    // 销售方式
    @Column(name = "f_sal_type")
    private Integer fSalType;

    // 结算方式
    @Column(name = "f_settle_id")
    private Integer fSettleId;

    private String companyName;


    @Override
    public String toString() {
        return "TSeoutStock{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", documentType=" + documentType +
                ", stockType=" + stockType +
                ", orderNo='" + orderNo + '\'' +
                ", leaseTime=" + leaseTime +
                ", productType=" + productType +
                ", comApprove=" + comApprove +
                ", paymentMethod=" + paymentMethod +
                ", remark='" + remark + '\'' +
                ", logisticsRemark='" + logisticsRemark + '\'' +
                ", fCustId=" + fCustId +
                ", fNote='" + fNote + '\'' +
                ", fRelateBr=" + fRelateBr +
                ", fRelationBillno='" + fRelationBillno + '\'' +
                ", fRelationTranType=" + fRelationTranType +
                ", fSalBillInterId=" + fSalBillInterId +
                ", fSalType=" + fSalType +
                ", fSettleId=" + fSettleId +
                ", fStockId=" + fStockId +
                ", fTranStatus=" + fTranStatus +
                '}';
    }

    // 收货仓库
    @Column(name = "f_stock_id")
    private Integer fStockId;

    // 传输状态
    @Column(name = "f_tran_status")
    private Integer fTranStatus;

    public void copy(TSeoutStock source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
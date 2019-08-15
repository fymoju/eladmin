package me.zhengjie.modules.recycle.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author jie
* @date 2019-08-15
*/
@Entity
@Data
@Table(name="t_recovery_request")
public class TRecoveryRequest implements Serializable {

    // 主键id
    @Id
    @Column(name = "id")
    private Long id;

    // 关联客户id
    @Column(name = "customer_id")
    private Long customerId;

    // 关联组织id
    @Column(name = "f_org_id")
    private Long fOrgId;

    // 省份
    @Column(name = "province")
    private String province;

    // 城市
    @Column(name = "city")
    private String city;

    // 大区
    @Column(name = "region")
    private String region;

    // 车组
    @Column(name = "f_set_cars")
    private String fSetCars;

    // 车长
    @Column(name = "f_car_leader")
    private String fCarLeader;

    // 副车长
    @Column(name = "f_car_assistant")
    private String fCarAssistant;

    // 单据状态
    @Column(name = "document_state")
    private Integer documentState;

    // 调拨类型
    @Column(name = "direct_type")
    private Integer directType;

    // 日期
    @Column(name = "lease_time",nullable = false)
    private Timestamp leaseTime;

    // 物流备注
    @Column(name = "logistics_remark")
    private String logisticsRemark;

    // 订货机构
    @Column(name = "f_relate_br")
    private Integer fRelateBr;

    // 关联单据号码
    @Column(name = "f_relation_billno")
    private String fRelationBillno;

    // 关联单据类型
    @Column(name = "f_relation_tran_type")
    private Integer fRelationTranType;

    // 收货仓库
    @Column(name = "f_stock_id")
    private Integer fStockId;

    // 传输状态
    @Column(name = "f_tran_status")
    private Integer fTranStatus;

    // 联系人
    @Column(name = "link_man")
    private String linkMan;

    // 地址
    @Column(name = "link_address")
    private String linkAddress;

    // 仓库备注
    @Column(name = "store_remark")
    private String storeRemark;

    // 内勤备注
    @Column(name = "interal_remark")
    private String interalRemark;

    // 车长电话
    @Column(name = "vehicle_phone")
    private String vehiclePhone;

    // 图片json
    @Column(name = "picture_json")
    private String pictureJson;

    // 扩展字段
    @Column(name = "ba_k1")
    private String baK1;

    // 扩展字段
    @Column(name = "ba_k2")
    private String baK2;

    // 扩展字段
    @Column(name = "ba_k3")
    private String baK3;

    // 扩展字段
    @Column(name = "ba_k4")
    private String baK4;

    // 上级订单id
    @Column(name = "f_parent_id")
    private Long fParentId;

    public void copy(TRecoveryRequest source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
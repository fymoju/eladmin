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
@Table(name="t_recovery_into")
public class TRecoveryInto implements Serializable {

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

    // 关联仓管员id
    @Column(name = "f_warehouse_id")
    private Long fWarehouseId;

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

    // 单据编号
    @Column(name = "f_order_no")
    private String fOrderNo;

    // 调拨类型
    @Column(name = "direct_type")
    private Integer directType;

    // 日期
    @Column(name = "lease_time",nullable = false)
    private Timestamp leaseTime;

    // 样品情况
    @Column(name = "f_sample")
    private Integer fSample;

    // 单据状态
    @Column(name = "f_document_state")
    private Integer fDocumentState;

    // 传输状态
    @Column(name = "f_tran_status")
    private Integer fTranStatus;

    // 联系人
    @Column(name = "link_man")
    private String linkMan;

    // 客户
    @Column(name = "f_client")
    private String fClient;

    // 仓管员
    @Column(name = "f_warehouse")
    private String fWarehouse;

    // 摘要
    @Column(name = "f_abstract")
    private String fAbstract;

    // 打印次数
    @Column(name = "f_print_number")
    private Integer fPrintNumber;

    // 地址
    @Column(name = "link_address")
    private String linkAddress;

    // 客户评级
    @Column(name = "store_remark")
    private String storeRemark;

    // 物流备注
    @Column(name = "interal_remark")
    private String interalRemark;

    // 产品类型
    @Column(name = "vehicle_phone")
    private String vehiclePhone;

    // 收款方式
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

    public void copy(TRecoveryInto source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
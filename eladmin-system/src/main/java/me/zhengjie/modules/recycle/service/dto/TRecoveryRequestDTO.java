package me.zhengjie.modules.recycle.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;


/**
* @author jie
* @date 2019-08-15
*/
@Data
public class TRecoveryRequestDTO implements Serializable {

    // 主键id
    // 处理精度丢失问题
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    // 关联客户id
    private Long customerId;

    // 关联组织id
    private Long fOrgId;

    // 省份
    private String province;

    // 城市
    private String city;

    // 大区
    private String region;

    // 车组
    private String fSetCars;

    // 车长
    private String fCarLeader;

    // 副车长
    private String fCarAssistant;

    // 单据状态
    private Integer documentState;

    // 调拨类型
    private Integer directType;

    // 日期
    private Timestamp leaseTime;

    // 物流备注
    private String logisticsRemark;

    // 订货机构
    private Integer fRelateBr;

    // 关联单据号码
    private String fRelationBillno;

    // 关联单据类型
    private Integer fRelationTranType;

    // 收货仓库
    private Integer fStockId;

    // 传输状态
    private Integer fTranStatus;

    // 联系人
    private String linkMan;

    // 地址
    private String linkAddress;

    // 仓库备注
    private String storeRemark;

    // 内勤备注
    private String interalRemark;

    // 车长电话
    private String vehiclePhone;

    // 图片json
    private String pictureJson;

    // 扩展字段
    private String baK1;

    // 扩展字段
    private String baK2;

    // 扩展字段
    private String baK3;

    // 扩展字段
    private String baK4;

    // 上级订单id
    private Long fParentId;
}
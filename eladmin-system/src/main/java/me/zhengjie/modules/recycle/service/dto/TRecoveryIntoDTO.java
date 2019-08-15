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
public class TRecoveryIntoDTO implements Serializable {

    // 主键id
    // 处理精度丢失问题
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    // 关联客户id
    private Long customerId;

    // 关联组织id
    private Long fOrgId;

    // 关联仓管员id
    private Long fWarehouseId;

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

    // 单据编号
    private String fOrderNo;

    // 调拨类型
    private Integer directType;

    // 日期
    private Timestamp leaseTime;

    // 样品情况
    private Integer fSample;

    // 单据状态
    private Integer fDocumentState;

    // 传输状态
    private Integer fTranStatus;

    // 联系人
    private String linkMan;

    // 客户
    private String fClient;

    // 仓管员
    private String fWarehouse;

    // 摘要
    private String fAbstract;

    // 打印次数
    private Integer fPrintNumber;

    // 地址
    private String linkAddress;

    // 客户评级
    private String storeRemark;

    // 物流备注
    private String interalRemark;

    // 产品类型
    private String vehiclePhone;

    // 收款方式
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
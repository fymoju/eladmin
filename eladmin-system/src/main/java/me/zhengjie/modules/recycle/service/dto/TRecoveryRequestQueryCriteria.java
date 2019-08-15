package me.zhengjie.modules.recycle.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import me.zhengjie.annotation.Query;

/**
* @author jie
* @date 2019-08-15
*/
@Data
public class TRecoveryRequestQueryCriteria{

    // 精确
    @Query
    private Long id;

    // 精确
    @Query
    private Long customerId;

    // 精确
    @Query
    private Long fOrgId;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String province;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String city;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String region;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String fSetCars;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String fCarLeader;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String fCarAssistant;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer documentState;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer directType;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Timestamp leaseTime;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String logisticsRemark;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer fRelateBr;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String fRelationBillno;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer fRelationTranType;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer fStockId;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String linkMan;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String linkAddress;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String storeRemark;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String interalRemark;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String vehiclePhone;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String pictureJson;
}
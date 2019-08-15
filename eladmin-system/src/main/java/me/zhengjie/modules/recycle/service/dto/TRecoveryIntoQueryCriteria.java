package me.zhengjie.modules.recycle.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import me.zhengjie.annotation.Query;

/**
* @author jie
* @date 2019-08-15
*/
@Data
public class TRecoveryIntoQueryCriteria{

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
    private String fOrderNo;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer directType;

    // 精确
    @Query
    private Timestamp leaseTime;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer fSample;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer fDocumentState;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer fTranStatus;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String linkMan;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String fClient;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String fWarehouse;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String fAbstract;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer fPrintNumber;

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
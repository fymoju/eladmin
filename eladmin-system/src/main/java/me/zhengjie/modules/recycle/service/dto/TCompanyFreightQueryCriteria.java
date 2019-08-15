package me.zhengjie.modules.recycle.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.math.BigDecimal;
import me.zhengjie.annotation.Query;

/**
* @author jie
* @date 2019-08-15
*/
@Data
public class TCompanyFreightQueryCriteria{

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String fOrderNo;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer fOriginalType;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer fDataState;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String fCustomer;

    // 精确
    @Query
    private Timestamp fDate;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String fWarehouse;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String fLogisticsCompany;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private BigDecimal fFreightRate;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer fLogisticsType;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer fFreightType;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String fOriginalNumber;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private BigDecimal fCompanyFreight;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String fRegion;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String fMarketOrg;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer fPrintNumber;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private Integer fExpenseType;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private BigDecimal fTonnage;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private BigDecimal fCollectAmount;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String fLogisticsRemark;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String fRemark;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String fProvince;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String fCity;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String fReceiptNumber;
}
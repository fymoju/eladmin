package me.zhengjie.modules.system.service.dto;

import lombok.Data;
import me.zhengjie.annotation.Query;

/**
* @author jie
* @date 2019-08-12
*/
@Data
public class AppAddressQueryCriteria{

    // 精确
    @Query
    private Long id;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String areaCode;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String areaName;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String center;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String cityCode;
}
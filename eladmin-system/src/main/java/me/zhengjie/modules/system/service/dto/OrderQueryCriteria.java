package me.zhengjie.modules.system.service.dto;

import lombok.Data;
import me.zhengjie.annotation.Query;

@Data
public class OrderQueryCriteria {

    //private Integer id;

    @Query(type = Query.Type.INNER_LIKE)
    private String status_id;

    @Query
    private Boolean enabled;
}

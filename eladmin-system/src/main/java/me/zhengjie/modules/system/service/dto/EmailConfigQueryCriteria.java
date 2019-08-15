package me.zhengjie.modules.system.service.dto;

import lombok.Data;
import me.zhengjie.annotation.Query;

@Data
public class EmailConfigQueryCriteria {

    //@Query(propName = "name",joinName = "dict")
    @Query(type = Query.Type.INNER_LIKE)
    private String from_user;

    @Query
    private Boolean enabled;
}

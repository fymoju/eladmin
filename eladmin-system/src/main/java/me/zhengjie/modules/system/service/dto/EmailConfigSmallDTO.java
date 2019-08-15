package me.zhengjie.modules.system.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.zhengjie.annotation.Query;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class EmailConfigSmallDTO implements Serializable {

    private Long id;

    @Query(type = Query.Type.INNER_LIKE)
    private String name;
}

package me.zhengjie.modules.system.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.zhengjie.annotation.Query;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class EmailConfigDTO implements Serializable {

   /* @Query(type = Query.Type.INNER_LIKE)*/
    private Long id;

    //@Query(type = Query.Type.INNER_LIKE)
    private String from_user;
    //@Query(type = Query.Type.INNER_LIKE)
    private String host;
    //@Query(type = Query.Type.INNER_LIKE)
    private String pass;
    //@Query(type = Query.Type.INNER_LIKE)
    private String port;
   // @Query(type = Query.Type.INNER_LIKE)
    private String user;

    public EmailConfigDTO( String from_user, String host, String pass, String port, String user) {
        this.from_user = from_user;
        this.host = host;
        this.pass = pass;
        this.port = port;
        this.user = user;
    }
}

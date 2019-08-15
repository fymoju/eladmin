package me.zhengjie.modules.system.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 邮件配置类，数据存覆盖式存入数据存
 * @author Zheng Jie
 * @date 2018-12-26
 */
@Entity
@Data
@Table(name = "email_config")
public class EmailConfigA implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(groups = Update.class)
    private Long id;

    /**
     *邮件服务器SMTP地址
     */
    @Column(name = "host")
    private String host;

    /**
     * 邮件服务器SMTP端口
     */
    @Column(name = "port")
    private String port;

    /**
     * 发件者用户名，默认为发件人邮箱前缀
     */
    @Column(name = "user")
    private String user;

    @Column(name = "pass")
    private String pass;

    /**
     * 收件人
     */

    @Column(name = "from_user")
    private String from_user;

    public @interface Update {}
}

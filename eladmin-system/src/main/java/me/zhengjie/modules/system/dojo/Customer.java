package me.zhengjie.modules.system.dojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "customer")
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer implements Serializable {

    @Id
    @NotNull(groups = Update.class)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//
    private String company_name;//公司名称
    private String area;//大区
    private String car;//车组
    private String car_master;//车长
    private String car_assistant;//副车长
    private java.util.Date datetime;//新到日期
    private String corporation;//公司特批
    private String organization;//销售组织
    private String mobile;//车长电话
    private String type;//产品类型
    private String payment;//收款方式
    private String notes;//备注
    private String province;//省
    private String city;//城市
    private String link;//联系人
    private String adress;//地址
    private String remarks;//物流备注

   /* @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "customers")
    private List<Order> order;*/

    public @interface Update {}
}

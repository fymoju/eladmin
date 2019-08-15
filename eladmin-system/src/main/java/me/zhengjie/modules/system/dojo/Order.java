package me.zhengjie.modules.system.dojo;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
@Data
@Table(name="tb_order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

   private Long document_type;
   private String document;

    private Long order_type;//订单类型
    private String ordern;


    private String order_no;//单据编号
    @CreationTimestamp
    private Timestamp creattime;//日期
    @CreationTimestamp
    private Timestamp endtime;//租赁到期
    private Long agreement;//合同情况
    private String hetong;

    private String note;//合同回执说明


    private Long status_id;
    private String status;

    private Long customer_key;
    private String company_name;

    private String processInstance;
/*    @ManyToOne
    @JoinColumn(name = "customer_key")
    private Customer customers;*/



    public @interface Update {}


}

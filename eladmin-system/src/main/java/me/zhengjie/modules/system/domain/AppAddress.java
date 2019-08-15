package me.zhengjie.modules.system.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
* @author jie
* @date 2019-08-12
*/
@Entity
@Data
@Table(name="app_address")
public class AppAddress implements Serializable {

    // 编号
    @Id
    @Column(name = "id")
    private Long id;

    // 测试
    @Column(name = "area_code")
    private String areaCode;

    // 地址
    @Column(name = "area_name")
    private String areaName;

    // 测试2
    @Column(name = "center")
    private String center;

    // 测试3
    @Column(name = "city_code")
    private String cityCode;

    // 测试4
    @Column(name = "level")
    private Long level;

    // 测试5
    @Column(name = "parent_id")
    private Long parentId;

    public void copy(AppAddress source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
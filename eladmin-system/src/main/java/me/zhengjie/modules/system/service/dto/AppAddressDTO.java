package me.zhengjie.modules.system.service.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;


/**
* @author jie
* @date 2019-08-12
*/
@Data
public class AppAddressDTO implements Serializable {

    // 编号
    // 处理精度丢失问题
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    // 测试
    private String areaCode;

    // 地址
    private String areaName;

    // 测试2
    private String center;

    // 测试3
    private String cityCode;

    // 测试4
    private Long level;

    // 测试5
    private Long parentId;
}
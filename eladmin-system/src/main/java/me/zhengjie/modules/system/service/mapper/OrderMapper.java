package me.zhengjie.modules.system.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.system.dojo.Order;
import me.zhengjie.modules.system.domain.EmailConfigA;
import me.zhengjie.modules.system.domain.Job;
import me.zhengjie.modules.system.service.dto.JobDTO;
import me.zhengjie.modules.system.service.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper extends EntityMapper<OrderDTO, Order> {

    /*@Mapping(source = "name", target = "name")
    OrderDTO toDto(Order order, String name);*/
}

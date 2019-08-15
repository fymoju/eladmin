package me.zhengjie.modules.system.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.system.domain.AppAddress;
import me.zhengjie.modules.system.service.dto.AppAddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author jie
* @date 2019-08-12
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppAddressMapper extends EntityMapper<AppAddressDTO, AppAddress> {

}
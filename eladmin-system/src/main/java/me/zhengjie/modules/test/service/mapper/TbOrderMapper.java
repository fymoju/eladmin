package me.zhengjie.modules.test.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.test.domain.TbOrder;
import me.zhengjie.modules.test.service.dto.TbOrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author jie
* @date 2019-08-09
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TbOrderMapper extends EntityMapper<TbOrderDTO, TbOrder> {

}
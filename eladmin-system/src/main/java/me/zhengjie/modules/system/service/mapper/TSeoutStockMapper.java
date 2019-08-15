package me.zhengjie.modules.system.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.system.dojo.TSeoutStock;
import me.zhengjie.modules.system.service.dto.TSeoutStockDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author jie
* @date 2019-08-13
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TSeoutStockMapper extends EntityMapper<TSeoutStockDTO, TSeoutStock> {

}
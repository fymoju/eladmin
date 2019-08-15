package me.zhengjie.modules.recycle.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.recycle.domain.TCompanyFreight;
import me.zhengjie.modules.recycle.service.dto.TCompanyFreightDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author jie
* @date 2019-08-15
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TCompanyFreightMapper extends EntityMapper<TCompanyFreightDTO, TCompanyFreight> {

}
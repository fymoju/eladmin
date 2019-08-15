package me.zhengjie.modules.system.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.system.dojo.AppModel;
import me.zhengjie.modules.system.service.dto.AppModelDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppModelMapper extends EntityMapper<AppModelDto, AppModel> {
}

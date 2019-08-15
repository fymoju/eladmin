package me.zhengjie.modules.system.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.system.domain.EmailConfigA;
import me.zhengjie.modules.system.service.dto.EmailConfigDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmailMapper extends EntityMapper<EmailConfigDTO, EmailConfigA> {


}

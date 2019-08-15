package me.zhengjie.modules.system.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.system.dojo.Dictionary;
import me.zhengjie.modules.system.service.dto.DictionaryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictionaryMapper extends EntityMapper<DictionaryDTO,Dictionary> {
}

package me.zhengjie.modules.system.service;





import me.zhengjie.modules.system.dojo.ModelA;
import me.zhengjie.modules.system.service.dto.ModelDto;

import org.activiti.engine.repository.Model;
import org.springframework.data.domain.Pageable;

import java.io.UnsupportedEncodingException;


public interface ActModelService {

    Object queryAll(ModelDto criteria , Pageable pageable);


    Model create(ModelA resources) throws UnsupportedEncodingException;
}

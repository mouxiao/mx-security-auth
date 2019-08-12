package com.m.x.picture.security.mapper;

import com.m.x.picture.security.api.dto.SystemUser;
import com.m.x.picture.security.persistent.model.SystemUserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

/**
 * @author xiao.mou_tic
 * @date 2019/8/12
 * @remark
 */
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SystemUserMapper {

  @Mapping(target = "authorities", ignore = true)
  SystemUser toSystemUser(SystemUserModel userModel);

}

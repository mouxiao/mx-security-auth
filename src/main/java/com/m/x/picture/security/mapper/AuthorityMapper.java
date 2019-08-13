package com.m.x.picture.security.mapper;

import com.m.x.picture.security.api.dto.SystemAuthority;
import com.m.x.picture.security.persistent.model.SystemAuthorityModel;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

/**
 * @author xiao.mou_tic
 * @date 2019/8/13
 * @remark
 */
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AuthorityMapper {

  SystemAuthority toSystemAuthority(SystemAuthorityModel model);

}

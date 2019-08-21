package com.m.x.picture.security.mapper;

import com.m.x.picture.security.api.dto.SystemAuthority;
import com.m.x.picture.security.api.dto.SystemUrl;
import com.m.x.picture.security.persistent.model.SystemAuthorityModel;
import com.m.x.picture.security.persistent.model.SystemUrlModel;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

/**
 * @author xiao.mou_tic
 * @date 2019/8/13
 * @remark
 */
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AuthorityMapper {

  SystemAuthority toSystemAuthority(SystemAuthorityModel model);


  @Mapping(target = "id", source = "id")
  @Mapping(target = "url", source = "url")
  @Mapping(target = "describe", source = "describe")
  @Mapping(target = "status", source = "status")
  SystemUrl toSystemUrl(SystemUrlModel model);

  List<SystemUrl> toSystemUrls(List<SystemUrlModel> models);

}

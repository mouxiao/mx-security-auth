package com.m.x.picture.security.service;

import com.m.x.picture.security.api.dto.SystemAuthority;
import com.m.x.picture.security.mapper.AuthorityMapper;
import com.m.x.picture.security.persistent.model.QSystemAuthorityModel;
import com.m.x.picture.security.persistent.model.QUserAuthorityModel;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiao.mou_tic
 * @date 2019/8/13
 * @remark
 */
@Service
public class UserAuthorityService extends BaseService {

  @Autowired(required = false)
  AuthorityMapper authorityMapper;

  public List<SystemAuthority> findAuthorityByUserId(Long userId) {
    QSystemAuthorityModel systemAuthorityModel = QSystemAuthorityModel.systemAuthorityModel;
    QUserAuthorityModel userAuthorityModel = QUserAuthorityModel.userAuthorityModel;
    JPAQuery<Tuple> tupleJPAQuery = jpaQueryFactory
        .select(systemAuthorityModel.id, systemAuthorityModel.authority)
        .from(systemAuthorityModel)
        .leftJoin(userAuthorityModel)
        .on(systemAuthorityModel.id.eq(userAuthorityModel.authorityId))
        .where(userAuthorityModel.userId.eq(userId));

    List<SystemAuthority> authorities = tupleJPAQuery.fetch().stream().map(tuple -> {
      return SystemAuthority.builder().id(tuple.get(systemAuthorityModel.id))
          .authority(tuple.get(systemAuthorityModel.authority)).build();
    }).collect(Collectors.toList());
    return authorities;

  }

}

package com.m.x.picture.security.service;

import static java.lang.String.format;

import com.m.x.picture.security.api.dto.SystemUser;
import com.m.x.picture.security.mapper.SystemUserMapper;
import com.m.x.picture.security.persistent.model.QSystemUserModel;
import com.m.x.picture.security.persistent.model.SystemUserModel;
import com.m.x.picture.security.persistent.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author xiao.mou_tic
 * @date 2019/8/9
 * @remark
 */
@Service
public class CustomUserService extends BaseService implements UserDetailsService {

  @Autowired
  private SystemUserRepository systemUserRepository;

  @Autowired(required = false)
  SystemUserMapper systemUserMapper;

  @Autowired
  UserAuthorityService authorityService;

  @Override
  public UserDetails loadUserByUsername(String username) {
    SystemUserModel model = systemUserRepository.findSystemUserModelByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException(
            format("No user found with username '%s'.", username)));
    SystemUser user = systemUserMapper.toSystemUser(model);
    user.setAuthorities(authorityService.findAuthorityByUserId(model.getId()));
    return user;
  }

  public SystemUserModel save(SystemUserModel userModel) {
    return systemUserRepository.save(userModel);
  }

  /**
   * 使用 queryDsl 方式
   */
  public SystemUserModel getSystemUserModelByOne(String username) {
    QSystemUserModel systemUserModel = QSystemUserModel.systemUserModel;
    return jpaQueryFactory.selectFrom(systemUserModel).where(systemUserModel.username.eq(username))
        .fetchOne();
  }
}

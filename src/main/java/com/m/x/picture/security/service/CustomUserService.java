package com.m.x.picture.security.service;

import static java.lang.String.format;

import com.m.x.picture.security.persistent.model.QSystemUserModel;
import com.m.x.picture.security.persistent.model.SystemUserModel;
import com.m.x.picture.security.persistent.repository.SystemUserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
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
public class CustomUserService implements UserDetailsService {

  @Autowired
  private SystemUserRepository systemUserRepository;

  @Autowired
  JPAQueryFactory jpaQueryFactory;

  @Override
  public UserDetails loadUserByUsername(String username){
    return systemUserRepository.findSystemUserModelByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException(format("%s not found", username)));
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

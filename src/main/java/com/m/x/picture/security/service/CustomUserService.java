package com.m.x.picture.security.service;

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
public class CustomUserService implements UserDetailsService {

  @Autowired
  private SystemUserRepository systemUserRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return systemUserRepository.findSystemUserModelByUsername(username);
  }

  public SystemUserModel save(SystemUserModel userModel) {
    return systemUserRepository.save(userModel);
  }
}

package com.m.x.picture.security.service;

import com.m.x.picture.security.MxSecurityAuthApplicationTests;
import com.m.x.picture.security.persistent.model.SystemUserModel;
import java.time.LocalDateTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xiao.mou_tic
 * @date 2019/8/9
 * @remark
 */
public class CustomUserServiceTest extends MxSecurityAuthApplicationTests {


  @Autowired
  CustomUserService customUserService;

  @Test
  public void saveSystemUser() {
    SystemUserModel userModel = new SystemUserModel();
    userModel.setAccountNonExpired(true);
    userModel.setAccountNonLocked(true);
    userModel.setCredentialsNonExpired(true);
    userModel.setEnabled(true);
    userModel.setUsername("admin");
    userModel.setPassword("password");
    userModel.setCreateTime(LocalDateTime.now());
    userModel.setUpdateTime(LocalDateTime.now());
    userModel.setCreateUser("SYSTEM");
    userModel.setUpdateUser("SYSTEM");
    userModel.setTenantCode("SYSTEM");
    customUserService.save(userModel);
  }

}

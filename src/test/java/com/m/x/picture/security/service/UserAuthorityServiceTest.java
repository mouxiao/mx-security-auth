package com.m.x.picture.security.service;

import com.m.x.picture.security.MxSecurityAuthApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xiao.mou_tic
 * @date 2019/8/13
 * @remark
 */
public class UserAuthorityServiceTest extends MxSecurityAuthApplicationTests {

  @Autowired
  UserAuthorityService userAuthorityService;

  @Test
  public void findAuthorityByUserId(){
    System.out.println(userAuthorityService.findAuthorityByUserId(1l));
  }

}

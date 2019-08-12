package com.m.x.picture.security.configuration;

import java.util.Collection;
import java.util.List;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;

/**
 * @author xiao.mou_tic
 * @date 2019/8/9
 * @remark
 */
public class CustomAccessDecisionVoter implements AccessDecisionVoter {

  @Override
  public boolean supports(ConfigAttribute configAttribute) {
    return true;
  }

  @Override
  public int vote(Authentication authentication, Object o, Collection collection) {
    List authorities = (List) authentication.getAuthorities();


    return ACCESS_GRANTED;
  }

  @Override
  public boolean supports(Class aClass) {
    return true;
  }
}

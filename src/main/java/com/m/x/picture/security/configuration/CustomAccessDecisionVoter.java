package com.m.x.picture.security.configuration;

import com.m.x.picture.security.api.dto.SystemUser;
import com.m.x.picture.security.service.AuthorityUrlService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

/**
 * @author xiao.mou_tic
 * @date 2019/8/9
 * @remark
 */
public class CustomAccessDecisionVoter implements AccessDecisionVoter<FilterInvocation> {

  @Autowired
  AuthorityUrlService authorityUrlService;

  @Override
  public boolean supports(ConfigAttribute configAttribute) {
    return true;
  }

  @Override
  public int vote(Authentication authentication, FilterInvocation filterInvocation, Collection collection) {
    List authorities = (List) authentication.getAuthorities();
    assert filterInvocation != null;
    if (authentication.getPrincipal() instanceof SystemUser){
      List<Long> authorityIds = authorityUrlService.getAuthorityUrlByUrl(filterInvocation.getRequestUrl());





    }

    if(!authentication.isAuthenticated()){
      return ACCESS_DENIED;
    }


    return ACCESS_GRANTED;
  }

  @Override
  public boolean supports(Class aClass) {
    return true;
  }
}

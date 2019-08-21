package com.m.x.picture.security.configuration;

import com.m.x.picture.security.api.dto.SystemUrl;
import com.m.x.picture.security.api.dto.SystemUser;
import com.m.x.picture.security.persistent.model.SystemUrlModel;
import com.m.x.picture.security.service.AuthorityUrlService;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

/**
 * @author xiao.mou_tic
 * @date 2019/8/9
 * @remark
 */
@Component
public class CustomAccessDecisionVoter implements AccessDecisionVoter<FilterInvocation> {

  @Autowired
  AuthorityUrlService authorityUrlService;

  @Override
  public boolean supports(ConfigAttribute configAttribute) {
    return true;
  }

  @Override
  public int vote(Authentication authentication, FilterInvocation filterInvocation,
      Collection collection) {
    assert filterInvocation != null;
    String url = filterInvocation.getRequestUrl();
    List<String> systemUrls = authorityUrlService.getSystemUrls().stream()
        .map(SystemUrlModel::getUrl)
        .collect(
            Collectors.toList());
    // 当前URL是否属于管控URL
    if (!systemUrls.contains(url)) {
      return ACCESS_GRANTED;
    }

    if (authentication.getPrincipal() instanceof SystemUser) {
      List<String> urls = ((SystemUser) authentication.getPrincipal()).getUrls().stream()
          .map(SystemUrl::getUrl).collect(
              Collectors.toList());
      //当前URL属于管控URL时,查看当前用户是否具有权限
      if (!urls.contains(url)) {
        return ACCESS_DENIED;
      }
      return ACCESS_GRANTED;
    }

    if (!authentication.isAuthenticated()) {
      return ACCESS_DENIED;
    }

    return ACCESS_DENIED;
  }

  @Override
  public boolean supports(Class aClass) {
    return true;
  }
}

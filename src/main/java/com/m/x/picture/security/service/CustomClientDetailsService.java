package com.m.x.picture.security.service;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

/**
 * @author xiao.mou_tic
 * @date 2020/10/22
 * @remark
 */
public class CustomClientDetailsService implements ClientDetailsService {

  @Override
  public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
    return null;
  }
}

package com.m.x.picture.security.service;

import static java.lang.String.format;

import com.m.x.picture.security.persistent.model.OauthClientDetails;
import com.m.x.picture.security.persistent.repository.OauthClientDetailsRepository;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

/**
 * @author xiao.mou_tic
 * @date 2020/10/22
 * @remark
 */
@Slf4j
@Service
public class CustomClientDetailsService implements ClientDetailsService {

  @Autowired
  OauthClientDetailsRepository oauthClientDetailsRepository;

  @Override
  public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

    OauthClientDetails oauthClientDetails = oauthClientDetailsRepository
        .findOne(Example.of(OauthClientDetails.builder().clientId(clientId).build()))
        .orElseThrow(
            () -> new NoSuchClientException(format("No client with requested id: %s", clientId)));

    BaseClientDetails details = new BaseClientDetails();
    details.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(oauthClientDetails.getAuthorities()));
    details.setAdditionalInformation();
    details.setAccessTokenValiditySeconds();
    details.setAuthorizedGrantTypes();
    details.setAutoApproveScopes();
    details.setClientId();
    details.setClientSecret();
    details.setRefreshTokenValiditySeconds();
    details.setRegisteredRedirectUri();
    details.setResourceIds();
    details.setScope();
    return details;
  }
}

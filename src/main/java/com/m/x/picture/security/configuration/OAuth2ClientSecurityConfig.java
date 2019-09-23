package com.m.x.picture.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;

/**
 * @author xiao.mou_tic
 * @date 2019/8/22
 * @remark
 */
@Configuration
public class OAuth2ClientSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  ClientRegistrationRepository clientRegistrationRepository;

  @Autowired
  @Qualifier(value = "oAuth2AuthorizedClient")
  OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository;

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http
        .oauth2Client()
        .clientRegistrationRepository(clientRegistrationRepository)
        .authorizedClientRepository(oAuth2AuthorizedClientRepository)
//        .authorizedClientService(this.authorizedClientService())
        .authorizationCodeGrant();
//        .authorizationRequestRepository(this.authorizationRequestRepository())
//        .authorizationRequestResolver(this.authorizationRequestResolver())
//        .accessTokenResponseClient(this.accessTokenResponseClient());




//    super.configure(http);
  }



}

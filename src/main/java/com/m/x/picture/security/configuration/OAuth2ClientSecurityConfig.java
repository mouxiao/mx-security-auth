package com.m.x.picture.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

/**
 * @author xiao.mou_tic
 * @date 2019/8/22
 * @remark
 */
@Configuration
public class OAuth2ClientSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private ClientRegistrationRepository clientRegistrationRepository;

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http
        .oauth2Client()
        .clientRegistrationRepository(clientRegistrationRepository);
//        .authorizedClientRepository(this.authorizedClientRepository())
//        .authorizedClientService(this.authorizedClientService())
//        .authorizationCodeGrant()
//        .authorizationRequestRepository(this.authorizationRequestRepository())
//        .authorizationRequestResolver(this.authorizationRequestResolver())
//        .accessTokenResponseClient(this.accessTokenResponseClient());




    super.configure(http);
  }


}

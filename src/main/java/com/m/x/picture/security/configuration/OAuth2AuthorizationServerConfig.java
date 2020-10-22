package com.m.x.picture.security.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author xiao.mou_tic
 * @date 2020/10/22
 * @remark
 */
@Slf4j
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {


    //添加客户端信息
    clients.inMemory()                  // 使用in-memory存储客户端信息
        .withClient("client")       // client_id
        .secret("secret")                   // client_secret
        .authorizedGrantTypes("authorization_code")     // 该client允许的授权类型
        .scopes("app") // 允许的授权范围
        .redirectUris("https://www.baidu.com/")
        .autoApprove(true); //登录后绕过批准询问(/oauth/confirm_access)
    log.info("auth.............................");
  }
}

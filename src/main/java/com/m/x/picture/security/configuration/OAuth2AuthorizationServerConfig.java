package com.m.x.picture.security.configuration;

import java.util.concurrent.TimeUnit;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author xiao.mou_tic
 * @date 2020/10/22
 * @remark
 */
@Slf4j
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private DataSource dataSource;

  @Autowired
  private TokenStore tokenStore;

  private ClientDetailsService clientDetailsService;

  @Bean // 声明TokenStore实现
  public TokenStore tokenStore() {
    return new JdbcTokenStore(dataSource);
  }

  @Bean // 声明 ClientDetails实现
  public ClientDetailsService clientDetails() {
    return new JdbcClientDetailsService(dataSource);
  }


//  @Bean
//  public TokenStore tokenStore() {
//    return new JwtTokenStore(jwtAccessTokenConverter());
//  }

  //使用同一个密钥来编码 JWT 中的  OAuth2 令牌
  @Bean
  public JwtAccessTokenConverter jwtAccessTokenConverter() {
    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
    converter.setSigningKey("123");
    return converter;
  }



  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    log.info("security**************************");
    security
        //允许所有资源服务器访问公钥端点（/oauth/token_key）
        //只允许验证用户访问令牌解析端点（/oauth/check_token）
        .tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()")
        // 允许客户端发送表单来进行权限认证来获取令牌
        .allowFormAuthenticationForClients();
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    log.info("endpoints**************************");
    endpoints.authenticationManager(authenticationManager);
    endpoints.tokenStore(tokenStore);

    // 配置TokenServices参数
    DefaultTokenServices tokenServices = new DefaultTokenServices();
    tokenServices.setTokenStore(endpoints.getTokenStore());
    tokenServices.setSupportRefreshToken(false);
    tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
    tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
    tokenServices.setAccessTokenValiditySeconds( (int) TimeUnit.DAYS.toSeconds(30)); // 30天
    endpoints.tokenServices(tokenServices);

  }

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    log.info("clients**************************");
    clients.withClientDetails(clientDetailsService);
    //添加客户端信息
//    clients.inMemory()                  // 使用in-memory存储客户端信息
//        .withClient("client")       // client_id
//        .secret("secret")                   // client_secret
//        .authorizedGrantTypes("authorization_code")     // 该client允许的授权类型
//        .scopes("app") // 允许的授权范围
//        .redirectUris("https://www.baidu.com/")
//        .autoApprove(true); //登录后绕过批准询问(/oauth/confirm_access)
    log.info("auth.............................");
  }
}

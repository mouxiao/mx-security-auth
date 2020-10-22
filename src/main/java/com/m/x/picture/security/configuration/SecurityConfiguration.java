package com.m.x.picture.security.configuration;

import com.m.x.picture.security.service.CustomUserService;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

/**
 * @author xiao.mou
 * @remark
 * @date 2019/7/10 0010 22:19
 */
@Slf4j
@Order(1)
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


  @Autowired
  private CustomUserService customUserService;

  @Autowired
  private CustomAccessDecisionVoter customAccessDecisionVoter;

  @Autowired
  @Qualifier(value = "clientRegistration")
  ClientRegistrationRepository clientRegistrationRepository;

  @Autowired
  @Qualifier(value = "oAuth2AuthorizedClient")
  OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository;

  /**
   * 基于表单认证
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    log.info("security.............................");
    http
        .authorizeRequests()
        .antMatchers("/", "/login", "/logout", "/actuator/health", "/oauth/**").permitAll()
        .anyRequest()
        .authenticated()
        .accessDecisionManager(accessDecisionManager())
        .and()
        .formLogin()
//        .loginPage("/login")
        .defaultSuccessUrl("/index")
        .permitAll();

    http
        .oauth2Client()
        .clientRegistrationRepository(clientRegistrationRepository)
        .authorizedClientRepository(oAuth2AuthorizedClientRepository)
        .authorizationCodeGrant();
  }


  @SuppressWarnings("deprecation")
  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(customUserService);
  }

  @Bean
  public AccessDecisionManager accessDecisionManager() {
    List<AccessDecisionVoter<? extends Object>> decisionVoters
        = Arrays.asList(
        new WebExpressionVoter(),
        new RoleVoter(),
        new AuthenticatedVoter(),
        customAccessDecisionVoter);
    return new UnanimousBased(decisionVoters);
  }


  @Bean
  public CookieLocaleResolver localeResolver() {
    CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
    cookieLocaleResolver.setDefaultLocale(Locale.CHINA);
    return cookieLocaleResolver;
  }

}
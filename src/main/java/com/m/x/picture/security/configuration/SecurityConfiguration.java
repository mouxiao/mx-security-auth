package com.m.x.picture.security.configuration;

import com.m.x.picture.security.service.CustomUserService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.access.expression.WebExpressionVoter;

/**
 * @author xiao.mou
 * @remark
 * @date 2019/7/10 0010 22:19
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


  @Autowired
  private CustomUserService customUserService;


  /**
   * 基于表单认证
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests().anyRequest().authenticated()
        .accessDecisionManager(accessDecisionManager());

  }


  public PasswordEncoder passwordEncoder() {
    return new Pbkdf2PasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(customUserService).passwordEncoder(passwordEncoder());
  }

  private AccessDecisionManager accessDecisionManager() {
    List<AccessDecisionVoter<? extends Object>> decisionVoters
        = Arrays.asList(
        new WebExpressionVoter(),
        new RoleVoter(),
        new AuthenticatedVoter(),
        new CustomAccessDecisionVoter());
    return new UnanimousBased(decisionVoters);
  }

}
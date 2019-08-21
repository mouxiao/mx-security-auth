package com.m.x.picture.security.configuration;

import com.m.x.picture.security.service.CustomUserService;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
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
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

/**
 * @author xiao.mou
 * @remark
 * @date 2019/7/10 0010 22:19
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


  @Autowired
  private CustomUserService customUserService;

  @Autowired
  private CustomAccessDecisionVoter customAccessDecisionVoter;


  /**
   * 基于表单认证
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http
        .authorizeRequests()
        .antMatchers("/", "/login", "/logout").permitAll()
        .anyRequest()
        .authenticated()
        .accessDecisionManager(accessDecisionManager())
        .and()
        .formLogin()
//        .loginPage("/login")
        .defaultSuccessUrl("/index")
        .permitAll();
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
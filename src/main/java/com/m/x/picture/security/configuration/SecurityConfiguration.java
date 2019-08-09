package com.m.x.picture.security.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author xiao.mou
 * @remark
 * @date 2019/7/10 0010 22:19
 */
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


  /**
   * 基于表单认证
   * @param http
   * @throws Exception
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {



  }
}
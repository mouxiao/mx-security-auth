package com.m.x.picture.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author xiao.mou_tic
 * @date 2019/8/21
 * @remark
 */
@Component
@Order(1)
public class Runner implements ApplicationRunner {

  @Autowired
  private ApplicationContext applicationContext;

  @Override
  public void run(ApplicationArguments args) throws Exception {
//    String arrArgs[] = applicationContext.getBeanDefinitionNames();
//    for (String bean : arrArgs) {
//      System.out.println("beanName:" + bean);
//    }
  }
}

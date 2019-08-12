package com.m.x.picture.security.configuration;

import com.querydsl.jpa.JPQLTemplates;
import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiao.mou_tic
 * @date 2019/8/12
 * @remark
 */
@Configuration
public class QueryDslConfiguration {

  @Autowired(required = false)
  JPQLTemplates jpqlTemplates;

  @Autowired
  EntityManager entityManager;

  @Bean
  public JPAQueryFactory jpaQueryFactory() {
    JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(jpqlTemplates, entityManager);
    return jpaQueryFactory;
  }


}

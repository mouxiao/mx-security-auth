package com.m.x.picture.security.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xiao.mou_tic
 * @date 2019/8/13
 * @remark
 */
public abstract class BaseService {

  @Autowired
  JPAQueryFactory jpaQueryFactory;

}

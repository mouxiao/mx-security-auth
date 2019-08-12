package com.m.x.picture.security.persistent.model.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xiao.mou_tic
 * @date 2019/8/12
 * @remark
 */
@Setter
@Getter
@MappedSuperclass
public class Id {

  @javax.persistence.Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
}

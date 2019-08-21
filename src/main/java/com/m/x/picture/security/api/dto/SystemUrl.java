package com.m.x.picture.security.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xiao.mou_tic
 * @date 2019/8/21
 * @remark
 */
@Setter
@Getter
public class SystemUrl {

  private Long id;
  private String url;
  private String describe;
  private Boolean status;

}

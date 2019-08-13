package com.m.x.picture.security.api.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author xiao.mou_tic
 * @date 2019/8/12
 * @remark
 */
@Data
@Builder
public class SystemAuthority implements GrantedAuthority {

  private Long id;
  private String authority;

}

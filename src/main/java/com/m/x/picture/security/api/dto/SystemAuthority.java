package com.m.x.picture.security.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author xiao.mou_tic
 * @date 2019/8/12
 * @remark
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemAuthority implements GrantedAuthority {

  private Long id;
  private String authority;

}

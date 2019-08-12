package com.m.x.picture.security.api.dto;

import com.m.x.picture.security.persistent.model.Authority;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author xiao.mou_tic
 * @date 2019/8/12
 * @remark
 */
@Data
public class SystemAuthority implements GrantedAuthority {

  private Long id;
  private Authority authority;


  @Override
  public String getAuthority() {
    return authority.name();
  }
}

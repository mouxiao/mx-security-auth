package com.m.x.picture.security.api.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author xiao.mou_tic
 * @date 2019/8/12
 * @remark
 */
@Data
public class SystemUser implements UserDetails {

  private Long id;
  private String tenantCode;
  private String username;
  private String password;
  private Integer status;
  private boolean accountNonExpired;
  private boolean accountNonLocked;
  private boolean credentialsNonExpired;
  private boolean enabled;
  private LocalDateTime createTime;
  private String createUser;
  private LocalDateTime updateTime;
  private String updateUser;
  private Integer version;
  private List<SystemAuthority> authorities;

}

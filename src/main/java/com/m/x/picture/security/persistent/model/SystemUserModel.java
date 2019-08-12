package com.m.x.picture.security.persistent.model;

import java.time.LocalDateTime;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author xiao.mou_tic
 * @date 2019/8/9
 * @remark
 */
@Data
@Entity
@Table(name = "SYS_USER")
public class SystemUserModel implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String tenantCode;
  private String username;
  private String password;
  private Integer status;
  private boolean accountNonExpired;
  private boolean accountNonLocked;
  private boolean credentialsNonExpired;
  private boolean enabled;
  @CreatedDate
  private LocalDateTime createTime;
  @CreatedBy
  private String createUser;
  @LastModifiedDate
  private LocalDateTime updateTime;
  @LastModifiedBy
  private String updateUser;
  @Version
  private Integer version;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }
}

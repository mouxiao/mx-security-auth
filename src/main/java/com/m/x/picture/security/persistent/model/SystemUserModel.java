package com.m.x.picture.security.persistent.model;

import com.m.x.picture.security.persistent.model.base.CreateHaveVersion;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author xiao.mou_tic
 * @date 2019/8/9
 * @remark
 */
@Data
@Entity
@Table(name = "sys_user")
public class SystemUserModel extends CreateHaveVersion {

  private String tenantCode;
  private String username;
  private String password;
  private Integer status;
  private boolean accountNonExpired;
  private boolean accountNonLocked;
  private boolean credentialsNonExpired;
  private boolean enabled;

}

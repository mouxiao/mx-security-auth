package com.m.x.picture.security.persistent.model;

import com.m.x.picture.security.persistent.model.base.CreateHaveVersion;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author xiao.mou_tic
 * @date 2019/8/12
 * @remark 角色
 */
@Data
@Entity
@Table(name = "sys_authority")
public class SystemAuthorityModel extends CreateHaveVersion {

  private String authority;

  private String authorityName;

  private Integer status;

  private String remark;

}

package com.m.x.picture.security.persistent.model;

import com.m.x.picture.security.persistent.model.base.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author xiao.mou_tic
 * @date 2019/8/12
 * @remark
 */
@Data
@Entity
@Table(name = "user_authority")
public class UserAuthorityModel extends Id {

  private Long userId;

  private Long authorityId;

}

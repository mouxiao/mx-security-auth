package com.m.x.picture.security.persistent.model.base;

import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * @author xiao.mou_tic
 * @date 2019/8/12
 * @remark
 */
@Setter
@Getter
@MappedSuperclass
public class Update {

  @LastModifiedDate
  private LocalDateTime updateTime;
  @LastModifiedBy
  private String updateUser;
}

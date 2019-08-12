package com.m.x.picture.security.persistent.model.base;

import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

/**
 * @author xiao.mou_tic
 * @date 2019/8/12
 * @remark
 */
@Setter
@Getter
@MappedSuperclass
public class CreateNoVersion extends Update {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @CreatedDate
  private LocalDateTime createTime;
  @CreatedBy
  private String createUser;
}

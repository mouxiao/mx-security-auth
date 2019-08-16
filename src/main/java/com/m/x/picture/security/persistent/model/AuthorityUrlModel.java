package com.m.x.picture.security.persistent.model;


import com.m.x.picture.security.persistent.model.base.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "authority_url")
public class AuthorityUrlModel extends Id {

  private Long authorityId;
  private Long urlId;
}

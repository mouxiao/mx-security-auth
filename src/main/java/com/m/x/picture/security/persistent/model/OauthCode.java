package com.m.x.picture.security.persistent.model;


import com.m.x.picture.security.persistent.model.base.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "oauth_code")
public class OauthCode extends Id {

  private String code;
  private String authentication;



}

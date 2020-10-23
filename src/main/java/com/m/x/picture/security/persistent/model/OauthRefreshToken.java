package com.m.x.picture.security.persistent.model;


import com.m.x.picture.security.persistent.model.base.CreateHaveVersion;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "oauth_refresh_token")
public class OauthRefreshToken extends CreateHaveVersion {

  private String tokenId;
  private String token;
  private String authentication;



}

package com.m.x.picture.security.persistent.model;


import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "oauth_refresh_token")
public class OauthRefreshToken {

  private String tokenId;
  private String token;
  private String authentication;



}

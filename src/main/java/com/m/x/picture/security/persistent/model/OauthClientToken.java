package com.m.x.picture.security.persistent.model;


import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "oauth_client_token")
public class OauthClientToken {

  private String tokenId;
  private String token;
  private String authenticationId;
  private String userName;
  private String clientId;



}

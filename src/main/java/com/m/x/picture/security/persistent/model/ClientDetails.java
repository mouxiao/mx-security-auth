package com.m.x.picture.security.persistent.model;


import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "client_details")
public class ClientDetails {

  private String appId;
  private String resourceIds;
  private String appSecret;
  private String scope;
  private String grantTypes;
  private String redirectUrl;
  private String authorities;
  private long accessTokenValidity;
  private long refreshTokenValidity;
  private String additionalInformation;
  private String autoApproveScopes;



}

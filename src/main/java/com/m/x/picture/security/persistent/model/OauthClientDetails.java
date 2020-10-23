package com.m.x.picture.security.persistent.model;

import com.m.x.picture.security.persistent.model.base.CreateHaveVersion;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

/**
 * @author xiao.mou_tic
 * @date 2020/10/23
 * @remark
 */
@Data
@Builder
@Entity
@Table(name = "oauth_client_details")
public class OauthClientDetails extends CreateHaveVersion {

  private String clientId;
  private String resourceIds;
  private String clientSecret;
  private String scope;
  private String authorizedGrantTypes;
  private String webServerRedirectUri;
  private String authorities;
  private long accessTokenValidity;
  private long refreshTokenValidity;
  private String additionalInformation;
  private String autoapprove;

}

package com.m.x.picture.security.persistent.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "oauth_approvals")
public class OauthApprovals {

  private String userId;
  private String clientId;
  private String scope;
  private String status;
  private java.sql.Timestamp expiresAt;
  private java.sql.Timestamp lastModifiedAt;



}

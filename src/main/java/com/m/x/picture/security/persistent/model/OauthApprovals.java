package com.m.x.picture.security.persistent.model;

import com.m.x.picture.security.persistent.model.base.Id;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "oauth_approvals")
public class OauthApprovals extends Id {

  private String userId;
  private String clientId;
  private String scope;
  private String status;
  private Date expiresAt;
  private Date lastModifiedAt;



}

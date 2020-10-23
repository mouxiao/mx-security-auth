package com.sample;


import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "oauth_code")
public class OauthCode {

  private String code;
  private String authentication;



}

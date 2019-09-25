package com.m.x.picture.security.persistent.model;

import com.m.x.picture.security.persistent.model.base.CreateHaveVersion;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

/**
 * @author xiao.mou_tic
 * @date 2019/8/22
 * @remark
 */
@Data
@Builder
@Entity
@Table(name = "client_registration")
public class ClientRegistrationModel extends CreateHaveVersion {

    private String registrationId;
    private String clientId;
    private String clientSecret;
    private String redirectUriTemplate;
    private String authorizationUri;
    private String tokenUri;
    private String userInfoUri;
    private String userNameAttributeName;
    private String jwkSetUri;
    private String clientName;
    private AuthorizationGrantType grantType;
    private ClientAuthenticationMethod authenticationMethod;



}

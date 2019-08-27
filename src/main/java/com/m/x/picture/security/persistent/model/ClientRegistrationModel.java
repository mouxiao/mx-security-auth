package com.m.x.picture.security.persistent.model;

import com.m.x.picture.security.persistent.model.base.CreateHaveVersion;
import java.util.Set;

/**
 * @author xiao.mou_tic
 * @date 2019/8/22
 * @remark
 */
public class ClientRegistrationModel extends CreateHaveVersion {

    private String registrationId;
    private String clientId;
    private String clientSecret;
    private String redirectUriTemplate;
    private Set<String> scopes;
    private String authorizationUri;
    private String tokenUri;
    private String userInfoUri;
    private String userNameAttributeName;
    private String jwkSetUri;
    private String clientName;
    private AuthorizationGrantType grantType;
    private ClientAuthenticationMethod authenticationMethod;



}

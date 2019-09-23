package com.m.x.picture.security.persistent.model.auth2;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;

/**
 * @author xiao.mou_tic
 * @date 2019/9/18
 * @remark
 */
public class CustomerOAuth2AuthorizedClient extends OAuth2AuthorizedClient {

    public CustomerOAuth2AuthorizedClient(ClientRegistration clientRegistration, String principalName, OAuth2AccessToken accessToken) {
        super(clientRegistration, principalName, accessToken);
    }

    public CustomerOAuth2AuthorizedClient(ClientRegistration clientRegistration, String principalName, OAuth2AccessToken accessToken, OAuth2RefreshToken refreshToken) {
        super(clientRegistration, principalName, accessToken, refreshToken);
    }
}

package com.m.x.picture.security.persistent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xiao.mou_tic
 * @date 2019/8/27
 * @remark
 */

@Getter
@AllArgsConstructor
public enum AuthorizationGrantType {

    AUTHORIZATION_CODE("authorization_code"),
    IMPLICIT("implicit"),
    REFRESH_TOKEN("refresh_token"),
    CLIENT_CREDENTIALS("client_credentials");

    private String value;

}



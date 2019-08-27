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
public enum ClientAuthenticationMethod {

    BASIC("basic"),
    POST("post");

    private String value;

}

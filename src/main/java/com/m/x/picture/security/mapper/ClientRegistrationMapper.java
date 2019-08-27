package com.m.x.picture.security.mapper;

import com.m.x.picture.security.persistent.model.ClientRegistrationModel;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.security.oauth2.client.registration.ClientRegistration;

/**
 * @author xiao.mou_tic
 * @date 2019/8/27
 * @remark
 */
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ClientRegistrationMapper {

    ClientRegistration toClientRegistration(ClientRegistrationModel model);

}

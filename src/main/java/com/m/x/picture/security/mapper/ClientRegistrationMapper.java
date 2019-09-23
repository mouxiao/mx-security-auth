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

    default ClientRegistration toClientRegistration(ClientRegistrationModel model){
        ClientRegistration clientRegistration = ClientRegistration.withRegistrationId(model.getRegistrationId()).build();
        return clientRegistration;
    }


    default ClientRegistrationModel toClientRegistrationModel(ClientRegistration clientRegistration){
        ClientRegistrationModel model = ClientRegistrationModel.builder().build();
        return model;
    }

}

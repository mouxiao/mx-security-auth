package com.m.x.picture.security.service;

import com.m.x.picture.security.mapper.ClientRegistrationMapper;
import com.m.x.picture.security.persistent.model.ClientRegistrationModel;
import com.m.x.picture.security.persistent.repository.CustomClientRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Service;

/**
 * @author xiao.mou_tic
 * @date 2019/8/22
 * @remark
 */
@Service
public class ClientRegistrationService implements ClientRegistrationRepository {

    @Autowired
    CustomClientRegistrationRepository clientRegistrationRepository;

    @Autowired(required = false)
    ClientRegistrationMapper registrationMapper;

    @Override
    public ClientRegistration findByRegistrationId(String registrationId) {
        ClientRegistrationModel registrationModel = clientRegistrationRepository.findByRegistrationId(registrationId);
        ClientRegistration clientRegistration = registrationMapper.toClientRegistration(registrationModel);
        return clientRegistration;
    }
}

package com.m.x.picture.security.service;

import static java.lang.String.format;

import com.m.x.picture.security.mapper.ClientRegistrationMapper;
import com.m.x.picture.security.persistent.model.ClientRegistrationModel;
import com.m.x.picture.security.persistent.model.auth2.CustomerOAuth2AuthorizedClient;
import com.m.x.picture.security.persistent.repository.CustomClientRegistrationRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.stereotype.Service;

/**
 * @author xiao.mou_tic
 * @date 2019/9/18
 * @remark
 */
@Slf4j
@Service(value = "oAuth2AuthorizedClient")
public class OAuth2AuthorizedClientService implements OAuth2AuthorizedClientRepository {

    @Autowired
    CustomClientRegistrationRepository clientRegistrationRepository;

    @Autowired(required = false)
    ClientRegistrationMapper clientRegistrationMapper;

    @Override
    public CustomerOAuth2AuthorizedClient loadAuthorizedClient(String clientRegistrationId, Authentication principal, HttpServletRequest request) {
        log.info(format("load authorized client, clientRegistrationId: %s", clientRegistrationId));
        ClientRegistrationModel byRegistrationId = clientRegistrationRepository.findByRegistrationId(clientRegistrationId);
        CustomerOAuth2AuthorizedClient auth2AuthorizedClient = new CustomerOAuth2AuthorizedClient(clientRegistrationMapper.toClientRegistration(byRegistrationId), null, null);
        return auth2AuthorizedClient;
    }

    @Override
    public void saveAuthorizedClient(OAuth2AuthorizedClient authorizedClient, Authentication principal, HttpServletRequest request, HttpServletResponse response) {
        log.info(format("save authorized client, clientRegistrationId"));
        ClientRegistration clientRegistration = authorizedClient.getClientRegistration();
        clientRegistrationRepository.save(clientRegistrationMapper.toClientRegistrationModel(clientRegistration));
    }

    @Override
    public void removeAuthorizedClient(String clientRegistrationId, Authentication principal, HttpServletRequest request, HttpServletResponse response) {
        log.info(format("remove authorized client, clientRegistrationId: %s", clientRegistrationId));
        clientRegistrationRepository.deleteByRegistrationId(clientRegistrationId);
    }
}


package com.m.x.picture.security.persistent.repository;

import com.m.x.picture.security.persistent.model.ClientRegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xiao.mou_tic
 * @date 2019/8/22
 * @remark
 */
@Repository
public interface CustomClientRegistrationRepository extends
    JpaRepository<ClientRegistrationModel, Long> {

  ClientRegistrationModel findByRegistrationId(String registrationId);

  void deleteByRegistrationId(String registrationId);

}

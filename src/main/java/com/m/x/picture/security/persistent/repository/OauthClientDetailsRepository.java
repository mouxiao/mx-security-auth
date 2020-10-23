package com.m.x.picture.security.persistent.repository;

import com.m.x.picture.security.persistent.model.OauthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xiao.mou_tic
 * @date 2020/10/23
 * @remark
 */
@Repository
public interface OauthClientDetailsRepository extends JpaRepository<OauthClientDetails, Long> {

}

package com.m.x.picture.security.persistent.repository;

import com.m.x.picture.security.persistent.model.SystemAuthorityModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xiao.mou_tic
 * @date 2019/8/13
 * @remark
 */
public interface AuthorityRepository extends JpaRepository<SystemAuthorityModel, Long> {



}

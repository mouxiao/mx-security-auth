package com.m.x.picture.security.persistent.repository;

import com.m.x.picture.security.persistent.model.SystemUrlModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xiao.mou_tic
 * @date 2019/8/19
 * @remark
 */
@Repository
public interface AuthorityUrlRepository extends JpaRepository<SystemUrlModel, Long> {



}

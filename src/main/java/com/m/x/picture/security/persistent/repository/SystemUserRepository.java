package com.m.x.picture.security.persistent.repository;

import com.m.x.picture.security.persistent.model.SystemUserModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xiao.mou_tic
 * @date 2019/8/9
 * @remark
 */
@Repository
public interface SystemUserRepository extends JpaRepository<SystemUserModel, Long> {

  Optional<SystemUserModel> findSystemUserModelByUsername(String username);


}

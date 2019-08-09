package com.m.x.picture.security.persistent.repository;

import com.m.x.picture.security.persistent.model.QSystemUserModel;
import com.m.x.picture.security.persistent.model.SystemUserModel;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author xiao.mou_tic
 * @date 2019/8/9
 * @remark
 */
@Repository
public interface SystemUserRepository extends JpaRepository<SystemUserModel, Long>,
    QuerydslPredicateExecutor<SystemUserModel> {


  SystemUserModel findSystemUserModelByUsername(String username);

//  default SystemUserModel getSystemUserModelByUsername(String username){
//    QSystemUserModel userModel = QSystemUserModel.systemUserModel;
//    return
//  }

}

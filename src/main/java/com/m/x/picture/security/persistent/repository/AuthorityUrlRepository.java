package com.m.x.picture.security.persistent.repository;

import com.m.x.picture.security.persistent.model.AuthorityUrlModel;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xiao.mou_tic
 * @date 2019/8/19
 * @remark
 */
public interface AuthorityUrlRepository extends JpaRepository<AuthorityUrlModel, Long> {

  Stream<AuthorityUrlModel> findAuthorityUrlModelsByUrlId(Long urlId);

}

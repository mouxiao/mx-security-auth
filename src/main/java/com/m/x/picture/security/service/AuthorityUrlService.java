package com.m.x.picture.security.service;

import com.m.x.picture.security.api.dto.SystemUrl;
import com.m.x.picture.security.mapper.AuthorityMapper;
import com.m.x.picture.security.persistent.model.QAuthorityUrlModel;
import com.m.x.picture.security.persistent.model.QSystemUrlModel;
import com.m.x.picture.security.persistent.model.SystemUrlModel;
import com.m.x.picture.security.persistent.repository.AuthorityUrlRepository;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiao.mou_tic
 * @date 2019/8/19
 * @remark
 */
@Service
public class AuthorityUrlService extends BaseService {


  @Autowired
  AuthorityUrlRepository authorityUrlRepository;

  @Autowired
  AuthorityMapper authorityMapper;


  /**
   * 获取用户可访问的url
   */
  public List<SystemUrl> getAuthorityUrlByUserId(Long userId) {
    QSystemUrlModel systemUrl = QSystemUrlModel.systemUrlModel;
    QAuthorityUrlModel authorityUrl = QAuthorityUrlModel.authorityUrlModel;

    List<SystemUrlModel> models = jpaQueryFactory.select(systemUrl).from(systemUrl)
        .leftJoin(authorityUrl)
        .on(systemUrl.id.eq(authorityUrl.urlId)).where(authorityUrl.authorityId.eq(userId)).fetch();
    return authorityMapper.toSystemUrls(models);
  }

  public List<SystemUrlModel> getSystemUrls() {
    return authorityUrlRepository.findAll();
  }


}

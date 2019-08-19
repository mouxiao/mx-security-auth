package com.m.x.picture.security.service;

import static java.lang.String.format;

import com.m.x.picture.security.exception.NoSuchResourceException;
import com.m.x.picture.security.persistent.model.AuthorityUrlModel;
import com.m.x.picture.security.persistent.model.QSystemUrlModel;
import com.m.x.picture.security.persistent.model.SystemUrlModel;
import com.m.x.picture.security.persistent.repository.AuthorityUrlRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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

  public List<Long> getAuthorityUrlByUrl(String url) {
    QSystemUrlModel systemUrl = QSystemUrlModel.systemUrlModel;
    SystemUrlModel model = Optional.of(jpaQueryFactory.selectFrom(systemUrl)
        .where(systemUrl.url.eq(url)).fetchOne())
        .orElseThrow(() -> new NoSuchResourceException(format("No such url [%s] not found!", url)));
    List<Long> urlIds = authorityUrlRepository.findAuthorityUrlModelsByUrlId(model.getId()).map(
        AuthorityUrlModel::getUrlId).collect(Collectors.toList());
    return urlIds;
  }


}

package com.m.x.picture.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiao.mou_tic
 * @date 2019/8/13
 * @remark
 */
@RestController
@Slf4j
public class IndexController {

  @Value(value = "${test: sss}")
  private String value;

  @GetMapping({"/", "/index"})
  public String index() {

    log.info("return params value:{}", value);
    return "index" + value;
  }

}

package com.m.x.picture.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiao.mou_tic
 * @date 2019/8/13
 * @remark
 */
@RestController
public class IndexController {


  @GetMapping({"/", "/index"})
  public String index() {
    return "index";
  }

}

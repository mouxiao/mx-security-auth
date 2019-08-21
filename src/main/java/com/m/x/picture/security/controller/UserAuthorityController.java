package com.m.x.picture.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiao.mou_tic
 * @date 2019/8/14
 * @remark
 */
@RestController
@RequestMapping("auth")
public class UserAuthorityController {


  @GetMapping("get")
  public String test() {
    return "get";
  }

  @GetMapping("set")
  public String set(){
    return "set";
  }
}

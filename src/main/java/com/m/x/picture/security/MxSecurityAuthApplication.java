package com.m.x.picture.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class MxSecurityAuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(MxSecurityAuthApplication.class, args);
  }

}

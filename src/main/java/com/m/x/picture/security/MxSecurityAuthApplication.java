package com.m.x.picture.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MxSecurityAuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(MxSecurityAuthApplication.class, args);
  }

}

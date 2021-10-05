package com.lq.springcloud.controller;

import com.lq.springcloud.pojo.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
  @Autowired private RestTemplate restTemplate;
  private static final String url = "http://localhost:8001";
  private static final String url1 = "http://COM.LQ.SPRINGCLOUD-PROVIDER";

  @GetMapping("user/get/{id}")
  public Business getUser(@PathVariable("id") Integer id) {

    return restTemplate.getForObject(url1 + "/user/get/" + id, Business.class);
  }
}

package com.lq.springcloud.controller;

import com.lq.springcloud.pojo.Business;
import com.lq.springcloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 控制器
 *
 * @author lq
 * @since 2020-09-17
 */
@Slf4j
@RestController
public class UserController {

  @Autowired private UserService userService;

  @Autowired private DiscoveryClient client;

  @GetMapping("user/get/{id}")
  public Business getUser(@PathVariable("id") Integer id) {

    Business userById = userService.getUserById(id);
    return userById;
  }

  @GetMapping("user/gettime")
  public Long getTime() {

    return System.currentTimeMillis();
  }

  /**
   * 获取一些注册进来的微服务的信息~，
   *
   * @return
   */
  @GetMapping("/dept/discovery")
  public Object discovery() {
    // 获取微服务列表的清单
    List<String> services = client.getServices();
    System.out.println("discovery=>services:" + services);
    // 得到一个具体的微服务信息,通过具体的微服务id，applicaioinName；
    List<ServiceInstance> instances = client.getInstances("com.lq.springcloud-provider");
    for (ServiceInstance instance : instances) {
      System.out.println(
          instance.getHost()
              + "\t"
              + // 主机名称
              instance.getPort()
              + "\t"
              + // 端口号
              instance.getUri()
              + "\t"
              + // uri
              instance.getServiceId() // 服务id
          );
    }
    return this.client;
  }
}

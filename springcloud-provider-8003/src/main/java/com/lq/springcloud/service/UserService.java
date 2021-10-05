package com.lq.springcloud.service;

import com.lq.springcloud.pojo.Business;

/**
 * 服务类
 *
 * @author lq
 * @since 2020-09-17
 */
public interface UserService {

  Business getUserById(Integer id);
}

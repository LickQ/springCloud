package com.lq.springcloud.service.impl;

import com.lq.springcloud.mapper.UserMapper;
import com.lq.springcloud.pojo.Business;
import com.lq.springcloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 *
 * @author lq
 * @since 2020-09-17
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

  @Autowired private UserMapper userMapper;

  @Override
  public Business getUserById(Integer id) {

    return userMapper.getUserById(id);
  }
}

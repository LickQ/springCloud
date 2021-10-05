package com.lq.springcloud.mapper;

import com.lq.springcloud.pojo.Business;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Mapper 接口
 *
 * @author lq
 * @since 2020-09-17
 */
@Repository
public interface UserMapper {

  @Select("select * from business where id=#{id}")
  Business getUserById(@Param("id") Integer id);
}

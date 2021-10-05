package com.lq.springcloud.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Business {
  private Integer id;
  private String name;
}

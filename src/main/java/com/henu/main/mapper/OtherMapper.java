package com.henu.main.mapper;

import com.henu.main.entities.Other;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component(value = "otherMapper")
public interface OtherMapper extends Mapper<Other> {
}

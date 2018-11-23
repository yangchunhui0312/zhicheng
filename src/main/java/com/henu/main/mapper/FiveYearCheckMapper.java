package com.henu.main.mapper;

import com.henu.main.entities.FiveYearCheck;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component(value = "fiveYearCheckMapper")
public interface FiveYearCheckMapper extends Mapper<FiveYearCheck> {
}

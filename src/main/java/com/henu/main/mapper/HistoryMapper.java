package com.henu.main.mapper;

import com.henu.main.entities.History;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component(value = "historyMapper")
public interface HistoryMapper extends Mapper<History> {
}

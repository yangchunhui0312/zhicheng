package com.henu.main.service;

import com.alibaba.fastjson.JSON;
import com.henu.main.entities.History;
import com.henu.main.mapper.HistoryMapper;
import com.henu.main.util.ApplicationInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class HistoryService {

    @Autowired
    HistoryMapper historyMapper;

    @Transactional
    public String selectAll() {
        return JSON.toJSONString(historyMapper.selectAll());
    }

    @Transactional
    public History selectByPrimaryKey(Integer id) {
        return historyMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public int insertSelective(History history) {
        return historyMapper.insertSelective(history);
    }

    @Transactional
    public int deleteByPrimaryKey(Integer id) {
        return historyMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public int updateByPrimaryKeySelective(History history) {
        return historyMapper.updateByPrimaryKeySelective(history);
    }

}

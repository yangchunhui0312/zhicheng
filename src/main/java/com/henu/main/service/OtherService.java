package com.henu.main.service;

import com.henu.main.entities.Other;
import com.henu.main.mapper.OtherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
public class OtherService {

    @Autowired
    OtherMapper otherMapper;

    @Autowired
    DataSource dataSource;

    public List<Other> selectAll() {
        return otherMapper.selectAll();
    }

    public List<Other> selectByExample(Example example) {
        return otherMapper.selectByExample(example);
    }

    public Other selectByPrimaryKey(Integer id) {
        return otherMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Other other) {
        return otherMapper.updateByPrimaryKeySelective(other);
    }

    public int updateByExampleSelective(Other other, Example example) {
        return otherMapper.updateByExampleSelective(other, example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return otherMapper.deleteByPrimaryKey(id);
    }

    public int deleteByExample(Example example) {
        return otherMapper.deleteByExample(example);
    }

    public int insertSelective(Other other) {
        return otherMapper.insertSelective(other);
    }

    public int selectCountByExample(Example example) {
        return otherMapper.selectCountByExample(example);
    }

}

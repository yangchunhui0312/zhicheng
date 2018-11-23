package com.henu.main.service;

import com.henu.main.entities.FiveYearCheck;
import com.henu.main.mapper.FiveYearCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class FiveYearMapperService {

    @Autowired
    FiveYearCheckMapper fiveYearCheckMapper;

    public List<FiveYearCheck> selectAll() {
        return fiveYearCheckMapper.selectAll();
    }

    public FiveYearCheck selectByPrimaryKey(Integer id) {
        return fiveYearCheckMapper.selectByPrimaryKey(id);
    }

    public int insertSelective(FiveYearCheck fiveYearCheck) {
        return fiveYearCheckMapper.insertSelective(fiveYearCheck);
    }

    public int updateByPrimaryKeySelective(FiveYearCheck fiveYearCheck) {
        return fiveYearCheckMapper.updateByPrimaryKeySelective(fiveYearCheck);
    }

    public int deleteByPrimaryKey(Integer id) {
        return fiveYearCheckMapper.deleteByPrimaryKey(id);
    }

    public int deleteByExample(Example example) {
        return fiveYearCheckMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(FiveYearCheck fiveYearCheck, Example example) {
        return fiveYearCheckMapper.updateByExampleSelective(fiveYearCheck, example);
    }

    public List<FiveYearCheck> selectByExample(Example example) {
        return fiveYearCheckMapper.selectByExample(example);
    }


}

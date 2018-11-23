package com.henu.main.mapper;

import com.henu.main.entities.Teacher;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component(value = "teacherMapper")
public interface TeacherMapper extends Mapper<Teacher> {
}

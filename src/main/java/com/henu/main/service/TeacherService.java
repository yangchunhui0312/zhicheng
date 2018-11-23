package com.henu.main.service;

import com.alibaba.fastjson.JSON;
import com.henu.main.entities.Teacher;
import com.henu.main.mapper.TeacherMapper;
import com.henu.main.util.ApplicationInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    /**
     * 查询所有用户
     * <p>
     * 1、获取缓存数据库。
     * 2、如果缓存数据库里面有所有老师的信息，比如 teachers,则直接从缓存数据库中返回数据。
     * 3、如果缓存数据库里面没有所有老师的信息，则会先返回查询的所有教师信息以JSON格式发送出去，然后记录在缓存数据库中。
     * 4、此功能不支持分页查询。
     *
     * @return JSON序列化后的所有教师信息。
     */
    @Transactional
    public String selectAll() {

        // 1、使用缓存情况
        HashMap<String, String> memoryDatabase = ApplicationInit.getMemoryDatabase();
        if (memoryDatabase.containsKey("teachers")) {
            return memoryDatabase.get("teachers");
        } else {
            String result = JSON.toJSONString(teacherMapper.selectAll());
            memoryDatabase.put("teachers", result);
            return result;
        }

        // 2、不使用缓存的情况
//        return JSON.toJSONString(teacherMapper.selectAll());
    }

    /**
     * 刷新同步内存数据库和MySQL数据库的教师表
     * <p>
     * 1、获取缓存数据库。
     * 2、如果缓存数据库里面有 teachers ，则会重新查询MySQL数据库拿到最新的数据结果以JSON格式替换掉原来内存数据库中的 teachers
     * 3、如果缓存数据库里面没有 teachers，则会先返回查询的所有教师信息以JSON格式发送出去，然后记录在缓存数据库中。
     *
     * @return 返回值是一个空字符串，此功能不是用户操作的，是管理员手动在数据库内插入数据后同步内存数据库和MySQL数据库的操作
     */
    @Transactional
    public String flushTeacher() {
        HashMap<String, String> memoryDatabase = ApplicationInit.getMemoryDatabase();
        String result = JSON.toJSONString(teacherMapper.selectAll());
        memoryDatabase.put("teachers", result);
        return "";
    }

    /**
     * 添加用户
     * <p>
     * 1、获取缓存数据库。
     * 2、直接插入到内存数据库中。
     * 3、重新刷新 缓存数据库 中的 teachers，从数据库中查询所有的用户重新赋值。
     *
     * @param teacher 要插入的用户。
     * @return 插入的行数。
     */
    @Transactional
    public int insertSelective(Teacher teacher) {
        try {
            return teacherMapper.insertSelective(teacher);
        } finally {
            HashMap<String, String> memoryDatabase = ApplicationInit.getMemoryDatabase();
            String result = JSON.toJSONString(teacherMapper.selectAll());
            memoryDatabase.put("teachers", result);
        }
    }

    /**
     * 按照条件查询
     * <p>
     * 1、拿到Example对象实例，查询
     * 2、此查询不会记录到内存中
     *
     * @param example Example查询的对象实例
     * @return 返回一个List，查询的结果。
     */
    @Transactional
    public List<Teacher> selectByExample(Example example) {
        return teacherMapper.selectByExample(example);
    }

    /**
     * 按照条件选择性的更新所有用户
     * <p>
     * 1、选择的一般条件是按照用户的身份证号查，因为身份证号不是主键，所以必须要用到Example
     * 2、Example是条件，Teacher是要更新的实例
     * 3、更新完后重新在内存数据库中更新teachers
     *
     * @param teacher
     * @param example
     * @return 更新的条数，一般是1
     */
    @Transactional
    public int updateByExampleSelective(Teacher teacher, Example example) {
        try {
            return teacherMapper.updateByExampleSelective(teacher, example);
        } finally {
            HashMap<String, String> memoryDatabase = ApplicationInit.getMemoryDatabase();
            String result = JSON.toJSONString(teacherMapper.selectAll());
            memoryDatabase.put("teachers", result);
        }
    }

    @Transactional
    public int updateByPrimaryKeySelective(Teacher teacher) {
        try {
            return teacherMapper.updateByPrimaryKeySelective(teacher);
        } finally {
            HashMap<String, String> memoryDatabase = ApplicationInit.getMemoryDatabase();
            String result = JSON.toJSONString(teacherMapper.selectAll());
            memoryDatabase.put("teachers", result);
        }
    }

    /**
     * 按照条件删除用户
     * <p>
     * 1、获得条件Example
     * 2、删除符合条件的teacher
     * 3、更新缓存数据库中的内容 teachers
     *
     * @param example 删除的条件
     * @return 返回修改的条数，一般是1
     */
    @Transactional
    public int deleteByExample(Example example) {
        try {
            return teacherMapper.deleteByExample(example);
        } finally {
            HashMap<String, String> memoryDatabase = ApplicationInit.getMemoryDatabase();
            String result = JSON.toJSONString(teacherMapper.selectAll());
            memoryDatabase.put("teachers", result);
        }
    }

    @Transactional
    public Teacher selectByPrimaryKey(Integer id) {
        return teacherMapper.selectByPrimaryKey(id);
    }

}

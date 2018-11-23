package com.henu.main.controller;

import com.alibaba.fastjson.JSON;
import com.henu.main.entities.History;
import com.henu.main.entities.Teacher;
import com.henu.main.service.HistoryService;
import com.henu.main.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class TeacherController {

    // 希望Linux下也能看到这句话

    @Autowired
    TeacherService teacherService;

    @Autowired
    HistoryService historyService;

    @RequestMapping("/updatePartTimeStudentMajorAndPhone1")
    public String updatePartTimeStudentMajorAndPhone(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("updatePartTimeStudentMajorAndPhone");
        history.setInput(input);
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------

            HashMap map = JSON.parseObject(input, HashMap.class);
            String stringId = (String) map.get("userId");
            Integer id = Integer.parseInt(stringId);
            String partTimeStudentMajorAndPhone = (String) map.get("danrenxueshu");
            Teacher teacher = teacherService.selectByPrimaryKey(id);
            teacher.setPartTimeStudentMajorAndPhone(partTimeStudentMajorAndPhone);
            teacherService.updateByPrimaryKeySelective(teacher);
            out = "{\"status\":\"1\"}";

            // -------------------------业务逻辑代码部分-------------------------
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            Long timeForCalculate2 = System.nanoTime();
            Double timeForCalculate3 = (timeForCalculate2 - timeForCalculate1) / Math.pow(10, 6);
            String now = dateFormat.format(new Date());
            System.out.println(now + "\t\t调用 updatePartTimeStudentMajorAndPhone 方法" + System.getProperty("line.separator") +
                    "----> 传入的数据为\t\t" + input + System.getProperty("line.separator") +
                    "----> 共经历的时间\t\t" + timeForCalculate3 + "毫秒" + System.getProperty("line.separator") +
                    "----> 传出的数据为\t\t" + out + System.getProperty("line.separator"));
//            out = "{\"time\":\"" + timeForCalculate3 + "\"}";
            history.setUser("" + teacher.getId() + "-" + teacher.getName());
            history.setTime(now);
            history.setUseTime("" + timeForCalculate3 + " 毫秒");
            history.setOutput(out);
            return out;
        } finally {
            historyService.insertSelective(history);
        }
    }

    @RequestMapping("/updatePartTimeAdminPositionAndTime1")
    public String updatePartTimeAdminPositionAndTime(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("updatePartTimeAdminPositionAndTime");
        history.setInput(input);
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------

            HashMap map = JSON.parseObject(input, HashMap.class);
            String stringId = (String) map.get("userId");
            Integer id = Integer.parseInt(stringId);
            String partTimeAdminPositionAndTime = (String) map.get("jianren");
            Teacher teacher = teacherService.selectByPrimaryKey(id);
            teacher.setPartTimeAdminPositionAndTime(partTimeAdminPositionAndTime);
            teacherService.updateByPrimaryKeySelective(teacher);
            out = "{\"status\":\"1\"}";

            // -------------------------业务逻辑代码部分-------------------------
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            Long timeForCalculate2 = System.nanoTime();
            Double timeForCalculate3 = (timeForCalculate2 - timeForCalculate1) / Math.pow(10, 6);
            String now = dateFormat.format(new Date());
            System.out.println(now + "\t\t调用 updatePartTimeAdminPositionAndTime 方法" + System.getProperty("line.separator") +
                    "----> 传入的数据为\t\t" + input + System.getProperty("line.separator") +
                    "----> 共经历的时间\t\t" + timeForCalculate3 + "毫秒" + System.getProperty("line.separator") +
                    "----> 传出的数据为\t\t" + out + System.getProperty("line.separator"));
//            out = "{\"time\":\"" + timeForCalculate3 + "\"}";
            history.setUser("" + teacher.getId() + "-" + teacher.getName());
            history.setTime(now);
            history.setUseTime("" + timeForCalculate3 + " 毫秒");
            history.setOutput(out);
            return out;
        } finally {
            historyService.insertSelective(history);
        }
    }

    @RequestMapping("/getStatus")
    public String getMainStatus(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("getMainStatus");
        history.setInput(input);
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------


            HashMap map = JSON.parseObject(input, HashMap.class);
            String stringId = (String) map.get("userId");
            Integer id = Integer.parseInt(stringId);
            Teacher teacher = teacherService.selectByPrimaryKey(id);
            HashMap<String, String> outMap = new HashMap();
            outMap.put("mainStatus0", teacher.getMainStatus0());
            outMap.put("mainStatus1", teacher.getMainStatus1());
            outMap.put("mainStatus2", teacher.getMainStatus2());
            outMap.put("mainStatus3", teacher.getMainStatus3());
            out = JSON.toJSONString(outMap);

            // -------------------------业务逻辑代码部分-------------------------
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            Long timeForCalculate2 = System.nanoTime();
            Double timeForCalculate3 = (timeForCalculate2 - timeForCalculate1) / Math.pow(10, 6);
            String now = dateFormat.format(new Date());
            System.out.println(now + "\t\t调用 getMainStatus 方法" + System.getProperty("line.separator") +
                    "----> 传入的数据为\t\t" + input + System.getProperty("line.separator") +
                    "----> 共经历的时间\t\t" + timeForCalculate3 + "毫秒" + System.getProperty("line.separator") +
                    "----> 传出的数据为\t\t" + out + System.getProperty("line.separator"));
//            out = "{\"time\":\"" + timeForCalculate3 + "\"}";
            history.setUser("" + teacher.getId() + "-" + teacher.getName());
            history.setTime(now);
            history.setUseTime("" + timeForCalculate3 + " 毫秒");
            history.setOutput(out);
            return out;
        } finally {
            historyService.insertSelective(history);
        }
    }

    @RequestMapping("/getLevel")
    public String getLevel(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("getLevel");
        history.setInput(input);
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------

            HashMap map = JSON.parseObject(input, HashMap.class);
            String stringId = (String) map.get("userId");
            Integer id = Integer.parseInt(stringId);
            Teacher teacher = teacherService.selectByPrimaryKey(id);
            HashMap<String, String> outMap = new HashMap();
            outMap.put("status", "" + teacher.getLevel());
            outMap.put("name", "" + teacher.getName());
            out = JSON.toJSONString(outMap);

            // -------------------------业务逻辑代码部分-------------------------
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            Long timeForCalculate2 = System.nanoTime();
            Double timeForCalculate3 = (timeForCalculate2 - timeForCalculate1) / Math.pow(10, 6);
            String now = dateFormat.format(new Date());
            System.out.println(now + "\t\t调用 getLevel 方法" + System.getProperty("line.separator") +
                    "----> 传入的数据为\t\t" + input + System.getProperty("line.separator") +
                    "----> 共经历的时间\t\t" + timeForCalculate3 + "毫秒" + System.getProperty("line.separator") +
                    "----> 传出的数据为\t\t" + out + System.getProperty("line.separator"));
//            out = "{\"time\":\"" + timeForCalculate3 + "\"}";
            history.setUser("");
            history.setTime(now);
            history.setUseTime("" + timeForCalculate3 + " 毫秒");
            history.setOutput(out);
            return out;
        } finally {
            historyService.insertSelective(history);
        }
    }

    @RequestMapping("/selectTeacherByPrimaryKey")
    public String selectTeacherByPrimaryKey(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("getLevel");
        history.setInput(input);
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------

            HashMap map = JSON.parseObject(input, HashMap.class);
            String stringId = (String) map.get("userId");
            Integer id = Integer.parseInt(stringId);
            Teacher teacher = teacherService.selectByPrimaryKey(id);
            out = JSON.toJSONString(teacher);

            // -------------------------业务逻辑代码部分-------------------------
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            Long timeForCalculate2 = System.nanoTime();
            Double timeForCalculate3 = (timeForCalculate2 - timeForCalculate1) / Math.pow(10, 6);
            String now = dateFormat.format(new Date());
            System.out.println(now + "\t\t调用 selectTeacherByPrimaryKey 方法" + System.getProperty("line.separator") +
                    "----> 传入的数据为\t\t" + input + System.getProperty("line.separator") +
                    "----> 共经历的时间\t\t" + timeForCalculate3 + "毫秒" + System.getProperty("line.separator") +
                    "----> 传出的数据为\t\t" + out + System.getProperty("line.separator"));
//            out = "{\"time\":\"" + timeForCalculate3 + "\"}";
            history.setUser("");
            history.setTime(now);
            history.setUseTime("" + timeForCalculate3 + " 毫秒");
            history.setOutput(out);
            return out;
        } finally {
            historyService.insertSelective(history);
        }
    }

    @RequestMapping("insertAndUpdateTeacherByPrimaryKey")
    public String insertAndUpdateTeacherById(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("insertAndUpdateTeacherByPrimaryKey");
        history.setInput(input);
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------

            Teacher teacher = JSON.parseObject(input, Teacher.class);
            Example example = new Example(Teacher.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("primaryKey", teacher.getPrimaryKey());
            List<Teacher> teachers = teacherService.selectByExample(example);
            if (teachers.size() == 1) {
                teacherService.updateByExampleSelective(teacher, example);
                out = "{\"status\":\"2\"}";
            } else {
                int i = teacherService.insertSelective(teacher);
                out = "{\"status\":\"1\"}";
            }

            // -------------------------业务逻辑代码部分-------------------------
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            Long timeForCalculate2 = System.nanoTime();
            Double timeForCalculate3 = (timeForCalculate2 - timeForCalculate1) / Math.pow(10, 6);
            String now = dateFormat.format(new Date());
            System.out.println(now + "\t\t调用 insertAndUpdateTeacherByPrimaryKey 方法" + System.getProperty("line.separator") +
                    "----> 传入的数据为\t\t" + input + System.getProperty("line.separator") +
                    "----> 共经历的时间\t\t" + timeForCalculate3 + "毫秒" + System.getProperty("line.separator") +
                    "----> 传出的数据为\t\t" + out + System.getProperty("line.separator"));
//            out = "{\"time\":\"" + timeForCalculate3 + "\"}";
            history.setUser("系统测试员");
            history.setTime(now);
            history.setUseTime("" + timeForCalculate3 + " 毫秒");
            history.setOutput(out);
            return out;
        } finally {
            historyService.insertSelective(history);
        }
    }

    /**
     * 用户登录
     * <p>
     * 1、传入数据格式是JSON，包含的字段是 userId ，userPassword
     *
     * @param input
     * @return id不存在是1，登陆成功是0，密码错误是2
     */
    @RequestMapping("/login")
    public String login(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("login");
        history.setInput(input);
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------

            HashMap map = JSON.parseObject(input, HashMap.class);
            String stringId = (String) map.get("userId");
            Integer id = Integer.parseInt(stringId);
            String password = (String) map.get("userPassword");
            Teacher teacher = teacherService.selectByPrimaryKey(id);
            if (teacher == null) {
                out = "{\"status\":\"1\"}";  //  当id不存在的时候，返回0
            } else if (teacher.getPassword().equals(password)) {
                out = "{\"status\":\"0\"}";  //  当用户名密码核实成功的时候，返回1
            } else {
                out = "{\"status\":\"2\"}";  //  当密码错误的时候，返回2
            }

            // -------------------------业务逻辑代码部分-------------------------
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            Long timeForCalculate2 = System.nanoTime();
            Double timeForCalculate3 = (timeForCalculate2 - timeForCalculate1) / Math.pow(10, 6);
            String now = dateFormat.format(new Date());
            System.out.println(now + "\t\t调用 login 方法" + System.getProperty("line.separator") +
                    "----> 传入的数据为\t\t" + input + System.getProperty("line.separator") +
                    "----> 共经历的时间\t\t" + timeForCalculate3 + "毫秒" + System.getProperty("line.separator") +
                    "----> 传出的数据为\t\t" + out + System.getProperty("line.separator"));
//            out = "{\"time\":\"" + timeForCalculate3 + "\"}";
            history.setUser("");
            history.setTime(now);
            history.setUseTime("" + timeForCalculate3 + " 毫秒");
            history.setOutput(out);
            return out;
        } finally {
            historyService.insertSelective(history);
        }
    }

    @RequestMapping("/selectAll")
    public String selectAll(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("selectAll");
        history.setInput(input);
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------

            out = teacherService.selectAll();

            // -------------------------业务逻辑代码部分-------------------------
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            Long timeForCalculate2 = System.nanoTime();
            Double timeForCalculate3 = (timeForCalculate2 - timeForCalculate1) / Math.pow(10, 6);
            String now = dateFormat.format(new Date());
            System.out.println(now + "\t\t调用 selectAll 方法" + System.getProperty("line.separator") +
                    "----> 传入的数据为\t\t" + input + System.getProperty("line.separator") +
                    "----> 共经历的时间\t\t" + timeForCalculate3 + "毫秒" + System.getProperty("line.separator") +
                    "----> 传出的数据为\t\t" + out + System.getProperty("line.separator"));
//            out = "{\"time\":\"" + timeForCalculate3 + "\"}";
            history.setInput(input);
            history.setTime(now);
            history.setOutput(out);
            history.setUseTime("" + timeForCalculate3 + " 毫秒");
            history.setUser("系统测试员");
            return out;
        } finally {
            historyService.insertSelective(history);
        }
    }

    @RequestMapping("flushTeacher")
    public String flushTeacher() {
        History history = History.getInstance();
        history.setName("flushTeacher");
        history.setInput("null");
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------

            out = teacherService.flushTeacher();

            // -------------------------业务逻辑代码部分-------------------------
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            Long timeForCalculate2 = System.nanoTime();
            Double timeForCalculate3 = (timeForCalculate2 - timeForCalculate1) / Math.pow(10, 6);
            String now = dateFormat.format(new Date());
            System.out.println(now + "\t\t调用 selectAll 方法" + System.getProperty("line.separator") +
                    "----> 传入的数据为\t\t" + "NULL" + System.getProperty("line.separator") +
                    "----> 共经历的时间\t\t" + timeForCalculate3 + "毫秒" + System.getProperty("line.separator") +
                    "----> 传出的数据为\t\t" + out + System.getProperty("line.separator"));
//            out = "{\"time\":\"" + timeForCalculate3 + "\"}";
            history.setUser("系统测试员");
            history.setTime(now);
            history.setUseTime("" + timeForCalculate3 + " 毫秒");
            history.setOutput(out);
            return out;
        } finally {
            historyService.insertSelective(history);
        }
    }

}

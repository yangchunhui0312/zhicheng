package com.henu.main.controller;

import com.alibaba.fastjson.JSON;
import com.henu.main.entities.History;
import com.henu.main.entities.Other;
import com.henu.main.service.HistoryService;
import com.henu.main.service.OtherService;
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
public class OtherController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    HistoryService historyService;

    @Autowired
    OtherService otherService;

    @RequestMapping("selectOneFromNowGetThePrime")
    public String selectOneFromNowGetThePrime(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("selectOneFromNowGetThePrime");
        history.setInput(input);
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------

            HashMap map = JSON.parseObject(input, HashMap.class);
            String stringId = (String) map.get("userId");
            Example example = new Example(Other.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("tableName", "任现职以来教育教学方面获奖情况-1");
            criteria.andEqualTo("teacherId", stringId);
            criteria.andNotEqualTo("key1", "main");
            example.orderBy("key1").asc();
            List<Other> outList = otherService.selectByExample(example);
            out = JSON.toJSONString(outList);

            // -------------------------业务逻辑代码部分-------------------------
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            Long timeForCalculate2 = System.nanoTime();
            Double timeForCalculate3 = (timeForCalculate2 - timeForCalculate1) / Math.pow(10, 6);
            String now = dateFormat.format(new Date());
            System.out.println(now + "\t\t调用 selectOneFromNowGetThePrime 方法" + System.getProperty("line.separator") +
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

    @RequestMapping("updateOneFromNowGetThePrime")
    public String updateOneFromNowGetThePrime(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("updateOneFromNowGetThePrime");
        history.setInput(input);
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------

            HashMap map = JSON.parseObject(input, HashMap.class);
            String stringId = (String) map.get("userId");
            String userValue = (String) map.get("userValue");
            String[] split = userValue.split(",");
            for (String s : split) {
                String[] split1 = s.split(":");
                Example example = new Example(Other.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("tableName", "任现职以来教育教学方面获奖情况-1");
                criteria.andEqualTo("teacherId", stringId);
                criteria.andEqualTo("key1", split1[0]);
                List<Other> list = otherService.selectByExample(example);
                if (list.size() == 1) {
                    Other other = list.get(0);
                    other.setValue2("" + split1[1]);
                    otherService.updateByPrimaryKeySelective(other);
                }
            }
            out = "{\"status\":\"1\"}";

            // -------------------------业务逻辑代码部分-------------------------
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            Long timeForCalculate2 = System.nanoTime();
            Double timeForCalculate3 = (timeForCalculate2 - timeForCalculate1) / Math.pow(10, 6);
            String now = dateFormat.format(new Date());
            System.out.println(now + "\t\t调用 updateOneFromNowGetThePrime 方法" + System.getProperty("line.separator") +
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

    @RequestMapping("updateFromNowGetThePrime")
    public String updateFromNowGetThePrime(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("updateFromNowGetThePrime");
        history.setInput(input);
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------

            HashMap map = JSON.parseObject(input, HashMap.class);
            String stringId = (String) map.get("userId");
            String huojiang = (String) map.get("huojiang");

            String[] split = huojiang.split("\\n<p>");
            Example example = new Example(Other.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("tableName", "任现职以来教育教学方面获奖情况-1");
            criteria.andEqualTo("teacherId", stringId);
            otherService.deleteByExample(example);
            for (String s : split) {
                if (!s.startsWith("<p>")) {
                    s = "<p>" + s;
                }
                int i = otherService.selectCountByExample(example);
                example.orderBy("key1").asc();
                Other other = new Other();
                other.setTableName("任现职以来教育教学方面获奖情况-1");
                other.setTeacherId(stringId);
                other.setKey1("" + (i + 1));
                other.setValue1(s);
                other.setValue2("1");
                other.setValue3("");
                otherService.insertSelective(other);
            }

            Example example1 = new Example(Other.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("tableName", "任现职以来教育教学方面获奖情况");
            criteria1.andEqualTo("teacherId", stringId);
            criteria1.andEqualTo("key1", "main");
            List<Other> list = otherService.selectByExample(example1);
            Other other = null;
            if (list.size() == 1) {
                other = list.get(0);
            }
            other.setValue1(huojiang);
            otherService.updateByPrimaryKeySelective(other);
            out = "{\"status\":\"1\"}";

            // -------------------------业务逻辑代码部分-------------------------
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            Long timeForCalculate2 = System.nanoTime();
            Double timeForCalculate3 = (timeForCalculate2 - timeForCalculate1) / Math.pow(10, 6);
            String now = dateFormat.format(new Date());
            System.out.println(now + "\t\t调用 updateFromNowGetThePrime 方法" + System.getProperty("line.separator") +
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

    @RequestMapping("selectFromNowGetThePrime")
    public String selectFromNowGetThePrime(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("selectFromNowGetThePrime");
        history.setInput(input);
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------

            HashMap map = JSON.parseObject(input, HashMap.class);
            String stringId = (String) map.get("userId");
            Example example = new Example(Other.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("tableName", "任现职以来教育教学方面获奖情况");
            criteria.andEqualTo("teacherId", stringId);
            List<Other> list = otherService.selectByExample(example);
            if (list.size() == 0) {
                Other other = new Other();
                other.setTableName("任现职以来教育教学方面获奖情况");
                other.setTeacherId(stringId);
                other.setValue1("");
                other.setKey1("main");
                otherService.insertSelective(other);
                HashMap<String, String> outMap = new HashMap();
                outMap.put("huojiang", other.getValue1());
                out = JSON.toJSONString(outMap);
            } else if (list.size() == 1) {
                Other other = list.get(0);
                HashMap<String, String> outMap = new HashMap();
                outMap.put("huojiang", other.getValue1());
                out = JSON.toJSONString(outMap);
            } else {
                out = "{\"status\":\"1\"}";
            }

            // -------------------------业务逻辑代码部分-------------------------
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            Long timeForCalculate2 = System.nanoTime();
            Double timeForCalculate3 = (timeForCalculate2 - timeForCalculate1) / Math.pow(10, 6);
            String now = dateFormat.format(new Date());
            System.out.println(now + "\t\t调用 selectFromNowGetThePrime 方法" + System.getProperty("line.separator") +
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

    @RequestMapping("updatePartTimeAdminPositionAndTime")
    public String updatePartTimeAdminPositionAndTime(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("updatePartTimeAdminPositionAndTime");
        history.setInput(input);
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------

            System.out.println(input);
            HashMap map = JSON.parseObject(input, HashMap.class);
            String stringId = (String) map.get("userId");
            String partTimeAdminPositionAndTime = (String) map.get("jianren");
            Example example = new Example(Other.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("tableName", "兼任");
            criteria.andEqualTo("teacherId", stringId);
            List<Other> list = otherService.selectByExample(example);
            Other other = null;
            if (list.size() == 1) {
                other = list.get(0);
            }
            other.setValue1(partTimeAdminPositionAndTime);
            otherService.updateByPrimaryKeySelective(other);
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
            history.setUser("系统测试员");
            history.setTime(now);
            history.setUseTime("" + timeForCalculate3 + " 毫秒");
            history.setOutput(out);
            return out;
        } finally {
            historyService.insertSelective(history);
        }
    }

    @RequestMapping("selectPartTimeAdminPositionAndTime")
    public String selectPartTimeAdminPositionAndTime(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("selectPartTimeAdminPositionAndTime");
        history.setInput(input);
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------

            HashMap map = JSON.parseObject(input, HashMap.class);
            String stringId = (String) map.get("userId");
            Example example = new Example(Other.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("tableName", "兼任");
            criteria.andEqualTo("teacherId", stringId);
            List<Other> list = otherService.selectByExample(example);
            if (list.size() == 0) {
                Other other = new Other();
                other.setTableName("兼任");
                other.setTeacherId(stringId);
                other.setValue1("");
                otherService.insertSelective(other);
                HashMap<String, String> outMap = new HashMap();
                outMap.put("partTimeAdminPositionAndTime", other.getValue1());
                out = JSON.toJSONString(outMap);
            } else if (list.size() == 1) {
                Other other = list.get(0);
                HashMap<String, String> outMap = new HashMap();
                outMap.put("partTimeAdminPositionAndTime", other.getValue1());
                out = JSON.toJSONString(outMap);
            } else {
                out = "{\"status\":\"1\"}";
            }

            // -------------------------业务逻辑代码部分-------------------------
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            Long timeForCalculate2 = System.nanoTime();
            Double timeForCalculate3 = (timeForCalculate2 - timeForCalculate1) / Math.pow(10, 6);
            String now = dateFormat.format(new Date());
            System.out.println(now + "\t\t调用 selectPartTimeAdminPositionAndTime 方法" + System.getProperty("line.separator") +
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

    @RequestMapping("updatePartTimeStudentMajorAndPhone")
    public String updatePartTimeStudentMajorAndPhone(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("updatePartTimeStudentMajorAndPhone");
        history.setInput(input);
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------

            System.out.println(input);
            HashMap map = JSON.parseObject(input, HashMap.class);
            String stringId = (String) map.get("userId");
            String partTimeAdminPositionAndTime = (String) map.get("danrenxueshu");
            Example example = new Example(Other.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("tableName", "担任");
            criteria.andEqualTo("teacherId", stringId);
            List<Other> list = otherService.selectByExample(example);
            Other other = null;
            if (list.size() == 1) {
                other = list.get(0);
            }
            other.setValue1(partTimeAdminPositionAndTime);
            otherService.updateByPrimaryKeySelective(other);
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
            history.setUser("系统测试员");
            history.setTime(now);
            history.setUseTime("" + timeForCalculate3 + " 毫秒");
            history.setOutput(out);
            return out;
        } finally {
            historyService.insertSelective(history);
        }
    }

    @RequestMapping("selectPartTimeStudentMajorAndPhone")
    public String selectPartTimeStudentMajorAndPhone(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("selectPartTimeStudentMajorAndPhone");
        history.setInput(input);
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------

            HashMap map = JSON.parseObject(input, HashMap.class);
            String stringId = (String) map.get("userId");
            Example example = new Example(Other.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("tableName", "担任");
            criteria.andEqualTo("teacherId", stringId);
            List<Other> list = otherService.selectByExample(example);
            if (list.size() == 0) {
                Other other = new Other();
                other.setTableName("担任");
                other.setTeacherId(stringId);
                other.setValue1("");
                otherService.insertSelective(other);
                HashMap<String, String> outMap = new HashMap();
                outMap.put("partTimeStudentMajorAndPhone", other.getValue1());
                out = JSON.toJSONString(outMap);
            } else if (list.size() == 1) {
                Other other = list.get(0);
                HashMap<String, String> outMap = new HashMap();
                outMap.put("partTimeStudentMajorAndPhone", other.getValue1());
                out = JSON.toJSONString(outMap);
            } else {
                out = "{\"status\":\"1\"}";
            }

            // -------------------------业务逻辑代码部分-------------------------
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            Long timeForCalculate2 = System.nanoTime();
            Double timeForCalculate3 = (timeForCalculate2 - timeForCalculate1) / Math.pow(10, 6);
            String now = dateFormat.format(new Date());
            System.out.println(now + "\t\t调用 selectPartTimeStudentMajorAndPhone 方法" + System.getProperty("line.separator") +
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

    @RequestMapping("workTimeInsert")
    public String workTimeInsert(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("workTimeInsert");
        history.setInput(input);
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------

            HashMap map = JSON.parseObject(input, HashMap.class);
            String teacherId = (String) map.get("userId");
            String value1 = (String) map.get("gongzuojianli");
            Example example = new Example(Other.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("tableName", "工作简历");
            criteria.andEqualTo("teacherId", teacherId);
            List<Other> lists = otherService.selectByExample(example);
            Other other = lists.get(0);
            other.setValue1(value1);
            otherService.updateByPrimaryKeySelective(other);
            out = "{\"status\":\"1\"}";

            // -------------------------业务逻辑代码部分-------------------------
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            Long timeForCalculate2 = System.nanoTime();
            Double timeForCalculate3 = (timeForCalculate2 - timeForCalculate1) / Math.pow(10, 6);
            String now = dateFormat.format(new Date());
            System.out.println(now + "\t\t调用 workTimeInsert 方法" + System.getProperty("line.separator") +
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

    @RequestMapping("workTimeSelect")
    public String workTimeSelect(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("workTimeSelect");
        history.setInput(input);
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------

            HashMap map = JSON.parseObject(input, HashMap.class);
            String teacherId = (String) map.get("userId");
            Example example = new Example(Other.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("tableName", "工作简历");
            criteria.andEqualTo("teacherId", teacherId);
            List<Other> lists = otherService.selectByExample(example);
            if (lists.size() == 0) {
                Other other = new Other();
                other.setTableName("工作简历");
                other.setTeacherId(teacherId);
                other.setValue1("");
                otherService.insertSelective(other);
                HashMap<String, String> outMap = new HashMap<>();
                outMap.put("gongzuojianli", "");
                out = JSON.toJSONString(outMap);
            } else if (lists.size() == 1) {
                Other other = lists.get(0);
                HashMap<String, String> outMap = new HashMap<>();
                outMap.put("gongzuojianli", other.getValue1());
                out = JSON.toJSONString(outMap);
            } else {
                out = "{\"status\":\"1\"}";
            }


            // -------------------------业务逻辑代码部分-------------------------
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            Long timeForCalculate2 = System.nanoTime();
            Double timeForCalculate3 = (timeForCalculate2 - timeForCalculate1) / Math.pow(10, 6);
            String now = dateFormat.format(new Date());
            System.out.println(now + "\t\t调用 workTimeSelect 方法" + System.getProperty("line.separator") +
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

}

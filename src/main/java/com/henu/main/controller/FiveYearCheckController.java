package com.henu.main.controller;

import com.alibaba.fastjson.JSON;
import com.henu.main.entities.FiveYearCheck;
import com.henu.main.entities.History;
import com.henu.main.entities.Teacher;
import com.henu.main.service.FiveYearMapperService;
import com.henu.main.service.HistoryService;
import com.henu.main.service.TeacherService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin
public class FiveYearCheckController {

    @Autowired
    FiveYearMapperService fiveYearMapperService;

    @Autowired
    HistoryService historyService;

    @Autowired
    TeacherService teacherService;

    @RequestMapping("/getAndInitYearList")
    public String getAndInitYearList(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("getAndInitYearList");
        history.setInput(input);
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------

            HashMap map = JSON.parseObject(input, HashMap.class);
            String stringId = (String) map.get("userId");
            Integer id = Integer.parseInt(stringId);
            Teacher teacher = teacherService.selectByPrimaryKey(id);
            Example example = new Example(FiveYearCheck.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("teacherId", id);
            example.orderBy("year").desc();
            List<FiveYearCheck> lists = fiveYearMapperService.selectByExample(example);
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(1);
            ArrayList<Integer> arr = new ArrayList<>();
            for (FiveYearCheck fiveYearCheck : lists) {
                arr.add(Integer.parseInt(fiveYearCheck.getYear()));
            }
            if (!arr.contains(year - 1)) {
                FiveYearCheck fiveYearCheck = new FiveYearCheck(null, id, "" + (year - 1), "");
                fiveYearMapperService.insertSelective(fiveYearCheck);
            }
            if (!arr.contains(year - 2)) {
                FiveYearCheck fiveYearCheck = new FiveYearCheck(null, id, "" + (year - 2), "");
                fiveYearMapperService.insertSelective(fiveYearCheck);
            }
            if (!arr.contains(year - 3)) {
                FiveYearCheck fiveYearCheck = new FiveYearCheck(null, id, "" + (year - 3), "");
                fiveYearMapperService.insertSelective(fiveYearCheck);
            }
            if (!arr.contains(year - 4)) {
                FiveYearCheck fiveYearCheck = new FiveYearCheck(null, id, "" + (year - 4), "");
                fiveYearMapperService.insertSelective(fiveYearCheck);
            }
            if (!arr.contains(year - 5)) {
                FiveYearCheck fiveYearCheck = new FiveYearCheck(null, id, "" + (year - 5), "");
                fiveYearMapperService.insertSelective(fiveYearCheck);
            }

            List<FiveYearCheck> outList = fiveYearMapperService.selectByExample(example);

            HashMap<String, String> outMap = new HashMap<>();
            outMap.put("year1", outList.get(0).getYear());
            outMap.put("year2", outList.get(1).getYear());
            outMap.put("year3", outList.get(2).getYear());
            outMap.put("year4", outList.get(3).getYear());
            outMap.put("year5", outList.get(4).getYear());
            outMap.put("info1", outList.get(0).getInfo());
            outMap.put("info2", outList.get(1).getInfo());
            outMap.put("info3", outList.get(2).getInfo());
            outMap.put("info4", outList.get(3).getInfo());
            outMap.put("info5", outList.get(4).getInfo());

            out = JSON.toJSONString(outMap);

            // -------------------------业务逻辑代码部分-------------------------
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            Long timeForCalculate2 = System.nanoTime();
            Double timeForCalculate3 = (timeForCalculate2 - timeForCalculate1) / Math.pow(10, 6);
            String now = dateFormat.format(new Date());
            System.out.println(now + "\t\t调用 getAndInitYearList 方法" + System.getProperty("line.separator") +
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

    @RequestMapping("/insertAndUpdateFiveYearForTeacherByPrimaryKey")
    public String insertAndUpdateFiveYearForTeacherByPrimaryKey(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("insertAndUpdateFiveYearForTeacherByPrimaryKey");
        history.setInput(input);
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------

            System.out.println(input);
            HashMap inputMap = JSON.parseObject(input, HashMap.class);
            String userId = (String) inputMap.get("userId");
            Integer id = Integer.parseInt(userId);
            Example example = new Example(FiveYearCheck.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("teacherId", id);
            List<FiveYearCheck> list = fiveYearMapperService.selectByExample(example);
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(1);
            for (FiveYearCheck fiveYearCheck : list) {
                if (fiveYearCheck.getYear().equals("" + (year - 1))) {
                    fiveYearCheck.setInfo("" + inputMap.get("year1in"));
                    fiveYearMapperService.updateByPrimaryKeySelective(fiveYearCheck);
                }
                if (fiveYearCheck.getYear().equals("" + (year - 2))) {
                    fiveYearCheck.setInfo("" + inputMap.get("year2in"));
                    fiveYearMapperService.updateByPrimaryKeySelective(fiveYearCheck);
                }
                if (fiveYearCheck.getYear().equals("" + (year - 3))) {
                    fiveYearCheck.setInfo("" + inputMap.get("year3in"));
                    fiveYearMapperService.updateByPrimaryKeySelective(fiveYearCheck);
                }
                if (fiveYearCheck.getYear().equals("" + (year - 4))) {
                    fiveYearCheck.setInfo("" + inputMap.get("year4in"));
                    fiveYearMapperService.updateByPrimaryKeySelective(fiveYearCheck);
                }
                if (fiveYearCheck.getYear().equals("" + (year - 5))) {
                    fiveYearCheck.setInfo("" + inputMap.get("year5in"));
                    fiveYearMapperService.updateByPrimaryKeySelective(fiveYearCheck);
                }
            }
            out = "{\"status\":\"1\"}";

            // -------------------------业务逻辑代码部分-------------------------
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            Long timeForCalculate2 = System.nanoTime();
            Double timeForCalculate3 = (timeForCalculate2 - timeForCalculate1) / Math.pow(10, 6);
            String now = dateFormat.format(new Date());
            System.out.println(now + "\t\t调用 insertAndUpdateFiveYearForTeacherByPrimaryKey 方法" + System.getProperty("line.separator") +
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

}

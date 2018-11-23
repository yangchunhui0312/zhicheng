package com.henu.main.controller;

import com.alibaba.fastjson.JSON;
import com.henu.main.entities.History;
import com.henu.main.entities.Teacher;
import com.henu.main.service.HistoryService;
import com.henu.main.util.ApplicationInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

@RestController
@CrossOrigin
public class TestController {

    @Autowired
    HistoryService historyService;

    @RequestMapping("getMemoryDatabase")
    public String getMemoryDatabase() {
        HashMap<String, String> memoryDatabase = ApplicationInit.getMemoryDatabase();
        String out = JSON.toJSONString(memoryDatabase);
        return out;
    }

    @RequestMapping("template")
    public String template(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("template");
        history.setInput("null");
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------


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
            history.setUser("系统测试员");
            history.setTime(now);
            history.setUseTime("" + timeForCalculate3 + " 毫秒");
            history.setOutput(out);
            return out;
        } finally {
            historyService.insertSelective(history);
        }
    }

    @RequestMapping("/cleanMemoryDatabase")
    public String cleanMemoryDatabase() {
        HashMap<String, String> memoryDatabase = ApplicationInit.getMemoryDatabase();
        int size = memoryDatabase.size();
        memoryDatabase.clear();
        return "内存数据库有 " + size + " 条数据，已全部清空";
    }

    @RequestMapping("/get")
    public String get(@RequestBody String str) {
        ArrayList list = JSON.parseObject(str, ArrayList.class);
        Collections.sort(list);
        int i;
        ArrayList arrayList = new ArrayList();
        for (i = 10; i < 90; i++) {
            arrayList.add(list.get(i));
        }
        Double sum = 0.0;
        for (Object o : arrayList) {
            sum += Double.parseDouble(o.toString());
        }
        Double result = sum / arrayList.size();
        return "{\"result\":\"" + result + "\"}";
    }


}

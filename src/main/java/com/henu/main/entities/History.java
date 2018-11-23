package com.henu.main.entities;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Id;
import javax.persistence.Table;

// 单例设计模式  饿汉 线程安全  程序启动后只要加载此类就会创建这个对象而且线程安全  不需要懒加载
@Table(name = "history")
public class History {

    @Id
    @JSONField(ordinal = 1)
    private Integer id;
    @JSONField(ordinal = 2)
    private String time;
    @JSONField(ordinal = 3)
    private String name;
    @JSONField(ordinal = 4)
    private String user;
    @JSONField(ordinal = 5)
    private String useTime;
    @JSONField(ordinal = 6)
    private String input;
    @JSONField(ordinal = 7)
    private String output;

    private static History history = new History();

    public static History getInstance() {
        return history;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", user='" + user + '\'' +
                ", useTime='" + useTime + '\'' +
                ", input='" + input + '\'' +
                ", output='" + output + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public static History getHistory() {
        return history;
    }

    public static void setHistory(History history) {
        History.history = history;
    }

    private History() {

    }
}

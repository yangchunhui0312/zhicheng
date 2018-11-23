package com.henu.main.entities;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "other")
public class Other {

    @Id
    @JSONField(ordinal = 1)
    private Integer primaryKey;
    @JSONField(ordinal = 2)
    private String teacherId;
    @JSONField(ordinal = 3)
    private String tableName;
    @JSONField(ordinal = 4)
    private String time;
    @JSONField(ordinal = 4)
    private String key1;
    @JSONField(ordinal = 5)
    private String value1;
    @JSONField(ordinal = 6)
    private String value2;
    @JSONField(ordinal = 7)
    private String value3;
    @JSONField(ordinal = 8)
    private String status;
    @JSONField(ordinal = 8)
    private String use1;
    @JSONField(ordinal = 8)
    private String score;

    @Override
    public String toString() {
        return "Other{" +
                "primaryKey=" + primaryKey +
                ", teacherId='" + teacherId + '\'' +
                ", tableName='" + tableName + '\'' +
                ", time='" + time + '\'' +
                ", key1='" + key1 + '\'' +
                ", value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                ", value3='" + value3 + '\'' +
                ", status='" + status + '\'' +
                ", use1='" + use1 + '\'' +
                ", score='" + score + '\'' +
                '}';
    }

    public Integer getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Integer primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUse1() {
        return use1;
    }

    public void setUse1(String use1) {
        this.use1 = use1;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Other(Integer primaryKey, String teacherId, String tableName, String time, String key1, String value1, String value2, String value3, String status, String use1, String score) {
        this.primaryKey = primaryKey;
        this.teacherId = teacherId;
        this.tableName = tableName;
        this.time = time;
        this.key1 = key1;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.status = status;
        this.use1 = use1;
        this.score = score;
    }

    public Other() {
    }
}

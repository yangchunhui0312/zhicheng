package com.henu.main.entities;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "five_year_check")
public class FiveYearCheck {

    @Id
    @JSONField(ordinal = 1)
    private Integer primaryKey;
    @JSONField(ordinal = 2)
    private Integer teacherId;
    @JSONField(ordinal = 3)
    private String year;
    @JSONField(ordinal = 4)
    private String info;

    @Override
    public String toString() {
        return "FiveYearCheck{" +
                "primaryKey=" + primaryKey +
                ", teacherId=" + teacherId +
                ", year='" + year + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    public Integer getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Integer primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public FiveYearCheck(Integer primaryKey, Integer teacherId, String year, String info) {
        this.primaryKey = primaryKey;
        this.teacherId = teacherId;
        this.year = year;
        this.info = info;
    }

    public FiveYearCheck() {
    }
}

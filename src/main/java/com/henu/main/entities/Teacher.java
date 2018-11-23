package com.henu.main.entities;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "teacher")
public class Teacher {

    @Id
    @JSONField(ordinal = 1)
    private Integer primaryKey;  // 教师的主键
    @JSONField(ordinal = 2)
    private String name;  //  教师的姓名
    @JSONField(ordinal = 3)
    private String password;    //  用户登录密码
    @JSONField(ordinal = 4)
    private String id;  //  教师的身份证号码
    @JSONField(ordinal = 5)
    private String birthday;  //  教师的出生年月日
    @JSONField(ordinal = 5)
    private String gender;
    @JSONField(ordinal = 6)
    private String startWorkTime;  //  教师的开始工作时间
    @JSONField(ordinal = 7)
    private String proviceAndCity;  //  教师归属于省直还是市直还是其他
    @JSONField(ordinal = 8)
    private String competentOrganizationId;  //  教师的主管单位的id
    @JSONField(ordinal = 9)
    private String CompetentOrganizationName;  //  教师的主管单位的名称
    @JSONField(ordinal = 10)
    private String workOrganizationId;  //  教师的工作单位的id
    @JSONField(ordinal = 11)
    private String workOrganizationName;  //  教师的工作单位的名称
    @JSONField(ordinal = 12)
    private String nowTeachName;  //  教师现在教授的课程
    @JSONField(ordinal = 13)
    private String nowTeachTime;  //  教师教授此课程的时间
    @JSONField(ordinal = 14)
    private String foreignLanguage;  //  教师的外语语种
    @JSONField(ordinal = 15)
    private String foreignLanguageLevel;  //  教师的外语证书等级
    @JSONField(ordinal = 16)
    private String foreignLanguageTime;  //  教师的外语证书取得时间
    @JSONField(ordinal = 17)
    private String firstEducationName;  //  教师的第一学历名称
    @JSONField(ordinal = 18)
    private String firstEducationTime;  //  教师的第一学历取得时间
    @JSONField(ordinal = 19)
    private String firstEducationInfo;  //  教师的第一学历详情
    @JSONField(ordinal = 20)
    private String highEducationName;  //  教师的最高学历名称
    @JSONField(ordinal = 21)
    private String highEducationTime;  //  教师的最高学历取得时间
    @JSONField(ordinal = 22)
    private String highEducationInfo;  //  教师的最高学历详情
    @JSONField(ordinal = 23)
    private String nowMajorName;  //  教师的现任专业技术职务系列
    @JSONField(ordinal = 24)
    private String nowMajorLevel;  //  教师的现任专业技术职务等级
    @JSONField(ordinal = 25)
    private String nowMajorDuty;  //  教师的现任专业技术职务职务
    @JSONField(ordinal = 26)
    private String nowMajorTime;  //  教师的现任专业技术职务取得时间
    @JSONField(ordinal = 27)
    private String nowMajorTimego;  //  教师的现任专业技术职务聘任时间
    @JSONField(ordinal = 28)
    private String otherMajorName;  //  教师的其他专业技术职务系列
    @JSONField(ordinal = 29)
    private String otherMajorLevel;  //  教师的其他专业技术职务等级
    @JSONField(ordinal = 30)
    private String otherMajorDuty;  //  教师的其他专业技术职务职务
    @JSONField(ordinal = 31)
    private String otherMajorTime;  //  教师的其他专业技术职务取得时间
    @JSONField(ordinal = 32)
    private String otherMajorTimego;  //  教师的其他专业技术职务聘任时间
    @JSONField(ordinal = 33)
    private String commitMajor;  //  表头申报专业
    @JSONField(ordinal = 34)
    private String commitName;  //  表头申报职务名称
    @JSONField(ordinal = 35)
    private String checkType;  //  表头评审类型
    @JSONField(ordinal = 36)
    private String workUnitType;  //  表头单位类型
    @JSONField(ordinal = 37)
    private String level;
    //  教师           0
    //  系管理员        1
    //  教学督导        2
    //  教务部门        3
    //  科研部门        4
    //  人事部门        5
    //  专家           6
    //  超级管理员      7

    @JSONField(ordinal = 38)
    private String mainStatus0;  //  总状态
    @JSONField(ordinal = 39)
    private String mainStatus1;  //  教务
    @JSONField(ordinal = 40)
    private String mainStatus2;  //  科研
    @JSONField(ordinal = 41)
    private String mainStatus3;  //  人事

    @JSONField(ordinal = 42)
    private String partTimeAdminPositionAndTime;  //  兼任行政职务及时间
    @JSONField(ordinal = 43)
    private String partTimeStudentMajorAndPhone;  //  担任学术团体职务或社会兼职及个人联系方式
    @JSONField(ordinal = 44)
    private String tableStatus;  //  表的状态


    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "primaryKey=" + primaryKey +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", startWorkTime='" + startWorkTime + '\'' +
                ", proviceAndCity='" + proviceAndCity + '\'' +
                ", competentOrganizationId='" + competentOrganizationId + '\'' +
                ", CompetentOrganizationName='" + CompetentOrganizationName + '\'' +
                ", workOrganizationId='" + workOrganizationId + '\'' +
                ", workOrganizationName='" + workOrganizationName + '\'' +
                ", nowTeachName='" + nowTeachName + '\'' +
                ", nowTeachTime='" + nowTeachTime + '\'' +
                ", foreignLanguage='" + foreignLanguage + '\'' +
                ", foreignLanguageLevel='" + foreignLanguageLevel + '\'' +
                ", foreignLanguageTime='" + foreignLanguageTime + '\'' +
                ", firstEducationName='" + firstEducationName + '\'' +
                ", firstEducationTime='" + firstEducationTime + '\'' +
                ", firstEducationInfo='" + firstEducationInfo + '\'' +
                ", highEducationName='" + highEducationName + '\'' +
                ", highEducationTime='" + highEducationTime + '\'' +
                ", highEducationInfo='" + highEducationInfo + '\'' +
                ", nowMajorName='" + nowMajorName + '\'' +
                ", nowMajorLevel='" + nowMajorLevel + '\'' +
                ", nowMajorDuty='" + nowMajorDuty + '\'' +
                ", nowMajorTime='" + nowMajorTime + '\'' +
                ", nowMajorTimego='" + nowMajorTimego + '\'' +
                ", otherMajorName='" + otherMajorName + '\'' +
                ", otherMajorLevel='" + otherMajorLevel + '\'' +
                ", otherMajorDuty='" + otherMajorDuty + '\'' +
                ", otherMajorTime='" + otherMajorTime + '\'' +
                ", otherMajorTimego='" + otherMajorTimego + '\'' +
                ", commitMajor='" + commitMajor + '\'' +
                ", commitName='" + commitName + '\'' +
                ", checkType='" + checkType + '\'' +
                ", workUnitType='" + workUnitType + '\'' +
                ", level='" + level + '\'' +
                ", mainStatus0='" + mainStatus0 + '\'' +
                ", mainStatus1='" + mainStatus1 + '\'' +
                ", mainStatus2='" + mainStatus2 + '\'' +
                ", mainStatus3='" + mainStatus3 + '\'' +
                ", partTimeAdminPositionAndTime='" + partTimeAdminPositionAndTime + '\'' +
                ", partTimeStudentMajorAndPhone='" + partTimeStudentMajorAndPhone + '\'' +
                ", tableStatus='" + tableStatus + '\'' +
                '}';
    }

    public Integer getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Integer primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStartWorkTime() {
        return startWorkTime;
    }

    public void setStartWorkTime(String startWorkTime) {
        this.startWorkTime = startWorkTime;
    }

    public String getProviceAndCity() {
        return proviceAndCity;
    }

    public void setProviceAndCity(String proviceAndCity) {
        this.proviceAndCity = proviceAndCity;
    }

    public String getCompetentOrganizationId() {
        return competentOrganizationId;
    }

    public void setCompetentOrganizationId(String competentOrganizationId) {
        this.competentOrganizationId = competentOrganizationId;
    }

    public String getCompetentOrganizationName() {
        return CompetentOrganizationName;
    }

    public void setCompetentOrganizationName(String competentOrganizationName) {
        CompetentOrganizationName = competentOrganizationName;
    }

    public String getWorkOrganizationId() {
        return workOrganizationId;
    }

    public void setWorkOrganizationId(String workOrganizationId) {
        this.workOrganizationId = workOrganizationId;
    }

    public String getWorkOrganizationName() {
        return workOrganizationName;
    }

    public void setWorkOrganizationName(String workOrganizationName) {
        this.workOrganizationName = workOrganizationName;
    }

    public String getNowTeachName() {
        return nowTeachName;
    }

    public void setNowTeachName(String nowTeachName) {
        this.nowTeachName = nowTeachName;
    }

    public String getNowTeachTime() {
        return nowTeachTime;
    }

    public void setNowTeachTime(String nowTeachTime) {
        this.nowTeachTime = nowTeachTime;
    }

    public String getForeignLanguage() {
        return foreignLanguage;
    }

    public void setForeignLanguage(String foreignLanguage) {
        this.foreignLanguage = foreignLanguage;
    }

    public String getForeignLanguageLevel() {
        return foreignLanguageLevel;
    }

    public void setForeignLanguageLevel(String foreignLanguageLevel) {
        this.foreignLanguageLevel = foreignLanguageLevel;
    }

    public String getForeignLanguageTime() {
        return foreignLanguageTime;
    }

    public void setForeignLanguageTime(String foreignLanguageTime) {
        this.foreignLanguageTime = foreignLanguageTime;
    }

    public String getFirstEducationName() {
        return firstEducationName;
    }

    public void setFirstEducationName(String firstEducationName) {
        this.firstEducationName = firstEducationName;
    }

    public String getFirstEducationTime() {
        return firstEducationTime;
    }

    public void setFirstEducationTime(String firstEducationTime) {
        this.firstEducationTime = firstEducationTime;
    }

    public String getFirstEducationInfo() {
        return firstEducationInfo;
    }

    public void setFirstEducationInfo(String firstEducationInfo) {
        this.firstEducationInfo = firstEducationInfo;
    }

    public String getHighEducationName() {
        return highEducationName;
    }

    public void setHighEducationName(String highEducationName) {
        this.highEducationName = highEducationName;
    }

    public String getHighEducationTime() {
        return highEducationTime;
    }

    public void setHighEducationTime(String highEducationTime) {
        this.highEducationTime = highEducationTime;
    }

    public String getHighEducationInfo() {
        return highEducationInfo;
    }

    public void setHighEducationInfo(String highEducationInfo) {
        this.highEducationInfo = highEducationInfo;
    }

    public String getNowMajorName() {
        return nowMajorName;
    }

    public void setNowMajorName(String nowMajorName) {
        this.nowMajorName = nowMajorName;
    }

    public String getNowMajorLevel() {
        return nowMajorLevel;
    }

    public void setNowMajorLevel(String nowMajorLevel) {
        this.nowMajorLevel = nowMajorLevel;
    }

    public String getNowMajorDuty() {
        return nowMajorDuty;
    }

    public void setNowMajorDuty(String nowMajorDuty) {
        this.nowMajorDuty = nowMajorDuty;
    }

    public String getNowMajorTime() {
        return nowMajorTime;
    }

    public void setNowMajorTime(String nowMajorTime) {
        this.nowMajorTime = nowMajorTime;
    }

    public String getNowMajorTimego() {
        return nowMajorTimego;
    }

    public void setNowMajorTimego(String nowMajorTimego) {
        this.nowMajorTimego = nowMajorTimego;
    }

    public String getOtherMajorName() {
        return otherMajorName;
    }

    public void setOtherMajorName(String otherMajorName) {
        this.otherMajorName = otherMajorName;
    }

    public String getOtherMajorLevel() {
        return otherMajorLevel;
    }

    public void setOtherMajorLevel(String otherMajorLevel) {
        this.otherMajorLevel = otherMajorLevel;
    }

    public String getOtherMajorDuty() {
        return otherMajorDuty;
    }

    public void setOtherMajorDuty(String otherMajorDuty) {
        this.otherMajorDuty = otherMajorDuty;
    }

    public String getOtherMajorTime() {
        return otherMajorTime;
    }

    public void setOtherMajorTime(String otherMajorTime) {
        this.otherMajorTime = otherMajorTime;
    }

    public String getOtherMajorTimego() {
        return otherMajorTimego;
    }

    public void setOtherMajorTimego(String otherMajorTimego) {
        this.otherMajorTimego = otherMajorTimego;
    }

    public String getCommitMajor() {
        return commitMajor;
    }

    public void setCommitMajor(String commitMajor) {
        this.commitMajor = commitMajor;
    }

    public String getCommitName() {
        return commitName;
    }

    public void setCommitName(String commitName) {
        this.commitName = commitName;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getWorkUnitType() {
        return workUnitType;
    }

    public void setWorkUnitType(String workUnitType) {
        this.workUnitType = workUnitType;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMainStatus0() {
        return mainStatus0;
    }

    public void setMainStatus0(String mainStatus0) {
        this.mainStatus0 = mainStatus0;
    }

    public String getMainStatus1() {
        return mainStatus1;
    }

    public void setMainStatus1(String mainStatus1) {
        this.mainStatus1 = mainStatus1;
    }

    public String getMainStatus2() {
        return mainStatus2;
    }

    public void setMainStatus2(String mainStatus2) {
        this.mainStatus2 = mainStatus2;
    }

    public String getMainStatus3() {
        return mainStatus3;
    }

    public void setMainStatus3(String mainStatus3) {
        this.mainStatus3 = mainStatus3;
    }

    public String getPartTimeAdminPositionAndTime() {
        return partTimeAdminPositionAndTime;
    }

    public void setPartTimeAdminPositionAndTime(String partTimeAdminPositionAndTime) {
        this.partTimeAdminPositionAndTime = partTimeAdminPositionAndTime;
    }

    public String getPartTimeStudentMajorAndPhone() {
        return partTimeStudentMajorAndPhone;
    }

    public void setPartTimeStudentMajorAndPhone(String partTimeStudentMajorAndPhone) {
        this.partTimeStudentMajorAndPhone = partTimeStudentMajorAndPhone;
    }

    public String getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(String tableStatus) {
        this.tableStatus = tableStatus;
    }

    public Teacher(Integer primaryKey, String name, String password, String id, String birthday, String gender, String startWorkTime, String proviceAndCity, String competentOrganizationId, String competentOrganizationName, String workOrganizationId, String workOrganizationName, String nowTeachName, String nowTeachTime, String foreignLanguage, String foreignLanguageLevel, String foreignLanguageTime, String firstEducationName, String firstEducationTime, String firstEducationInfo, String highEducationName, String highEducationTime, String highEducationInfo, String nowMajorName, String nowMajorLevel, String nowMajorDuty, String nowMajorTime, String nowMajorTimego, String otherMajorName, String otherMajorLevel, String otherMajorDuty, String otherMajorTime, String otherMajorTimego, String commitMajor, String commitName, String checkType, String workUnitType, String level, String mainStatus0, String mainStatus1, String mainStatus2, String mainStatus3, String partTimeAdminPositionAndTime, String partTimeStudentMajorAndPhone, String tableStatus) {
        this.primaryKey = primaryKey;
        this.name = name;
        this.password = password;
        this.id = id;
        this.birthday = birthday;
        this.gender = gender;
        this.startWorkTime = startWorkTime;
        this.proviceAndCity = proviceAndCity;
        this.competentOrganizationId = competentOrganizationId;
        CompetentOrganizationName = competentOrganizationName;
        this.workOrganizationId = workOrganizationId;
        this.workOrganizationName = workOrganizationName;
        this.nowTeachName = nowTeachName;
        this.nowTeachTime = nowTeachTime;
        this.foreignLanguage = foreignLanguage;
        this.foreignLanguageLevel = foreignLanguageLevel;
        this.foreignLanguageTime = foreignLanguageTime;
        this.firstEducationName = firstEducationName;
        this.firstEducationTime = firstEducationTime;
        this.firstEducationInfo = firstEducationInfo;
        this.highEducationName = highEducationName;
        this.highEducationTime = highEducationTime;
        this.highEducationInfo = highEducationInfo;
        this.nowMajorName = nowMajorName;
        this.nowMajorLevel = nowMajorLevel;
        this.nowMajorDuty = nowMajorDuty;
        this.nowMajorTime = nowMajorTime;
        this.nowMajorTimego = nowMajorTimego;
        this.otherMajorName = otherMajorName;
        this.otherMajorLevel = otherMajorLevel;
        this.otherMajorDuty = otherMajorDuty;
        this.otherMajorTime = otherMajorTime;
        this.otherMajorTimego = otherMajorTimego;
        this.commitMajor = commitMajor;
        this.commitName = commitName;
        this.checkType = checkType;
        this.workUnitType = workUnitType;
        this.level = level;
        this.mainStatus0 = mainStatus0;
        this.mainStatus1 = mainStatus1;
        this.mainStatus2 = mainStatus2;
        this.mainStatus3 = mainStatus3;
        this.partTimeAdminPositionAndTime = partTimeAdminPositionAndTime;
        this.partTimeStudentMajorAndPhone = partTimeStudentMajorAndPhone;
        this.tableStatus = tableStatus;
    }
}

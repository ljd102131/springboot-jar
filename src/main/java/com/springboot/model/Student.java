package com.springboot.model;

public class Student {
    private String id;
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年级
     */
    private String grade;

    public Student student(String id,String name,String sex,String grade){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.grade = grade;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

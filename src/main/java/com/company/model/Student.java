package main.java.com.company.model;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private String sex;
    private int age;
    private String major;
    private List<Subject> subjects;

    public Student(int id, String name, String sex, int age, String major) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.major = major;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return this.id + ", "
                + this.name + ", "
                + this.age + ", "
                + this.sex + ", "
                + this.major;
    }
}

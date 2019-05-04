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

    public String getName() {
        return this.name;
    }

    public List<Subject> getSubjects() {
        return this.subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
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

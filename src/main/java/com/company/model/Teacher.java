package main.java.com.company.model;

public class Teacher {
    private final int id;
    private final String name;
    private final String sex;
    private String age;

    public Teacher(int id, String name, String sex, String age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}

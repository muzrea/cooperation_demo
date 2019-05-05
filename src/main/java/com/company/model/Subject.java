package main.java.com.company.model;

public class Subject {
    private final int id;
    private final String name;
    private final Teacher teacher;
    private double score;

    public Subject(int id, String name, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }

    public Subject(int id, String name, Teacher teacher, double score) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.score = score;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public double getScore() {
        return this.score;
    }

    @Override
    public String toString() {
        return this.id + ", " +
                this.name + ", " +
                this.score + ", ";
    }
}

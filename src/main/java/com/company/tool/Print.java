package main.java.com.company.tool;

import main.java.com.company.model.Student;

import java.util.List;

public class Print {

    public void printAllStudentInfor(List<Student> students) {
        System.out.println("");
        students.forEach(item -> System.out.println(item.toString()));
    }

    public void printStudentInfor(Student student) {
        System.out.println("\n" + student.toString());
    }

    public void printStudentScore(Student student) {
        student.getSubjects().forEach(subject -> System.out.println(subject.toString()));
    }

}

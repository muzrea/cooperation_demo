package main.java.com.company.tool;

import main.java.com.company.model.Student;
import main.java.com.company.model.Subject;

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

    public void printStudentsAndScore(List<Student> students) {
        students.forEach(student -> {
            System.out.print(student.getId() + ", " + student.getName() + ", ");
            student.getSubjects().forEach(subject -> System.out.println(subject.getScore()));
        });
    }

    public void printAllSubjectInfor(List<Subject> subjects) {
        System.out.println();
        subjects.forEach(subject -> System.out.println(subject.getId() + ", " +
                subject.getName() + ", " +
                subject.getTeacher().getName()));
    }

    public void printSubjectInfor(Subject subject) {
        System.out.println(subject.getId() + ", " +
                subject.getName() + ", " +
                subject.getTeacher().getName());
    }

}

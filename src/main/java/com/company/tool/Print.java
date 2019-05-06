package main.java.com.company.tool;

import main.java.com.company.model.Student;
import main.java.com.company.model.Subject;

import java.util.List;

public class Print {

    public void printStudentList(List<Student> students) {
        System.out.println();
        students.forEach(this::printStudentInfor);
    }

    public void printStudentInfor(Student student) {
        System.out.println(student.toString());
    }

    public void printStudentScore(Student student) {
        student.getSubjects().forEach(subject -> System.out.println(subject.toString()));
    }

    public void printStudentListWithScore(List<Student> students) {
        students.forEach(student -> {
            System.out.print(student.getId() + ", " + student.getName() + ", ");
            student.getSubjects().forEach(subject -> System.out.println(subject.getScore()));
        });
    }

    public void printSubjectList(List<Subject> subjects) {
        System.out.println();
        subjects.forEach(this::printSubjectInfor);
    }

    public void printSubjectInfor(Subject subject) {
        System.out.println(subject.getId() + ", " +
                subject.getName() + ", " +
                subject.getTeacher().getName());
    }

}

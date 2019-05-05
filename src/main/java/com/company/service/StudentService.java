package main.java.com.company.service;

import main.java.com.company.dao.StudentDao;
import main.java.com.company.model.Student;
import main.java.com.company.tool.Print;
import main.java.com.company.tool.Prompt;
import main.java.com.company.tool.Reader;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
    private StudentDao studentDao = new StudentDao();

    private Print print = new Print();
    private Prompt prompt = new Prompt();
    private Reader reader = new Reader();

    public void getAllStudent() throws SQLException, ClassNotFoundException {
        List<Student> students = this.studentDao.getAllStudent();
        this.print.printAllStudentInfor(students);
    }

    public void getStudentAndScoreByStudentName() throws SQLException, ClassNotFoundException {
        this.prompt.promptInputStudentName();
        String name = this.reader.readUserInput();
        Student student = this.studentDao.getStudentByName(name);
        this.print.printStudentInfor(student);
        this.print.printStudentScore(student);
    }

    public void getStudentNameAndScoreByTeacher() throws SQLException, ClassNotFoundException {
        this.prompt.promptInputTeacherName();
        String teacherName = this.reader.readUserInput();
        List<Student> students = this.studentDao.getStudentByTeacherName(teacherName);
        this.print.printStudentsAndScore(students);
    }

    public void getStudentNameAndScoreBySubject() throws SQLException, ClassNotFoundException {
        this.prompt.promptInputSubjectName();
        String subjectName = this.reader.readUserInput();
        List<Student> students = this.studentDao.getStudentBySubjectName(subjectName);
        this.print.printStudentsAndScore(students);
    }
}

package main.java.com.company.service;

import main.java.com.company.dao.StudentDao;
import main.java.com.company.model.Student;
import main.java.com.company.tool.Print;
import main.java.com.company.tool.Prompt;
import main.java.com.company.tool.Reader;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
    private StudentDao studentDao;

    private Print print;
    private Prompt prompt;
    private Reader reader;

    public StudentService() {
        this.studentDao = new StudentDao();
        this.print = new Print();
        this.prompt = new Prompt();
        this.reader = new Reader();
    }

    public void getAllStudentInfor() throws SQLException, ClassNotFoundException {
        List<Student> students = this.studentDao.getAllStudent();
        this.print.printAllStudentInfor(students);
    }

    public void getStudentInforAndScoreByName() throws SQLException, ClassNotFoundException {
        this.prompt.promptInptStudentName();
        String name = this.getStudentName();
        Student student = this.studentDao.getStudentAndScoreByName(name);
        this.print.printStudentInfor(student);
        this.print.printStudentScore(student);
    }

    private String getStudentName() {
        return this.reader.readUserInput();
    }
}

package main.java.com.company.dao;

import main.java.com.company.model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private BasicDao basicDao;

    public StudentDao() {
        this.basicDao = new BasicDao();
    }

    public List<Student> getAllStudent() throws SQLException, ClassNotFoundException {
        ResultSet allStudent = this.queryAllStudent();
        List<Student> students = new ArrayList<>();
        while (allStudent.next()) {
            int id = allStudent.getInt("id");
            String name = allStudent.getString("name");
            String sex = allStudent.getString("sex");
            int age = allStudent.getInt("age");
            String major = allStudent.getString("major");
            Student student = new Student(id, name, sex, age, major);
            students.add(student);
        }
        return students;
    }

    private ResultSet queryAllStudent() throws SQLException, ClassNotFoundException {
        final String SQL = "SELECT * FROM student";
        Connection connection = basicDao.getConnect();
        Statement statement = basicDao.getStatement(connection);
        return this.basicDao.executeQuerySQL(statement, SQL);
    }
}

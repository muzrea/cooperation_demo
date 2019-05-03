package main.java.com.company.dao;

import main.java.com.company.model.Student;
import main.java.com.company.model.Subject;

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
        ResultSet resultSet = this.queryAllStudent();
        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            int age = resultSet.getInt("age");
            String major = resultSet.getString("major");
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

    public Student getStudentByName(String name) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = this.queryStudentByName(name);
        Student student = null;
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String sex = resultSet.getString("sex");
            int age = resultSet.getInt("age");
            String major = resultSet.getString("major");
            student = new Student(id, name, sex, age, major);
            List<Subject> subjects = new SubjectDao().getAllSubjectByStudentId(id);
            student.setSubjects(subjects);
        }
        return student;
    }

    private ResultSet queryStudentByName(String name) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * " +
                "FROM student " +
                "WHERE name = '" + name + "'";
        Connection connection = this.basicDao.getConnect();
        Statement statement = this.basicDao.getStatement(connection);
        return this.basicDao.executeQuerySQL(statement, sql);
    }
}

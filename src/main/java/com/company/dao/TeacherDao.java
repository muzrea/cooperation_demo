package main.java.com.company.dao;

import main.java.com.company.model.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TeacherDao {

    private BasicDao basicDao;

    public TeacherDao() {
        this.basicDao = new BasicDao();
    }

    public Teacher getTeacherBySubjectId(int subjectId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = this.queryTeacherBySubjectId(subjectId);
        Teacher teacher = null;
        while (resultSet.next()) {
            int id = resultSet.getInt("teacher.id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            int age = resultSet.getInt("age");
            teacher = new Teacher(id, name, sex, age);
        }
        return teacher;
    }

    private ResultSet queryTeacherBySubjectId(int subjectId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT teacher.id, name, sex, age " +
                "FROM teacher " +
                "INNER JOIN subject_teacher " +
                "ON teacher.id = teacher_id " +
                "WHERE subject_id = " + subjectId;
        Connection connection = this.basicDao.getConnect();
        Statement statement = this.basicDao.getStatement(connection);
        return this.basicDao.executeQuerySQL(statement, sql);
    }

    public Teacher getTeacherByName(String name) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = this.queryTeacherByName(name);
        Teacher teacher = null;
        while (resultSet.next()) {
            int id = resultSet.getInt("teacher.id");
            String sex = resultSet.getString("sex");
            int age = resultSet.getInt("age");
            teacher = new Teacher(id, name, sex, age);
        }
        return teacher;
    }

    private ResultSet queryTeacherByName(String name) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM teacher WHERE name = '" + name + "'";
        Connection connection = this.basicDao.getConnect();
        Statement statement = this.basicDao.getStatement(connection);
        return this.basicDao.executeQuerySQL(statement, sql);
    }
}

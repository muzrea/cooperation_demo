package main.java.com.company.dao;

import main.java.com.company.model.Subject;
import main.java.com.company.model.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao {

    private BasicDao basicDao;

    public SubjectDao() {
        this.basicDao = new BasicDao();
    }

    public List<Subject> getAllSubjectByStudentId(int studentId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = this.queryAllSubjectByStudentId(studentId);
        List<Subject> subjects = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("subject.id");
            String name = resultSet.getString("name");
            double score = resultSet.getDouble("score");
            Teacher teacher = new TeacherDao().getTeacherBySubjectId(id);
            Subject subject = new Subject(id, name, teacher, score);
            subjects.add(subject);
        }
        return subjects;
    }

    private ResultSet queryAllSubjectByStudentId(int studentId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT subject.id, name, score " +
                "FROM subject " +
                "INNER JOIN score " +
                "ON subject.id = subject_id " +
                "WHERE student_id = " + studentId;
        Connection connection = this.basicDao.getConnect();
        Statement statement = this.basicDao.getStatement(connection);
        return this.basicDao.executeQuerySQL(statement, sql);
    }

    public Subject getSubjectByTeacherName(String teacherName) throws SQLException, ClassNotFoundException {
        Teacher teacher = new TeacherDao().getTeacherByName(teacherName);
        ResultSet resultSet = this.querySubjectByTeacherId(teacher.getId());
        Subject subject = null;
        while (resultSet.next()) {
            int id = resultSet.getInt("subject.id");
            String name = resultSet.getString("name");
            double score = resultSet.getDouble("score");
            subject = new Subject(id, name, teacher, score);
        }
        return subject;
    }

    private ResultSet querySubjectByTeacherId(int teacherId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT subject.id, name, score " +
                "FROM subject " +
                "INNER JOIN score ON subject.id = subject_id " +
                "INNER JOIN subject_teacher ON teacher_id = " + teacherId;
        Connection connection = this.basicDao.getConnect();
        Statement statement = this.basicDao.getStatement(connection);
        return this.basicDao.executeQuerySQL(statement, sql);
    }

}

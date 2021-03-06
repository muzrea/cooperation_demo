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

    private BasicDao basicDao = new BasicDao();

    public List<Subject> getSubjectByStudentId(int studentId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = this.querySubjectByStudentId(studentId);
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

    private ResultSet querySubjectByStudentId(int studentId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT subject.id, name, score " +
                "FROM subject " +
                "INNER JOIN score " +
                "ON subject.id = subject_id " +
                "WHERE student_id = " + studentId;
        Connection connection = this.basicDao.getConnect();
        Statement statement = this.basicDao.getStatement(connection);
        return this.basicDao.executeQuerySQL(statement, sql);
    }

    public int getSubjectIdByTeacherName(String teacherName) throws SQLException, ClassNotFoundException {
        Teacher teacher = new TeacherDao().getTeacherByName(teacherName);
        return this.getSubjectIdByTeacherId(teacher.getId());
    }

    public int getSubjectIdByTeacherId(int teacherId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = this.querySubjectIdByTeacherId(teacherId);
        int subjectId = 0;
        while (resultSet.next()) {
            subjectId = resultSet.getInt("subject_id");
        }
        return subjectId;
    }

    private ResultSet querySubjectIdByTeacherId(int teacherId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT subject_id " +
                "FROM subject_teacher " +
                "WHERE teacher_id = " + teacherId;
        Connection connection = this.basicDao.getConnect();
        Statement statement = this.basicDao.getStatement(connection);
        return this.basicDao.executeQuerySQL(statement, sql);
    }

    public Subject getSubjectByStudentIdAndSubjectId(int studentId, int subjectId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = this.querySubjectByStudentIdAndSubjectId(studentId, subjectId);
        Subject subject = null;
        while (resultSet.next()) {
            int id = resultSet.getInt("subject.id");
            String name = resultSet.getString("name");
            double score = resultSet.getDouble("score");
            Teacher teacher = new TeacherDao().getTeacherBySubjectId(id);
            subject = new Subject(id, name, teacher, score);
        }
        return subject;
    }

    private ResultSet querySubjectByStudentIdAndSubjectId(int studentId, int subjectId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT subject.id, name, score\n" +
                "FROM subject\n" +
                "INNER JOIN score ON subject.id = subject_id\n" +
                "WHERE subject_id = " + subjectId + "\n" +
                "AND student_id = " + studentId;
        Connection connection = this.basicDao.getConnect();
        Statement statement = this.basicDao.getStatement(connection);
        return this.basicDao.executeQuerySQL(statement, sql);
    }

    public int getSubjectIdBySubjectName(String subjectName) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = this.querySubjectIdBySubjectName(subjectName);
        int subjectId = 0;
        while (resultSet.next()) {
            subjectId = resultSet.getInt("id");
        }
        return subjectId;
    }

    private ResultSet querySubjectIdBySubjectName(String subjectName) throws SQLException, ClassNotFoundException {
        String sql = "SELECT id FROM subject WHERE name = '" + subjectName + "'";
        Connection connection = this.basicDao.getConnect();
        Statement statement = this.basicDao.getStatement(connection);
        return this.basicDao.executeQuerySQL(statement, sql);
    }

    public List<Subject> getAllSubject() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = this.queryAllSubject();
        List<Subject> subjects = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Teacher teacher = new TeacherDao().getTeacherBySubjectId(id);
            Subject subject = new Subject(id, name, teacher);
            subjects.add(subject);
        }
        return subjects;
    }

    private ResultSet queryAllSubject() throws SQLException, ClassNotFoundException {
        final String SQL = "SELECT * FROM subject";
        Connection connection = this.basicDao.getConnect();
        Statement statement = this.basicDao.getStatement(connection);
        return this.basicDao.executeQuerySQL(statement, SQL);
    }

    public Subject getSubjectByName(String name) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = this.querySubjectByName(name);
        Subject subject = null;
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            Teacher teacher = new TeacherDao().getTeacherBySubjectId(id);
            subject = new Subject(id, name, teacher);
        }
        return subject;
    }

    private ResultSet querySubjectByName(String name) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM subject WHERE name = '" + name + "'";
        Connection connection = this.basicDao.getConnect();
        Statement statement = this.basicDao.getStatement(connection);
        return this.basicDao.executeQuerySQL(statement, sql);
    }

    public Subject getSubjectByTeacherName(String teacherName) throws SQLException, ClassNotFoundException {
        Teacher teacher = new TeacherDao().getTeacherByName(teacherName);
        int subjectId = this.getSubjectIdByTeacherId(teacher.getId());
        ResultSet resultSet = this.querySubjectById(subjectId);
        Subject subject = null;
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            subject = new Subject(subjectId, name, teacher);
        }
        return subject;

    }

    private ResultSet querySubjectById(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM subject WHERE id = " + id;
        Connection connection = this.basicDao.getConnect();
        Statement statement = this.basicDao.getStatement(connection);
        return this.basicDao.executeQuerySQL(statement, sql);
    }

}

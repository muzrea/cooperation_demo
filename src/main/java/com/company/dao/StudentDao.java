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
    private BasicDao basicDao = new BasicDao();

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
            List<Subject> subjects = new SubjectDao().getSubjectByStudentId(id);
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

    public List<Student> getStudentByTeacherName(String teacherName) throws SQLException, ClassNotFoundException {
        SubjectDao subjectDao = new SubjectDao();
        int subjectId = subjectDao.getSubjectIdByTeacherName(teacherName);
        List<Student> students = new ArrayList<>();
        List<Integer> studentIdList = this.getStudentIdBySubjectId(subjectId);
        for (Integer studentId : studentIdList) {
            Student student = getStudentById(studentId);
            Subject subject = subjectDao.getSubjectByStudentIdAndSubjectId(studentId, subjectId);
            List<Subject> subjects = new ArrayList<>();
            subjects.add(subject);
            student.setSubjects(subjects);
            students.add(student);
        }
        return students;
    }

    public List<Integer> getStudentIdBySubjectId(int subjectId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = this.queryStudentIdBySubjectId(subjectId);
        List<Integer> idList = new ArrayList<>();
        while (resultSet.next()) {
            int studentId = resultSet.getInt("student_id");
            idList.add(studentId);
        }
        return idList;
    }

    private ResultSet queryStudentIdBySubjectId(int subjectId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT student_id " +
                "FROM score " +
                "WHERE subject_id = " + subjectId;
        Connection connection = this.basicDao.getConnect();
        Statement statement = this.basicDao.getStatement(connection);
        return this.basicDao.executeQuerySQL(statement, sql);
    }

    public Student getStudentById(int id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = queryStudentById(id);
        Student student = null;
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            int age = resultSet.getInt("age");
            String major = resultSet.getString("major");
            student = new Student(id, name, sex, age, major);
        }
        return student;
    }

    private ResultSet queryStudentById(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM student WHERE id = " + id;
        Connection connection = this.basicDao.getConnect();
        Statement statement = this.basicDao.getStatement(connection);
        return this.basicDao.executeQuerySQL(statement, sql);
    }

    public List<Student> getStudentBySubjectName(String subjectName) throws SQLException, ClassNotFoundException {
        SubjectDao subjectDao = new SubjectDao();
        int subjectId = subjectDao.getSubjectIdBySubjectName(subjectName);
        List<Integer> studentIdList = this.getStudentIdBySubjectId(subjectId);
        List<Student> students = new ArrayList<>();
        for (Integer studentId : studentIdList) {
            Student student = this.getStudentById(studentId);
            Subject subject = subjectDao.getSubjectByStudentIdAndSubjectId(studentId, subjectId);
            List<Subject> subjects = new ArrayList<>();
            subjects.add(subject);
            student.setSubjects(subjects);
            students.add(student);
        }
        return students;
    }
}

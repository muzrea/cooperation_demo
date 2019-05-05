package main.java.com.company.service;

import main.java.com.company.dao.SubjectDao;
import main.java.com.company.model.Subject;
import main.java.com.company.tool.Print;

import java.sql.SQLException;
import java.util.List;

public class SubjectService {

    private SubjectDao subjectDao;

    private Print print;

    public SubjectService() {
        this.subjectDao = new SubjectDao();
        this.print = new Print();
    }

    public void getAllSubject() throws SQLException, ClassNotFoundException {
        List<Subject> subjects = this.subjectDao.getAllSubject();
        this.print.printAllSubjectInfor(subjects);
    }
}

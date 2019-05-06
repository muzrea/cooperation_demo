package main.java.com.company.service;

import main.java.com.company.dao.SubjectDao;
import main.java.com.company.model.Subject;
import main.java.com.company.tool.Print;
import main.java.com.company.tool.Prompt;
import main.java.com.company.tool.Reader;

import java.sql.SQLException;
import java.util.List;

public class SubjectService {

    private SubjectDao subjectDao = new SubjectDao();

    private Print print = new Print();
    private Reader reader = new Reader();
    private Prompt prompt = new Prompt();

    public void getAllSubject() throws SQLException, ClassNotFoundException {
        List<Subject> subjects = this.subjectDao.getAllSubject();
        this.print.printAllSubjectInfor(subjects);
    }

    public void getSubjectByName() throws SQLException, ClassNotFoundException {
        this.prompt.promptInputSubjectName();
        String name = this.reader.readUserInput();
        Subject subject = this.subjectDao.getSubjectByName(name);
        this.print.printSubjectInfor(subject);
    }
}

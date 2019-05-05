package main.java.com.company.service;

import main.java.com.company.model.MainMenu;
import main.java.com.company.tool.Prompt;
import main.java.com.company.tool.Reader;

import java.sql.SQLException;

public class MainService {

    private Prompt prompt = new Prompt();
    private Reader reader = new Reader();

    private UserService userService = new UserService();
    private StudentService studentService = new StudentService();

    public void mainService() throws SQLException, ClassNotFoundException {
        this.prompt.promptWelcome();
        this.login();
        MainMenu mainMenu = userService.getMainMenu();
        this.prompt.promptOperationOptions(mainMenu);
        String option = this.getOption(mainMenu);
        switch (option) {
            case "1.1.1":
                this.studentService.getAllStudent();
                break;
            case "1.1.2":
                this.studentService.getStudentAndScoreByStudentName();
                break;
            case "1.1.3":
                this.studentService.getStudentNameAndScoreByTeacher();
                break;
            case "1.1.4":
                this.studentService.getStudentNameAndScoreBySubject();
                break;
            default:
                break;
        }
    }

    private void login() throws SQLException, ClassNotFoundException {
        this.prompt.promptInputUsername();
        String username = this.reader.readUserInput();
        this.prompt.promptInputPassword();
        String password = this.reader.readUserInput();
        boolean loginResult = this.userService.login(username, password);
        if (!loginResult) {
            this.prompt.promptIllegalLoginInfor();
            this.login();
        }
    }

    private String getOption(MainMenu mainMenu) {
        String option = this.reader.readUserInput();
        boolean verifyResult = this.verifyOption(option, mainMenu);
        if (!verifyResult) {
            this.prompt.promptIllegalOption();
            option = getOption(mainMenu);
        }
        return option;
    }

    private boolean verifyOption(String option, MainMenu mainMenu) {
        return mainMenu.getAvailableOptions().get(option) != null;
    }
}

package main.java.com.company.service;

import main.java.com.company.model.MainMenu;
import main.java.com.company.tool.Prompt;
import main.java.com.company.tool.Reader;

import java.sql.SQLException;

public class MainService {

    private Prompt prompt = new Prompt();
    private Reader reader = new Reader();
    private UserService userService = new UserService();

    public void mainService() throws SQLException, ClassNotFoundException {
        this.prompt.promptWelcome();
        this.login();
        MainMenu mainMenu = userService.getMainMenu();
        this.prompt.promptOperationOptions(mainMenu);
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
}

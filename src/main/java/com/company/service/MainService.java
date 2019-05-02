package main.java.com.company.service;

import main.java.com.company.model.MainMenu;
import main.java.com.company.tool.Prompt;
import main.java.com.company.tool.ReadInput;

import java.sql.SQLException;

public class MainService {

    Prompt prompt = new Prompt();
    ReadInput readInput = new ReadInput();
    UserService userService = new UserService();

    public void mainService() throws SQLException, ClassNotFoundException {
        this.prompt.promptWelcome();
        this.login();
        MainMenu mainMenu = userService.getMainMenu();
        this.prompt.promptOperationOptions(mainMenu);
    }

    public void login() throws SQLException, ClassNotFoundException {
        this.prompt.promptInputUsername();
        String username = this.readInput.readUserInput();
        this.prompt.promptInputPassword();
        String password = this.readInput.readUserInput();
        boolean loginResult = this.userService.login(username, password);
        if (!loginResult) {
            this.prompt.promptIllegalLoginInfor();
            this.login();
        }
    }
}

package main.java.com.company.service;

import main.java.com.company.dao.UserDao;
import main.java.com.company.model.MainMenu;
import main.java.com.company.model.User;

import java.sql.SQLException;

public class UserService {
    private UserDao userDao = new UserDao();
    private User user;

    public boolean login(String username, String password) throws SQLException, ClassNotFoundException {
        this.user = this.userDao.getUser(username, password);
        return this.user != null;
    }

    public MainMenu getMainMenu() {
        MainMenu mainMenu = new MainMenu();
        mainMenu.setRoleName(this.user.getRole().getName());
        mainMenu.setAvailableOptions(this.user.getRole());
        return mainMenu;
    }
}

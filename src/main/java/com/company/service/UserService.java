package main.java.com.company.service;

import main.java.com.company.dao.UserDao;
import main.java.com.company.model.User;

public class UserService {
    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public boolean login(String username, String password) {
        User user = this.userDao.getUser(username, password);
        return user != null;
    }
}

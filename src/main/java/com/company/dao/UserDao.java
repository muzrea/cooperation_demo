package main.java.com.company.dao;

import main.java.com.company.model.Role;
import main.java.com.company.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
    private BasicDao basicDao;

    public UserDao() {
        this.basicDao = new BasicDao();
    }

    public User getUser(String username, String password) {
        String sql = "SELECT id, role_id FROM user WHERE username = \'" + username
                + "\' AND password = \'" + password + "\'";
        Connection connection = this.basicDao.getConnect();
        Statement statement = this.basicDao.getStatement(connection);
        ResultSet resultSet = this.basicDao.executeQuerySQL(statement, sql);
        User user = null;
        try {
            int user_id = resultSet.getInt("id");
            int role_id = resultSet.getInt("role_id");
            Role role = new RoleDao().getRole(role_id);
            user = new User(user_id, username, password, role);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.basicDao.closeConnection(resultSet, statement, connection);
        return user;
    }

}

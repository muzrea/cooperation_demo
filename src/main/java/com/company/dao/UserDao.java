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

    public User getUser(String username, String password) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = this.queryUserIdAndRoleId(username, password);
        User user = null;
        while (resultSet.next()) {
            int user_id = resultSet.getInt("id");
            int role_id = resultSet.getInt("role_id");
            Role role = new RoleDao().getRole(role_id);
            user = new User(user_id, username, password, role);
        }
        return user;
    }

    private ResultSet queryUserIdAndRoleId(String username, String password)
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT id, role_id\n" +
                "FROM user\n" +
                "WHERE username = '" + username + "'\n" +
                "AND password = '" + password + "'";
        Connection connection = this.basicDao.getConnect();
        Statement statement = this.basicDao.getStatement(connection);
        return this.basicDao.executeQuerySQL(statement, sql);
    }

}

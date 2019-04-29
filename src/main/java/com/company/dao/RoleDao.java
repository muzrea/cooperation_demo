package main.java.com.company.dao;

import main.java.com.company.model.Profile;
import main.java.com.company.model.Role;
import main.java.com.company.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class RoleDao {
    private BasicDao basicDao;

    public RoleDao() {
        this.basicDao = new BasicDao();
    }

    public Role getRole(int role_id) {
        String sql = "SELECT name " +
                "FROM role " +
                "WHERE id = " + role_id;
        Connection connection = this.basicDao.getConnect();
        Statement statement = this.basicDao.getStatement(connection);
        ResultSet resultSet = this.basicDao.executeQuerySQL(statement, sql);
        Role role = null;
        try {
            String role_name = resultSet.getString("name");
            List<Profile> profiles = new ProfileDao().getProfile(role_id);
            role = new Role(role_id, role_name, profiles);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.basicDao.closeConnection(resultSet, statement, connection);
        return role;
    }
}
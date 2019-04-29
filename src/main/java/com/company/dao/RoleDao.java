package main.java.com.company.dao;

import main.java.com.company.model.Profile;
import main.java.com.company.model.Role;

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

    public Role getRole(int role_id) throws SQLException, ClassNotFoundException {
        String role_name = this.queryRoleNameById(role_id).getString("name");
        List<Profile> profiles = new ProfileDao().getProfile(role_id);
        return new Role(role_id, role_name, profiles);
    }

    private ResultSet queryRoleNameById(int role_id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT name " +
                "FROM role " +
                "WHERE id = " + role_id;
        Connection connection = this.basicDao.getConnect();
        Statement statement = this.basicDao.getStatement(connection);
        return this.basicDao.executeQuerySQL(statement, sql);
    }
}

package main.java.com.company.dao;

import main.java.com.company.model.Profile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProfileDao {
    private BasicDao basicDao = new BasicDao();

    public List<Profile> getProfile(int role_id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = this.queryProfileOfSpecificRole(role_id);
        List<Profile> profiles = new ArrayList<>();
        while (resultSet.next()) {
            String profile_id = resultSet.getString("profile.id");
            String profile_name = resultSet.getString("name");
            Profile profile = new Profile(profile_id, profile_name);
            profiles.add(profile);
        }
        return profiles;
    }

    private ResultSet queryProfileOfSpecificRole(int role_id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT profile.id, name " +
                "FROM profile " +
                "INNER JOIN role_profile ON profile.id = profile_id " +
                "WHERE role_id = " + role_id;
        Connection connection = this.basicDao.getConnect();
        Statement statement = this.basicDao.getStatement(connection);
        return this.basicDao.executeQuerySQL(statement, sql);
    }
}

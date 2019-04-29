package main.java.com.company.dao;

import main.java.com.company.model.Profile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProfileDao {
    private BasicDao basicDao;

    public ProfileDao() {
        this.basicDao = new BasicDao();
    }
    public List<Profile> getProfile(int role_id) {
        String sql = "SELECT profile.id, name " +
                "FROM profile " +
                "INNER JOIN role_profile ON profile.id = profile_id " +
                "WHERE role_id = " + role_id;
        Connection connection = this.basicDao.getConnect();
        Statement statement = this.basicDao.getStatement(connection);
        ResultSet resultSet = this.basicDao.executeQuerySQL(statement, sql);
        List<Profile> profiles = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int profile_id = resultSet.getInt("profile.id");
                String profile_name = resultSet.getString("name");
                Profile profile = new Profile(profile_id, profile_name);
                profiles.add(profile);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profiles;
    }
}

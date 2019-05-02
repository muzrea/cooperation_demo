package main.java.com.company.dao;

import java.sql.*;

public class BasicDao {

    private static final String URL = "jdbc:mysql://localhost:3306/examination_management_sys?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0717";

    public Connection getConnect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public Statement getStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    public ResultSet executeQuerySQL(Statement statement, String sql) throws SQLException {
        return statement.executeQuery(sql);
    }

    public void executeUpdateSQL(Statement statement, String sql) throws SQLException {
        statement.executeUpdate(sql);
    }

    public void closeConnection(
            ResultSet resultSet,
            Statement statement,
            Connection connection) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }

        if (statement != null) {
            statement.close();
        }

        if (connection != null) {
            connection.close();
        }
    }
}

package main.java.com.company;

import main.java.com.company.service.MainService;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        MainService mainService = new MainService();
        try {
            mainService.mainService();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

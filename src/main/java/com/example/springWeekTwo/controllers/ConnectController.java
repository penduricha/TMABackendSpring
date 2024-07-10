package com.example.springWeekTwo.controllers;


import com.example.springWeekTwo.database.DatabaseConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@RestController
public class ConnectController {

    private final DatabaseConfiguration databaseConfiguration;

    @Autowired
    public ConnectController(DatabaseConfiguration databaseConfiguration) {
        this.databaseConfiguration = databaseConfiguration;
    }

    @RequestMapping("/connect")
    public String checkConnection(Model model) {
        String jdbcUrl = databaseConfiguration.getJdbcUrl();
        String username = databaseConfiguration.getUsername();
        String password = databaseConfiguration.getPassword();
        boolean isConnected = testConnection(jdbcUrl, username, password);
        model.addAttribute("isConnected", isConnected);
        model.addAttribute("jdbcUrl", jdbcUrl);
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        if(isConnected){
            return databaseConfiguration.getJdbcUrl();
        }else{
            return "error to connect database";
        }
    }
    private boolean testConnection(String jdbcUrl, String username, String password) {
        // Viết code để kiểm tra kết nối cơ sở dữ liệu ở đây
        // Ví dụ:
        try {
            Connection connection=DriverManager.getConnection(jdbcUrl, username, password);
            //System.out.println("Connected to PostgreSQL server successfully!");
            //System.out.println("Failed to make connection to PostgreSQL server.");
            return connection != null;
        } catch (SQLException e) {
            return false;
        }
    }
}
package com.tcet.srms.modal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    // Database URL, username, and password
    private static final String URL = "jdbc:mysql://localhost:3306/student_record_management_system";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Pallavi@20";

   
    public static Connection getConnection() {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Database connected!");
            return con;

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to connect to database.");
            e.printStackTrace();
        }
        return null;
    }
}
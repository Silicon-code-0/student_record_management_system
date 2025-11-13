
package com.tcet.srms.modal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testDb {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/student_record_management_system";
        String user = "root"; // replace with your DB username
        String password = "Pallavi@20"; // replace with your DB password

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println(" Connection successful!");
        } catch (SQLException e) {
            System.out.println(" Connection failed:");
            e.printStackTrace();
        }
    }
}




package com.tcet.srms.controller;

import com.tcet.srms.modal.DbConnection;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class LoginController implements Initializable {

    @FXML
    private ComboBox<String> roleComboBox;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        roleComboBox.getItems().addAll("Admin", "Faculty");
        roleComboBox.setValue("Admin");
    }

    @FXML
    private void login(ActionEvent event) {
        String user_role = roleComboBox.getValue();
        String username = usernameField.getText();
        String user_password = passwordField.getText();

        if (username.isEmpty() || user_password.isEmpty()) {
            showAlert(AlertType.ERROR, "Login Error", "Please enter both username and password.");
            return;
        }

      try (Connection conn = DbConnection.getConnection()) {
    String query = "SELECT * FROM users_master WHERE user_role=? AND username=? AND user_password=?";
    PreparedStatement stmt = conn.prepareStatement(query);
    stmt.setString(1, user_role);
    stmt.setString(2, username);
    stmt.setString(3, user_password);


            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String fxmlFile;
                if (user_role.equals("Admin")) {
                    fxmlFile = "/com/tcet/srms/view/DashboardScreen.fxml";
                } else if (user_role.equals("Faculty")) {
                    fxmlFile = "/com/tcet/srms/view/FacultyDashboard.fxml";
                } else {
                    showAlert(AlertType.ERROR, "Login Failed", "Unknown role.");
                    return;
                }

                // Load the appropriate dashboard
                Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();

            } else {
                showAlert(AlertType.ERROR, "Login Failed", "Username or password is incorrect.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Database Error", "Could not connect to the database.");
        }
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
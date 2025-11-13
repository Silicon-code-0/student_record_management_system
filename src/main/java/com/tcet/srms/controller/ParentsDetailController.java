package com.tcet.srms.controller;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;
import java.net.URL;
import javafx.scene.control.Alert;
import com.tcet.srms.modal.DbConnection;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.ChoiceBox;

public class ParentsDetailController implements Initializable {

     private int student_id; 

    public void setStudentId(int student_id) {
        this.student_id = student_id;
    }


    @FXML
    private Button backButton;

    @FXML
    private TextField fatherNameField;
    @FXML
    private TextField fatherEmailField;
    @FXML
    private TextField fatherContactField;

    @FXML
    private TextField motherNameField;
    @FXML
    private TextField motherEmailField;
    @FXML
    private TextField motherContactField;

    @FXML
    private ChoiceBox<String> fatherOccupationChoice;
    @FXML
    private ChoiceBox<String> motherOccupationChoice;
    @FXML
    private ChoiceBox<String> fatherQualificationChoice;
    @FXML
    private ChoiceBox<String> motherQualificationChoice;

    @FXML
    private TextField totalEarning;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        backButton.setOnAction(e -> NavigationHelper.goBack(backButton, "StudentDetail.fxml"));

        fatherOccupationChoice.getItems().addAll("Engineer", "Doctor", "Teacher", "Business", "Farmer", "Other");
        motherOccupationChoice.getItems().addAll("Homemaker", "Teacher", "Doctor", "Business", "Engineer", "Other");

        fatherQualificationChoice.getItems().addAll("High School", "Diploma", "Graduate", "Postgraduate", "PhD");
        motherQualificationChoice.getItems().addAll("High School", "Diploma", "Graduate", "Postgraduate", "PhD");

    }

    @FXML
    private void goToAcademicDetail(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tcet/srms/view/AcademicDetail.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Cannot open Academic Detail page.");
        }
    }

    @FXML
    private void handleSave(ActionEvent event) {
        String sql = "INSERT INTO guardian_details ("
                + "father_name, mother_name, father_contact, mother_contact, "
                + "father_email, mother_email, father_qualification, mother_qualification, "
                + "total_earning, father_occupation, mother_occupation,student_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DbConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fatherNameField.getText());
            stmt.setString(2, motherNameField.getText());
            stmt.setString(3, fatherContactField.getText());
            stmt.setString(4, motherContactField.getText());
            stmt.setString(5, fatherEmailField.getText());
            stmt.setString(6, motherEmailField.getText());
            stmt.setString(7, fatherQualificationChoice.getValue());
            stmt.setString(8, motherQualificationChoice.getValue());
            stmt.setString(9, totalEarning.getText());
            stmt.setString(10, fatherOccupationChoice.getValue());
            stmt.setString(11, motherOccupationChoice.getValue());
             stmt.setInt(12, student_id);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                showAlert("Success", "Parent details saved to database.");
            } else {
                showAlert("Error", "Failed to save parent details.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "Error inserting data: " + e.getMessage());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

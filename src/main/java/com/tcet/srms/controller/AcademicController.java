package com.tcet.srms.controller;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import com.tcet.srms.modal.DbConnection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class AcademicController implements Initializable {

    @FXML private ComboBox<String> primaryBoardCombo;
    @FXML private TextField primarySchoolField;
    @FXML private TextField primaryCityField;
    @FXML private ComboBox<String> primaryYearCombo;
    @FXML private TextField primaryPercentageField;

    @FXML private ComboBox<String> secondaryBoardCombo;
    @FXML private TextField secondaryCollegeField;
    @FXML private TextField secondaryCityField;
    @FXML private ComboBox<String> secondaryYearCombo;
    @FXML private TextField secondaryPercentageField;

    @FXML private ComboBox<String> graduationBoardCombo;
    @FXML private TextField graduationCollegeField;
    @FXML private TextField graduationCityField;
    @FXML private ComboBox<String> graduationYearCombo;
    @FXML private TextField graduationPercentageField;

    @FXML private Button saveButton;
    @FXML private Button nextButton2;
    
     @FXML
    private Button backButton;
     
     
     private int student_id; 

    public void setStudentId(int student_id) {
        this.student_id = student_id;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        backButton.setOnAction(e -> NavigationHelper.goBack(backButton, "ParentsDetail.fxml"));

        
       
        ObservableList<String> boardOptions = FXCollections.observableArrayList("SSC", "CBSE", "ICSE", "OTHER");
        ObservableList<String> yearOptions = FXCollections.observableArrayList(
           "2004", "2005", "2006","2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017",
            "2018", "2019", "2020", "2021", "2022", "2023", "2024"
        );

        primaryBoardCombo.setItems(boardOptions);
        secondaryBoardCombo.setItems(boardOptions);
        graduationBoardCombo.setItems(boardOptions);

        primaryYearCombo.setItems(yearOptions);
        secondaryYearCombo.setItems(yearOptions);
        graduationYearCombo.setItems(yearOptions);
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void goToCourseDetail(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tcet/srms/view/CourseDetail.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Cannot open Course Detail page.");
        }
       
    }


    @FXML
private void handleSave(ActionEvent event) {
    String sql = "INSERT INTO academic_details (" +
            "student_id, primary_board, primary_school_name, primary_city, primary_year_of_passing, primary_percentage, " +
            "secondary_board, secondary_college_name, secondary_city, secondary_year_of_passing, secondary_percentage, " +
            "graduation_board, graduation_college_name, graduation_city, graduation_year_of_passing, graduation_percentage) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = DbConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, student_id);

        // Primary Education
        stmt.setString(2, primaryBoardCombo.getValue());
        stmt.setString(3, primarySchoolField.getText());
        stmt.setString(4, primaryCityField.getText());
        stmt.setString(5, primaryYearCombo.getValue());
        stmt.setString(6, primaryPercentageField.getText());

        // Secondary Education
        stmt.setString(7, secondaryBoardCombo.getValue());
        stmt.setString(8, secondaryCollegeField.getText());
        stmt.setString(9, secondaryCityField.getText());
        stmt.setString(10, secondaryYearCombo.getValue());
        stmt.setString(11, secondaryPercentageField.getText());

        // Graduation Education
        stmt.setString(12, graduationBoardCombo.getValue());
        stmt.setString(13, graduationCollegeField.getText());
        stmt.setString(14, graduationCityField.getText());
        stmt.setString(15, graduationYearCombo.getValue());
        stmt.setString(16, graduationPercentageField.getText());

        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            showAlert("Success", "Academic details including graduation saved to database.");
        } else {
            showAlert("Error", "Failed to save academic details.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
        showAlert("Database Error", "Error inserting data: " + e.getMessage());
    }
}}

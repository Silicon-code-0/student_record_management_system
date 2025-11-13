package com.tcet.srms.controller;

import javafx.scene.chart.PieChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;




import java.io.IOException;

public class DashboardScreenController {

    @FXML private BorderPane rootPane;
    @FXML private AnchorPane mainContent;

    @FXML private PieChart profilePieChart;
    @FXML private BarChart<String, Number> marksBarChart;
    @FXML private CategoryAxis xAxis;
    @FXML private NumberAxis yAxis;
    @FXML private TextField searchField;

    @FXML
    private void switchToDashboard() throws IOException {
        Parent view = FXMLLoader.load(getClass().getResource("/DashboardScreen.fxml"));
        rootPane.setCenter(view);
    }
    @FXML
private void switchToStudentDetail(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tcet/srms/view/StudentDetail.fxml"));
    Parent addStudentRoot = loader.load();

    Scene addStudentScene = new Scene(addStudentRoot, 900, 650); // Match your FXML size
    Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    currentStage.setScene(addStudentScene);
}

@FXML
private void switchToSearch(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tcet/srms/view/Search.fxml"));
    Parent searchRoot = loader.load();

    Stage searchStage = new Stage();
    searchStage.setTitle("Search Student");
    searchStage.setScene(new Scene(searchRoot, 800, 500));
    searchStage.show();
}


   @FXML
    private void handleProfile() {
        System.out.println("Profile");
        // Future logout logic goes here
    }


    @FXML
    private void exportData() {
        System.out.println("Exporting data...");
        // Future export logic goes here
    }
    
    

@FXML
private void handleLogout(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tcet/srms/view/LoginPage.fxml"));
    Parent loginRoot = loader.load();

    Scene loginScene = new Scene(loginRoot, 550, 400);
    Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    currentStage.setScene(loginScene);
}

}



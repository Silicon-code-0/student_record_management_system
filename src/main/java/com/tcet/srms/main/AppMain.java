package com.tcet.srms.main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AppMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tcet/srms/view/LoginPage.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Student Record Management System");
        primaryStage.setScene(scene);
        primaryStage.show();// to display the contents of a stage.
    }

    public static void main(String[] args) {
        launch(args);
    }
}
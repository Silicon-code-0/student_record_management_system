package com.tcet.srms.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

import com.tcet.srms.modal.DbConnection;

public class StudentDetailController implements Initializable {

    @FXML
    private int student_id;

    public void setStudentId(int student_id) {
        this.student_id = student_id;
    }
    @FXML
    private Button backButton;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField middleNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private DatePicker dobPicker;
    @FXML
    private TextField birthPlaceField;
    @FXML
    private TextField bloodGroupField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField contactField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField aadharField;
    @FXML
    private TextField abcField;
    @FXML
    private TextArea addressField;

    // ---------- Gender ----------
    @FXML
    private HBox genderBox;

    private ToggleGroup genderGroup;

    private Map<RadioButton, Integer> genderMap = new HashMap<>();

    // ---------- Dropdowns ----------
    @FXML
    private ChoiceBox<String> stateChoiceBox;
    @FXML
    private ChoiceBox<String> districtChoiceBox;
    @FXML
    private ChoiceBox<String> categoryChoiceBox;
    @FXML
    private ChoiceBox<String> religionChoiceBox;
    @FXML
    private ChoiceBox<String> countryChoiceBox;

    // ---------- Data Maps ----------
    private final Map<String, Integer> stateMap = new HashMap<>();
    private final Map<String, Integer> districtMap = new HashMap<>();
    private final Map<String, Integer> categoryMap = new HashMap<>();
    private final Map<String, Integer> religionMap = new HashMap<>();
    private final Map<String, Integer> countryMap = new HashMap<>();

    private int lastInsertedStudentId = 0;

    // ---------- Initialize ----------
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        backButton.setOnAction(e -> NavigationHelper.goBack(backButton, "DashboardScreen.fxml"));

        loadGenders();
        loadStates();
        loadCategories();
        loadReligions();

        // Auto-load districts based on selected state
        stateChoiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null && stateMap.containsKey(newVal)) {
                loadDistricts(stateMap.get(newVal));
            }
        });

    }

    // ---------- Load Genders ----------
    private void loadGenders() {
        genderGroup = new ToggleGroup();
        genderBox.getChildren().clear();

        String query = "SELECT gender_id, gender_name FROM gender_master";
        try (Connection conn = DbConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int genderId = rs.getInt("gender_id");
                String genderName = rs.getString("gender_name");

                RadioButton radio = new RadioButton(genderName);
                radio.setToggleGroup(genderGroup);
                genderBox.getChildren().add(radio);
                genderMap.put(radio, genderId);
            }

            if (!genderBox.getChildren().isEmpty()) {
                ((RadioButton) genderBox.getChildren().get(0)).setSelected(true);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load genders: " + e.getMessage());
        }
    }

    // ---------- Load States ----------
    private void loadStates() {
        String query = "SELECT state_id, state_name FROM state_master";
        try (Connection conn = DbConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            stateChoiceBox.getItems().clear();
            while (rs.next()) {
                int id = rs.getInt("state_id");
                String name = rs.getString("state_name");
                stateChoiceBox.getItems().add(name);
                stateMap.put(name, id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load states: " + e.getMessage());
        }
    }

    // ---------- Load Districts ----------
    private void loadDistricts(int stateId) {
        String query = "SELECT district_id, district_name FROM district_master WHERE state_id = ?";
        districtChoiceBox.getItems().clear();
        districtMap.clear();

        try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, stateId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("district_id");
                    String name = rs.getString("district_name");
                    districtChoiceBox.getItems().add(name);
                    districtMap.put(name, id);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load districts: " + e.getMessage());
        }
    }
    // ---------- Load Country ----------

    private void loadCountries() {
        try (Connection conn = DbConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT country_id, country_name FROM country_master")) {

            while (rs.next()) {
                int id = rs.getInt("country_id");
                String name = rs.getString("country_name");

                countryChoiceBox.getItems().add(name);
                countryMap.put(name, id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ---------- Load Categories ----------
    private void loadCategories() {
        String query = "SELECT category_id, category_name FROM category_master";
        try (Connection conn = DbConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            categoryChoiceBox.getItems().clear();
            while (rs.next()) {
                int id = rs.getInt("category_id");
                String name = rs.getString("category_name");
                categoryChoiceBox.getItems().add(name);
                categoryMap.put(name, id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load categories: " + e.getMessage());
        }
    }

    // ---------- Load Religions ----------
    private void loadReligions() {
        String query = "SELECT religion_id, religion_name FROM religion_master";
        try (Connection conn = DbConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            religionChoiceBox.getItems().clear();
            while (rs.next()) {
                int id = rs.getInt("religion_id");
                String name = rs.getString("religion_name");
                religionChoiceBox.getItems().add(name);
                religionMap.put(name, id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load religions: " + e.getMessage());
        }
    }

    // ---------- Add Student ----------
    @FXML
    private void AddStudent() {
        String query = "INSERT INTO student_detail_master "
                + "(first_name, middle_name, last_name, gender_id, date_of_birth, country_id, religion_id, category_id, "
                + "address, state_id, district_id, city, contact_no, email_id, aadhar_no, abc_id, birth_place, blood_group) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DbConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            RadioButton selectedGender = (RadioButton) genderGroup.getSelectedToggle();
            int genderId = selectedGender != null ? genderMap.get(selectedGender) : 0;

            int countryId = 0;
            String selectedCountry = countryChoiceBox.getValue();
            if (selectedCountry != null && countryMap.containsKey(selectedCountry)) {
                countryId = countryMap.get(selectedCountry);
            }

            int stateId = getSelectedId(stateChoiceBox, stateMap);
            int districtId = getSelectedId(districtChoiceBox, districtMap);
            int categoryId = getSelectedId(categoryChoiceBox, categoryMap);
            int religionId = getSelectedId(religionChoiceBox, religionMap);

            ps.setString(1, firstNameField.getText());
            ps.setString(2, middleNameField.getText());
            ps.setString(3, lastNameField.getText());
            ps.setInt(4, genderId);

            LocalDate dob = dobPicker.getValue();
            if (dob != null) {
                ps.setDate(5, java.sql.Date.valueOf(dob));
            } else {
                ps.setNull(5, Types.DATE);
            }

            ps.setInt(6, 1);
            ps.setInt(7, religionId);
            ps.setInt(8, categoryId);
            ps.setString(9, addressField.getText());
            ps.setInt(10, stateId);
            ps.setInt(11, districtId);
            ps.setString(12, cityField.getText());
            ps.setString(13, contactField.getText());
            ps.setString(14, emailField.getText());
            ps.setString(15, aadharField.getText());
            ps.setString(16, abcField.getText());
            ps.setString(17, birthPlaceField.getText());
            ps.setString(18, bloodGroupField.getText());

            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    student_id = rs.getInt(1); // ✅ Capture auto-generated student_id
                }
            }

            showAlert("Success", "Student added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", e.getMessage());
        }
    }

    // ---------- Helper Methods ----------
    private int getSelectedId(ChoiceBox<String> box, Map<String, Integer> map) {
        String selected = box.getValue();
        return (selected != null && map.containsKey(selected)) ? map.get(selected) : 0;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void goToParentsDetail(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tcet/srms/view/ParentsDetail.fxml"));
            Parent root = loader.load();
            ParentsDetailController controller = loader.getController();
    controller.setStudentId(student_id);


            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Cannot open Parents Detail page.");
        }
    }
}

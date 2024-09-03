package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertController {

    public void showWarning1() {
        // Create an Alert of type WARNING
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Duplicate ID");
        alert.setContentText("Please Enter an unique ID");
        alert.showAndWait();
    }
    public void showWarning2() {
        // Create an Alert of type WARNING
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Duplicate Contact Number");
        alert.setContentText("Please Enter a different CONTACT NUMBER");
        alert.showAndWait();
    }
    public void showWarning3() {
        // Create an Alert of type WARNING
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Invalid Contact Number");
        alert.setContentText("Please Enter a valid CONTACT NUMBER");
        alert.showAndWait();
    }
    public void showWarning4() {
        // Create an Alert of type WARNING
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Invalid Salary");
        alert.setContentText("Please Enter a valid SALARY");
        alert.showAndWait();
    }
    public void showWarning5() {
        // Create an Alert of type WARNING
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Invalid Input");
        alert.setContentText("There is no such customer under this ID.Please Enter a valid ID");
        alert.showAndWait();
    }
    public void showSuccessAlert1() {
        // Create an information alert
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Process Successful"); // No header text
        alert.setContentText("Customer Added Successfully");
        alert.showAndWait();
    }
    public void showSuccessAlert2() {
        // Create an information alert
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Process Successful"); // No header text
        alert.setContentText("Customer Updated Successfully");
        alert.showAndWait();
    }
    public void showSuccessAlert3() {
        // Create an information alert
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Process Successful"); // No header text
        alert.setContentText("Customer Deleted Successfully");
        alert.showAndWait();
    }
}

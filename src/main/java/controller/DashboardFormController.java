package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import single.*;

import java.io.IOException;

public class DashboardFormController {

    public Button btnUpdateCustomer;
    public Button btnSearchCustomer;
    public Button btnDeleteCustomer;
    @FXML
    private Button btnAddCustomer;

    @FXML
    private Button btnViewCustomer;

    @FXML
    void btnAddCustomerOnAction(ActionEvent event) {
        AddCustomerForm addCustomerForm = AddCustomerForm.getInstance();
        addCustomerForm.show();
    }

    @FXML
    void btnViewCustomerOnAction(ActionEvent event) {
        ViewCustomerForm viewCustomerForm = ViewCustomerForm.getInstance();
        viewCustomerForm.show();
    }

    public void btnDeleteCustomerOnAction(ActionEvent actionEvent) {
        DeleteCustomerForm deleteCustomerForm = DeleteCustomerForm.getInstance();
        deleteCustomerForm.show();
    }

    public void btnSearchCustomerOnAction(ActionEvent actionEvent) {
        SearchCustomerForm searchCustomerForm = SearchCustomerForm.getInstance();
        searchCustomerForm.show();
    }

    public void btnUpdateCustomerOnAction(ActionEvent actionEvent) {
        UpdateCustomerForm updateCustomerForm = UpdateCustomerForm.getInstance();
        updateCustomerForm.show();
    }
}

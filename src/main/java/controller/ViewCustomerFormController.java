package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Customer;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewCustomerFormController implements Initializable {

    public TableColumn colTitle;
    public TableColumn colDob;

    @FXML
    private Button btnReload;

    @FXML
    private TableColumn colAddress;

    @FXML
    private TableColumn colContNum;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colName;

    @FXML
    private TableColumn colSalary;

    @FXML
    private TableView<Customer> tblCustomer;

    @FXML
    void btnReloadOnAction(ActionEvent event) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colContNum.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));

        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();

        List<Customer> customerList = DBConnection.getInstance().getConnection();

        customerList.forEach(obj->{
           customerObservableList.add(obj);
        });
        if(customerObservableList.isEmpty()){
            tblCustomer.setItems(customerObservableList);
        }else{
            tblCustomer.getItems().clear();
            tblCustomer.setItems(customerObservableList);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblCustomer.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {

            System.out.println(newValue);

            if (newValue != null) {
                openCustomerDetails(newValue);
            }
        }));
    }

    private void openCustomerDetails(Customer newValue) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/customer_detail_form.fxml"));
            Parent customerDetailsRoot = loader.load();
            CustomerDetailFormController customerDetailsController = loader.getController();

            // Pass selected customer data to CustomerDetails controller
            customerDetailsController.setValues(newValue);

            // Display the CustomerDetails form
            Stage stage = new Stage();
            stage.setScene(new Scene(customerDetailsRoot));
            stage.setTitle("Customer's Details Form");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Customer;

import java.util.List;

public class DeleteCustomerFormController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSearch;

    @FXML
    private DatePicker dateSearchDob;

    @FXML
    private TextField txtSearch;

    @FXML
    private TextField txtSearchAddress;

    @FXML
    private TextField txtSearchContNum;

    @FXML
    private TextField txtSearchId;

    @FXML
    private TextField txtSearchName;

    @FXML
    private TextField txtSearchSalary;

    private List<Customer> customerList = DBConnection.getInstance().getConnection();
    int index;
    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        customerList.remove(index);
        clearFields();

        AlertController example = new AlertController();
        example.showSuccessAlert3();

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String searchID = txtSearch.getText();
        boolean state = true;

        for (int i = 0; i < customerList.size(); i++) {
            if (searchID.equals(customerList.get(i).getId())){
                setValues(i);
                index = i;
                state = false;
            }
        }
        if(state){
            error();
        }
    }
    public void error(){
        AlertController example = new AlertController();
        example.showWarning5();
        clearFields();
    }
    public void setValues(int i){
        txtSearchId.setText(customerList.get(i).getId());
        txtSearchName.setText(customerList.get(i).getTitle()+"."+customerList.get(i).getName());
        txtSearchAddress.setText(customerList.get(i).getAddress());
        txtSearchSalary.setText("Rs."+String.valueOf(customerList.get(i).getSalary()));
        txtSearchContNum.setText(customerList.get(i).getContact());
        dateSearchDob.setValue(customerList.get(i).getDob());
        txtSearch.setText(null);
    }
    public void clearFields(){
        txtSearchId.setText(null);
        txtSearchName.setText(null);
        txtSearchAddress.setText(null);
        txtSearchSalary.setText(null);
        txtSearchContNum.setText(null);
        dateSearchDob.setValue(null);
    }

}

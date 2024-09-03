package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Customer;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UpdateCustomerFormController implements Initializable {

    public TextField txtSearch;
    public TextField txtUpdateId;
    public TextField txtUpdateName;
    public TextField txtUpdateAddress;
    public TextField txtUpdateSalary;
    public TextField txtUpdateContNum;
    public DatePicker dateUpdatehDob;
    public ComboBox cmbUpdateTitle;
    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    private List<Customer> customerList = DBConnection.getInstance().getConnection();
    int index;
    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String searchID = txtSearch.getText();
        boolean state = true;

        for (int i = 0; i < customerList.size(); i++) {
            if (searchID.equals(customerList.get(i).getId())){
                setValues(i);
                index = i;
                state = false;
                break;
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
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> titlesList2 = FXCollections.observableArrayList();
        titlesList2.add("Mr");
        titlesList2.add("Mrs");
        titlesList2.add("Ms");

        cmbUpdateTitle.setItems(titlesList2);
    }
    public void setValues(int i){
        txtUpdateId.setText(customerList.get(i).getId());
        txtUpdateName.setText(customerList.get(i).getName());
        txtUpdateAddress.setText(customerList.get(i).getAddress());
        txtUpdateSalary.setText(String.valueOf(customerList.get(i).getSalary()));
        txtUpdateContNum.setText(customerList.get(i).getContact());
        dateUpdatehDob.setValue(customerList.get(i).getDob());
        cmbUpdateTitle.setValue(customerList.get(i).getTitle());
        txtSearch.setText(null);
    }
    public void clearFields(){
        txtUpdateId.setText(null);
        txtUpdateName.setText(null);
        txtUpdateAddress.setText(null);
        txtUpdateSalary.setText(null);
        txtUpdateContNum.setText(null);
        dateUpdatehDob.setValue(null);
        cmbUpdateTitle.setValue(null);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        customerList.get(index).setName(txtUpdateName.getText());
        customerList.get(index).setAddress(txtUpdateAddress.getText());
        customerList.get(index).setSalary(Double.parseDouble(txtUpdateSalary.getText()));
        customerList.get(index).setContact(txtUpdateContNum.getText());
        customerList.get(index).setDob(dateUpdatehDob.getValue());
        customerList.get(index).setTitle((String) cmbUpdateTitle.getValue());

        AlertController example = new AlertController();
        example.showSuccessAlert2();

        clearFields();
    }

}

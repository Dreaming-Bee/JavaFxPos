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
import javafx.stage.Stage;
import model.Customer;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {

    public ComboBox<String> cmbTitle;
    public DatePicker dateDob;
    @FXML
    private Button btnAdd;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContNum;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSalary;
    private static int nextIndex = 100;
    private List<Customer> customerList = DBConnection.getInstance().getConnection();
    @FXML
    void btnAddOnAction(ActionEvent event) {

        String contNum = txtContNum.getText();
        double salary = Double.parseDouble(txtSalary.getText());
        boolean state = true;

        for (int i = 0; i < customerList.size(); i++) {
            if (contNum.equals(customerList.get(i).getContact())){
                AlertController example = new AlertController();
                example.showWarning2();
                state = false;
                clearContactfield();
            }
        }
        if (contNum.length()!=10){
            AlertController example = new AlertController();
            example.showWarning3();
            state = false;
            clearContactfield();
        }
        if (salary<=0){
            AlertController example = new AlertController();
            example.showWarning4();
            state = false;
            clearSalaryfield();
        }
        if(state){
            customerList.add(
                    new Customer(
                            txtID.getText(),
                            txtName.getText(),
                            txtAddress.getText(),
                            Double.parseDouble(txtSalary.getText()),
                            txtContNum.getText(),
                            cmbTitle.getValue(),
                            dateDob.getValue()
                    )
            );
            AlertController example = new AlertController();
            example.showSuccessAlert1();

            clearFields();

            txtID.setText(generateID());
        }

    }
    public void clearIdfield(){
        txtID.setText(null);
    }
    public void clearContactfield(){
        txtContNum.setText(null);
    }
    public void clearSalaryfield(){
        txtSalary.setText(null);
    }

    public String generateID(){
        return "C" + nextIndex++;
    }
    public void clearFields(){
        txtID.setText(null);
        txtName.setText(null);
        txtAddress.setText(null);
        txtSalary.setText(null);
        txtContNum.setText(null);
        cmbTitle.setValue(null);
        dateDob.setValue(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> titlesList = FXCollections.observableArrayList();
        titlesList.add("Mr");
        titlesList.add("Mrs");
        titlesList.add("Ms");

        txtID.setText(generateID());

        cmbTitle.setItems(titlesList);
    }
}

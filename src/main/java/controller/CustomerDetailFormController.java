package controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Customer;

public class CustomerDetailFormController {

    public DatePicker dateDisplayDob;
    @FXML
    private TextField txtDisplayAddress;

    @FXML
    private TextField txtDisplayContNum;

    @FXML
    private TextField txtDisplayId;

    @FXML
    private TextField txtDisplayName;

    @FXML
    private TextField txtDisplaySalary;

    public void setValues(Customer newValue) {

        if (newValue != null) {
            txtDisplayId.setText(newValue.getId());
            txtDisplayName.setText(newValue.getTitle()+"."+newValue.getName());
            txtDisplayAddress.setText(newValue.getAddress());
            txtDisplaySalary.setText("Rs."+String.valueOf(newValue.getSalary()));
            txtDisplayContNum.setText(newValue.getContact());
            dateDisplayDob.setValue(newValue.getDob());
        }

    }
}

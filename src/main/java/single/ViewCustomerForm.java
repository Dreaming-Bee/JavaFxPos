package single;

import controller.ViewCustomerFormController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ViewCustomerForm {

    private static ViewCustomerForm instance;
    private Stage stage;

    private ViewCustomerForm() {
        stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/view_customer_form.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.setTitle("View Customer Form ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ViewCustomerForm getInstance() {
        if (instance == null) {
            instance = new ViewCustomerForm();
        }
        return instance;
    }

    public void show() {
        stage.show();
    }

}
package GUI;

import Model.Customer;
import Model.TeamMember;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerFieldsController {
    @FXML
    Label idLabel;
    @FXML
    Label nameLabel;
    @FXML
    Button okButton;
    Customer selectedCustomer;

    public void initData(Customer customer) {
        selectedCustomer = customer;
        idLabel.setText(Integer.toString(customer.getId()));
        nameLabel.setText(customer.getName());
    }

    public void changeScene(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("main.fxml"));
        Parent mainParent = loader.load();
        Scene MainParentVIew = new Scene(mainParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(MainParentVIew);
        window.show();
    }
}

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

/**
 * GUI scene for displaying customer fields
 *
 * @author Tymon
 */
public class CustomerFieldsController {
    @FXML
    Label idLabel;
    @FXML
    Label nameLabel;
    @FXML
    Button okButton;
    Customer selectedCustomer;

    /**
     * Initialises gui containers and controllers with information about given customer
     *
     * @param customer data about that customer is going to be displayed
     */
    public void initData(Customer customer) {
        selectedCustomer = customer;
        idLabel.setText(Integer.toString(customer.getId()));
        nameLabel.setText(customer.getName());
    }

    /**
     * goes back to home scene
     *
     * @param e ActionEvent type object for getting window source
     * @throws IOException if source file cannot be opened
     */
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

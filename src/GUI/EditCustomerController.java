package GUI;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * GUI scene for editing customer information
 */
public class EditCustomerController {
    @FXML
    TextField idField;
    @FXML
    TextField nameField;

    @FXML
    Button okButton;
    private Customer customer;
    private final ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin", "data.xml");

    /**
     * Initialises GUI containers and controllers with information about given customer
     *
     * @param customer customer that is going to be edited
     */
    public void initData(Customer customer) {
        this.customer = customer;
        nameField.setText(customer.getName());
        idField.setText(Integer.toString(customer.getId()));
    }

    /**
     * Accepts changes and goes back to home scene
     *
     * @param e ActionEvent type object for getting window source
     * @throws IOException             if source file cannot be found
     * @throws CustomNotFoundException if customer was not found inside ColourIT class
     */
    public void handleOK(ActionEvent e) throws IOException, CustomNotFoundException {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        ColourIT colourIT = adapter.getColourIt();
        Customer customer = colourIT.getCustomerList().getCustomer(id);
        colourIT.getCustomerList().editCustomer(customer, name);
        adapter.save(colourIT);
        adapter.saveToXml(colourIT);
        changeScene(e);
    }

    /**
     * goes back to home scene
     * @param e ActionEvent type object for getting window source
     * @throws IOException if source file cannot be found
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

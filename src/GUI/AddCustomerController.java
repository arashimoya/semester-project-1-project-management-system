package GUI;

import Model.ColourIT;
import Model.ColourITFileAdapter;
import Model.ObjectAlreadyExistsException;
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

public class AddCustomerController {
    @FXML
    Button Button;
    @FXML
    Button okButton;
    @FXML
    Button nextButton;
    @FXML
    TextField idField;
    @FXML
    TextField nameField;

    private final ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin","data.xml");

    public void handleOK(ActionEvent e) throws IOException,
        ObjectAlreadyExistsException
    {
        ColourIT colourIT = adapter.getColourIt();
        String name = nameField.getText();
        String id = idField.getText();
        colourIT.getCustomerList().createCustomer(name);
        adapter.save(colourIT);
        changeScene(e);
    }
    public void handleNext(ActionEvent e) throws IOException, ObjectAlreadyExistsException
    {
        ColourIT colourIT = adapter.getColourIt();
        String name = nameField.getText();
        String id = idField.getText();
        colourIT.getCustomerList().createCustomer(name);
        adapter.save(colourIT);
        idField.clear();
        nameField.clear();
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

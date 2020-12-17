package GUI;

import Model.ColourIT;
import Model.ColourITFileAdapter;
import Model.ObjectAlreadyExistsException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Public class responsible for displaying UI for adding customer to ColourIT class
 * gets data from TextFields and saves it to file.
 *
 * @author Tymon
 * @version 1.0
 */
public class AddCustomerController implements Initializable {

    @FXML
    Button okButton;
    @FXML
    Button nextButton;
    @FXML
    TextField idField;
    @FXML
    TextField nameField;

    private final ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin", "data.xml");

    /**
     * adds one Customer to customerList inside Colour IT
     *
     * @param e object type ActionEvent
     * @throws IOException if file could not been opened
     * @throws ObjectAlreadyExistsException if customer with the same parameters already exists
     */
    public void handleOK(ActionEvent e) throws IOException,
            ObjectAlreadyExistsException {
        ColourIT colourIT = adapter.getColourIt();
        String name = nameField.getText();
        String id = idField.getText();
        colourIT.getCustomerList().createCustomer(name);
        adapter.save(colourIT);
        adapter.saveToXml(colourIT);
        changeScene(e);
    }

    /**
     * Allows to add customers one after another without going back to previous screen
     *
     * @throws ObjectAlreadyExistsException if customer with the same parameters already exists
     */
    public void handleNext() throws ObjectAlreadyExistsException {
        ColourIT colourIT = adapter.getColourIt();
        String name = nameField.getText();
        colourIT.getCustomerList().createCustomer(name);
        adapter.save(colourIT);
        adapter.saveToXml(colourIT);
        idField.setText(Integer.toString(Integer.parseInt(idField.getText()) + 1));
        nameField.clear();
    }

    /**
     * goes back to the home screen
     *
     * @param e object type ActionEvent used to get source of the window
     * @throws IOException if file was not found
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

    /**
     * Initialises IdField with customer ID
     *
     * @param url mandatory for this method
     * @param resourceBundle mandatory for this method
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idField.setText(Integer.toString(adapter.getColourIt().getCustomerList().getIdCounter()));
    }
}

package GUI;


import Model.ColourIT;
import Model.ColourITFileAdapter;
import Model.Customer;
import Model.TeamMember;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class AddRequirementController implements Initializable {
    @FXML
    TextField nameTextField;
    @FXML
    TextField idTextField;
    @FXML
    TextField projectIdTextField;
    @FXML
    TextField dayTextField;
    @FXML
    TextField monthTextField;
    @FXML
    TextField yearTextField;
    @FXML
    TextField priorityTextField;
    @FXML
    ComboBox<String> functionalComboBox;
    @FXML
    TextField estimatedTimeTextField;
    @FXML
    TextArea userStoryTextTextArea;
    @FXML
    Button previousButton;
    @FXML
    Button cancelButton;
    @FXML
    Button okButton;
    @FXML
    Button nextButton;
    ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin", "data.xml");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}

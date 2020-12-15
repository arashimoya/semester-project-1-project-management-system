package GUI;


import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class responsible for displaying UI for adding requirement to the project, adding requirement to the project and saving it to file
 *
 * @author Tymon
 */

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

    /**
     * Initialises ComboBoxes, displays value of project and requirement ID
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        functionalComboBox.getItems().addAll("true", "false");
        projectIdTextField.setText(Integer.toString(adapter.getColourIt().getProjectList().getIdCounter() - 1));
        try {
            idTextField.setText(Integer.toString(adapter.getColourIt().getProjectList().getProject(Integer.parseInt(projectIdTextField.getText())).getRequirementList().getIdCounter()));
        } catch (CustomNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates requirement with data from input fields, adds it to RequirementList inside project
     *
     * @param e object type Action Event
     * @throws IllegalDateException         if data is in wrong format
     * @throws CustomNotFoundException      if project was not found
     * @throws ObjectAlreadyExistsException if requirement already exists
     * @throws IOException                  if file cannot be opened
     */
    public void handleNext(ActionEvent e) throws IllegalDateException, CustomNotFoundException, ObjectAlreadyExistsException, IOException {
        String name = nameTextField.getText();
        int projectID = Integer.parseInt(projectIdTextField.getText());
        int day = Integer.parseInt(dayTextField.getText());
        int month = Integer.parseInt(monthTextField.getText());
        int year = Integer.parseInt(yearTextField.getText());
        MyDate deadline = new MyDate(day, month, year);
        int priority = Integer.parseInt(priorityTextField.getText());
        boolean functional = functionalComboBox.getValue().equals("true");
        int estimatedTime = Integer.parseInt(estimatedTimeTextField.getText());
        String userStoryText = userStoryTextTextArea.getText();
        ColourIT colourIT = adapter.getColourIt();
        String status = "not started";
        colourIT.getProjectList().getProject(projectID).getRequirementList().createRequirement(projectID, userStoryText,
                status, name, deadline, functional, priority, estimatedTime);
        adapter.save(colourIT);
        adapter.saveToXml(colourIT);
        goBack(e);
    }

    /**
     * changes scene to home scene
     * @param e ActionEvent type object for getting window
     * @throws IOException when source file cannot be opened
     */
    public void goBack(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("main.fxml"));
        Parent mainParent = loader.load();
        Scene MainParentVIew = new Scene(mainParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(MainParentVIew);
        window.show();
    }

}

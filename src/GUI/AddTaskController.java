package GUI;

import Model.*;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddTaskController {
    @FXML
    TextField idTextField;
    @FXML
    TextField nameTextField;
    @FXML
    TextField requirementIdTextField;
    @FXML
    TextField descriptionTextField;
    @FXML
    TextField dayField;
    @FXML
    TextField monthField;
    @FXML
    TextField yearField;
    @FXML
    TextField estimatedTimeTextField;
    @FXML
    TextField statusTextField;
    @FXML
    TextField timeSpentTextField;
    @FXML
    Button previousButton;
    @FXML
    Button cancelButton;
    @FXML
    Button okButton;
    @FXML
    Button nextButton;
    ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin", "data.xml");

    public void initData(Requirement requirement, int projectID) {
        idTextField.setText(Integer.toString(requirement.getTaskList().getIdCounter()));
        requirementIdTextField.setText(Integer.toString(requirement.getID()));
    }

    public void handleNext(ActionEvent e) throws IllegalDateException {
        String name = nameTextField.getText();
        String description = descriptionTextField.getText();
        int day = Integer.parseInt(dayField.getText());
        int month = Integer.parseInt(monthField.getText());
        int year = Integer.parseInt(yearField.getText());
        MyDate date = new MyDate(day, month, year);
        int estimatedTime = Integer.parseInt(estimatedTimeTextField.getText());
        String status = statusTextField.getText();
        int timeSpent = Integer.parseInt(timeSpentTextField.getText());
        ColourIT colourIT = new ColourIT();
        colourIT.getProjectList().getProject()
        adapter.saveToXml(colourIT);
    }
}

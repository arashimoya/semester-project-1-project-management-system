package GUI;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * GUI scene for editing requirement
 */
public class EditRequirementController implements Initializable {
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
    @FXML
    TextField statusLabel;
    ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin", "data.xml");
    Requirement requirement;

    /**
     * Initialises GUI with information about given requirement
     * @param requirement requirement that will be edited
     */
    public void initData(Requirement requirement) {
        this.requirement = requirement;
        nameTextField.setText(requirement.getName());
        idTextField.setText(Integer.toString(requirement.getID()));
        projectIdTextField.setText(Integer.toString(requirement.getProjectID()));
        dayTextField.setText(Integer.toString(requirement.getDeadline().getDay()));
        monthTextField.setText(Integer.toString(requirement.getDeadline().getMonth()));
        yearTextField.setText(Integer.toString(requirement.getDeadline().getYear()));
        priorityTextField.setText(Integer.toString(requirement.getPriority()));
        userStoryTextTextArea.setText(requirement.getUserStoryText());
        statusLabel.setText(requirement.getStatus());
        estimatedTimeTextField.setText(Integer.toString(requirement.getEstimatedTime()));
        String functional = "";
        if (requirement.isFunctional()) {
            functional = "true";
        } else functional = "false";
        functionalComboBox.getSelectionModel().select(functional);

    }

    /**
     * Initialises ComboBox with requirement type
     * @param url mandatory for this method
     * @param resourceBundle mandatory for this method
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        functionalComboBox.getItems().addAll("true", "false");
    }

    /**
     * Saves changes
     * @param e ActionEvent type object for getting window source
     * @throws IllegalDateException if date format is incorrect
     * @throws CustomNotFoundException if project or Requirement were not found
     * @throws IOException if source file cannot be opened
     */
    public void handleNext(ActionEvent e) throws IllegalDateException, CustomNotFoundException, IOException {
        String name = nameTextField.getText();
        int projectID = Integer.parseInt(projectIdTextField.getText());
        int day = Integer.parseInt(dayTextField.getText());
        int month = Integer.parseInt(monthTextField.getText());
        int year = Integer.parseInt(yearTextField.getText());
        MyDate deadline = new MyDate(day, month, year);
        int priority = Integer.parseInt(priorityTextField.getText());
        boolean functional = functionalComboBox.getValue().equals("true");
        int estimatedTime = Integer.parseInt(estimatedTimeTextField.getText());
        int requirementID = Integer.parseInt(idTextField.getText());

        String userStoryText = userStoryTextTextArea.getText();
        ColourIT colourIT = adapter.getColourIt();
        String status = "not started";
        colourIT.getProjectList().getProject(projectID).getRequirementList().editRequirement(colourIT.getProjectList()
                        .getProject(projectID).getRequirementList().getRequirement(requirementID), userStoryText,
                status, name, deadline, functional, priority, estimatedTime);
        adapter.save(colourIT);
        adapter.saveToXml(colourIT);
        handleCancel(e);
    }

    /**
     * goes back to GUI scene representing project fields
     * @param e ActionEvent type object for getting window source
     * @throws IOException if source file cannot be found
     */
    public void handleCancel(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ProjectFields.fxml"));
        Parent projectFieldsParent = loader.load();
        Scene projectFieldsView = new Scene(projectFieldsParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(projectFieldsView);
        window.show();
    }
}

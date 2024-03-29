package GUI;

import Model.*;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
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
 * GUI scene for adding tasks
 * @author Tymon
 */
public class AddTaskController {
    @FXML
    TextField projectID;
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

    /**
     * Initialises GUI controllers
     * @param requirement related to task
     */
    public void initData(Requirement requirement) {
        idTextField.setText(Integer.toString(requirement.getTaskList().getIdCounter()));
        requirementIdTextField.setText(Integer.toString(requirement.getID()));
        projectID.setText(Integer.toString(requirement.getProjectID()));
        statusTextField.setText("Not started");
        timeSpentTextField.setText("0");
    }

    /**
     * adds task and allows to add more tasks
     * @param e ActionEvent type object for window source
     * @throws IllegalDateException if date format is incorrect
     * @throws CustomNotFoundException if project or requirement was not found
     * @throws ObjectAlreadyExistsException if task already exists
     */
    public void handleNext(ActionEvent e) throws IllegalDateException, CustomNotFoundException, ObjectAlreadyExistsException {
        String name = nameTextField.getText();
        String description = descriptionTextField.getText();
        int day = Integer.parseInt(dayField.getText());
        int month = Integer.parseInt(monthField.getText());
        int year = Integer.parseInt(yearField.getText());
        MyDate date = new MyDate(day, month, year);
        int estimatedTime = Integer.parseInt(estimatedTimeTextField.getText());
        ColourIT colourIT = adapter.getColourIt();
        colourIT.getProjectList().getProject(Integer.parseInt(projectID.getText())).getRequirementList().
                getRequirement(Integer.parseInt(requirementIdTextField.getText())).
                getTaskList().createTask(Integer.parseInt(requirementIdTextField.getText()), description, name, date, estimatedTime);
        adapter.saveToXml(colourIT);
        adapter.save(colourIT);
        if (e.getSource() == nextButton)
            setUpForNext(adapter.getColourIt().getProjectList().
                    getProject(Integer.parseInt(projectID.getText())).getRequirementList().getRequirement(Integer.parseInt(requirementIdTextField.getText())));
    }

    /**
     * Initialises fields for the next task to be added
     * @param requirement related to task
     */
    public void setUpForNext(Requirement requirement) {
        nameTextField.clear();
        descriptionTextField.clear();
        dayField.clear();
        monthField.clear();
        yearField.clear();
        estimatedTimeTextField.clear();
        initData(requirement);
    }

    /**
     * adds task and goes back to requirement scene
     * @param e ActionEvent type object
     * @throws IOException if source file could not been opened
     * @throws CustomNotFoundException if project or requirement were not found
     * @throws IllegalDateException if date format is incorrect
     * @throws ObjectAlreadyExistsException if task already exists
     */
    public void handleOk(ActionEvent e) throws IOException, CustomNotFoundException, IllegalDateException, ObjectAlreadyExistsException {
        handleNext(e);
        ColourIT colourIT = adapter.getColourIt();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("RequirementFields.fxml"));
        Parent requirementFieldsParent = loader.load();
        Scene detailedRequirementView = new Scene(requirementFieldsParent);
        RequirementFieldsController controller = loader.getController();
        controller.initData(colourIT.getProjectList().getProject(Integer.parseInt(projectID.getText())).
                getRequirementList().getRequirement(Integer.parseInt(requirementIdTextField.getText())));
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(detailedRequirementView);
        window.show();
    }
}

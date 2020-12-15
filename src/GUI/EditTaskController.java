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
 * GUI scene for editing task
 *
 * @author Tymon
 */
public class EditTaskController {
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
     * Initialises GUI with data about task and requirement
     *
     * @param requirement that has taskList with given task
     * @param task        that is going to be edited
     */
    public void initData(Requirement requirement, Task task) {
        nameTextField.setText(task.getName());
        idTextField.setText(Integer.toString(task.getId()));
        requirementIdTextField.setText(Integer.toString(requirement.getID()));
        projectID.setText(Integer.toString(requirement.getProjectID()));
        statusTextField.setText("Not started");
        timeSpentTextField.setText("0");
        descriptionTextField.setText(task.getDescription());
        estimatedTimeTextField.setText(Integer.toString(task.getEstimatedTime()));
        statusTextField.setText(task.getStatus());
        dayField.setText(Integer.toString(task.getDeadline().getDay()));
        monthField.setText(Integer.toString(task.getDeadline().getMonth()));
        yearField.setText(Integer.toString(task.getDeadline().getYear()));
        timeSpentTextField.setText(Integer.toString(task.getTimeSpent()));
    }

    /**
     * saves changes
     *
     * @param e ActionEvent type object for getting window source
     * @throws IllegalDateException    if data format is incorrect
     * @throws CustomNotFoundException if project or requirement or task were not found
     */
    public void handleNext(ActionEvent e) throws IllegalDateException, CustomNotFoundException {
        String name = nameTextField.getText();
        String description = descriptionTextField.getText();
        int day = Integer.parseInt(dayField.getText());
        int month = Integer.parseInt(monthField.getText());
        int year = Integer.parseInt(yearField.getText());
        String status = statusTextField.getText();
        MyDate date = new MyDate(day, month, year);
        int estimatedTime = Integer.parseInt(estimatedTimeTextField.getText());
        ColourIT colourIT = adapter.getColourIt();
        System.out.println(colourIT.getProjectList().getProject(Integer.parseInt(projectID.getText())).getRequirementList().
                getRequirement(Integer.parseInt(requirementIdTextField.getText())).
                getTaskList().getTask(Integer.parseInt(idTextField.getText())));
        colourIT.getProjectList().getProject(Integer.parseInt(projectID.getText())).getRequirementList().
                getRequirement(Integer.parseInt(requirementIdTextField.getText())).
                getTaskList().editTask(colourIT.getProjectList().getProject(Integer.parseInt(projectID.getText()))
                .getRequirementList().getRequirement(Integer.parseInt(requirementIdTextField.getText())).getTaskList()
                .getTask(Integer.parseInt(idTextField.getText())), status, description, name, date, estimatedTime);

        adapter.saveToXml(colourIT);
        adapter.save(colourIT);

    }

    /**
     * Saves changes and goes back to home screen
     *
     * @param e ActionEvent type object for getting window source
     * @throws IOException             if source file cannot be found
     * @throws CustomNotFoundException if Project was not found
     * @throws IllegalDateException    if date format is incorrect
     */
    public void handleOk(ActionEvent e) throws IOException, CustomNotFoundException, IllegalDateException {
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

    /**
     * goes back to requirements fields GUI scene
     *
     * @param e ActionEvent type object for getting window source
     * @throws IOException             if file cannot be opened
     * @throws CustomNotFoundException if project or requirement or task were not found
     */
    public void handleCancel(ActionEvent e) throws IOException, CustomNotFoundException {
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

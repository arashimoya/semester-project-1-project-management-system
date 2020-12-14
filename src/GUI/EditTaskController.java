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

    public void handleNext(ActionEvent e) throws IllegalDateException, CustomNotFoundException, ObjectAlreadyExistsException {
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

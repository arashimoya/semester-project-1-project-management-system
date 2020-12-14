package GUI;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;

public class AddTaskReportController {
    @FXML
    Button okButton;

    @FXML
    TextField projectIDLabel;
    @FXML
    TextField requirementIDLabel;
    @FXML
    TextField taskIDLabel;
    @FXML
    ComboBox<String> teamMembersBox;
    @FXML
    TextField reportText;
    @FXML
    TextField taskReportID;
    Project project;
    Requirement requirement;
    Task task;
    ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin", "data.xml");

    public void initData(int projectID, int requirementID, int taskID) throws CustomNotFoundException {
        project = adapter.getColourIt().getProjectList().getProject(projectID);
        requirement = project.getRequirementList().getRequirement(requirementID);
        task = requirement.getTaskList().getTask(taskID);
        taskReportID.setText(Integer.toString(task.getTaskReportList().getIdCounter()));
        for (TeamMember teamMember : task.getTeamMemberList().getTeamMembers()) {
            teamMembersBox.getItems().add(teamMember.getName());
        }
        projectIDLabel.setText(Integer.toString(projectID));
        requirementIDLabel.setText(Integer.toString(requirementID));
        taskIDLabel.setText(Integer.toString(taskID));
    }

    public void handleNext(ActionEvent e) throws CustomNotFoundException, ObjectAlreadyExistsException, IOException {
        String report = reportText.getText();
        ColourIT colourIT = adapter.getColourIt();
        Project project = colourIT.getProjectList().getProject(Integer.parseInt(projectIDLabel.getText()));
        Requirement requirement = project.getRequirementList().getRequirement(Integer.parseInt(requirementIDLabel.getText()));
        Task task = requirement.getTaskList().getTask(Integer.parseInt(taskIDLabel.getText()));
        TeamMember teamMember = task.getTeamMemberList().getTeamMember(teamMembersBox.getSelectionModel().getSelectedItem());
        MyDate today = new MyDate();
        colourIT.getProjectList().getProject(project.getId()).getRequirementList().
                getRequirement(requirement.getID()).getTaskList().getTask(task.getId()).
                getTaskReportList().createTaskReport(teamMember, report, today,10);
        adapter.save(colourIT);
        adapter.saveToXml(colourIT);
        handleCancel(e);
    }

    public void handleCancel(ActionEvent e) throws IOException, CustomNotFoundException {
        ColourIT colourIT = adapter.getColourIt();
        Project project = colourIT.getProjectList().getProject(Integer.parseInt(projectIDLabel.getText()));
        Requirement requirement = project.getRequirementList().getRequirement(Integer.parseInt(requirementIDLabel.getText()));
        Task task = requirement.getTaskList().getTask(Integer.parseInt(taskIDLabel.getText()));
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TaskFields.fxml"));
        Parent requirementFieldsParent = loader.load();
        Scene detailedRequirementView = new Scene(requirementFieldsParent);
        TaskFieldsController controller = loader.getController();
        controller.initData(task, requirement);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(detailedRequirementView);
        window.show();
    }
}

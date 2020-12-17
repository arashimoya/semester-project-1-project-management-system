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

/**
 * GUI scene for adding new task report
 * @author Tymon
 */
public class AddTaskReportController {
    @FXML
    Button okButton;
    @FXML
    TextField timeSpentTextField;
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

    /**
     * Initialises GUI controllers with information from parameters
     * @param projectID projectID
     * @param requirementID requirementID
     * @param taskID taskID
     * @throws CustomNotFoundException if something was not found
     */
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

    /**
     * Saves changes
     * @param e ActionEvent object
     * @throws CustomNotFoundException if something was not found
     * @throws ObjectAlreadyExistsException if taskReport already exists
     * @throws IOException if source file was not found
     */
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
                getTaskReportList().createTaskReport(teamMember, report, today, Integer.parseInt(timeSpentTextField.getText()));
        int taskTimeSpent = task.getTimeSpent();
        colourIT.getProjectList().getProject(project.getId()).getRequirementList().getRequirement(requirement.getID()).
                getTaskList().getTask(task.getId()).setTimeSpent(taskTimeSpent + Integer.parseInt(timeSpentTextField.getText()));
        colourIT.getProjectList().getProject(project.getId()).getRequirementList().getRequirement(requirement.getID()).
                setTimeSpent(colourIT.getProjectList().getProject(project.getId()).getRequirementList().getRequirement(requirement.getID()).
                        getTaskList().getTask(task.getId()).getTimeSpent() + requirement.getTimeSpent());
        adapter.save(colourIT);
        adapter.saveToXml(colourIT);
        handleCancel(e);
    }

    /**
     * goes back to task fields scene
     * @param e ActionEvent object
     * @throws IOException if source file could not been opened
     * @throws CustomNotFoundException if something was not found
     */
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

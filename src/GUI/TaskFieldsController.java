package GUI;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * GUI scene for displaying information about task fields
 *
 * @author Tymon
 */
public class TaskFieldsController {
    @FXML
    Button removeTeamMemberButton;
    @FXML
    Button addTeamMemberButton;
    @FXML
    Label projectIDLabel;
    @FXML
    Label nameLabel;
    @FXML
    Label IDLabel;
    @FXML
    Label requirementIDLabel;
    @FXML
    Label deadlineLabel;
    @FXML
    Label statusLabel;
    @FXML
    Label timeSpentLabel;
    @FXML
    Label estimatedTimeLabel;
    @FXML
    Label descriptionLabel;
    @FXML
    Button backButton;
    @FXML
    ListView<String> taskListView;
    @FXML
    ListView<String> teamMemberListView;
    private Task task;
    ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin", "data.xml");
    @FXML
    Button viewTaskReport;
    @FXML
    Button addTaskReport;

    /**
     * Initialises GUI with data from given task and requirement
     *
     * @param task1       to display information about task
     * @param requirement to display information about requirement id and project id
     */
    public void initData(Task task1, Requirement requirement) {

        projectIDLabel.setText(Integer.toString(requirement.getProjectID()));
        task = task1;

        nameLabel.setText(task.getName());
        IDLabel.setText(Integer.toString(task.getId()));
        requirementIDLabel.setText(Integer.toString(task.getRequirementID()));
        deadlineLabel.setText(task.getDeadline().toString());
        statusLabel.setText(task.getStatus());
        timeSpentLabel.setText(Integer.toString(task.getTimeSpent()));
        estimatedTimeLabel.setText(Integer.toString(task.getEstimatedTime()));
        descriptionLabel.setText(task.getDescription());
        for (TaskReport report : task.getTaskReportList().getTasks()) {
            taskListView.getItems().add(Integer.toString(report.getId()));
        }
        for (TeamMember teamMember : task.getTeamMemberList().getTeamMembers()) {
            teamMemberListView.getItems().add(teamMember.getName());
        }
    }

    /**
     * Changes scene to home scene
     *
     * @param e ActionEvent type object for getting source of the window
     * @throws IOException if source file could not been opened
     */
    public void handleCancel(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("main.fxml"));
        Parent mainParent = loader.load();
        Scene MainParentVIew = new Scene(mainParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(MainParentVIew);
        window.show();
    }

    /**
     * Changes scene to addTeamMemberScene to add teamMember to chosen task
     *
     * @param e ActionEvent type object for getting source of the window
     * @throws IOException             if source file could not been opened
     * @throws CustomNotFoundException if controller cannot be called
     */
    public void handleAddTeamMember(ActionEvent e) throws IOException, CustomNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddTeamMemberToTask.fxml"));
        Parent addTeamMemberView = loader.load();
        AddTeamMemberToTaskController controller = loader.getController();
        controller.initData(Integer.parseInt(projectIDLabel.getText()), Integer.parseInt(requirementIDLabel.getText()), Integer.parseInt(IDLabel.getText()));
        Scene addTeamMember = new Scene(addTeamMemberView);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(addTeamMember);
        window.show();
    }

    /**
     * Removes teamMember from teamMemberList inside task
     *
     * @param e ActionEvent type object for getting source of the window
     * @throws CustomNotFoundException if source file could not been opened
     */
    public void handleRemoveTeamMember(ActionEvent e) throws CustomNotFoundException {
        String name = teamMemberListView.getSelectionModel().getSelectedItem();
        ColourIT colourIT = adapter.getColourIt();
        TeamMember teamMember = colourIT.getTeamMemberList().getTeamMember(name);
        colourIT.getProjectList().getProject(Integer.parseInt(projectIDLabel.getText())).getRequirementList().getRequirement(Integer.parseInt(requirementIDLabel.getText())).getTaskList().getTask(Integer.parseInt(IDLabel.getText())).getTeamMemberList().deleteTeamMember(teamMember);
        teamMemberListView.getItems().remove(name);
        adapter.save(colourIT);
        adapter.saveToXml(colourIT);
    }

    /**
     * changes scenes to taskReport scene to view task reports
     *
     * @param e ActionEvent type object for getting source of the window
     * @throws IOException             if source file could not been opened
     * @throws CustomNotFoundException if project or requirement or task could not been opened
     */
    public void viewTaskReport(ActionEvent e) throws IOException, CustomNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TaskReportFields.fxml"));
        Parent addTeamMemberView = loader.load();
        TaskReportFieldsController controller = loader.getController();
        int taskReportId = Integer.parseInt(taskListView.getSelectionModel().getSelectedItem());
        controller.initData(Integer.parseInt(projectIDLabel.getText()), Integer.parseInt(requirementIDLabel.getText()), Integer.parseInt(IDLabel.getText()), taskReportId);
        Scene addTeamMember = new Scene(addTeamMemberView);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(addTeamMember);
        window.show();
    }

    /**
     * changes scene to addTaskReport scene to add task report to task
     * @param e ActionEvent type object for getting source of the window
     * @throws IOException if source file could not been opened
     * @throws CustomNotFoundException if project or requirement or task could not been found
     */
    public void handleAddTaskReport(ActionEvent e) throws IOException, CustomNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddTaskReport.fxml"));
        Parent addTeamMemberView = loader.load();
        AddTaskReportController controller = loader.getController();
        controller.initData(Integer.parseInt(projectIDLabel.getText()), Integer.parseInt(requirementIDLabel.getText()), Integer.parseInt(IDLabel.getText()));
        Scene addTeamMember = new Scene(addTeamMemberView);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(addTeamMember);
        window.show();
    }
}

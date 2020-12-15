package GUI;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * GUI scene representing taskReport fields
 * @author Tymon
 */
public class TaskReportFieldsController {
    @FXML
    Button okButton;
    @FXML
    Label teamMemberLabel;
    @FXML
    Label idLabel;
    @FXML
    Label report;
    @FXML
    Label timeSpentLabel;
    @FXML
    ListView<String> taskReports;
    ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin", "data.xml");

    /**
     * Initialises GUI with given parameters and task report information
     * @param projectID related project ID
     * @param requirementID related requirement ID
     * @param taskID related task ID
     * @param taskReportID task report ID
     * @throws CustomNotFoundException if project or requirement or task or taskReport were not found
     */
    public void initData(int projectID, int requirementID, int taskID, int taskReportID) throws CustomNotFoundException {
        Project project = adapter.getColourIt().getProjectList().getProject(projectID);
        Requirement requirement = project.getRequirementList().getRequirement(requirementID);
        Task task = requirement.getTaskList().getTask(taskID);
        idLabel.setText(Integer.toString(task.getId()));
        teamMemberLabel.setText(task.getTaskReportList().getTaskReport(taskReportID).getTeamMember().getName());
        report.setText(task.getTaskReportList().getTaskReport(taskReportID).getReport());
        timeSpentLabel.setText(Integer.toString(task.getTaskReportList().getTaskReport(taskReportID).getTimeSpent()));
    }

    /**
     * changes scene back to home scene
     * @param e ActionEvent type object for getting source of the window
     * @throws IOException if source file could not been opened
     */
    public void handleOk(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("main.fxml"));
        Parent mainParent = loader.load();
        Scene MainParentVIew = new Scene(mainParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(MainParentVIew);
        window.show();
    }
}

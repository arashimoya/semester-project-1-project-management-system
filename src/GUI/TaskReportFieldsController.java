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

    public void initData(int projectID, int requirementID, int taskID, int taskReportID) throws CustomNotFoundException {
        Project project = adapter.getColourIt().getProjectList().getProject(projectID);
        Requirement requirement = project.getRequirementList().getRequirement(requirementID);
        Task task = requirement.getTaskList().getTask(taskID);
        idLabel.setText(Integer.toString(task.getId()));
        teamMemberLabel.setText(task.getTaskReportList().getTaskReport(taskReportID).getTeamMember().getName());
        report.setText(task.getTaskReportList().getTaskReport(taskReportID).getReport());
    }

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

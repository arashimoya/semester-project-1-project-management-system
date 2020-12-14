package GUI;

import Model.Task;
import Model.TaskReport;
import Model.TeamMember;
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
import java.util.List;

public class TaskFieldsController {
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
    Button viewTeamMemberButton;
    @FXML
    Button backButton;
    @FXML
    ListView<String> taskListView;
    @FXML
    ListView<String> teamMemberListView;
    private Task task;

    public void initData(Task task1) {
        task = task1;
        System.out.println(task);
        nameLabel.setText(task.getName());
        IDLabel.setText(Integer.toString(task.getId()));
        requirementIDLabel.setText(Integer.toString(task.getRequirementID()));
        deadlineLabel.setText(task.getDeadline().toString());
        statusLabel.setText(task.getStatus());
        timeSpentLabel.setText(Integer.toString(task.getTimeSpent()));
        estimatedTimeLabel.setText(Integer.toString(task.getEstimatedTime()));
        descriptionLabel.setText(task.getDescription());
        for (TaskReport report : task.getTaskReportList().getTasks()) {
            taskListView.getItems().add(report.getReport());
        }
        for (TeamMember teamMember : task.getTeamMemberList().getTeamMembers()) {
            teamMemberListView.getItems().add(teamMember.getName());
        }
    }

    public void handleCancel(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("main.fxml"));
        Parent mainParent = loader.load();
        Scene MainParentVIew = new Scene(mainParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(MainParentVIew);
        window.show();
    }
    public void handleAddTask(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("RequirementFields.fxml"));
        Parent requirementFieldsParent = loader.load();
        Scene detailedRequirementView = new Scene(requirementFieldsParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(detailedRequirementView);
        window.show();
    }
}

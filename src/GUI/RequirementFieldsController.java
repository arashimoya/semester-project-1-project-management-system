package GUI;

import Model.Requirement;
import Model.Task;
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

public class RequirementFieldsController {
    @FXML
    Label nameLabel;
    @FXML
    Label idLabel;
    @FXML
    Label projectIDLabel;
    @FXML
    Label deadlineLabel;
    @FXML
    Label statusLabel;
    @FXML
    Label priorityLabel;
    @FXML
    Label functionalLabel;
    @FXML
    Label timeSpentLabel;
    @FXML
    Label estimatedTimeLabel;
    @FXML
    Label userStoryTextLabel;
    @FXML
    Button addButton;
    @FXML
    Button editButton;
    @FXML
    Button deleteButton;
    @FXML
    Button viewButton;
    @FXML
    Button backButton;
    @FXML
    ListView<String> tasksListView;
    Requirement requirement;

    public void initData(Requirement requirement) {
        this.requirement = requirement;
        nameLabel.setText(requirement.getName());
        idLabel.setText(Integer.toString(requirement.getID()));
        projectIDLabel.setText(Integer.toString(requirement.getProjectID()));
        deadlineLabel.setText(requirement.getDeadline().toString());
        statusLabel.setText(requirement.getStatus());
        userStoryTextLabel.setText(requirement.getUserStoryText());
        priorityLabel.setText(Integer.toString(requirement.getPriority()));
        if (requirement.isFunctional())
            functionalLabel.setText("functional");
        else
            functionalLabel.setText("not-functional");
        timeSpentLabel.setText(Integer.toString(requirement.getTimeSpent()));
        estimatedTimeLabel.setText(Integer.toString(requirement.getEstimatedTime()));
        for (Task task : requirement.getTaskList().getTasks()) {
            tasksListView.getItems().add(task.getName());
        }
    }

    public void handleAddRequirement(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddRequirement.fxml"));
        Parent addRequirementParent = loader.load();
        Scene addRequirementView = new Scene(addRequirementParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(addRequirementView);
        window.show();
    }
}

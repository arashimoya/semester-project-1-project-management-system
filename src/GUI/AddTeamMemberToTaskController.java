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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddTeamMemberToTaskController {
    @FXML
    ComboBox<String> teamMemberComboBox;
    @FXML
    TextField requirementIDText;
    @FXML
    TextField projectIDText;
    @FXML
    TextField taskIDText;
    @FXML
    Button nextButton;
    @FXML
    Button okButton;
    @FXML
    Button cancelButton;
    ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin", "data.xml");

    public void initData(int projectID, int requirementID, int taskID) throws CustomNotFoundException {
        for (TeamMember teamMember : adapter.getColourIt().getProjectList().getProject(projectID).getRequirementList().
                getRequirement(requirementID).getTeamMembers().getTeamMembers()) {
            teamMemberComboBox.getItems().add(teamMember.getName());
        }
        projectIDText.setText(Integer.toString(projectID));
        requirementIDText.setText(Integer.toString(requirementID));
        taskIDText.setText(Integer.toString(taskID));
    }

    public void handleNext(ActionEvent e) throws CustomNotFoundException, ObjectAlreadyExistsException {
        String name = teamMemberComboBox.getSelectionModel().getSelectedItem();
        ColourIT colourIT = adapter.getColourIt();
        TeamMember teamMember = colourIT.getProjectList().getProject(Integer.parseInt(projectIDText.getText())).getTeamMemberList().getTeamMember(name);
        colourIT.getProjectList().getProject(Integer.parseInt(projectIDText.getText())).getRequirementList().
                getRequirement(Integer.parseInt(requirementIDText.getText())).getTaskList().getTask(Integer.parseInt(taskIDText.getText())).getTeamMemberList().addTeamMember(teamMember);
        adapter.save(colourIT);
        adapter.saveToXml(colourIT);
        teamMemberComboBox.getSelectionModel().selectFirst();
        teamMemberComboBox.getItems().remove(name);
    }

    public void handleCancel(ActionEvent e) throws IOException, CustomNotFoundException {
        ColourIT colourIT = adapter.getColourIt();
        Project project = colourIT.getProjectList().getProject(Integer.parseInt(projectIDText.getText()));
        Requirement requirement = project.getRequirementList().getRequirement(Integer.parseInt(requirementIDText.getText()));
        Task task = requirement.getTaskList().getTask(Integer.parseInt(taskIDText.getText()));
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

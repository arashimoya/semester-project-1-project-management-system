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

/**
 * GUI scene for adding teamMember to teamMemberList inside task
 *
 * @author Tymon
 */
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

    /**
     * Initialises gui controllers and containers
     *
     * @param projectID     id of a project related to task, type int
     * @param requirementID id of a requirement related to task, type int
     * @param taskID        teamMember will be added to teamMemberList inside this task
     * @throws CustomNotFoundException if project, requirement or task were not found
     */
    public void initData(int projectID, int requirementID, int taskID) throws CustomNotFoundException {
        for (TeamMember teamMember : adapter.getColourIt().getProjectList().getProject(projectID).getRequirementList().
                getRequirement(requirementID).getTeamMembers().getTeamMembers()) {
            teamMemberComboBox.getItems().add(teamMember.getName());
        }
        projectIDText.setText(Integer.toString(projectID));
        requirementIDText.setText(Integer.toString(requirementID));
        taskIDText.setText(Integer.toString(taskID));
    }

    /**
     * adds teamMember to teamMemberList inside task
     *
     * @param e ActionEvent type object for getting window source
     * @throws CustomNotFoundException      if project or requirement or task were not found
     * @throws ObjectAlreadyExistsException if teamMember object is already in the teamMemberList
     */
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

    /**
     * goes back to GUI scene representing task fields
     * @param e ActionEvent type object for getting window source
     * @throws IOException if source file cannot be opened
     * @throws CustomNotFoundException if project or requirement or task cannot be found
     */
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

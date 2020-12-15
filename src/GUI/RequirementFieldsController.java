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
 * GUI scene representing requirement fields
 *
 * @author Tymon
 */
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
    Button addTeamMemberButton;
    @FXML
    Button deleteTeamMemberButton;
    @FXML
    Button viewTaskButton;
    @FXML
    Button cancelButton;
    @FXML
    ListView<String> tasksListView;
    @FXML
    ListView<String> teamMembersView;
    Requirement requirement;
    ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin", "data.xml");

    /**
     * Initialises GUI with data from requirement fields
     *
     * @param requirement that is going to be displayed
     */
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
        for (TeamMember teamMember : requirement.getTeamMembers().getTeamMembers()) {
            teamMembersView.getItems().add(teamMember.getName());
        }
    }

    /**
     * Changes scene to addTeamMember scene
     *
     * @param e ActionEvent type object for getting source of the window
     * @throws IOException             if source file could not be opened
     * @throws CustomNotFoundException if project was not found
     */
    public void handleAddTeamMember(ActionEvent e) throws IOException, CustomNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddTeamMemberToRequirement.fxml"));
        Parent addTeamMemberView = loader.load();
        AddTeamMemberToRequirementController controller = loader.getController();
        controller.initData(Integer.parseInt(projectIDLabel.getText()), Integer.parseInt(idLabel.getText()));
        Scene addTeamMember = new Scene(addTeamMemberView);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(addTeamMember);
        window.show();
    }

    /**
     * changes scene to home scene
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
     * Deletes chosen teamMember from teamMemberList inside requirement
     * @param e ActionEvent type object for getting source of the window
     * @throws CustomNotFoundException if project or requirement or teamMember were not found
     */
    public void handleDeleteTeamMember(ActionEvent e) throws CustomNotFoundException {
        String name = teamMembersView.getSelectionModel().getSelectedItem();
        ColourIT colourIT = adapter.getColourIt();
        TeamMember teamMember = colourIT.getTeamMemberList().getTeamMember(name);
        colourIT.getProjectList().getProject(Integer.parseInt(projectIDLabel.getText())).getRequirementList().getRequirement(Integer.parseInt(idLabel.getText())).getTeamMembers().deleteTeamMember(teamMember);
        teamMembersView.getItems().remove(name);
        adapter.save(colourIT);
        adapter.saveToXml(colourIT);
    }

    /**
     * Changes scenes so task fields can be displayed
     * @param e ActionEvent type object for getting source of the window
     * @throws CustomNotFoundException if project or requirement or task were not found
     * @throws IOException if source file could not been opened
     */
    public void handleViewTask(ActionEvent e) throws CustomNotFoundException, IOException {
        String taskName = tasksListView.getSelectionModel().getSelectedItem();
        ColourIT colourIT = adapter.getColourIt();
        Project project = colourIT.getProjectList().getProject(Integer.parseInt(projectIDLabel.getText()));
        Requirement requirement = project.getRequirementList().getRequirement(Integer.parseInt(idLabel.getText()));
        Task task = requirement.getTaskList().getTask(taskName);
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

    /**
     * Changes scene to addTask scene to allow adding task to given requirement
     * @param e ActionEvent type object for getting source of the window
     * @throws IOException if source file could not been opened
     * @throws CustomNotFoundException if project or requirement were not found
     */
    public void handleAddTask(ActionEvent e) throws IOException, CustomNotFoundException {
        ColourIT colourIT = adapter.getColourIt();
        Project project = colourIT.getProjectList().getProject(Integer.parseInt(projectIDLabel.getText()));
        Requirement requirement = project.getRequirementList().getRequirement(Integer.parseInt(idLabel.getText()));
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddTask.fxml"));
        Parent requirementFieldsParent = loader.load();
        Scene detailedRequirementView = new Scene(requirementFieldsParent);
        AddTaskController controller = loader.getController();
        controller.initData(requirement);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(detailedRequirementView);
        window.show();
    }

    /**
     * Changes scene to editTask to edit chosen task
     * @param e ActionEvent type object for getting source of the window
     * @throws IOException if source file could not been opened
     * @throws CustomNotFoundException if project or requirement were not found
     */
    public void handleEditTask(ActionEvent e) throws IOException, CustomNotFoundException {
        ColourIT colourIT = adapter.getColourIt();
        Project project = colourIT.getProjectList().getProject(Integer.parseInt(projectIDLabel.getText()));
        Requirement requirement = project.getRequirementList().getRequirement(Integer.parseInt(idLabel.getText()));
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EditTask.fxml"));
        Parent requirementFieldsParent = loader.load();
        Scene detailedRequirementView = new Scene(requirementFieldsParent);
        EditTaskController controller = loader.getController();
        controller.initData(requirement, requirement.getTaskList().getTask(tasksListView.getSelectionModel().getSelectedItem()));
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(detailedRequirementView);
        window.show();
    }

    /**
     * Deletes chosen task
     * @param e ActionEvent type object for getting source of the window
     * @throws CustomNotFoundException if project or requirement or task were not found
     */
    public void handleDeleteTask(ActionEvent e) throws CustomNotFoundException {
        ColourIT colourIT = adapter.getColourIt();
        String name = tasksListView.getSelectionModel().getSelectedItem();
        Task task = colourIT.getProjectList().getProject(Integer.parseInt(projectIDLabel.getText())).getRequirementList().
                getRequirement(Integer.parseInt(idLabel.getText())).getTaskList().getTask(name);
        colourIT.getProjectList().getProject(Integer.parseInt(projectIDLabel.getText())).getRequirementList().
                getRequirement(Integer.parseInt(idLabel.getText())).getTaskList().deleteTask(task);
        adapter.save(colourIT);
        adapter.saveToXml(colourIT);
        tasksListView.getItems().remove(name);
    }
}

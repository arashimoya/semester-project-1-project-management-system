package GUI;

import Model.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Gui scene for displaying project fields
 *
 * @author Tymon
 */
public class ProjectFieldsController {
    @FXML
    Label idLabel;
    @FXML
    Label nameLabel;
    @FXML
    Label scrumMasterLabel;
    @FXML
    Label projectCreatorLabel;
    @FXML
    Label projectOwnerLabel;
    @FXML
    Label customerLabel;
    @FXML
    Label deadlineLabel;
    Project selectedProject;
    @FXML
    ListView<String> requirementsListView;
    ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin", "data.xml");
    @FXML
    Button goBack;
    @FXML
    TextArea descriptionLabel;
    @FXML
    Button addRequirement;
    @FXML
    Button editRequirement;
    @FXML
    Button viewRequirement;
    @FXML
    Button deleteRequirement;
    @FXML
    Button addTeamMember;
    @FXML
    Button editTeamMember;
    @FXML
    Button viewTeamMember;
    @FXML
    Button deleteTeamMember;
    @FXML
    Button addProjectReport;
    @FXML
    Button editProjectReport;
    @FXML
    Button viewProjectReport;
    @FXML
    Button deleteProjectReport;
    @FXML
    ListView<String> teammembersListView;
    @FXML
    ListView<String> projectReportsListView;

    /**
     * Initialises GUI scene with information about the given project
     *
     * @param project that is going to be displayed
     */
    public void initData(Project project) {
        selectedProject = project;
        idLabel.setText(Integer.toString(project.getId()));
        nameLabel.setText(project.getName());
        deadlineLabel.setText(project.getDeadline().toString());
        scrumMasterLabel.setText(project.getScrumMaster().getName());
        projectCreatorLabel.setText(project.getProjectCreator().getName());
        projectOwnerLabel.setText(project.getProductOwner().getName());
        customerLabel.setText(project.getCustomer().getName());
        descriptionLabel.setText(project.getDescription());
        ArrayList<Requirement> reqs = project.getRequirementList().getRequirements();
        ArrayList<TeamMember> members = project.getTeamMemberList().getTeamMembers();
        ArrayList<ProjectReport> reports = project.getProjectReportList().getProjectReports();
        for (Requirement requirement : reqs)
            requirementsListView.getItems().add(requirement.getName());
        for (TeamMember teamMember : members) {
            String name = teamMember.getName();
            teammembersListView.getItems().add(name);
        }
        for (ProjectReport report : reports) {
            projectReportsListView.getItems().add(Integer.toString(report.getID()));
        }
    }

    /**
     * Goes back to home scene
     *
     * @param e ActionEvent type object for getting window source
     * @throws IOException if source file cannot be found
     */
    public void changeScene(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("main.fxml"));
        Parent mainParent = loader.load();
        Scene MainParentVIew = new Scene(mainParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(MainParentVIew);
        window.show();
    }

    /**
     * Gets chosen requirement
     *
     * @return requirement chosen via ListView
     * @throws CustomNotFoundException if project or requirement were not found
     */
    public Requirement viewDetails() throws CustomNotFoundException {
        String currentSelectedItem;
        Project project = null;
        currentSelectedItem = requirementsListView.getSelectionModel().getSelectedItem();
        for (Project project1 : adapter.getColourIt().getProjectList().getProjects()) {
            if (project1.getId() == Integer.parseInt(idLabel.getText()))
                project = project1;
        }
        assert project != null;
        return project.getRequirementList().getRequirement(currentSelectedItem);
    }

    /**
     * Loads GUI scene for adding requirement
     *
     * @param e ActionEvent type object for getting window source
     * @throws IOException if source file cannot be found
     */
    public void addRequirement(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddRequirement.fxml"));
        Parent addRequirementParent = loader.load();
        Scene addRequirementView = new Scene(addRequirementParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(addRequirementView);
        window.show();
    }

    /**
     * Loads GUI scene for editing requirement
     * @param e ActionEvent type object for getting window source
     * @throws IOException             if source file cannot be found
     * @throws CustomNotFoundException if project or requirement were not found
     */
    public void editRequirement(ActionEvent e) throws IOException, CustomNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EditRequirement.fxml"));
        Parent editRequirement = loader.load();
        Scene editRequirementView = new Scene(editRequirement);
        EditRequirementController controller = loader.getController();
        controller.initData(viewDetails());
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(editRequirementView);
        window.show();
    }

    /**
     * Loads GUI scene for viewing requirement fields
     * @param e ActionEvent type object for getting window source
     * @throws IOException             if source file cannot be found
     * @throws CustomNotFoundException if project or requirement were not found
     */
    public void viewDetailedRequirement(ActionEvent e) throws IOException, CustomNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("RequirementFields.fxml"));
        Parent requirementFieldsParent = loader.load();
        Scene detailedRequirementView = new Scene(requirementFieldsParent);
        RequirementFieldsController controller = loader.getController();
        controller.initData(viewDetails());
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(detailedRequirementView);
        window.show();
    }

    /**
     * Deletes chosen requirement
     *
     * @param e ActionEvent type object for getting window source
     * @throws CustomNotFoundException if project or requirement were not found
     */
    public void handleDeleteRequirement(ActionEvent e) throws CustomNotFoundException {
        ColourIT colourIT = adapter.getColourIt();
        Requirement requirement = null;
        Project project = colourIT.getProjectList().getProject(Integer.parseInt(idLabel.getText()));
        for (Requirement requirement1 :
                project.getRequirementList().getRequirements()) {
            if (requirement1.getID() == viewDetails().getID())
                requirement = requirement1;
        }

        colourIT.getProjectList().getProject(project.getId()).getRequirementList().deleteRequirement(requirement);
        adapter.save(colourIT);
        requirementsListView.getItems().remove(requirementsListView.getSelectionModel().getSelectedItem());
    }

    /**
     * gets TeamMember object from ListView
     *
     * @return TeamMember object
     * @throws CustomNotFoundException if project or teamMember were not found
     */
    public TeamMember viewTeamMemberDetails() throws CustomNotFoundException {
        String currentSelectedItem;
        Project project = null;
        currentSelectedItem = teammembersListView.getSelectionModel().getSelectedItem();
        for (Project project1 : adapter.getColourIt().getProjectList().getProjects()) {
            if (project1.getId() == Integer.parseInt(idLabel.getText()))
                project = project1;
        }
        assert project != null;
        return project.getTeamMemberList().getTeamMember(currentSelectedItem);

    }

    /**
     * Launches GUI scene showing TeamMember fields
     *
     * @param e ActionEvent type object for getting window source
     * @throws IOException             if source file cannot be opened
     * @throws CustomNotFoundException if project or teamMember were not found
     */
    public void handleViewTeammember(ActionEvent e) throws IOException, CustomNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TeamMemberFields.fxml"));
        Parent teamMemberParent = loader.load();
        Scene detailedTeamMember = new Scene(teamMemberParent);
        TeamMemberFieldsController controller = loader.getController();
        controller.initData(viewTeamMemberDetails());
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(detailedTeamMember);
        window.show();
    }

    /**
     * Launches GUI scene for adding teamMember into project
     *
     * @param e ActionEvent type object for getting window source
     * @throws IOException             if source file cannot be opened
     * @throws CustomNotFoundException if project was not found
     */
    public void handleAddTeammember(ActionEvent e) throws IOException, CustomNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddTeamMemberToProject.fxml"));
        Parent addTeamMemberParent = loader.load();
        Scene addTeamMember = new Scene(addTeamMemberParent);
        AddTeamMemberToProjectController controller = loader.getController();
        controller.initData(adapter.getColourIt().getProjectList().getProject(Integer.parseInt(idLabel.getText())));
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(addTeamMember);
    }

    /**
     * Removes selected teamMember from the list
     *
     * @param e ActionEvent type object for getting window source
     * @throws CustomNotFoundException if project or teamMember were not found
     */
    public void handleDeleteTeamMember(ActionEvent e) throws CustomNotFoundException {
        String name = teammembersListView.getSelectionModel().getSelectedItem();
        ColourIT colourIT = adapter.getColourIt();
        TeamMember teamMember = colourIT.getProjectList().getProject(Integer.parseInt(idLabel.getText())).getTeamMemberList().getTeamMember(name);
        colourIT.getProjectList().getProject(Integer.parseInt(idLabel.getText())).getTeamMemberList().deleteTeamMember(teamMember);
        adapter.save(colourIT);
        teammembersListView.getItems().remove(name);
    }

    /**
     * Launches GUI scene for viewing details about selected project report
     *
     * @param e ActionEvent type object for getting window source
     * @throws IOException             if file cannot be opened
     * @throws CustomNotFoundException if project or project report cannot be found
     */
    public void handleViewProjectReport(ActionEvent e) throws IOException, CustomNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ProjectReportFields.fxml"));
        Parent teamMemberParent = loader.load();
        Scene detailedTeamMember = new Scene(teamMemberParent);
        ProjectReportController controller = loader.getController();
        Project project = adapter.getColourIt().getProjectList().getProject(Integer.parseInt(idLabel.getText()));
        ProjectReport projectReport = project.getProjectReportList().getProjectReport(Integer.parseInt(projectReportsListView.getSelectionModel().getSelectedItem()));
        controller.initData(projectReport);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(detailedTeamMember);
        window.show();
    }

    /**
     * Adds project report to project
     *
     * @param e ActionEvent type object for getting window source
     * @throws IOException             if source file cannot be opened
     * @throws CustomNotFoundException if project or teamMember were not found
     */
    public void handleAddProjectReport(ActionEvent e) throws IOException, CustomNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddProjectReportFields.fxml"));
        Parent addProjectReportParent = loader.load();
        Scene detailedTeamMember = new Scene(addProjectReportParent);
        int projectID = Integer.parseInt(idLabel.getText());
        AddProjectReportController controller = loader.getController();
        controller.initData(projectID);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(detailedTeamMember);
        window.show();
    }

}

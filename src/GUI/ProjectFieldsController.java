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
import java.util.ResourceBundle;

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
        for (Requirement requirement : reqs)
            requirementsListView.getItems().add(requirement.getName());
    }

    public void changeScene(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("main.fxml"));
        Parent mainParent = loader.load();
        Scene MainParentVIew = new Scene(mainParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(MainParentVIew);
        window.show();
    }

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

    public void addRequirement(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddRequirement.fxml"));
        Parent addRequirementParent = loader.load();
        Scene addRequirementView = new Scene(addRequirementParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(addRequirementView);
        window.show();
    }

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

}

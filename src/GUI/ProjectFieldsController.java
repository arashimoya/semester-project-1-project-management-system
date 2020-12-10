package GUI;

import Model.ColourITFileAdapter;
import Model.Project;
import Model.Requirement;
import Model.RequirementList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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

    public void initData(Project project) {
        selectedProject = project;
        idLabel.setText(Integer.toString(project.getId()));
        nameLabel.setText(project.getName());
        deadlineLabel.setText(project.getDeadline().toString());
        scrumMasterLabel.setText(project.getScrumMaster().getName());
        projectCreatorLabel.setText(project.getProjectCreator().getName());
        projectOwnerLabel.setText(project.getProductOwner().getName());
        customerLabel.setText(project.getCustomer().getName());
        ArrayList<Requirement> reqs = project.getRequirementList().getRequirements();
        for (Requirement requirement : reqs)
            requirementsListView.getItems().add("ID: " + requirement.getID() + "    Name:  " + requirement.getName());
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

}

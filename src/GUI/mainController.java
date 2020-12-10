package GUI;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class mainController implements Initializable {
    @FXML
    Button Add;
    @FXML
    Button Edit;
    @FXML
    Button Delete;
    @FXML
    Button View;
    @FXML
    ListView<String> projects;
    @FXML
    ListView<String> teamMembers;
    @FXML
    ListView<String> customers;
    private ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin", "projects.xml");


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adapter = new ColourITFileAdapter("data.bin", "data.xml");
        ColourIT colourIT = adapter.getColourIt();
        ArrayList<Project> projectList;
        ArrayList<TeamMember> teamMembersList;
        ArrayList<Customer> customersList;

        projectList = colourIT.getProjectList().getProjects();
        teamMembersList = colourIT.getTeamMemberList().getTeamMembers();
        customersList = colourIT.getCustomerList().getCustomers();
        customersList.add(new Customer(1, "huj"));


        for (Project project : projectList) {
            projects.getItems().add(project.getName());
        }
        for (TeamMember teamMember : teamMembersList) {
            System.out.println(teamMember);
            teamMembers.getItems().add(teamMember.getName());
        }
        System.out.println(customersList);
        for (Customer customer : customersList) {
            System.out.println(customer);
            customers.getItems().add(customer.getName());
        }

    }

    public Project viewDetails() throws CustomNotFoundException {
        String currentSelectedItem;
        currentSelectedItem = projects.getSelectionModel().getSelectedItem();
        return adapter.getColourIt().getProjectList().getProject(currentSelectedItem);
    }

    public void detailedProjectView(ActionEvent e) throws IOException, CustomNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ProjectFields.fxml"));
        Parent projectFieldsParent = loader.load();
        Scene detailedProjectView = new Scene(projectFieldsParent);
        ProjectFieldsController controller = loader.getController();
        controller.initData(viewDetails());
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(detailedProjectView);
        window.show();
    }

    public void handleAddProject(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddProject.fxml"));
        Parent mainParent = loader.load();
        Scene MainParentVIew = new Scene(mainParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(MainParentVIew);
        window.show();

    }

    public void handleDelete(ActionEvent e) throws IOException, CustomNotFoundException {

        ColourIT colourIT = adapter.getColourIt();
        ArrayList<Project> projects1 = new ArrayList<>();
        projects1 = colourIT.getProjectList().getProjects();
        for (Project project : projects1) {
            System.out.println(project.getName());
            if (project.getName().equals(projects.getSelectionModel().getSelectedItem())) {
                System.out.println("If statement kurwa?");
                colourIT.getProjectList().deleteProject(project);
                break;
            }

        }
        adapter.save(colourIT);
        projects.getItems().remove(projects.getSelectionModel().getSelectedItem());
    }

    public void handleEditProject(ActionEvent e) throws IOException, CustomNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EditProject.fxml"));
        Parent editProjectParent = loader.load();
        Scene editProjectView = new Scene(editProjectParent);
        EditProjectController controller = loader.getController();
        controller.initData(viewDetails());
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(editProjectView);
        window.show();
    }
}

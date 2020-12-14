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
    Button addTeamMemberButton;
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

        ArrayList<TeamMember> teamMembersList;
        ArrayList<Customer> customersList;

        ArrayList<Project> projectList = colourIT.getProjectList().getProjects();
        teamMembersList = colourIT.getTeamMemberList().getTeamMembers();
        customersList = colourIT.getCustomerList().getCustomers();
        customersList.add(new Customer(1, "huj"));


        for (Project project : projectList) {
            projects.getItems().add(project.getName());
        }
        for (TeamMember teamMember : teamMembersList) {
            teamMembers.getItems().add(teamMember.getName());
        }
        System.out.println(customersList);
        for (Customer customer : customersList) {
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
        System.out.println(adapter.getColourIt().getProjectList().getProjects());
    }

    public TeamMember viewMembersDetails() throws CustomNotFoundException {
        String currentSelectedItem;
        currentSelectedItem = teamMembers.getSelectionModel().getSelectedItem();
        System.out.println(adapter.getColourIt().getTeamMemberList().getTeamMember(currentSelectedItem));
        return adapter.getColourIt().getTeamMemberList().getTeamMember(currentSelectedItem);
    }

    public void detailedTeamMemberView(ActionEvent e) throws IOException, CustomNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TeamMemberFields.fxml"));
        Parent TeamMemberFieldsParent = loader.load();
        Scene detailedTeamMemberView = new Scene(TeamMemberFieldsParent);
        TeamMemberFieldsController controller = loader.getController();
        controller.initData(viewMembersDetails());
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene((detailedTeamMemberView));
        window.show();
    }

    public Customer viewCustomerDetails() throws CustomNotFoundException {
        String currentSelectedItem;
        currentSelectedItem = customers.getSelectionModel().getSelectedItem();
        System.out.println(adapter.getColourIt().getCustomerList().getCustomer(currentSelectedItem));
        return adapter.getColourIt().getCustomerList().getCustomer(currentSelectedItem);
    }

    public void detailedCustomerView(ActionEvent e) throws IOException, CustomNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CustomerFields.fxml"));
        Parent CustomerFieldsParent = loader.load();
        Scene detailedCustomerView = new Scene(CustomerFieldsParent);
        CustomerFieldsController controller = loader.getController();
        controller.initData(viewCustomerDetails());
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene((detailedCustomerView));
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

    public void handleAddTeamMember(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddTeamMember.fxml"));
        Parent mainParent = loader.load();
        Scene MainParentVIew = new Scene(mainParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(MainParentVIew);
        window.show();

    }

    public void handleAddCustomer(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddCustomer.fxml"));
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

    public void handleDeleteTeamMember(ActionEvent e) throws IOException, CustomNotFoundException {

        ColourIT colourIT = adapter.getColourIt();
        ArrayList<TeamMember> teamMembers1 = new ArrayList<>();
        teamMembers1 = colourIT.getTeamMemberList().getTeamMembers();
        for (TeamMember teamMember : teamMembers1) {
            System.out.println(teamMember.getName());
            if (teamMember.getName().equals(teamMembers.getSelectionModel().getSelectedItem())) {
                System.out.println("If statement kurwa?");
                colourIT.getTeamMemberList().deleteTeamMember(teamMember);
                break;
            }

        }
        adapter.save(colourIT);
        teamMembers.getItems().remove(teamMembers.getSelectionModel().getSelectedItem());
    }

    public void handleDeleteCustomer(ActionEvent e) throws IOException, CustomNotFoundException {

        ColourIT colourIT = adapter.getColourIt();
        ArrayList<Customer> customers1 = new ArrayList<>();
        customers1 = colourIT.getCustomerList().getCustomers();
        for (Customer customer : customers1) {
            System.out.println(customer.getName());
            if (customer.getName().equals(customers.getSelectionModel().getSelectedItem())) {
                System.out.println("If statement kurwa?");
                colourIT.getCustomerList().deleteCustomer(customer);
                break;
            }

        }
        adapter.save(colourIT);
        customers.getItems().remove(customers.getSelectionModel().getSelectedItem());
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

    public void handleEditTeamMember(ActionEvent e) throws IOException, CustomNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EditTeamMember.fxml"));
        Parent editTeamMemberParent = loader.load();
        Scene editTeamMemberView = new Scene(editTeamMemberParent);
        EditTeamMemberController controller = loader.getController();
        controller.initData(viewMembersDetails());
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(editTeamMemberView);
        window.show();
    }

    public void handleEditCustomer(ActionEvent e) throws IOException, CustomNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EditCustomer.fxml"));
        Parent editCustomerParent = loader.load();
        Scene editCustomerView = new Scene(editCustomerParent);
        EditCustomerController controller = loader.getController();
        controller.initData(viewCustomerDetails());
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(editCustomerView);
        window.show();
    }
}

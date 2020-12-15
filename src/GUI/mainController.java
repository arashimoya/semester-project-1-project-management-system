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

/**
 * GUI scene representing home scene
 *
 * @author Tymon
 */
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

    /**
     * Initialises home scene
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adapter = new ColourITFileAdapter("data.bin", "data.xml");
        ColourIT colourIT = adapter.getColourIt();
        ArrayList<TeamMember> teamMembersList;
        ArrayList<Customer> customersList;
        ArrayList<Project> projectList;
        try {
            projectList = colourIT.getProjectList().getProjects();
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
        } catch(NullPointerException e){
            ColourIT colourIT1 = new ColourIT();
            adapter.save(colourIT1);
            adapter.save(colourIT1);
        }
    }

    /**
     * Gets Project based on selected ListView item
     *
     * @return project based on data displayed in ListView
     * @throws CustomNotFoundException if project was not found
     */
    public Project viewDetails() throws CustomNotFoundException {
        String currentSelectedItem;
        currentSelectedItem = projects.getSelectionModel().getSelectedItem();
        return adapter.getColourIt().getProjectList().getProject(currentSelectedItem);
    }

    /**
     * Launches GUI Scene responsible for viewing project fields
     *
     * @param e ActionEvent type object for getting window source
     * @throws IOException             if source file was not found
     * @throws CustomNotFoundException if project was not found
     */
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

    /**
     * Returns TeamMember Object based on selected item in ListView
     *
     * @return TeamMember Object if it was found with given name
     * @throws CustomNotFoundException if teamMember was not found
     */
    public TeamMember viewMembersDetails() throws CustomNotFoundException {
        String currentSelectedItem;
        currentSelectedItem = teamMembers.getSelectionModel().getSelectedItem();
        System.out.println(adapter.getColourIt().getTeamMemberList().getTeamMember(currentSelectedItem));
        return adapter.getColourIt().getTeamMemberList().getTeamMember(currentSelectedItem);
    }

    /**
     * Launches GUI Scene responsible for viewing TeamMember fields
     *
     * @param e ActionEvent type object for getting window source
     * @throws IOException             if source file was not found
     * @throws CustomNotFoundException if TeamMember was not found
     */
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

    /**
     * Returns Customer Object based on selected item in ListView
     *
     * @return Customer Object if it was found with given name
     * @throws CustomNotFoundException if Customer was not found
     */
    public Customer viewCustomerDetails() throws CustomNotFoundException {
        String currentSelectedItem;
        currentSelectedItem = customers.getSelectionModel().getSelectedItem();
        System.out.println(adapter.getColourIt().getCustomerList().getCustomer(currentSelectedItem));
        return adapter.getColourIt().getCustomerList().getCustomer(currentSelectedItem);
    }

    /**
     * Launches GUI Scene responsible for viewing Customer fields
     *
     * @param e ActionEvent type object for getting window source
     * @throws IOException             if source file was not found
     * @throws CustomNotFoundException if Customer was not found
     */
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

    /**
     * Opens GUI scene for adding a project
     *
     * @param e ActionEvent type object for getting window source
     * @throws IOException if source file cannot be opened
     */
    public void handleAddProject(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddProject.fxml"));
        Parent mainParent = loader.load();
        Scene MainParentVIew = new Scene(mainParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(MainParentVIew);
        window.show();

    }

    /**
     * Opens GUI scene for adding a teamMember
     *
     * @param e ActionEvent type object for getting window source
     * @throws IOException if source file cannot be opened
     */
    public void handleAddTeamMember(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddTeamMember.fxml"));
        Parent mainParent = loader.load();
        Scene MainParentVIew = new Scene(mainParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(MainParentVIew);
        window.show();

    }

    /**
     * Opens GUI scene for adding a Customer
     *
     * @param e ActionEvent type object for getting window source
     * @throws IOException if source file cannot be opened
     */
    public void handleAddCustomer(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddCustomer.fxml"));
        Parent mainParent = loader.load();
        Scene MainParentVIew = new Scene(mainParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(MainParentVIew);
        window.show();

    }

    /**
     * Deletes selected project
     *
     * @param e ActionEvent type object for getting window source
     * @throws CustomNotFoundException if selected project was not found
     */
    public void handleDelete(ActionEvent e) throws CustomNotFoundException {

        ColourIT colourIT = adapter.getColourIt();
        ArrayList<Project> projects1 = new ArrayList<>();
        projects1 = colourIT.getProjectList().getProjects();
        for (Project project : projects1) {
            System.out.println(project.getName());
            if (project.getName().equals(projects.getSelectionModel().getSelectedItem())) {
                colourIT.getProjectList().deleteProject(project);
                break;
            }

        }
        adapter.save(colourIT);
        projects.getItems().remove(projects.getSelectionModel().getSelectedItem());
    }

    /**
     * Deletes selected teamMember
     *
     * @throws CustomNotFoundException if teamMember was not found
     */
    public void handleDeleteTeamMember() throws CustomNotFoundException {

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

    /**
     * Deletes selected Customer
     *
     * @throws CustomNotFoundException if Customer was not found
     */
    public void handleDeleteCustomer() throws CustomNotFoundException {

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

    /**
     * Launches GUI scene for editing projects
     *
     * @param e ActionEvent type object for getting window source
     * @throws IOException             if source file cannot be opened
     * @throws CustomNotFoundException if project was not found
     */
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

    /**
     * Launches GUI scene for editing TeamMembers
     *
     * @param e ActionEvent type object for getting window source
     * @throws IOException             if source file cannot be opened
     * @throws CustomNotFoundException if teamMember was not found
     */
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

    /**
     * Launches GUI scene for editing Customers
     *
     * @param e ActionEvent type object for getting window source
     * @throws IOException             if source file cannot be opened
     * @throws CustomNotFoundException if Customer was not found
     */
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

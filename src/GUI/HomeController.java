package GUI;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.ObjectInputFilter;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController {
    @FXML
    Button add;
    @FXML
    Button edit;
    @FXML
    Button delete;
    @FXML
    TableView<Project> tableView;
    @FXML
    TableColumn<Project, Integer> ID;
    @FXML
    TableColumn<Project, String> Name;
    @FXML
    TableColumn<Project, MyDate> deadline;
    @FXML
    TableColumn<Project, String> status;
    @FXML
    TableColumn<Project, ProjectCreator> projectCreator;
    @FXML
    TableColumn<Project, ProductOwner> productOwner;
    @FXML
    TableColumn<Project, ScrumMaster> scrumMaster;
    @FXML
    TableColumn<Project, Customer> customer;

    public void initialize(URL url, ResourceBundle rb) {
        ID.setCellValueFactory(new PropertyValueFactory<Project, Integer>("id"));
        Name.setCellValueFactory(new PropertyValueFactory<Project, String>("name"));
        scrumMaster.setCellValueFactory(new PropertyValueFactory<Project, ScrumMaster>("scrumMaster"));
        productOwner.setCellValueFactory(new PropertyValueFactory<Project, ProductOwner>("productOwner"));
        projectCreator.setCellValueFactory(new PropertyValueFactory<Project, ProjectCreator>("projectCreator"));
        deadline.setCellValueFactory(new PropertyValueFactory<Project, MyDate>("deadline"));
        customer.setCellValueFactory(new PropertyValueFactory<Project, Customer>("customer"));
        tableView.setItems(getProjects());
    }

    public ObservableList<Project> getProjects() {
        ObservableList<Project> projects = FXCollections.observableArrayList();
        return null;
    }
}

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
import org.w3c.dom.Text;

import java.io.IOException;

public class EditProjectController {
    @FXML
    Button cancel;
    @FXML
    Button next;
    @FXML
    TextField nameField;
    @FXML
    TextField dayField;
    @FXML
    TextField monthField;
    @FXML
    TextField yearField;
    @FXML
    ComboBox<String> scrumMasterNameField;
    @FXML
    ComboBox<String> projectCreatorNameField;
    @FXML
    ComboBox<String> projectOwnerNameField;
    @FXML
    ComboBox<String> customerNameField;
    @FXML
    TextField projectID;
    private Project project;
    private final ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin", "data.xml");

    public void initData(Project project) {
        this.project = project;
        nameField.setText(project.getName());
        projectID.setText(Integer.toString(project.getId()));
        dayField.setText(Integer.toString(project.getDeadline().getDay()));
        monthField.setText(Integer.toString(project.getDeadline().getMonth()));
        yearField.setText(Integer.toString(project.getDeadline().getYear()));
        projectCreatorNameField.getSelectionModel().select(project.getProjectCreator().getName());
        customerNameField.getSelectionModel().select(project.getCustomer().getName());
        scrumMasterNameField.getSelectionModel().select(project.getScrumMaster().getName());
        projectOwnerNameField.getSelectionModel().select(project.getProductOwner().getName());
        ColourIT colourIT = adapter.getColourIt();
        for (Customer customer : colourIT.getCustomerList().getCustomers()) {
            customerNameField.getItems().add(customer.getName());
        }
        for (TeamMember teamMember : colourIT.getTeamMemberList().getTeamMembers()) {
            scrumMasterNameField.getItems().add(teamMember.getName());
            projectCreatorNameField.getItems().add(teamMember.getName());
            projectOwnerNameField.getItems().add(teamMember.getName());
        }
    }

    public void handleNext(ActionEvent e) throws IllegalDateException, CustomNotFoundException, IOException {
        int id = Integer.parseInt(projectID.getText());
        ColourIT colourIT = adapter.getColourIt();
        String name = nameField.getText();
        String scrumMasterName = scrumMasterNameField.getValue();
        String customerName = customerNameField.getValue();
        String projectOwnerName = projectOwnerNameField.getValue();
        for (Project project1 : colourIT.getProjectList().getProjects()) {
            if (project1.getId() == id) {
                project = project1;
                break;
            }
        }
        int day = Integer.parseInt(dayField.getText());
        int month = Integer.parseInt(monthField.getText());
        int year = Integer.parseInt(yearField.getText());
        MyDate deadline = new MyDate(day, month, year);
        colourIT.getProjectList().editProject(project, name, colourIT.getTeamMemberList().getTeamMember(scrumMasterName),
                colourIT.getTeamMemberList().getTeamMember(projectOwnerName),
                deadline, colourIT.getCustomerList().getCustomer(customerName), "huj");
        adapter.save(colourIT);
        changeScene(e);


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

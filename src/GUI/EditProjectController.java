package GUI;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    TextField idField;
    @FXML
    TextField nameField;
    @FXML
    TextField dayField;
    @FXML
    TextField monthField;
    @FXML
    TextField yearField;
    @FXML
    TextField scrumMasterNameField;
    @FXML
    TextField projectCreatorNameField;
    @FXML
    TextField projectOwnerNameField;
    @FXML
    TextField customerNameField;
    @FXML
    TextField scrumMasterID;
    @FXML
    TextField productOwnerID;
    @FXML
    TextField projectID;
    @FXML
    TextField customerID;
    @FXML
    TextField projectCreatorID;
    private Project project;

    private final ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin", "data.xml");

    public void initData(Project project) {
        this.project = project;
        nameField.setText(project.getName());
        projectID.setText(Integer.toString(project.getId()));
        dayField.setText(Integer.toString(project.getDeadline().getDay()));
        monthField.setText(Integer.toString(project.getDeadline().getMonth()));
        yearField.setText(Integer.toString(project.getDeadline().getYear()));
        projectOwnerNameField.setText(project.getProductOwner().getName());
        projectCreatorNameField.setText(project.getProjectCreator().getName());
        customerNameField.setText(project.getCustomer().getName());
        customerID.setText(Integer.toString(project.getCustomer().getId()));
        productOwnerID.setText(Integer.toString(project.getProductOwner().getId()));
        projectCreatorID.setText(Integer.toString(project.getProjectCreator().getId()));
        projectID.setText(Integer.toString(project.getId()));
        scrumMasterNameField.setText(project.getScrumMaster().getName());
        scrumMasterID.setText(Integer.toString(project.getScrumMaster().getId()));

    }

    public void handleNext(ActionEvent e) throws IllegalDateException, CustomNotFoundException, IOException, ObjectAlreadyExistsException {
        ColourIT colourIT = adapter.getColourIt();
        String name = nameField.getText();
        String scrumMasterName = scrumMasterNameField.getText();
        String customerName = customerNameField.getText();
        String projectCreatorName = projectCreatorNameField.getText();
        String projectOwnerName = projectOwnerNameField.getText();
        int day = Integer.parseInt(dayField.getText());
        int month = Integer.parseInt(monthField.getText());
        int year = Integer.parseInt(yearField.getText());
        if (!(colourIT.getTeamMemberList().getTeamMembers().contains(colourIT.getTeamMemberList().getTeamMember(scrumMasterName))))
            colourIT.getTeamMemberList().createTeamMember(scrumMasterName);
        if (!(colourIT.getTeamMemberList().getTeamMembers().contains(colourIT.getTeamMemberList().getTeamMember(projectOwnerName))))
            colourIT.getTeamMemberList().createTeamMember(projectOwnerName);
        if (!(colourIT.getCustomerList().getCustomers().contains(colourIT.getCustomerList().getCustomer(customerName))))
            colourIT.getCustomerList().createCustomer(customerName);
        MyDate deadline = new MyDate(day, month, year);
        colourIT.getProjectList().editProject(project, name, colourIT.getTeamMemberList().getTeamMember(scrumMasterName),
                colourIT.getTeamMemberList().getTeamMember(projectOwnerName), colourIT.getTeamMemberList().getTeamMember(projectCreatorName),
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

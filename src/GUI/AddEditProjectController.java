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

public class AddEditProjectController {
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
    private final ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin", "data.xml");

    public void handleNext(ActionEvent e) throws IllegalDateException, CustomNotFoundException, IOException {
        String name = nameField.getText();
        String scrumMasterName = scrumMasterNameField.getText();
        String customerName = customerNameField.getText();
        String projectCreatorName = projectCreatorNameField.getText();
        String projectOwnerName = projectOwnerNameField.getText();
        int id = 3;
        int day = Integer.parseInt(dayField.getText());
        int month = Integer.parseInt(monthField.getText());
        int year = Integer.parseInt(yearField.getText());
        ColourIT colourIT = adapter.getColourIt();
        colourIT.getTeamMemberList().createTeamMember(scrumMasterName);
        colourIT.getTeamMemberList().createTeamMember(projectCreatorName);
        colourIT.getTeamMemberList().createTeamMember(projectOwnerName);
        colourIT.getCustomerList().createCustomer(customerName);
        MyDate deadline = new MyDate(day, month, year);
        colourIT.getProjectList().createProject(name, colourIT.getTeamMemberList().getTeamMember(scrumMasterName),
                colourIT.getTeamMemberList().getTeamMember(projectOwnerName), colourIT.getTeamMemberList().getTeamMember(projectCreatorName),
                deadline, colourIT.getCustomerList().getCustomer(customerName), "jd");
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

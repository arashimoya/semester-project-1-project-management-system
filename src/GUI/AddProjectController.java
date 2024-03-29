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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Public class responsible for creating projects inside ColourIT
 * @author Tymon
 * @version 1
 */
public class AddProjectController implements Initializable {
    @FXML
    TextField descriptionField;
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
    ComboBox<String> scrumMasterNameField;
    @FXML
    ComboBox<String> projectCreatorNameField;
    @FXML
    ComboBox<String> projectOwnerNameField;
    @FXML
    ComboBox<String> customerNameField;


    private final ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin", "data.xml");

    /**
     * Responsible for creating project inside projectList with parameters given in TextFields
     * @param e ActionEvent type object
     * @throws IllegalDateException if date format is incorrect
     * @throws CustomNotFoundException if one or more team members were not found inside teamMemberList
     * @throws IOException if file cannot be opened
     * @throws ObjectAlreadyExistsException if project already exists
     */
    public void handleNext(ActionEvent e) throws IllegalDateException, CustomNotFoundException, IOException, ObjectAlreadyExistsException {
        ColourIT colourIT = adapter.getColourIt();
        String description = descriptionField.getText();
        String name = nameField.getText();
        String scrumMasterName = scrumMasterNameField.getValue();
        String customerName = customerNameField.getValue();
        String projectCreatorName = projectCreatorNameField.getValue();
        String projectOwnerName = projectOwnerNameField.getValue();
        int day = Integer.parseInt(dayField.getText());
        int month = Integer.parseInt(monthField.getText());
        int year = Integer.parseInt(yearField.getText());
        MyDate deadline = new MyDate(day, month, year);
        colourIT.getProjectList().createProject(name, colourIT.getTeamMemberList().getTeamMember(scrumMasterName),
                colourIT.getTeamMemberList().getTeamMember(projectOwnerName), colourIT.getTeamMemberList().getTeamMember(projectCreatorName),
                deadline, colourIT.getCustomerList().getCustomer(customerName), description);
        adapter.save(colourIT);
        adapter.saveToXml(colourIT);
        changeScene(e);


    }

    /**
     * changes scene to home
     * @param e ActionEvent type object for getting current window
     * @throws IOException if file cannot be opened
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
     * sets field representing ProjectID with data from ProjectList, initialises ComboBoxes with data from ColourIT
     * @param url mandatory for this method
     * @param resourceBundle mandatory for this method
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ColourIT colourIT = adapter.getColourIt();
        try {
            idField.setText(Integer.toString(colourIT.getProjectList().getIdCounter()));
            for (Customer customer : colourIT.getCustomerList().getCustomers()) {
                customerNameField.getItems().add(customer.getName());
            }
            for (TeamMember teamMember : colourIT.getTeamMemberList().getTeamMembers()) {
                scrumMasterNameField.getItems().add(teamMember.getName());
                projectCreatorNameField.getItems().add(teamMember.getName());
                projectOwnerNameField.getItems().add(teamMember.getName());
            }
        }catch (NullPointerException e){
            idField.setText("0");
        }

    }

}

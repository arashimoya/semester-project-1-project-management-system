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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Gui scene for adding teamMember to project, teamMember can only be selected from ComboBox
 * @author Tymon
 */
public class AddTeamMemberToProjectController {
    @FXML
    ComboBox<String> teamMemberComboBox;
    @FXML
    TextField projectID;
    @FXML
    Button nextButton;
    @FXML
    Button okButton;
    @FXML
    Button cancelButton;
    ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin", "data.xml");

    /**
     * initialises ComboBox inside gui
     * @param project teamMember will be added to this project
     */
    public void initData(Project project) {
        for (TeamMember teamMember : adapter.getColourIt().getTeamMemberList().getTeamMembers()) {
            teamMemberComboBox.getItems().add(teamMember.getName());
        }
        projectID.setText(Integer.toString(project.getId()));
    }

    /**
     * adds teamMember to project, does not go back to home scene which allows adding multiple teamMembers one after another
     * @param e ActionEvent type object for getting window source
     * @throws CustomNotFoundException if project was not found
     * @throws ObjectAlreadyExistsException if teamMember is inside TeamMemberList field in given project
     */
    public void handleNext(ActionEvent e) throws CustomNotFoundException, ObjectAlreadyExistsException {
        String name = teamMemberComboBox.getSelectionModel().getSelectedItem();
        ColourIT colourIT = adapter.getColourIt();
        TeamMember teamMember = colourIT.getTeamMemberList().getTeamMember(name);
        colourIT.getProjectList().getProject(Integer.parseInt(projectID.getText())).getTeamMemberList().addTeamMember(teamMember);
        adapter.save(colourIT);
        adapter.saveToXml(colourIT);
        teamMemberComboBox.getSelectionModel().selectFirst();
        teamMemberComboBox.getItems().remove(name);
    }

    /**
     * goes back to home scene
     * @param e ActionEvent type object for getting window source
     * @throws IOException if source file cannot be opened
     */
    public void handleCancel(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("main.fxml"));
        Parent mainParent = loader.load();
        Scene MainParentVIew = new Scene(mainParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(MainParentVIew);
        window.show();
    }


}

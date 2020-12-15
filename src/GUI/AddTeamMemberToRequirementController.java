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
 * GUI scene for adding teamMember to requirement
 * @author Tymon
 *
 */
public class AddTeamMemberToRequirementController {
    @FXML
    ComboBox<String> teamMemberComboBox;
    @FXML
    TextField requirementIDText;
    @FXML
    TextField projectIDText;
    @FXML
    Button nextButton;
    @FXML
    Button okButton;
    @FXML
    Button cancelButton;
    ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin", "data.xml");

    /**
     * Initialises gui controllers and containers
     * @param projectID id of project related to requirement, type int
     * @param requirementID id of requirement, type int
     * @throws CustomNotFoundException if project or requirement were not found
     */
    public void initData(int projectID, int requirementID) throws CustomNotFoundException {
        for (TeamMember teamMember : adapter.getColourIt().getProjectList().getProject(projectID).getTeamMemberList().getTeamMembers()) {
            teamMemberComboBox.getItems().add(teamMember.getName());
        }
        projectIDText.setText(Integer.toString(projectID));
        requirementIDText.setText(Integer.toString(requirementID));
    }

    /**
     * adds teamMember to teamMemberList inside requirement
     * @param e ActionEvent type object for getting window source
     * @throws CustomNotFoundException if requirement or projects were not found
     * @throws ObjectAlreadyExistsException when teamMemberList already contains given teamMember
     */
    public void handleNext(ActionEvent e) throws CustomNotFoundException, ObjectAlreadyExistsException {
        String name = teamMemberComboBox.getSelectionModel().getSelectedItem();
        ColourIT colourIT = adapter.getColourIt();
        TeamMember teamMember = colourIT.getProjectList().getProject(Integer.parseInt(projectIDText.getText())).getTeamMemberList().getTeamMember(name);
        colourIT.getProjectList().getProject(Integer.parseInt(projectIDText.getText())).getRequirementList().
                getRequirement(Integer.parseInt(requirementIDText.getText())).getTeamMembers().addTeamMember(teamMember);
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


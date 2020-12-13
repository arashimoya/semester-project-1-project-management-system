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

import java.io.IOException;

public class EditTeamMemberController {
    @FXML
    TextField idField;
    @FXML
    TextField nameField;
    @FXML
    Button cancelButton;
    @FXML
    Button okButton;
    private TeamMember teamMember;
    private final ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin", "data.xml");

    public void initData(TeamMember teamMember) {
        this.teamMember = teamMember;
        nameField.setText(teamMember.getName());
        idField.setText(Integer.toString(teamMember.getId()));
    }

    public void handleOK(ActionEvent e)
            throws IOException, CustomNotFoundException {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        ColourIT colourIT = adapter.getColourIt();
        TeamMember teamMember = colourIT.getTeamMemberList().getTeamMember(id);
        colourIT.getTeamMemberList().editTeamMember(teamMember, name);
        adapter.save(colourIT);
        adapter.saveToXml(colourIT);
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

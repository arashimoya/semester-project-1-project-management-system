package GUI;

import Model.TeamMember;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * GUI representation of TeamMember information
 * @author Tymon
 */
public class TeamMemberFieldsController
{
  @FXML
  Label idLabel;
  @FXML
  Label nameLabel;
  @FXML
  Button cancelButton;
  @FXML
  Button okButton;
  TeamMember selectedTeamMember;

  /**
   * Initialises GUI with data about given teamMember
   * @param teamMember that data will be displayed
   */
  public void initData (TeamMember teamMember){
    selectedTeamMember = teamMember;
    idLabel.setText(Integer.toString(teamMember.getId()));
    nameLabel.setText(teamMember.getName());
  }

  /**
   * changes scene back to home scene
   * @param e ActionEvent type object for getting source of the window
   * @throws IOException if source file could not been loaded
   */
  public void changeScene(ActionEvent e) throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("main.fxml"));
    Parent mainParent = loader.load();
    Scene MainParentVIew = new Scene(mainParent);
    Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
    window.setScene(MainParentVIew);
    window.show();
  }
}

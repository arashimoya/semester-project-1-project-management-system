package GUI;

import Model.ColourIT;
import Model.ColourITFileAdapter;
import Model.ObjectAlreadyExistsException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * GUI scene for adding team member to teamMemberList inside Colour IT
 * @author Adam
 */
public class AddTeamMemberController {
  @FXML
  TextField idField;
  @FXML TextField nameField;
  @FXML Button okButton;
  @FXML Button cancelButton;
  @FXML Button nextButton;

  private final ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin","data.xml");

  /**
   * adds one teamMember to teamMemberList and changes scene to home scene
   * @param e ActionEvent type object for getting window source
   * @throws IOException if source file cannot be opened
   * @throws ObjectAlreadyExistsException if teamMember already exists
   */
  public void handleOK(ActionEvent e) throws IOException, ObjectAlreadyExistsException {
    ColourIT colourIT = adapter.getColourIt();
    String name = nameField.getText();
    String id = idField.getText();
    colourIT.getTeamMemberList().createTeamMember(name);
    adapter.save(colourIT);
    changeScene(e);
  }

  /**
   * Allows to add multiple customers without going back to home scene
   * @param e ActionEvent type object for getting window source
   * @throws IOException if source file cannot be opened
   * @throws ObjectAlreadyExistsException if teamMember already exists inside TeamMemberList
   */
  public void handleNext(ActionEvent e) throws IOException, ObjectAlreadyExistsException
  {
    ColourIT colourIT = adapter.getColourIt();
    String name = nameField.getText();
    String id = idField.getText();
    colourIT.getTeamMemberList().createTeamMember(name);
    adapter.save(colourIT);
    adapter.saveToXml(colourIT);
    idField.clear();
    nameField.clear();
  }

  /**
   * changes scene to home scene
   * @param e ActionEvent type object for getting window source
   * @throws IOException if source file cannot be opened
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
}

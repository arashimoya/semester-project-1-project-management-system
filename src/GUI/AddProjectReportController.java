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

public class AddProjectReportController {
    @FXML
    TextField projectIDField;
    @FXML
    TextField projectReportIDField;
    @FXML
    TextField ScrumMasterField;
    @FXML
    TextField Message;
    @FXML
    TextField day;
    @FXML
    TextField month;
    @FXML
    TextField year;
    @FXML
    Button ok;
    @FXML
    Button cancel;
    ColourITFileAdapter adapter = new ColourITFileAdapter("data.bin", "data.xml");

    public void initData(int projectID) throws CustomNotFoundException {
        Project project = adapter.getColourIt().getProjectList().getProject(projectID);
        projectIDField.setText(Integer.toString(projectID));
        ScrumMasterField.setText(project.getScrumMaster().getName());
        projectReportIDField.setText(Integer.toString(project.getProjectReportList().getIdCounter()));
        MyDate date = new MyDate();
        day.setText(Integer.toString(date.getDay()));
        month.setText(Integer.toString(date.getMonth()));
        year.setText(Integer.toString(date.getYear()));
    }

    public void handleOk(ActionEvent e) throws CustomNotFoundException, ObjectAlreadyExistsException, IOException {
        String message = Message.getText();
        Project project = adapter.getColourIt().getProjectList().getProject(Integer.parseInt(projectIDField.getText()));
        TeamMember scrumMaster = project.getScrumMaster();
        ColourIT colourIT = adapter.getColourIt();
        colourIT.getProjectList().getProject(project.getId()).
                getProjectReportList().createProjectReport(scrumMaster, message);
        adapter.save(colourIT);
        adapter.saveToXml(colourIT);
        cancel(e);
    }

    public void cancel(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("main.fxml"));
        Parent mainParent = loader.load();
        Scene MainParentVIew = new Scene(mainParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(MainParentVIew);
        window.show();
    }
}

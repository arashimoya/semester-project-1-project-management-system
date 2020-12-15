package GUI;

import Model.Project;
import Model.ProjectReport;
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
 * Represents projectReport fields as a GUI scene
 * @author Tymon
 */
public class ProjectReportController {
    @FXML
    Label idLabel;
    @FXML
    Label ScrumMasterLabel;
    @FXML
    Label messageLabel;
    @FXML
    Label dateLabel;
    @FXML
    Button backButton;

    /**
     * Initialises GUI with information from report
     * @param report that is going to be displayed
     */
    public void initData(ProjectReport report) {
        idLabel.setText(Integer.toString(report.getID()));
        ScrumMasterLabel.setText(report.getScrumMaster().getName());
        messageLabel.setText(report.getMessage());
        dateLabel.setText(report.getDate().toString());
    }

    /**
     * Changes scene to home scene
     * @param e ActionEvent type object for getting window source
     * @throws IOException if source file could not be opened
     */
    public void handleBack(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("main.fxml"));
        Parent mainParent = loader.load();
        Scene MainParentVIew = new Scene(mainParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(MainParentVIew);
        window.show();
    }
}

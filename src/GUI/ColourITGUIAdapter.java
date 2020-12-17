package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Launches GUI application
 *
 * @author Oliver
 */
public class ColourITGUIAdapter extends Application {
    /**
     * Starts application
     *
     * @param primaryStage represents home scene
     * @throws Exception mandatory for this method
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("Project Management System");
        primaryStage.setScene(new Scene(root, 800, 700));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

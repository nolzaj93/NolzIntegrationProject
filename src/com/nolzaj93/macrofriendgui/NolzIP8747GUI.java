package com.nolzaj93.macrofriendgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * GUI is in infant stage.
 * @author Austin Nolz
 */
public class NolzIP8747GUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLIntegrationProject.fxml"));

        Scene scene = new Scene(root, 1100, 680);

        stage.setTitle("MacroFriend");
        stage.setScene(scene);
        scene.getStylesheets().add(NolzIP8747GUI.class.getResource("MacroFriendCSS.css").toExternalForm());

        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

package com.nolzaj93.macrofriendgui;

import com.nolzaj93.macrofriend.NewUser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * GUI is in infant stage. This class holds the Java code for the GUI and will switch between FXML
 * views depending on whether user input is valid or not.
 *
 * @author Austin Nolz
 */
public class MacroFriendGui extends Application {

  @Override
  public void start(Stage stage) throws Exception {

    Parent root = FXMLLoader.load(getClass().getResource("loginOrRegister.fxml"));
    Scene scene = new Scene(root, 1100, 680);

    stage.setTitle("MacroFriend");
    stage.setScene(scene);
    scene.getStylesheets()
        .add(MacroFriendGui.class.getResource("MacroFriendCSS.css").toExternalForm());

    stage.show();
  }

}

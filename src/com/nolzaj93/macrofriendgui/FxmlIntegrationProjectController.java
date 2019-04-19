package com.nolzaj93.macrofriendgui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 * @author Austin Nolz
 */
public class FxmlIntegrationProjectController {

  @FXML
  private Text actiontarget;

  @FXML
  protected void handleSubmitButtonAction(ActionEvent event) {
    actiontarget.setText("sign in button pressed");
  }

}

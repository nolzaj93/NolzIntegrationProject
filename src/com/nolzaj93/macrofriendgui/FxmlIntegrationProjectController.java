package com.nolzaj93.macrofriendgui;

import com.nolzaj93.macrofriend.NewUser;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * (2) MacroFriend is a program that is able to recommend an estimate of daily calories and
 * macronutrients depending on your activity level and fitness goal.
 * This controller class listens for actions from the user and makes changes to the view depending
 * on whether input is valid or not.
 *
 * @author Austin Nolz
 */
public class FxmlIntegrationProjectController {

  @FXML
  private Text actiontarget;

  @FXML
  private TextField userNameField;

  @FXML
  protected void handleSubmitButtonAction(ActionEvent event) {
    actiontarget.setText("Database coding in progress");
  }

  @FXML
  protected void handleRegisterButtonAction(ActionEvent event) {
    if ((userNameField.getText() != null && !userNameField.getText().isEmpty())) {
      NewUser user = new NewUser();
      actiontarget.setText(user.checkUserNameInput(userNameField.getText()));
      userNameField.clear();
    } else {
      actiontarget.setText("You have not entered a UserName.");
    }
  }
}

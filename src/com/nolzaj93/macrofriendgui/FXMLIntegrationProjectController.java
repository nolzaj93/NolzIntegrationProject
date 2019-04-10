/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nolzaj93.macrofriendgui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 *
 * @author Austin Nolz
 */
public class FXMLIntegrationProjectController {
    
    @FXML
    private Text actiontarget;
    
    @FXML
    protected void handleSubmitButtonAction(ActionEvent event){
        actiontarget.setText("sign in button pressed");
    }  
    
}

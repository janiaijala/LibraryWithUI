/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kirjastographui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Jani-Meiju
 */
class SelectUserPartial extends HBox {
    
    private final static Button userButton = new Button("Kayttaja");
    private final static Button adminButton = new Button("Admin");
    
    
    public SelectUserPartial() {
        this.setStyle("-fx-padding:30");
        this.setSpacing(30);
        this.getChildren().add(userButton);  
        this.getChildren().add(adminButton);
        this.getChildren().add(new SelectUserPartialCredentials());
    
    
        userButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                UserTabPanePartial.tab3.setDisable(true);
                UserTabPanePartial.tab4.setDisable(true);
                SelectUserPartialCredentials.etunimi.setDisable(false);
                SelectUserPartialCredentials.sukunimi.setDisable(false);
            }    
        });
        adminButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                
                SelectUserPartialCredentials.salasana.setDisable(false);
                
            }    
        }); 
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kirjastographui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Jani-Meiju
 */
class SelectUserPartialCredentials extends VBox{
    protected final static TextField etunimi = new TextField();
    protected final static TextField sukunimi = new TextField();    
    protected final static TextField salasana = new TextField();   
    private final static Label etunimiLabel = new Label("Etunimi");
    private final static Label sukunimiLabel = new Label("Sukunimi");
    private final static Label salasanaLabel = new Label("Salasana");
    private final static Button kirjauduButton = new Button("Kirjaudu");

    
    public SelectUserPartialCredentials() {
        this.setSpacing(5.0);
        this.getChildren().add(etunimiLabel);
        this.getChildren().add(etunimi);
        this.getChildren().add(sukunimiLabel);
        this.getChildren().add(sukunimi);      
        this.getChildren().add(salasanaLabel);
        this.getChildren().add(salasana);
        this.getChildren().add(kirjauduButton);
        
        etunimi.setDisable(true);
        sukunimi.setDisable(true);
        salasana.setDisable(true);
    
    
        kirjauduButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {

                    UserTabPanePartial.tab2.setDisable(true);
            }
        });
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kirjastographui;

import java.util.Iterator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;
import static kirjastographui.AddPiecePartial.teokset;

/**
 *
 * @author Jani-Meiju
 */
public class FindPiecePartialLeft extends VBox {
    
    private final static TextField etsiName = new TextField();
    private final static TextField etsiISBN = new TextField();
    private final static Label etsiNameLabel = new Label("Etsi nimella");
    private final static Label etsiISBNLabel = new Label("Etsi ISBN:lla");
    private final static Button etsiButton = new Button("Etsi");
    private final static Button poistaButton = new Button("poista");
    private final static Button myohassaButton = new Button("Myohassa olevat");
    private final static Button kaikkiButton = new Button("Koko kokoelma");
    private String temp_etsiName;
    private String temp_etsiISBN;
    
    public FindPiecePartialLeft() {
        this.setSpacing(5.0f);
        this.getChildren().add(etsiNameLabel);
        this.getChildren().add(etsiName);
        this.getChildren().add(etsiISBNLabel);
        this.getChildren().add(etsiISBN);
        this.getChildren().add(etsiButton);
        this.getChildren().add(poistaButton);
        this.getChildren().add(myohassaButton);
        this.getChildren().add(kaikkiButton);
        
        poistaButton.setVisible(false);

        etsiButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                
                for(TeosInfo temp:teokset){
                    FindPiecePartialRight.teosDB.clear();
                    if(etsiName.getText().equals(temp.getTeoksenNimi()) || etsiISBN.getText().equals(temp.getISBN())){
                        FindPiecePartialRight.teosDB.setText("Teoksen nimi: " +temp.getTeoksenNimi() + "\n" +
                            "Valmistusvuosi: " +temp.getVuosi() + "\n" +
                            "Tekija: " + temp.getTekija() + "\n" + 
                            "ISBN: " + temp.getISBN() +"\n\n");
                        poistaButton.setVisible(true);
                        temp_etsiName=etsiName.getText();
                        temp_etsiISBN=etsiISBN.getText();
                        etsiName.clear();
                        etsiISBN.clear();
                        break;
                    }else{
                        poistaButton.setVisible(false);
                    }
                }
            }    
        });
        
        poistaButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                for(TeosInfo temp:teokset){
                    if(temp_etsiName.equals(temp.getTeoksenNimi())||temp_etsiISBN.equals(temp.getISBN())){
                        teokset.remove(temp); 
                        JOptionPane.showMessageDialog(null, "Teos poistettu tietokannasta");
                        FindPiecePartialRight.teosDB.clear();
                    }
                    
                }   
            }             
        });
        myohassaButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {

            }    
        });
        kaikkiButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                FindPiecePartialRight.teosDB.clear();
                for(TeosInfo temp:teokset){
               
                    FindPiecePartialRight.teosDB.appendText(temp.tulosta(temp));
                            /*"Teoksen nimi: " +temp.getTeoksenNimi() + "\n" +
                            "Valmistusvuosi: " +temp.getVuosi() + "\n" +
                            "Tekija: " + temp.getTekija() + "\n" + 
                            "ISBN: " + temp.getISBN() +"\n\n");*/
                }
                poistaButton.setVisible(false);
            }   
            
        });        
    }
    
}

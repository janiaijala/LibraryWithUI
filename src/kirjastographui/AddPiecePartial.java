/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kirjastographui;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author Jani-Meiju
 */
public class AddPiecePartial extends VBox{
    
    private final static ChoiceBox teosValinta = new ChoiceBox(FXCollections.observableArrayList("Kirja","Lehti","DVD","CD"));
    private final static TextField teoksenNimi = new TextField();
    private final static TextField vuosi = new TextField();
    private final static TextField tekija= new TextField();
    private final static TextField ISBN = new TextField();
    private final static Label teoksenNLabel = new Label("Teoksen nimi");    
    private final static Label vuosiLabel = new Label("Valmistusvuosi");    
    private final static Label tekijaLabel = new Label("Teoksen tekija"); 
    private final static Label ISBNLabel = new Label("Teoksen ISBN"); 
    private final static Button tallennaButton = new Button("Tallenna");
    private final static TextField sivumaara = new TextField();
    private final static Label sivumaaraLabel = new Label("Sivumäärä");
    private final static TextField numero = new TextField();
    private final static Label numeroLabel = new Label("Numero");
    private final static TextField kplMaara = new TextField();
    private final static Label kplMaaraLabel = new Label("CD:n kappalemäärä");
    private final static TextField ohjaaja = new TextField();
    private final static Label ohjaajaLabel = new Label("Elokuvan ohjaaja");
    
    protected static final ArrayList<TeosInfo> teokset = new ArrayList<>();
    
    public AddPiecePartial(){
        this.setSpacing(5.0f);
        this.getChildren().add(teosValinta);
        this.getChildren().add(teoksenNLabel);
        this.getChildren().add(teoksenNimi);
        this.getChildren().add(vuosiLabel);
        this.getChildren().add(vuosi);
        this.getChildren().add(tekijaLabel);
        this.getChildren().add(tekija);
        this.getChildren().add(ISBNLabel);
        this.getChildren().add(ISBN);    
        this.getChildren().add(sivumaaraLabel);
        this.getChildren().add(sivumaara);
        this.getChildren().add(numeroLabel);
        this.getChildren().add(numero);
        this.getChildren().add(kplMaaraLabel);
        this.getChildren().add(kplMaara);
        this.getChildren().add(ohjaajaLabel);
        this.getChildren().add(ohjaaja);
        this.getChildren().add(tallennaButton);
        
        teosValinta.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
            //value contains old value and new_value selected value. Choicebox is observablelist and starts from index 0
            @Override
            public void changed(ObservableValue ov, Number value, Number new_value){
                if(new_value.equals(0)){
                    sivumaara.setDisable(false);
                    numero.setDisable(true);
                    kplMaara.setDisable(true);
                    ohjaaja.setDisable(true);
                }
                if(new_value.equals(1)){
                    sivumaara.setDisable(true);
                    numero.setDisable(false);
                    kplMaara.setDisable(true);
                    ohjaaja.setDisable(true);
                }
                if(new_value.equals(2)){
                    sivumaara.setDisable(true);
                    numero.setDisable(true);
                    kplMaara.setDisable(true);
                    ohjaaja.setDisable(false);
                }
                if(new_value.equals(3)){
                    sivumaara.setDisable(true);
                    numero.setDisable(true);
                    kplMaara.setDisable(false);
                    ohjaaja.setDisable(true);
                }                
            }
        });
        tallennaButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                //Cache object in arraylist
                teokset.add(getTeosInfo());
                clearFields();
            }    
        });
    }
    
    public static final TeosInfo getTeosInfo(){
        if(sivumaara.isDisabled()==false){
            Kirja kirja = new Kirja();
            kirja.setTekija(tekija.getText());
            kirja.setVuosi(vuosi.getText());
            kirja.setTeoksenNimi(teoksenNimi.getText());
            kirja.setISBN(ISBN.getText());
            kirja.setSivumaara(sivumaara.getText());
            return kirja;
        }
        if(numero.isDisabled()==false){
            Lehti lehti = new Lehti();
            lehti.setTekija(tekija.getText());
            lehti.setVuosi(vuosi.getText());
            lehti.setTeoksenNimi(teoksenNimi.getText());
            lehti.setISBN(ISBN.getText());
            lehti.setNumero(numero.getText());
            return lehti;
        }
        if(kplMaara.isDisabled()==false){
            CD cd = new CD();
            cd.setTekija(tekija.getText());
            cd.setVuosi(vuosi.getText());
            cd.setTeoksenNimi(teoksenNimi.getText());
            cd.setISBN(ISBN.getText());
            cd.setKplMaara(kplMaara.getText());
            return cd;
        }
        if(ohjaaja.isDisabled()==false){
            DVD dvd = new DVD();
            dvd.setTekija(tekija.getText());
            dvd.setVuosi(vuosi.getText());
            dvd.setTeoksenNimi(teoksenNimi.getText());
            dvd.setISBN(ISBN.getText());
            dvd.setOhjaaja(ohjaaja.getText());
            return dvd;
        }        
        /*TeosInfo teos = new TeosInfo();
        
        teos.setTekija(tekija.getText());
        teos.setVuosi(vuosi.getText());
        teos.setTeoksenNimi(teoksenNimi.getText());
        teos.setISBN(ISBN.getText());
                */
        
        return null;
    }
    
    public static final void clearFields(){
        teoksenNimi.clear();
        vuosi.clear();
        tekija.clear();
        ISBN.clear();
        sivumaara.clear();
        numero.clear();
        kplMaara.clear();
        ohjaaja.clear();

        }        
}

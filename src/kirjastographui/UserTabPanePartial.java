/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kirjastographui;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 *
 * @author Jani-Meiju
 */
public class UserTabPanePartial extends TabPane{
    protected static Tab tab1 = new Tab();
    protected static Tab tab2 = new Tab();
    protected static Tab tab3 = new Tab();
    protected static Tab tab4 = new Tab();
    
    
    public UserTabPanePartial(){
        this.setStyle("-fx-padding:10");
        tab1.setText("Kayttaja valinta");
        tab1.setContent(new SelectUserPartial());
        tab2.setText("Lainaa/palauta");
        tab2.setContent(new BorrowReturnPiecePartial());
        tab3.setText("Lisaa teos");
        tab3.setContent(new AddPiecePartial());
        //tab2.setDisable(true);
        tab4.setText("Etsi");
        tab4.setContent(new FindPiecePartial());
        //tab5.setText("Kokoelma");
        this.getTabs().add(tab1);
        this.getTabs().add(tab2);
        this.getTabs().add(tab3);
        this.getTabs().add(tab4);
    }
}

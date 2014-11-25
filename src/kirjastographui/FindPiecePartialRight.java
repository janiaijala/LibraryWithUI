/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kirjastographui;

import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

/**
 *
 * @author Jani-Meiju
 */
public class FindPiecePartialRight extends VBox {

    protected static TextArea teosDB = new TextArea();
    
    public FindPiecePartialRight() {
        this.setStyle("-fx-padding:10");
        this.setMaxSize(300, 800);
        this.getChildren().add(teosDB);
        
    }
    
}

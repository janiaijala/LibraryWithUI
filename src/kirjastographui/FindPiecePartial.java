/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kirjastographui;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Jani-Meiju
 */
public class FindPiecePartial extends BorderPane {


    
    
    public FindPiecePartial() {
         
        this.setCenter(new FindPiecePartialLeft());
        this.setRight(new FindPiecePartialRight());
        
    }
    
}

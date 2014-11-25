/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kirjastographui;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Jani-Meiju
 */
class BorrowReturnPiecePartial extends BorderPane {

    public BorrowReturnPiecePartial() {
        
        this.setCenter(new BorrowReturnPartialCenter());
        this.setRight(new BorrowReturnPartialRight());
        this.setBottom(new BorrowRerurnPartialBottom());
        
    }
    
}

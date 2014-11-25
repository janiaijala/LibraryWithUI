/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kirjastographui;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author Jani-Meiju
 */
class BorrowReturnPartialCenter extends VBox {
    protected final static TextField etsiUserName = new TextField();
    protected final static TextField etsiUserISBN = new TextField();
    protected final static Label etsiUNameLabel = new Label("Etsi nimella");
    protected final static Label etsiUISBNLabel = new Label("Etsi ISBN:lla");
    
    public BorrowReturnPartialCenter() {
        this.setSpacing(5.0f);
        this.getChildren().add(etsiUNameLabel);
        this.getChildren().add(etsiUserName);
        this.getChildren().add(etsiUISBNLabel);
        this.getChildren().add(etsiUserISBN);
    }
    
}

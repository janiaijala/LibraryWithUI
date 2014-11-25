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
import static kirjastographui.AddPiecePartial.teokset;

/**
 *
 * @author Jani-Meiju
 */
class BorrowRerurnPartialBottom extends HBox {

    protected final static Button etsiUserButton = new Button("Etsi");
    protected final static Button palautaUserButton = new Button("Palauta teos");
    protected final static Button lainaaUserButton = new Button("Lainaa teos");
    private String temp_etsiName;
    private String temp_etsiISBN;

    public BorrowRerurnPartialBottom() {
        this.setStyle("-fx-padding:10");
        this.setStyle("-fx-spacing:50");
        this.getChildren().add(etsiUserButton);
        this.getChildren().add(lainaaUserButton);
        this.getChildren().add(palautaUserButton);
        palautaUserButton.setDisable(true);
        
        etsiUserButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                
                for(TeosInfo temp:teokset){
                    BorrowReturnPartialRight.infoField.clear();
                    if(BorrowReturnPartialCenter.etsiUserName.getText().equals(temp.getTeoksenNimi()) || BorrowReturnPartialCenter.etsiUserISBN.getText().equals(temp.getISBN())){
                        BorrowReturnPartialRight.infoField.setText(temp.tulosta(temp));
                        
                        if(temp.isLainattu()){
                            palautaUserButton.setDisable(false);
                            lainaaUserButton.setDisable(true);
                        }else{
                            lainaaUserButton.setDisable(false);
                        }
                        
                        temp_etsiName=BorrowReturnPartialCenter.etsiUserName.getText();
                        temp_etsiISBN=BorrowReturnPartialCenter.etsiUserISBN.getText();
                        BorrowReturnPartialCenter.etsiUserName.clear();
                        BorrowReturnPartialCenter.etsiUserISBN.clear();
                        break;
                    }else{
                        JOptionPane.showMessageDialog(null, "Teosta ei löytynyt");

                    }
                }
            }    
        });
        palautaUserButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                for(TeosInfo temp:teokset){
                    BorrowReturnPartialRight.infoField.clear();
                    if(temp_etsiName.equals(temp.getTeoksenNimi()) || temp_etsiISBN.equals(temp.getISBN())){
                        temp.setLainattu(false);
                        temp.setLainaAlku(null);
                        temp.setLainaLoppu(null);
                        JOptionPane.showMessageDialog(null, "Teos palautettu");
                        BorrowReturnPartialRight.infoField.clear();
                    }
                }
            }    
        });      
        lainaaUserButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                for(TeosInfo temp:teokset){
                    BorrowReturnPartialRight.infoField.clear();
                    if(temp_etsiName.equals(temp.getTeoksenNimi()) || temp_etsiISBN.equals(temp.getISBN())){
                        temp.lainaaTeos();
                        JOptionPane.showMessageDialog(null, "Teos lainattu. Eräpäivä on " + temp.getLainaLoppu());
                        BorrowReturnPartialRight.infoField.clear();
                    }
                }

            }    
        });        
    }
    
}

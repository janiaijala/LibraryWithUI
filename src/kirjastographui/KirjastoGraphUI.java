/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kirjastographui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Jani-Meiju
 */
public class KirjastoGraphUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        //the root layout
        BorderPane root = new BorderPane();
        root.setCenter(new UserTabPanePartial());
  
        Scene scene = new Scene(root, 500, 550);
        
        primaryStage.setTitle("Janin kirjasto");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class sample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group root=new Group();
        Color [] colors=new Color[]{
            Color.AQUAMARINE, Color.CRIMSON, Color.DARKMAGENTA, 
            Color.LEMONCHIFFON
        };
        for(int i=0; i<100000; i++){
            Line line=new Line();
            line.setStartX(Math.random()*800);
            line.setStartY(Math.random()*600);
            line.setEndX(Math.random()*400);
            line.setEndY(Math.random()*300);
            line.setStroke(colors[(int)Math.floor(Math.random()*4)]);
            root.getChildren().add(line);
        }
        Scene scene = new Scene(root, 800, 600);
        
        primaryStage.setTitle("Hello World!");
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

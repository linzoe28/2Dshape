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
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class JavaFXApplication4 extends Application {
    Rectangle rect=null;
    double x=0;
    double y=0;
    @Override
    public void start(Stage primaryStage) {
        Group root=new Group();
        Scene scene = new Scene(root, 800, 600);
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(rect==null){
                    rect=new Rectangle();
                    rect.setX(event.getSceneX());
                    rect.setY(event.getSceneY());
                    x=event.getSceneX();
                    y=event.getSceneY();
                    root.getChildren().add(rect);
                }else{
                    if(event.getSceneX()<rect.getX()){
                        rect.setWidth(Math.abs(event.getSceneX()-x));
                        rect.setHeight(Math.abs(event.getSceneY()-y));
                        rect.setX(event.getSceneX());
                        rect.setY(event.getSceneY());
                    }else{
                        rect.setWidth(event.getSceneX()-rect.getX());
                        rect.setHeight(event.getSceneY()-rect.getY());
                    }
                }
            }
        });
        scene.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rect=null;
            }
        });
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

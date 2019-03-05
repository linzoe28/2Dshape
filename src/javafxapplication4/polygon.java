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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class polygon extends Application {

    Polygon poly = null;

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);
        scene.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                Circle dot=new Circle(event.getSceneX(), event.getSceneY(), 1);
                root.getChildren().add(dot);
                if(poly==null){
                      poly=new Polygon();
                      poly.getPoints().addAll(event.getSceneX(),event.getSceneY());
                      root.getChildren().add(poly);
                }else{
                      poly.getPoints().addAll(event.getSceneX(),event.getSceneY()); 
                      if(event.getClickCount()==2){   //兩次點擊結束，上一個圖形
                          poly=null;
                      }
                }
            }
        });
        /*poly = new Polygon();
        poly.getPoints().addAll(
                150d, 50d,
                500d, 30d,
                150d, 90d,
                700d, 40d);   //new Double[]{150,50,500,30,150,90,500,40}
        root.getChildren().add(poly);*/
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

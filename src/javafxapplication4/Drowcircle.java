/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Drowcircle extends Application {

    Circle circle = null;

    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (circle == null) {
                    circle = new Circle();
                    circle.setCenterX(event.getSceneX());
                    circle.setCenterY(event.getSceneY());
                    root.getChildren().add(circle);
                } else {
                    Point2D p1 = new Point2D(circle.getCenterX(), circle.getCenterY());
                    Point2D p2 = new Point2D(event.getSceneX(), event.getScreenY());
                    circle.setRadius(p1.distance(p2));
                }
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
        // TODO code application logic here
        launch(args);
    }

}

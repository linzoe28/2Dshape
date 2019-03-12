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
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class ImageViewtest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);
        Image image= new Image("https://vignette.wikia.nocookie.net/characters/images/9/99/MarioSMBW.png/revision/latest?cb=20131224152135");
        ImageView imageView=new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(400);
        imageView.setX(200);
        imageView.setY(20);
        //Glow glow=new Glow(0);
        //imageView.setEffect(glow);
        GaussianBlur blur=new GaussianBlur(0);
       imageView.setEffect(blur);
        
        scene.setOnScroll(new EventHandler<ScrollEvent>(){
            @Override
            public void handle(ScrollEvent event) {
              //double level=glow.getLevel()+event.getDeltaY()*0.001;
              double level=blur.getRadius()+event.getDeltaY()*0.01;
              if(level<0){
                  level=0;
              }
              //glow.setLevel(level);
              blur.setRadius(level);
            }
        });
        root.getChildren().add(imageView);
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

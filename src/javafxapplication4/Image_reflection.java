/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Image_reflection extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);
        Image image = new Image("https://vignette.wikia.nocookie.net/characters/images/9/99/MarioSMBW.png/revision/latest?cb=20131224152135");
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(250);
        imageView.setX(200);
        imageView.setY(20);

        /* Reflection reflection = new Reflection();
        reflection.setTopOpacity(1); //最上點的透明度
        reflection.setBottomOpacity(0.5); //圖片下半張的透明度
        reflection.setFraction(1);  //倒影比例
        imageView.setEffect(reflection);*/
 /*SepiaTone sepiaTone =new SepiaTone(0.75); //懷舊風
        imageView.setEffect(sepiaTone);*/
        Light.Spot spot = new Light.Spot();  //打光
        spot.setX(200);
        spot.setY(150);
        spot.setZ(610);
        spot.setColor(Color.ALICEBLUE);
        Lighting lighting = new Lighting(spot);
        imageView.setEffect(lighting);

        scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                spot.setX(event.getSceneX());
                spot.setY(event.getSceneY());
            }
        });
        scene.setOnScroll(new EventHandler<ScrollEvent>(){
            @Override
            public void handle(ScrollEvent event) {
               if(event.getDeltaX()<0){
                   spot.setZ(0);
               }
               spot.setZ(event.getDeltaX());
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

package javafxapplication4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class TextTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);

        Text text = new Text(50, 50, "Hello,");
        Font font = Font.font("Arial", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 35);
        text.setFont(font);
        text.setStroke(Color.CORNFLOWERBLUE);
        text.setStrokeWidth(3); //字體邊框寬度
        text.setFill(Color.DARKORANGE);
        text.setStrokeType(StrokeType.OUTSIDE);  //邊框填入的方向(往字體內或外)
        root.getChildren().addAll(text);
        
        String [] fontnames=new String[]{"Arial","Jokerman","Chiller","Colonna MT","Ink Free"};
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                int index=Integer.valueOf(event.getText());
                text.setFont(Font.font(fontnames[index], FontWeight.SEMI_BOLD, FontPosture.REGULAR, 35));
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

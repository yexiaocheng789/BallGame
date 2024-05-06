package game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.MouseEvent;

public class Game extends Application{

        public void start(Stage stage1) {
            Pane child = new Pane();
            BallPane ballPane = new BallPane();
            ballPane.pause();
            Rectangle rectangle = new Rectangle(375, 680, 150, 20);
            rectangle.setStyle("-fx-fill: #ff0000; -fx-stroke: #110b0b;");

            Button btn1 = new Button();
            btn1.setText("Start");
            btn1.setStyle("-fx-font: 20 arial; -fx-base: #110b0b;");
            btn1.setLayoutX(0);
            btn1.setLayoutY(670);
            btn1.setOnAction((ActionEvent event1)->{
                ballPane.play();
                if(ballPane.ballx()>=rectangle.getX() && ballPane.ballx()<=rectangle.getX()+150&&ballPane.bally()==660){

                    ballPane.balldy();
                }
                child.setOnMouseMoved(event -> {

                    rectangle.setX(event.getX() - (rectangle.getWidth()/2));

                    if(ballPane.ballx()>=rectangle.getX() && ballPane.ballx()<=rectangle.getX()+150&&ballPane.bally()==660){

                        ballPane.balldy();
                    }
                    if (event.getX() >= 825) {
                        rectangle.setX(750);
                    }
                    if (event.getX() <= 75) {
                        rectangle.setX(0);
                    }
                });

            });



            child.getChildren().addAll(rectangle,ballPane,btn1);


            Scene scene = new Scene(child,900, 700);
            stage1.setScene(scene);
            stage1.setTitle("new");
            stage1.show();
            ballPane.requestFocus();



        }

    }




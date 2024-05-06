package game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BallPane extends Pane {
    public final double radius = 20;
    private double x = 450,y = 660;
    private double dx = 1,dy = 1;
    private Circle circle = new Circle(x,y,radius);
    private Timeline animation;

    public BallPane(){
        circle.setFill(Color.GREEN);

        getChildren().add(circle);

        animation = new Timeline(
                new KeyFrame(Duration.millis(5),e->moveBall())
        );
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    public double ballx(){return circle.getCenterX();}
    public double bally(){return circle.getCenterY();}
    public void balldx(){dx *= -1;}
    public void balldy(){dy *= -1;}
    public void play(){
        animation.play();
    }

    public void pause(){
        animation.pause();
    }

    public void increaseSpeed(){
        animation.setRate(animation.getRate()+0.1);
    }

    public void decreaseSpeed(){
        animation.setRate(animation.getRate()-0.1);
    }

    public DoubleProperty rateProperty(){
        return animation.rateProperty();
    }

    protected void moveBall(){
            if(x<radius||x>900-radius){
                dx *= -1;
            }
            if(y<radius){
                dy *= -1;
            }
            x += dx;
            y += dy;
            circle.setCenterX(x);
            circle.setCenterY(y);
    }
}

package game;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;


public class ballgame extends Application {
    public void start(Stage primaryStage) {

        Pane root = new Pane();
        Image input = new Image("file:D:\\IDEA\\picture\\93483791_p0.jpg",900,700,false,false);

//    background-image 为元素设置背景图像。
        BackgroundImage backgroundimage = new BackgroundImage(input,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
// 	放进去
        Background background = new Background(backgroundimage);
        //把图片放布局里面
        root.setBackground(background);

        Label gametitle = new Label();
        gametitle.setText("弹球大作战");
        gametitle.setTextFill(Color.web("#FFFFFFFF"));
        gametitle.setFont(new Font("Arial", 70));
        gametitle.setLayoutX(300);
        gametitle.setLayoutY(200);


        Button btn1 = new Button();
        btn1.setText("进入游戏");
        btn1.setStyle("-fx-font: 30 arial; -fx-base: #ee1111;");
        btn1.setLayoutX(370);
        btn1.setLayoutY(400);
        btn1.setOnAction((ActionEvent event)->{
            Game game = new Game();
            game.start(new Stage());
            primaryStage.hide();
        });


        Button btn2 = new Button();
        btn2.setText("设置");
        btn2.setStyle("-fx-font: 30 arial; -fx-base: #1115ee; ");
        btn2.setLayoutX(370);
        btn2.setLayoutY(500);

        Button btn3=new Button();
        btn3.setText("历史战绩");
        btn3.setStyle("-fx-font: 30 arial; -fx-base: #50ee11; ");
        btn3.setLayoutX(370);
        btn3.setLayoutY(600);


        root.getChildren().addAll(btn1,btn2,btn3,gametitle);


        Scene scene = new Scene(root, 900, 700);
        primaryStage.setTitle("弹球小游戏");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

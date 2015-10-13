package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 880, 680, Color.BLACK);
        for (int i = 0; i < 2000; i++) {
            Button btn1 = new Button("press" + i);
            btn1.setRotate(random(360));
            btn1.setEffect(new Reflection());
            btn1.setLayoutX(random(800));
            btn1.setLayoutY(random(600));
            root.getChildren().add(btn1);
        }
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private int random(int rnd) {
        Random r = new Random();
        return r.nextInt(rnd + 1);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

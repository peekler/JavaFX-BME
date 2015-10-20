package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();

        final Rectangle rectBasicTimeline = new Rectangle(0, 50, 50, 50);
        rectBasicTimeline.setFill(Color.BLUE);
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);

        final KeyValue kv1 = new KeyValue(rectBasicTimeline.xProperty(), 200);
        final KeyFrame kf1 = new KeyFrame(Duration.valueOf("500ms"), kv1);
        timeline.getKeyFrames().add(kf1);
        final KeyValue kv2 = new KeyValue(rectBasicTimeline.yProperty(), 300);
        final KeyFrame kf2 = new KeyFrame(Duration.valueOf("1000ms"), kv2);
        timeline.getKeyFrames().add(kf2);
        final KeyValue kv3 = new KeyValue(rectBasicTimeline.fillProperty(), Color.GREEN);
        final KeyFrame kf3 = new KeyFrame(Duration.valueOf("1500ms"), kv3);
        timeline.getKeyFrames().add(kf3);

        timeline.play();
        root.getChildren().add(rectBasicTimeline);



        primaryStage.setTitle("TimeLine Demo");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

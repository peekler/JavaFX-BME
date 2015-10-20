package sample;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Transform&Transition");
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.LIGHTGREEN);

        //simpleTransform(root);

        //fadeTransition(root);

        pathTransitoin(root);


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void pathTransitoin(Group root) {
        final Rectangle rectPath = new Rectangle (50, 50, 40, 40);
        rectPath.setArcHeight(10);
        rectPath.setArcWidth(10);
        rectPath.setFill(Color.ORANGE);
        Path path = new Path();
        path.getElements().add(new MoveTo(50,50));
        path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
        path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.valueOf("4s"));
        pathTransition.setPath(path);
        pathTransition.setNode(rectPath);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.play();
        root.getChildren().add(rectPath);
    }

    private void fadeTransition(Group root) {
        final Rectangle rect1 = new Rectangle(
                10, 10, 100, 100);
        rect1.setFill(Color.RED);

        FadeTransition ft =
                new FadeTransition(Duration.valueOf("2s"), rect1);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        root.getChildren().add(rect1);
    }

    private void simpleTransform(Group root) {
        Rectangle rect = new Rectangle(100, 100, Color.GREEN);
        rect.setLayoutX(100);
        rect.setLayoutY(100);
        rect.getTransforms().add(Transform.rotate(45, 50, 50));
        // VS.
        //rect.getTransforms().add(Transform.rotate(45, 0, 0));
        root.getChildren().add(rect);
    }


    public static void main(String[] args) {
        launch(args);
    }
}

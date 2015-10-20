package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        VBox root = new VBox();

        Media mMovie = new Media(
                "http://www.mediacollege.com/video-gallery/testclips/20051210-w50s.flv");
        final MediaPlayer playerMovie = new MediaPlayer(mMovie);
        MediaView mvMovie = new MediaView(playerMovie);
        mvMovie.setLayoutX(5);
        mvMovie.setLayoutY(30);
        mvMovie.setRotate(30);
        Media mMp3 = new Media("file:///D:/music.mp3");
        final MediaPlayer playerMp3 = new MediaPlayer(mMp3);
        Button btn = new Button();
        btn.setLayoutX(5);
        btn.setLayoutY(5);
        btn.setText("Play");
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        //playerMovie.setVolume(0.0);
                        playerMovie.play();
                        playerMp3.play();
                    }
                });
        root.getChildren().add(btn);
        root.getChildren().add(mvMovie);



        primaryStage.setTitle("Hello JavaFX Media");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

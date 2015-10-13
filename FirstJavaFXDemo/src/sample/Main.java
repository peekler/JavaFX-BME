package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        //initBaseUI(primaryStage);

        initPopUpUI(primaryStage);
    }

    private void initPopUpUI(final Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Show PopUp");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Popup popup = new Popup();
                HBox box = new HBox();
                box.getChildren().add(new Label("Hello JavaFX csoport!"));
                box.setPrefSize(150, 30);
                box.setStyle("-fx-background-color: #00ff00;");

                popup.getContent().add(box);
                popup.setX(200);
                popup.setY(300);
                popup.show(primaryStage);
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello PopUp!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initBaseUI(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root,80,20);
        primaryStage.setScene(scene);

        root.getChildren().add(new Label(
                "Hello JavaFX 2.2"));
        // teljes képernyõ támogatása
        //primaryStage.setFullScreen(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

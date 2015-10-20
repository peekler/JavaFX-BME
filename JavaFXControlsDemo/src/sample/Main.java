package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox scrollBox = new VBox();
        Image ship = new Image(getClass().getResourceAsStream("cat.jpg"));
        scrollBox.getChildren().add(new ImageView(ship));
        scrollBox.getChildren().add(new Label("Enterprise"));
        ScrollPane sp = new ScrollPane();
        sp.setPrefWidth(400);
        sp.setPrefHeight(300);
        //sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        Hyperlink link = new Hyperlink();
        link.setText("http://www.aut.bme.hu");
        link.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        System.out.println(
                                "Link kiválasztva");
                        getHostServices().showDocument("http://www.aut.bme.hu");
                    }
                });
        scrollBox.getChildren().add(link);

        final PasswordField pwField = new PasswordField();
        final Tooltip tooltip = new Tooltip();
        tooltip.setText(
                "A jelszó legalább 8 karakter és\n" +
                        "betût és számot is tartalma\n");
        Image infoImage = new Image(
                getClass().getResourceAsStream("info.png"));
        tooltip.setGraphic(new ImageView(infoImage));
        pwField.setTooltip(tooltip);
        scrollBox.getChildren().add(pwField);




        sp.setContent(scrollBox);


        Group root = new Group();

        root.getChildren().add(sp);


        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

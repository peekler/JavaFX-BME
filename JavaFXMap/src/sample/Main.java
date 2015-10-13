package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root,300,420, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);

        VBox vBox = new VBox(10);
        final TextField textFieldLat = new TextField("47.5");
        final TextField textFieldLng = new TextField("19");
        final ImageView imgView = new ImageView();
        Button buttonShowMap = new Button("Show map");

        buttonShowMap.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                new Thread() {
                    public void run() {
                        loadHttpFile(
                                "http://staticmap.openstreetmap.de/staticmap.php?center=" +
                                        textFieldLat.getText() + "," +
                                        textFieldLng.getText() +
                                        "&zoom=10&size=865x512&maptype=mapnik",
                                imgView);
                    }
                }.start();
            }
        });

        buttonShowMap.setEffect(new Reflection());
        buttonShowMap.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9");
        buttonShowMap.setRotate(118);


        vBox.getChildren().add(textFieldLat);
        vBox.getChildren().add(textFieldLng);
        vBox.getChildren().add(buttonShowMap);
        vBox.getChildren().add(imgView);
        root.getChildren().add(vBox);

        primaryStage.show();
    }

    private void loadHttpFile(String urlAddress, final ImageView imgView) {
        HttpURLConnection hc = null;
        InputStream is = null;
        try {
            URL url = new URL(urlAddress);
            hc = (HttpURLConnection)url.openConnection();
            is = hc.getInputStream();

            Image im = new Image(is);

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    imgView.setImage(im);
                }
            });

            //imgView.setImage(new Image(is));
        } catch(Exception e1) {
            e1.printStackTrace();
        }
        finally {
            try {
                if(is != null) {
                    is.close();
                }
                if(hc != null) {
                    hc.disconnect();
                }
            } catch(Exception e2) {
                e2.printStackTrace();
            }
        }
    }




    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

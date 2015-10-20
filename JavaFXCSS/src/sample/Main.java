package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World");
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);
        //scene.getStylesheets().add(this.getClass().getResource(
        //        "/resources/cssfiles/test.css").toExternalForm());
        VBox vBox = new VBox(5);
        Label lbl = new Label("Hello JavaFX Csoport!");
        vBox.getChildren().add(lbl);
        Button btn = new Button();
        btn.setLayoutX(100);
        btn.setLayoutY(80);
        btn.setText("Hello JavaFX CSS Button!");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scene.getStylesheets().add(this.getClass().getResource(
                        "/resources/cssfiles/test2.css").toExternalForm());
            }
        });

        vBox.getChildren().add(btn);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Symbian", 2),
                        new PieChart.Data("JavaME", 8),
                        new PieChart.Data("Android", 60),
                        new PieChart.Data("iOS", 20),
                        new PieChart.Data("WindowsPhone", 10));
        final PieChart chart = new PieChart(
                pieChartData);
        chart.setTitle("Platforms");
        vBox.getChildren().add(chart);

        root.getChildren().add(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Reflection;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Label lblData;
    @FXML
    private Button btnPress;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         btnPress.setEffect(new Reflection());
    }


    @FXML
    public void btnPressed(ActionEvent actionEvent) {
        lblData.setText(new Date(System.currentTimeMillis()).toString());
    }


}

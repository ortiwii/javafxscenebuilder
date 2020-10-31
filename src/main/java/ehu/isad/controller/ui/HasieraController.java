package ehu.isad.controller.ui;

import java.net.URL;
import java.util.ResourceBundle;

import ehu.isad.Main;
import ehu.isad.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class HasieraController {
    private Main main;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView irudia;

    @FXML
    void onClick(ActionEvent event) {
        System.out.println("BOZKATU");
    }

    @FXML
    void initialize() {
        irudia.setImage(Utils.getUtils().irekiIrudia("logo.png"));
    }
    public void setMainApp(Main nMain){
        this.main = nMain;
    }
}

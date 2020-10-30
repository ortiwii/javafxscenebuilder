package ehu.isad.controller.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class HasieraController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView irudia;

    @FXML
    void onClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        irudia.setImage(null);
    }
}

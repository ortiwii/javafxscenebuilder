package ehu.isad.controller.ui;

import ehu.isad.Herrialdea;
import ehu.isad.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class JadaBozkatuController {

    private Main main;
    @FXML
    private ImageView irudia;

    @FXML
    private Label text;

    @FXML
    void onClick(ActionEvent event) {
        main.herrialdeaAukeratuMenua();
    }
    public void prestatu(Herrialdea herrialdea){
        this.text.setText(herrialdea.getIzena()+"k jada banatu ditu bere puntuak");
        this.irudia.setImage(new Image(getClass().getResourceAsStream("/irudiak/"+herrialdea.getIrudia()+".png")));
    }
    public void setMainApp(Main main){
        this.main = main;
    }
}
package ehu.isad.controller.ui;

import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import ehu.isad.Herrialdea;
import ehu.isad.controller.db.EurobisioaDBKud;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class BozkatuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Herrialdea> cbox;

    @FXML
    void initialize() {
//        int year = Calendar.getInstance().get(Calendar.YEAR);
        List<Herrialdea> lista = EurobisioaDBKud.getInstantzia().herrialdeakLortu();


    }
}
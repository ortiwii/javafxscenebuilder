package ehu.isad.controller.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ehu.isad.Herrialdea;
import ehu.isad.Main;
import ehu.isad.controller.db.EurobisioaDBKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class BozkatuController {

    private Main main;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Herrialdea> cbox;

    @FXML
    void onClick(ActionEvent event) {
        System.out.println(cbox.getSelectionModel().toString());
    }
    @FXML
    void initialize() {
//        int year = Calendar.getInstance().get(Calendar.YEAR);
        List<Herrialdea> lista = EurobisioaDBKud.getInstantzia().herrialdeakLortu();
        ObservableList<Herrialdea> herrialdeak = FXCollections.observableArrayList(lista);
        cbox.setItems(herrialdeak);

    }
    public void setMainApp(Main nMain){
        this.main = nMain;
    }
}
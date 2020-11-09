package ehu.isad.controller.ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import ehu.isad.Herrialdea;
import ehu.isad.Main;
import ehu.isad.OrdezkaritzaModel;
import ehu.isad.controller.db.EurobisioaDBKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

public class BozkaketaPanelaController {

    private Main main;
    private Herrialdea norkBozkatu;
    private int puntuEskuragarriak = 5;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView herrialdeIrudia;

    @FXML
    private TableView<OrdezkaritzaModel> tbData;

    @FXML
    private Label label;

    @FXML
    private TableColumn<OrdezkaritzaModel, Image> irudia;

    @FXML
    private TableColumn<OrdezkaritzaModel, String> herrialdeIzena;

    @FXML
    private TableColumn<OrdezkaritzaModel, String> artistaIzena;

    @FXML
    private TableColumn<OrdezkaritzaModel, String> abestiaIzena;

    @FXML
    private TableColumn<OrdezkaritzaModel, Integer> puntuKopurua;

    Callback<TableColumn<OrdezkaritzaModel, Integer>, TableCell<OrdezkaritzaModel, Integer>> defaultTextFieldCellFactory
            = TextFieldTableCell.forTableColumn(new IntegerStringConverter());

    private final ObservableList<OrdezkaritzaModel> ordezkaritzaModels = FXCollections.observableArrayList(
            EurobisioaDBKud.getInstantzia().getOrdezkaritzak()
    );


    @FXML
    void initialize() {

        tbData.setEditable(true);

        herrialdeIzena.setCellValueFactory(new PropertyValueFactory<>("Herrialdea"));
        artistaIzena.setCellValueFactory(new PropertyValueFactory<>("Artista"));
        abestiaIzena.setCellValueFactory(new PropertyValueFactory<>("Abestia"));
        puntuKopurua.setCellValueFactory(new PropertyValueFactory<>("PuntuKop"));

        puntuKopurua.setCellFactory(col -> {
            TableCell<OrdezkaritzaModel, Integer> cell = defaultTextFieldCellFactory.call(col);
            cell.setOnMouseClicked(event -> {
                if (! cell.isEmpty()) {
                    if (this.norkBozkatu.getIzena().equals(cell.getTableView().getSelectionModel().getSelectedItem().getHerrialdea())){
                        cell.setEditable(false);
                    }else {
                        cell.setEditable(true);
                    }
                }
            });
            return cell ;});

        puntuKopurua.setOnEditCommit((TableColumn.CellEditEvent<OrdezkaritzaModel, Integer> event) ->{
            TablePosition<OrdezkaritzaModel, Integer> pos = event.getTablePosition();
            int row = pos.getRow();
            OrdezkaritzaModel act = event.getTableView().getItems().get(row);
            String herrialdea = act.getHerrialdea();

            this.bozkatuHerrialdea(act, herrialdea, event.getNewValue(), event.getOldValue());
        });

        irudia.setCellValueFactory(new PropertyValueFactory<OrdezkaritzaModel, Image>("Bandera"));

        irudia.setCellFactory(p -> new TableCell<>() {
            public void updateItem(Image image, boolean empty) {
                if (image != null && !empty){
                    final ImageView imageview = new ImageView();
                    imageview.setFitHeight(50);
                    imageview.setFitWidth(50);
                    imageview.setImage(image);
                    setGraphic(imageview);
                    setAlignment(Pos.CENTER);
                    // tbData.refresh();
                }else{
                    setGraphic(null);
                    setText(null);
                }
            };
        });

        tbData.setItems(ordezkaritzaModels);

    }
    @FXML
    void onClick(ActionEvent event) {
        //Bozkaketa datu basean gorde
        for (int i = 0; i < ordezkaritzaModels.size(); i ++){
            OrdezkaritzaModel act = ordezkaritzaModels.get(i);
            if (act.getPuntuKop() > 0){
                EurobisioaDBKud.getInstantzia().bozkatuHerrialdea(this.norkBozkatu.getIzena(), act, main.getUrtea());
            }
        }
        main.rankingErakutsi();
    }
    private void bozkatuHerrialdea (OrdezkaritzaModel ordezkaritzaModel, String herrialdea, Integer puntuKopBerria, Integer oldValue) {

            if (puntuEskuragarriak- (puntuKopBerria-oldValue) >= 0){ //bozkatu ahal du
                ordezkaritzaModel.setPuntuKop(puntuKopBerria);
                this.puntuEskuragarriak = this.puntuEskuragarriak - (puntuKopBerria-oldValue);
            }else{ //ezin du bozkatu, errore mezua
                ordezkaritzaModel.setPuntuKop(oldValue);

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("KONTUZ !!");
                alert.setHeaderText("Ezin ditzakezu puntu gehiago eman");
                alert.setContentText("Herrialde bakoitzak soilik 5 puntu banatu ditzake. \nZuk "+this.puntuEskuragarriak+" puntu dituzu soilik eskuragarri.");
                alert.showAndWait();
            }
            tbData.refresh();

    }
    public void konfiguratu(Herrialdea herrialdea){

        this.norkBozkatu = herrialdea;
        String text = herrialdea.getIzena()+"k horrela nahi ditu bere puntuak banatu:";
        this.label.setText(text);
        Image image = new Image(getClass().getResourceAsStream("/irudiak/"+herrialdea.getIrudia()+".png"));
        this.herrialdeIrudia.setImage(image);
        this.puntuakHasieratu();
        tbData.refresh();
    }
    private void puntuakHasieratu (){
        this.puntuEskuragarriak = 5;
        for (int i = 0; i < ordezkaritzaModels.size(); i++){
            OrdezkaritzaModel act = ordezkaritzaModels.get(i);
                act.setPuntuKop(0);
        }

    }
    public void setMainApp (Main nMain){
        this.main = nMain;
    }
}
package ehu.isad;

import ehu.isad.controller.ui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  private int urtea;

  private Parent hasieraUI;
  private Parent bozkatuUI;
  private Parent bozkaketaPanelaUI;
  private Parent errorePanelaUI;
  private Parent rankingUI;

  private Stage stage;

  private Scene hasieraScene;
  private Scene bozkatuScene;
  private Scene bozkaketaPanelaScene;
  private Scene erroreaScene;
  private Scene rankingScene;

  private HasieraController hasieraKud;
  private BozkatuController bozkatuKud;
  private BozkaketaPanelaController bozkaketaPanelaKud;
  private JadaBozkatuController erroreaKud;
  private RankingController rankingKud;

  @Override
  public void start(Stage primaryStage) throws Exception {

    urtea = 2019;
    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("EUROVISION");
    stage.setScene(hasieraScene);
    stage.show();
  }

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderHasiera = new FXMLLoader(getClass().getResource("/hasiera.fxml"));
    hasieraUI = (Parent) loaderHasiera.load();
    hasieraKud = loaderHasiera.getController();
    hasieraKud.setMainApp(this);
    hasieraScene = new Scene(hasieraUI);


    FXMLLoader loaderBozkatu = new FXMLLoader(getClass().getResource("/bozkatu.fxml"));
    bozkatuUI = (Parent) loaderBozkatu.load();
    bozkatuKud = loaderBozkatu.getController();
    bozkatuKud.setMainApp(this);
    bozkatuScene = new Scene(bozkatuUI);

    FXMLLoader loaderBozkatuPanela = new FXMLLoader(getClass().getResource("/bozkaketaPanela.fxml"));
    bozkaketaPanelaUI = (Parent) loaderBozkatuPanela.load();
    bozkaketaPanelaKud = loaderBozkatuPanela.getController();
    bozkaketaPanelaKud.setMainApp(this);
    bozkaketaPanelaScene = new Scene(bozkaketaPanelaUI);

    FXMLLoader loaderErroreaPanela = new FXMLLoader(getClass().getResource("/jadaBozkatuErrorea.fxml"));
    errorePanelaUI = (Parent) loaderErroreaPanela.load();
    erroreaKud = loaderErroreaPanela.getController();
    erroreaKud.setMainApp(this);
    erroreaScene = new Scene(errorePanelaUI);

    FXMLLoader loaderRanking = new FXMLLoader(getClass().getResource("/ranking.fxml"));
    rankingUI = (Parent) loaderRanking.load();
    rankingKud = loaderRanking.getController();
    rankingKud.setMainApp(this);
    rankingScene = new Scene(rankingUI);
  }

  public void herrialdeaAukeratuMenua(){
    stage.setScene(bozkatuScene);
    stage.setTitle("Informazioaren Eguneraketa");
    stage.show();
  }
  public void erroreaErakutsi (Herrialdea herrialdea){
    stage.setScene(erroreaScene);
    stage.setTitle(herrialdea.getIzena()+"ren inguruko informazioa");
    erroreaKud.prestatu(herrialdea);
    stage.show();
  }
  public void bozkatu(Herrialdea herrialdea){
    stage.setScene(bozkaketaPanelaScene);
    stage.setTitle("Bozkaketa Panela");
    bozkaketaPanelaKud.konfiguratu(herrialdea);
    stage.show();
  }
  public void rankingErakutsi(){
    stage.setScene(rankingScene);
    stage.setTitle("Datuak Sartu");
    rankingKud.hasieratu();
    stage.show();
  }
  public int getUrtea (){
    return this.urtea;
  }
  public static void main(String[] args) {
    launch(args);
  }
}

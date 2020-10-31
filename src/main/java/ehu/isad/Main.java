package ehu.isad;

import ehu.isad.controller.ui.BozkatuController;
import ehu.isad.controller.ui.HasieraController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  private Parent hasieraUI;
  private Parent bozkatuUI;

  private Stage stage;

  private Scene hasieraScene;
  private Scene bozkatuScene;

  private HasieraController hasieraKud;
  private BozkatuController bozkatuKud;

  @Override
  public void start(Stage primaryStage) throws Exception {

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
//
//    FXMLLoader loaderMain = new FXMLLoader(getClass().getResource("/EzarpenakUI.fxml"));
//    ezarpenakUI = (Parent) loaderMain.load();
//    ezarpenakKud = loaderMain.getController();
//    ezarpenakKud.setMainApp(this);
  }

  public void herrialdeaAukeratuMenua(){
    stage.setScene(bozkatuScene);
    stage.setTitle("Informazioaren Eguneraketa");
    stage.show();
  }
  public static void main(String[] args) {
    launch(args);
  }
}

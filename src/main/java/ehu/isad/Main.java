package ehu.isad;

import ehu.isad.controller.ui.HasieraController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  private Parent hasieraUI;

  private Stage stage;

  private HasieraController hasieraKud;


  @Override
  public void start(Stage primaryStage) throws Exception {

    stage = primaryStage;
    pantailakKargatu();

    stage.setTitle("EUROVISION");
    stage.setScene(new Scene(hasieraUI));
    stage.show();
  }

  private void pantailakKargatu() throws IOException {

    FXMLLoader loaderHasiera = new FXMLLoader(getClass().getResource("/hasiera.fxml"));
    hasieraUI = (Parent) loaderHasiera.load();
    hasieraKud = loaderHasiera.getController();
    hasieraKud.setMainApp(this);

//    FXMLLoader loaderKautotu = new FXMLLoader(getClass().getResource("/NagusiaUI.fxml"));
//    nagusiaUI = (Parent) loaderKautotu.load();
//    nagusiaKud = loaderKautotu.getController();
//    nagusiaKud.setMainApp(this);
//
//    FXMLLoader loaderMain = new FXMLLoader(getClass().getResource("/EzarpenakUI.fxml"));
//    ezarpenakUI = (Parent) loaderMain.load();
//    ezarpenakKud = loaderMain.getController();
//    ezarpenakKud.setMainApp(this);
  }

  public void bozkatzeraAldatu(){

  }
  public static void main(String[] args) {
    launch(args);
  }
}

package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.OrdezkaritzaModel;
import ehu.isad.controller.db.EurobisioaDBKud;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.*;

public class RankingController {

    private Main main;

    @FXML
    private Label top1;

    @FXML
    private Label top2;

    @FXML
    private Label top3;

    @FXML
    private ImageView top1Irudia;

    @FXML
    private ImageView top2Irudia;

    @FXML
    private ImageView top3Irudia;


    @FXML
    void onClick(ActionEvent event) {
        main.herrialdeaAukeratuMenua();
    }

    public void hasieratu(){
        HashMap<String, OrdezkaritzaModel> top = EurobisioaDBKud.getInstantzia().getRanking(main.getUrtea());
        List<OrdezkaritzaModel> ord = this.getTop3(top);
        OrdezkaritzaModel lehena = ord.get(ord.size()-1);
        OrdezkaritzaModel bigarrena = ord.get(ord.size()-2);
        OrdezkaritzaModel hirugarrena = ord.get(ord.size()-3);

        top1.setText(lehena.getHerrialdea()+" - "+lehena.getPuntuKop()+" puntu");
        top2.setText(bigarrena.getHerrialdea()+" - "+bigarrena.getPuntuKop()+" puntu");
        top3.setText(hirugarrena.getHerrialdea()+" - "+hirugarrena.getPuntuKop()+" puntu");

        top1Irudia.setImage(lehena.getBandera());
        top2Irudia.setImage(bigarrena.getBandera());
        top3Irudia.setImage(hirugarrena.getBandera());
    }
    private List<OrdezkaritzaModel> getTop3 (HashMap<String, OrdezkaritzaModel> lista){
        List<OrdezkaritzaModel> emaitza = new ArrayList<>(lista.values());
        Collections.sort(emaitza, new Comparator<OrdezkaritzaModel>(){
            @Override
            public int compare(OrdezkaritzaModel o1, OrdezkaritzaModel o2) {
                return (o1.getPuntuKop() - o2.getPuntuKop());
            }
        });
        return emaitza;
    }
    public void setMainApp (Main main){
        this.main = main;
    }

}

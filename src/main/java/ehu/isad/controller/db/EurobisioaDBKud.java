package ehu.isad.controller.db;

import ehu.isad.Herrialdea;
import ehu.isad.OrdezkaritzaModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EurobisioaDBKud {

  // singleton patroia

  private static EurobisioaDBKud instantzia = new EurobisioaDBKud();

  public static EurobisioaDBKud getInstantzia(){
      return instantzia;
  };

  private EurobisioaDBKud(){}

  public List<Herrialdea> herrialdeakLortu(){
      List<Herrialdea> emaitza = new ArrayList<>();
      String query = "SELECT izena, bandera FROM Herrialde;";
      ResultSet rs = DBKudeatzaile.getInstantzia().execSQL(query);
      try{
          while(rs.next()){
              Herrialdea act = new Herrialdea(rs.getString("izena"), rs.getString("bandera"));
              emaitza.add(act);
          }
      }catch (SQLException throwables) {
          throwables.printStackTrace();
      }
      return emaitza;
  }
  public List<OrdezkaritzaModel> getOrdezkaritzak (){
      List<OrdezkaritzaModel> emaitza = new ArrayList<>();
      String query = "SELECT O.herrialdea, O.artista, O.abestia, H.bandera FROM ORDEZKARITZA O, HERRIALDE H WHERE O.herrialdea = H.izena;";
      ResultSet rs = DBKudeatzaile.getInstantzia().execSQL(query);
      try{
          while (rs.next()){
            String herria = rs.getString("herrialdea");
            String artista = rs.getString("artista");
            String abestia = rs.getString("abestia");
            String bandera = rs.getString("bandera");
            Integer puntuKop = 0;
            OrdezkaritzaModel act = new OrdezkaritzaModel(herria, artista, abestia, bandera, puntuKop);
            emaitza.add(act);
          }
      }catch (SQLException e){
          e.printStackTrace();
      }

      return emaitza;
  }
  public void bozkatuHerrialdea (String norkBozkatu, OrdezkaritzaModel noriBozkatu, int urtea){
    String query = "INSERT INTO Bozkaketa VALUES ('"+noriBozkatu.getHerrialdea()+"', '"+norkBozkatu+"', "+urtea+", "+noriBozkatu.getPuntuKop()+");";
    DBKudeatzaile.getInstantzia().execSQL(query);
  }
  public boolean bozkatuDu (String nork, int noiz){
      String query = "SELECT * FROM BOZKAKETA WHERE bozkatuDu = '"+nork+"' and urtea = "+noiz+";";
      ResultSet rs = DBKudeatzaile.getInstantzia().execSQL(query);
      boolean emaitza = false;
      try {
          emaitza = rs.next();
      } catch (SQLException throwables) {
          throwables.printStackTrace();
      }
      return emaitza;
  }

  public HashMap<String, OrdezkaritzaModel> getRanking (int urtea){
      HashMap<String, OrdezkaritzaModel> emaitza = new HashMap<String, OrdezkaritzaModel>();
      String query = "SELECT bozkatuaIzanDa, puntuak, bandera FROM BOZKAKETA, HERRIALDE WHERE urtea = "+urtea+" AND bozkatuaIzanDa = izena;";
      ResultSet rs = DBKudeatzaile.getInstantzia().execSQL(query);
      try{
          while(rs.next()){
              String nori = rs.getString("bozkatuaIzanDa");
              int puntuak = rs.getInt("puntuak");
              if (emaitza.containsKey(nori)){
                  OrdezkaritzaModel act = emaitza.get(nori);
                  act.setPuntuKop(act.getPuntuKop()+puntuak);
              }else{
                  String bandera = rs.getString("bandera");
                  emaitza.put(nori, new OrdezkaritzaModel(nori, puntuak, bandera));
              }
          }
      }catch (SQLException throwables) {
          throwables.printStackTrace();
      }
      return emaitza;
  }
}

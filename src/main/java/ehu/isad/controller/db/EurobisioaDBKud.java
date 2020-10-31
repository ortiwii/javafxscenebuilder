package ehu.isad.controller.db;

import ehu.isad.Herrialdea;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
      String query = "SELECT izena, bandera FROM Herrialdea;";
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

}

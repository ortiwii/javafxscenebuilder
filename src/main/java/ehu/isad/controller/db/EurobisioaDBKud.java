package ehu.isad.controller.db;

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


}

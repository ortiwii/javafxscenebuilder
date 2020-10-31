package ehu.isad.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

    private static Utils instantzia= new Utils();
    private Utils (){ }

    public static Utils getUtils(){return instantzia;}

//    public Image irekiIrudia (String path){
//        Properties properties=this.lortuEzarpenak();
//        String pathToImages = properties.getProperty("pathToImages");
//        String filepath = pathToImages+"/"+path;
//        File irudia = new File(filepath);
//        BufferedImage img = null;
//        try {
//            img = ImageIO.read(irudia);
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//        return SwingFXUtils.toFXImage(img, null);
//    }
//    public Image irekiIrudia(String path) {
////        Image imagenInterna = new ImageIcon(getClass().getResource("/irudiak/"+path)).getImage();
////        return imagenInterna;
//        File file = new File(getClass().getResource("/irudiak/" + path).getFile());
//        Image image = new Image(file.toURI().toString());
//    }

    public Properties lortuEzarpenak()  {
        Properties properties = null;

        try (InputStream in = Utils.class.getResourceAsStream("/setup.properties")) {
            properties = new Properties();
            properties.load(in);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}

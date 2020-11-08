package ehu.isad;

import javafx.scene.image.Image;

public class OrdezkaritzaModel {
    private String herrialdea;
    private String artista;
    private String abestia;
    private Image bandera;
    private Integer puntuKop;

    public void setHerrialdea(String herrialdea) {
        this.herrialdea = herrialdea;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setAbestia(String abestia) {
        this.abestia = abestia;
    }

    public void setBandera(Image bandera) {
        this.bandera = bandera;
    }

    public String getHerrialdea() {
        return herrialdea;
    }

    public String getArtista() {
        return artista;
    }

    public String getAbestia() {
        return abestia;
    }

    public Image getBandera() {
        return bandera;
    }

    public void setPuntuKop(Integer puntuKop) {
        this.puntuKop = puntuKop;
    }

    public int getPuntuKop() {
        return puntuKop;
    }

    public OrdezkaritzaModel(String herrialdea, String artista, String abestia, String bandera, Integer puntuKop) {
        this.herrialdea = herrialdea;
        this.artista = artista;
        this.abestia = abestia;
        this.bandera = new Image(getClass().getResourceAsStream("/irudiak/"+bandera+".png"));
        this.puntuKop = puntuKop;
    }
    public OrdezkaritzaModel (String herrialdea, int puntuKop, String bandera){
        this.herrialdea = herrialdea;
        this.puntuKop = puntuKop;
        this.bandera = new Image(getClass().getResourceAsStream("/irudiak/"+bandera+".png"));
    }
}

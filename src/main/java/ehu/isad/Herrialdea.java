package ehu.isad;


public class Herrialdea {
    private String izena;
    private String irudia;

    public Herrialdea(String izena, String irudia) {
        this.izena = izena;
        this.irudia = irudia;
    }

    @Override
    public String toString() {
        return izena;
    }

    public String getIzena() {
        return izena;
    }

    public String getIrudia() {
        return irudia;
    }
}

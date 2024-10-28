public class Larga extends Arma implements Comparable {
    private String justifUso;
    private int nivelArma;
    private boolean tieneSello;

    public Larga(String marca, int cantMuniciones, double alcance, int calibre, String estado, String justifUso, int nivelArma, boolean tieneSello, int legajoAsociado) {
        super(marca, cantMuniciones, alcance, calibre, estado, legajoAsociado);
        this.justifUso = justifUso;
        this.nivelArma = nivelArma;
        this.tieneSello = tieneSello;
    }

    public String getJustifUso() {
        return justifUso;
    }

    public void setJustifUso(String justifUso) {
        this.justifUso = justifUso;
    }

    public int getNivelArma() {
        return nivelArma;
    }

    public void setNivelArma(int nivelArma) {
        this.nivelArma = nivelArma;
    }

    public boolean isTieneSello() {
        return tieneSello;
    }

    public void setTieneSello(boolean tieneSello) {
        this.tieneSello = tieneSello;
    }

    @Override
    public int CompareTo() {
        return 0;
    }
}
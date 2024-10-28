public class Corta extends Arma {
    private boolean esAutomatica;

    public Corta( String marca, int cantMuniciones, double alcance, int calibre, String estado, boolean esAutomatica, int legajoAsociado) {
        super(marca, cantMuniciones, alcance, calibre, estado, legajoAsociado);
        this.esAutomatica = esAutomatica;
    }

    public boolean efectividadMts() {
        return false;
    }

    public boolean isEsAutomatica() {
        return esAutomatica;
    }

    public void setEsAutomatica(boolean esAutomatica) {
        this.esAutomatica = esAutomatica;
    }

}

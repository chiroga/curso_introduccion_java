abstract class Arma {
    private int cantMuniciones;
    private double alcance;
    private String marca;
    private int calibre;
    private String estado;
    private int legajoAsociado;

    public boolean enCondicion(){
        return false;
    }

    public Arma(String marca, int cantMuniciones, double alcance, int calibre, String estado, int legajoAsociado) {
        this.cantMuniciones = cantMuniciones;
        this.alcance = alcance;
        this.marca = marca;
        this.calibre = calibre;
        this.estado = estado;
        this.legajoAsociado = legajoAsociado;
    }

    public int getCantMuniciones() {
        return cantMuniciones;
    }

    public void setCantMuniciones(int cantMuniciones) {
        this.cantMuniciones = cantMuniciones;
    }

    public double getAlcance() {
        return alcance;
    }

    public void setAlcance(double alcance) {
        this.alcance = alcance;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCalibre() {
        return calibre;
    }

    public void setCalibre(int calibre) {
        this.calibre = calibre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getLegajoAsociado() {
        return legajoAsociado;
    }

    public void setLegajoAsociado(int legajoAsociado) {
        this.legajoAsociado = legajoAsociado;
    }
}

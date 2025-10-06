package co.edu.uniquindio.poo.envioproyecto.model;

public class Envios implements Cloneable {

    private String idEnvio;
    private String destino;
    private int peso;
    private String tamano;
    private String fecha;
    private EstadoEnvio estadoEnvio;

    public Envios(String idEnvio, String destino, int peso, String tamano, String fecha, EstadoEnvio estadoEnvio) {
        this.idEnvio = idEnvio;
        this.destino = destino;
        this.peso = peso;
        this.tamano = tamano;
        this.fecha = fecha;
        this.estadoEnvio = estadoEnvio;

    }

    public Envios clone() throws CloneNotSupportedException {
        return (Envios) super.clone();
    }

    public String getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(String idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public EstadoEnvio getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(EstadoEnvio estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }
}

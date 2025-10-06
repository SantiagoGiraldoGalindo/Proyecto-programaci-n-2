package co.edu.uniquindio.poo.envioproyecto.model;

public class SMS {

    private String fecha;
    private String hora;
    private Paquete paquete;
    private Envios envios;

    public SMS(String fecha, String hora, Paquete paquete, Envios envios) {
        this.fecha = fecha;
        this.hora = hora;
        this.paquete = paquete;
        this.envios = envios;

    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Envios getEnvios() {
        return envios;
    }

    public void setEnvios(Envios envios) {
        this.envios = envios;
    }
}

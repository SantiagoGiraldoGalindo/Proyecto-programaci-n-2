package co.edu.uniquindio.poo.envioproyecto.model;



import java.util.Objects;

public class Envios implements Cloneable {
    private String idEnvio;
    private String destino;
    private int peso;
    private String tamano;
    private String fecha;
    private EstadoEnvio estado;



    // Constructor principal (de tu original: sin contexto inicial)
    public Envios(String idEnvio, String destino, int peso, String tamano, String fecha) {
        this.idEnvio = idEnvio;
        this.destino = destino;
        this.peso = peso;
        this.tamano = tamano;
        this.fecha = fecha;

        this.estado = EstadoEnvio.SOLICITADO;
    }

    // Clone (de tu original)
    @Override
    public Envios clone() throws CloneNotSupportedException {
        Envios clon = (Envios) super.clone();
       // Referencia al contexto
        return clon;
    }

    // Inicializar contexto post-pago (a En Camino)

    // Método para avanzar post-pago (a ENRUTA)
    public void avanzarAPostPago() {
        this.estado = EstadoEnvio.ENRUTA;  // Cambia a En Ruta (en camino)
        System.out.println("Estado cambiado a ENRUTA post-pago.");
    }

    // Setter para estado (usado en PagarView o actualizaciones)
    public void setEstadoEnvio(EstadoEnvio estado) {
        this.estado = estado;
    }

    // Getter para tabla
    public EstadoEnvio getEstado() {
        return estado;
    }
    // Getter para descripción del estado (usa tu obtenerDescripcionEstado() para tabla)


    // Getters y Setters originales (de tu archivo)
    public String getIdEnvio() { return idEnvio; }
    public void setIdEnvio(String idEnvio) { this.idEnvio = idEnvio; }
    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }
    public int getPeso() { return peso; }
    public void setPeso(int peso) { this.peso = peso; }
    public String getTamano() { return tamano; }
    public void setTamano(String tamano) { this.tamano = tamano; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Envios envios = (Envios) o;
        return peso == envios.peso && Objects.equals(idEnvio, envios.idEnvio) && Objects.equals(destino, envios.destino) && Objects.equals(tamano, envios.tamano) && Objects.equals(fecha, envios.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEnvio, destino, peso, tamano, fecha);
    }

    @Override
    public String toString() {
        return "Envios{" +
                "idEnvio='" + idEnvio + '\'' +
                ", destino='" + destino + '\'' +
                ", peso=" + peso +
                ", tamano='" + tamano + '\'' +
                ", fecha='" + fecha + '\'' +
                ", estado=" + estado +
                '}';
    }
}

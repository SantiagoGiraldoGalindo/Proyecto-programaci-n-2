package co.edu.uniquindio.poo.envioproyecto.model;



import java.util.Objects;

public class Envios implements Cloneable {
    private String idEnvio;
    private String destino;
    private int peso;
    private String tamano;
    private String fecha;
    private EstadoEnvio estado;
    private ContextoEnvio contextoEnvio;
    private Integer usuarioId;



    // Constructor principal (de tu original: sin contexto inicial)
    public Envios(String idEnvio, String destino, int peso, String tamano, String fecha) {
        this.idEnvio = idEnvio;
        this.destino = destino;
        this.peso = peso;
        this.tamano = tamano;
        this.fecha = fecha;

        this.estado = EstadoEnvio.ENRUTA;
        this.contextoEnvio = new ContextoEnvio(this);
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
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
        this.contextoEnvio.enCamino();
        syncEstadoDesdeContexto();
        System.out.println("Estado cambiado a ENRUTA post-pago.");
    }

    // Setter para estado (usado en PagarView o actualizaciones)
    public void setEstadoEnvio(EstadoEnvio estado) {
        this.estado = estado;
        // sincronizar contexto si es necesario
        if (this.contextoEnvio == null) this.contextoEnvio = new ContextoEnvio(this);
        switch (estado) {
            case ENRUTA:
                contextoEnvio.setEstado(new EstadoEnCamino(contextoEnvio));
                break;
            case ENTREGADO:
                contextoEnvio.setEstado(new EstadoEntregado(contextoEnvio));
                break;
            case INCIDENCIA:
                contextoEnvio.setEstado(new EstadoFallado(contextoEnvio));
                break;
            case PAGADO:
                contextoEnvio.setEstado(new EstadoPagado(contextoEnvio));
                break;
            case ASIGNADO:
            default:
                contextoEnvio.setEstado(new EstadoEnCamino(contextoEnvio));
                break;
        }
    }

    // Getter para tabla
    public EstadoEnvio getEstado() {
        return estado;
    }
    /**
     * Devuelve una descripción legible del estado actual del envío.
     */
    public String getEstadoDescripcion() {
        if (contextoEnvio != null) return contextoEnvio.obtenerDescripcionEstado();
        if (estado == null) return "DESCONOCIDO";
        switch (estado) {
            case ASIGNADO: return "Asignado";
            case PAGADO: return "Pagado";
            case ENRUTA: return "En ruta";
            case ENTREGADO: return "Entregado";
            case INCIDENCIA: return "Incidencia";
            default: return estado.name();
        }
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

    // Métodos que delegan al contexto (patrón State)
    public void enCamino() {
        if (contextoEnvio == null) contextoEnvio = new ContextoEnvio(this);
        contextoEnvio.enCamino();
        syncEstadoDesdeContexto();
    }

    public void entregar() {
        if (contextoEnvio == null) contextoEnvio = new ContextoEnvio(this);
        contextoEnvio.entregar();
        syncEstadoDesdeContexto();
    }

    public void fallar() {
        if (contextoEnvio == null) contextoEnvio = new ContextoEnvio(this);
        contextoEnvio.fallar();
        syncEstadoDesdeContexto();
    }

    public void pagar() {
        if (contextoEnvio == null) contextoEnvio = new ContextoEnvio(this);
        contextoEnvio.pagar();
        syncEstadoDesdeContexto();
    }

    private void syncEstadoDesdeContexto() {
        IEstadoEnvio s = contextoEnvio.getEstado();
        if (s instanceof EstadoEnCamino) this.estado = EstadoEnvio.ENRUTA;
        else if (s instanceof EstadoEntregado) this.estado = EstadoEnvio.ENTREGADO;
        else if (s instanceof EstadoFallado) this.estado = EstadoEnvio.INCIDENCIA;
        else if (s instanceof EstadoPagado) this.estado = EstadoEnvio.PAGADO;
        else this.estado = EstadoEnvio.ASIGNADO;
    }

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

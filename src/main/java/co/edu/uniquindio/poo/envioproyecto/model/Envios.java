package co.edu.uniquindio.poo.envioproyecto.model;



import java.util.Objects;

/**
 * Representa un envío en el sistema.
 *
 * Esta clase implementa el patrón State delegando comportamientos a un
 * {@link ContextoEnvio}. Mantiene información básica del envío (id, destino,
 * peso, tamaño, fecha) y su estado actual. Muchos métodos actúan como
 * "passthrough" al contexto de estado para ejecutar transiciones de estado
 * (por ejemplo, {@link #entregar()}, {@link #fallar()}, {@link #pagar()}).
 */
public class Envios implements Cloneable {
    private String idEnvio;
    private String destino;
    private int peso;
    private String tamano;
    private String fecha;
    private EstadoEnvio estado;
    private ContextoEnvio contextoEnvio;
    private Integer usuarioId;



    /**
     * Crea un nuevo envío con los valores básicos y configura el contexto de
     * estado inicial.
     *
     * @param idEnvio identificador único del envío
     * @param destino dirección de destino
     * @param peso    peso en unidades (kg)
     * @param tamano  descripción de tamaño/dimensiones
     * @param fecha   fecha de creación o envío (formato libre)
     */
    public Envios(String idEnvio, String destino, int peso, String tamano, String fecha) {
        this.idEnvio = idEnvio;
        this.destino = destino;
        this.peso = peso;
        this.tamano = tamano;
        this.fecha = fecha;

        this.estado = EstadoEnvio.ENRUTA;
        this.contextoEnvio = new ContextoEnvio(this);
    }

    /**
     * Devuelve el id del usuario propietario del envío (si está asignado).
     *
     * @return id del usuario o {@code null} si no está asignado
     */
    public Integer getUsuarioId() {
        return usuarioId;
    }

    /**
     * Asigna el id del usuario propietario del envío.
     *
     * @param usuarioId id del usuario
     */
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    /**
     * Crea una copia superficial del envío. Nota: el objeto {@code ContextoEnvio}
     * no se clona profundamente aquí, por lo que el clon puede compartir referencias
     * internas con el original.
     *
     * @return clon superficial de este objeto
     * @throws CloneNotSupportedException si la clonación no está soportada
     */
    @Override
    public Envios clone() throws CloneNotSupportedException {
        Envios clon = (Envios) super.clone();
       // Referencia al contexto
        return clon;
    }

    // Inicializar contexto post-pago (a En Camino)

    /**
     * Forza la transición del contexto a estado "en camino" después de un pago.
     * Este método invoca la transición en el {@link ContextoEnvio} y sincroniza
     * el campo {@link #estado} con el estado real del contexto.
     */
    public void avanzarAPostPago() {
        this.contextoEnvio.enCamino();
        syncEstadoDesdeContexto();
        System.out.println("Estado cambiado a ENRUTA post-pago.");
    }

    /**
     * Establece el estado enum del envío y actualiza el {@link ContextoEnvio}
     * para que refleje esa elección. Este método es útil cuando se quiere
     * sincronizar el contexto con un valor explícito (por ejemplo, restauración
     * desde almacenamiento o cambios manuales en la UI).
     *
     * @param estado nuevo estado a asignar
     */
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

    /**
     * Devuelve el valor enum que representa el estado del envío.
     *
     * @return estado actual (enum {@link EstadoEnvio})
     */
    public EstadoEnvio getEstado() {
        return estado;
    }
    /**
     * Devuelve una descripción legible del estado actual del envío.
     */
    /**
     * Obtiene una descripción legible del estado actual del envío. Si existe
     * {@link ContextoEnvio} delega en él; en caso contrario devuelve una cadena
     * basada en el enum {@link EstadoEnvio}.
     *
     * @return descripción legible del estado
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

    /**
     * Solicita al contexto del envío la transición a estado "en camino".
     * Crea el contexto si aún no existe y sincroniza el enum {@link #estado}.
     */
    public void enCamino() {
        if (contextoEnvio == null) contextoEnvio = new ContextoEnvio(this);
        contextoEnvio.enCamino();
        syncEstadoDesdeContexto();
    }

    /**
     * Marca el envío como entregado mediante el contexto de estado.
     * Después sincroniza el enum {@link #estado} con el nuevo estado.
     */
    public void entregar() {
        if (contextoEnvio == null) contextoEnvio = new ContextoEnvio(this);
        contextoEnvio.entregar();
        syncEstadoDesdeContexto();
    }

    /**
     * Marca el envío como con incidencia/fallado mediante el contexto.
     */
    public void fallar() {
        if (contextoEnvio == null) contextoEnvio = new ContextoEnvio(this);
        contextoEnvio.fallar();
        syncEstadoDesdeContexto();
    }

    /**
     * Marca el envío como pagado en el contexto. Esto puede habilitar
     * transiciones posteriores (por ejemplo asignación/reparto).
     */
    public void pagar() {
        if (contextoEnvio == null) contextoEnvio = new ContextoEnvio(this);
        contextoEnvio.pagar();
        syncEstadoDesdeContexto();
    }

    /**
     * Sincroniza el campo {@link #estado} (enum) a partir de la implementación
     * actual de {@link IEstadoEnvio} contenida en {@link ContextoEnvio}.
     */
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

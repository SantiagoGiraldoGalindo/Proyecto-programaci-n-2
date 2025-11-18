package co.edu.uniquindio.poo.envioproyecto.model;

/**
 * Contexto del patrón State para un envío. Contiene la referencia al estado
 * actual ({@link IEstadoEnvio}) y delega las transiciones hacia la
 * implementación concreta del estado.
 */
public class ContextoEnvio {
    private IEstadoEnvio estadoActual;
    private Envios envio;
    
    /**
     * Construye el contexto para el envío dado y establece el estado inicial
     * por defecto (por diseño se usa {@link EstadoEnCamino}).
     *
     * @param envio instancia de {@link Envios} asociada a este contexto
     */
    public ContextoEnvio(Envios envio) {
        this.envio = envio;
        // Estado inicial: En Camino (por defecto)
        this.estadoActual = new EstadoEnCamino(this);
    }
    
    /**
     * Solicita al estado actual que ejecute la lógica correspondiente a la
     * transición "en camino".
     */
    public void enCamino() {
        estadoActual.enCamino();
    }
    
    /**
     * Solicita al estado actual la transición a "entregado".
     */
    public void entregar() {
        estadoActual.entregar();
    }
    
    /**
     * Solicita al estado actual la transición a "fallado" (incidencia).
     */
    public void fallar() {
        estadoActual.fallar();
    }

    /**
     * Marca el envío como pagado. De forma simple aquí reemplazamos el
     * estado actual por una instancia de {@link EstadoPagado}.
     */
    public void pagar() {
        // Al pagar, forzamos el estado a PAGADO
        this.estadoActual = new EstadoPagado(this);
    }
    
    /**
     * Obtiene una descripción legible del estado actual delegando en la
     * implementación concreta de {@link IEstadoEnvio}.
     *
     * @return descripción legible del estado actual
     */
    public String obtenerDescripcionEstado() {
        return estadoActual.obtenerDescripcion();
    }
    
    /**
     * Sustituye el estado actual por la implementación indicada.
     *
     * @param nuevoEstado nueva implementación de {@link IEstadoEnvio}
     */
    public void setEstado(IEstadoEnvio nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }
    
    public IEstadoEnvio getEstado() {
        return estadoActual;
    }
    
    public Envios getEnvio() {
        return envio;
    }
}
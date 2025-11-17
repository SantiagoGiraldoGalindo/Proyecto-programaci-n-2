package co.edu.uniquindio.poo.envioproyecto.model;

public class ContextoEnvio {
    private IEstadoEnvio estadoActual;
    private Envios envio;
    
    public ContextoEnvio(Envios envio) {
        this.envio = envio;
        // Estado inicial: En Camino (por defecto)
        this.estadoActual = new EstadoEnCamino(this);
    }
    
    /**
     * Transiciona el envío a "En Camino"
     */
    public void enCamino() {
        estadoActual.enCamino();
    }
    
    /**
     * Transiciona el envío a "Entregado"
     */
    public void entregar() {
        estadoActual.entregar();
    }
    
    /**
     * Transiciona el envío a "Fallado"
     */
    public void fallar() {
        estadoActual.fallar();
    }

    /**
     * Marca el envío como pagado (delegado al estado actual)
     */
    public void pagar() {
        // Al pagar, forzamos el estado a PAGADO
        this.estadoActual = new EstadoPagado(this);
    }
    
    /**
     * Obtiene descripción del estado actual
     */
    public String obtenerDescripcionEstado() {
        return estadoActual.obtenerDescripcion();
    }
    
    /**
     * Cambia el estado actual
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
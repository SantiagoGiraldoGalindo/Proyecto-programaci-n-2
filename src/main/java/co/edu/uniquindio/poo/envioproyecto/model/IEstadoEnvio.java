package co.edu.uniquindio.poo.envioproyecto.model;

public interface IEstadoEnvio {
    /**
     * Transiciona el envío a estado "En Camino"
     */
    void enCamino();
    
    /**
     * Marca el envío como entregado
     */
    void entregar();
    
    /**
     * Marca el envío como fallado
     */
    void fallar();
    
    /**
     * Obtiene descripción del estado
     */
    String obtenerDescripcion();
}
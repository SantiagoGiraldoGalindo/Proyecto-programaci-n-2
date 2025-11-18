package co.edu.uniquindio.poo.envioproyecto.model;

/**
 * Interfaz que define las operaciones que un estado de envío debe soportar
 * dentro del patrón State. Cada implementación representa el comportamiento
 * posible para un estado concreto (por ejemplo: en camino, entregado,
 * fallado, pagado).
 */
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
     * Obtiene una descripción legible del estado actual.
     *
     * @return descripción breve del estado
     */
    String obtenerDescripcion();
    
    /**
     * Marca el envío como pagado (estado "Pagado")
     */
    void pagar();
}
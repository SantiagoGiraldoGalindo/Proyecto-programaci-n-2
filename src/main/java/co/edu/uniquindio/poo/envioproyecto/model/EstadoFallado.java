package co.edu.uniquindio.poo.envioproyecto.model;

/**
 * Estado que representa un envío que presentó una incidencia o fallo.
 * Desde este estado se puede reintentar la entrega pasando a 'En camino',
 * pero no es posible marcarlo como entregado ni pagarlo directamente.
 */
public class EstadoFallado implements IEstadoEnvio {
    private ContextoEnvio contexto;
    
    public EstadoFallado(ContextoEnvio contexto) {
        this.contexto = contexto;
    }
    
    @Override
    public void enCamino() {
        System.out.println("Reintentando envío...");
        contexto.setEstado(new EstadoEnCamino(contexto));
    }
    
    @Override
    public void entregar() {
        System.out.println("No se puede entregar un envío que falló");
    }
    
    @Override
    public void fallar() {
        System.out.println("El envío ya está marcado como fallado");
    }
    
    @Override
    public String obtenerDescripcion() {
        return "Envío fallado";
    }

    @Override
    public void pagar() {
        System.out.println("No se puede pagar un envío que falló");
    }
}
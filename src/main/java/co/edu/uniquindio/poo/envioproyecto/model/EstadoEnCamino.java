package co.edu.uniquindio.poo.envioproyecto.model;

public class EstadoEnCamino implements IEstadoEnvio {
    private ContextoEnvio contexto;
    
    public EstadoEnCamino(ContextoEnvio contexto) {
        this.contexto = contexto;
    }
    
    @Override
    public void enCamino() {
        System.out.println("El envío ya está en camino");
    }
    
    @Override
    public void entregar() {
        System.out.println("Envío entregado exitosamente");
        contexto.setEstado(new EstadoEntregado(contexto));
    }
    
    @Override
    public void fallar() {
        System.out.println("Fallo en la entrega");
        contexto.setEstado(new EstadoFallado(contexto));
    }
    
    @Override
    public String obtenerDescripcion() {
        return "Envío en camino";
    }
}
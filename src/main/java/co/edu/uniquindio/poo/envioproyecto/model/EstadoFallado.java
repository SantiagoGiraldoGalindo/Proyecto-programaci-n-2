package co.edu.uniquindio.poo.envioproyecto.model;

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
}
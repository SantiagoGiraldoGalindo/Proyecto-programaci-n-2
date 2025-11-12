package co.edu.uniquindio.poo.envioproyecto.model;

public class EstadoEntregado implements IEstadoEnvio {
    private ContextoEnvio contexto;

    public EstadoEntregado(ContextoEnvio contexto) {
        this.contexto = contexto;
    }

    @Override
    public void enCamino() {
        System.out.println("No se puede cambiar a 'En Camino' desde 'Entregado'");
    }

    @Override
    public void entregar() {
        System.out.println("El envío ya fue entregado");
    }

    @Override
    public void fallar() {
        System.out.println("No se puede marcar como fallado un envío ya entregado");
    }

    @Override
    public String obtenerDescripcion() {
        return "Envío entregado";
    }
}
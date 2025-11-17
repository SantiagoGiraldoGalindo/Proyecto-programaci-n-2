package co.edu.uniquindio.poo.envioproyecto.model;

public class EstadoPagado implements IEstadoEnvio {
    private ContextoEnvio contexto;

    public EstadoPagado(ContextoEnvio contexto) {
        this.contexto = contexto;
    }

    @Override
    public void enCamino() {
        System.out.println("Envío en ruta (después de pago)");
        contexto.setEstado(new EstadoEnCamino(contexto));
    }

    @Override
    public void entregar() {
        System.out.println("No se puede entregar directamente desde 'Pagado' sin estar en camino");
    }

    @Override
    public void fallar() {
        System.out.println("No se puede marcar como fallado desde 'Pagado'");
    }

    @Override
    public String obtenerDescripcion() {
        return "Envío pagado";
    }

    @Override
    public void pagar() {
        System.out.println("El envío ya fue marcado como pagado");
    }
}

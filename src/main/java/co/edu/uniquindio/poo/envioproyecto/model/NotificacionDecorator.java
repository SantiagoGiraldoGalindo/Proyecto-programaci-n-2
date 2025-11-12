package co.edu.uniquindio.poo.envioproyecto.model;


public abstract class NotificacionDecorator implements INotificacion {
    protected INotificacion notificacionDecorada;

    public NotificacionDecorator(INotificacion notificacion) {
        this.notificacionDecorada = notificacion;
    }

    @Override
    public String descripcion() {
        return notificacionDecorada.descripcion();
    }

    @Override
    public String EnviarNotificacion() {
        return notificacionDecorada.EnviarNotificacion();
    }

    @Override
    public String asunto() {
        return notificacionDecorada.asunto();
    }
}

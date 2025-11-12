package co.edu.uniquindio.poo.envioproyecto.model;

public class NotificacionConPrioridad extends NotificacionDecorator {
    public NotificacionConPrioridad(INotificacion notificacion) {
        super(notificacion);
    }

    @Override
    public String EnviarNotificacion() {
        // Añade [PRIORIDAD] al mensaje final
        return "[PRIORIDAD] " + notificacionDecorada.EnviarNotificacion();
    }

    @Override
    public String descripcion() {
        return "[PRIORIDAD] " + notificacionDecorada.descripcion();
    }

    @Override
    public String asunto() {
        return "[PRIORIDAD] " + notificacionDecorada.asunto();
    }
}

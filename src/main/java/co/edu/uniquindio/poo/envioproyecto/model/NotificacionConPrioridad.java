package co.edu.uniquindio.poo.envioproyecto.model;

/**
 * Decorador que marca una notificación con prioridad. Añade prefijos y
 * modificaciones para enfatizar que la notificación requiere atención.
 */
public class NotificacionConPrioridad extends NotificacionDecorator {
    public NotificacionConPrioridad(INotificacion notificacion) {
        super(notificacion);
    }

    @Override
    public String EnviarNotificacion() {
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

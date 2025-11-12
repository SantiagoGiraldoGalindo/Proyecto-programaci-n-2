package co.edu.uniquindio.poo.envioproyecto.model;

public class NotificacionPago extends NotificacionDecorator {
    public NotificacionPago(INotificacion notificacion) {
        super(notificacion);
    }

    @Override
    public String EnviarNotificacion() {
        // Especializa el comportamiento para pago
        return notificacionDecorada.EnviarNotificacion() + " [PAGO REGISTRADO]";
    }

    @Override
    public String descripcion() {
        return "[Pago] " + notificacionDecorada.descripcion();
    }
}

package co.edu.uniquindio.poo.envioproyecto.model;

/**
 * Decorador que especializa la notificación para eventos de pago.
 * Añade marcas o texto que indican que un pago ha sido registrado.
 */
public class NotificacionPago extends NotificacionDecorator {
    public NotificacionPago(INotificacion notificacion) {
        super(notificacion);
    }

    @Override
    public String EnviarNotificacion() {
        return notificacionDecorada.EnviarNotificacion() + " [PAGO REGISTRADO]";
    }

    @Override
    public String descripcion() {
        return "[Pago] " + notificacionDecorada.descripcion();
    }
}

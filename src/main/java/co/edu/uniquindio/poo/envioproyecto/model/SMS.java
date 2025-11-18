package co.edu.uniquindio.poo.envioproyecto.model;

/**
 * Notificación por SMS. Genera contenido específico para envíos y usa la
 * funcionalidad base de {@link NotificacionBase}.
 */
public class SMS extends NotificacionBase {
    public SMS(String fecha, String hora, Envios envios, Paquete paquete) {
        super(fecha, hora, envios, paquete);
    }

    @Override
    public String EnviarNotificacion() {
        return "Enviando SMS: " + asunto() + ". " + descripcion();
    }

    @Override
    public String asunto() {
        return "Envío por SMS para: " + envios.getIdEnvio();
    }
}
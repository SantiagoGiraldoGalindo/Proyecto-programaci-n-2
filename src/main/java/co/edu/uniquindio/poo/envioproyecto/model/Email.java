package co.edu.uniquindio.poo.envioproyecto.model;

/**
 * Notificación por correo electrónico. Construye un mensaje específico
 * para envíos y paquetes delegando en {@link NotificacionBase}.
 */
public class Email extends NotificacionBase {
    public Email(String fecha, String hora, Envios envios, Paquete paquete) {
        super(fecha, hora, envios, paquete);
    }

    @Override
    public String EnviarNotificacion() {
        return "Enviando EMAIL: " + asunto() + ". " + descripcion();
    }

    @Override
    public String asunto() {

        return "Envío por Email para: " + envios.getIdEnvio();
    }
}


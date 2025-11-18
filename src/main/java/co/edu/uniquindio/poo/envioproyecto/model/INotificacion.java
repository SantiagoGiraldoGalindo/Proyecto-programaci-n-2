package co.edu.uniquindio.poo.envioproyecto.model;

/**
 * Interfaz que define el contrato mínimo para una notificación dentro
 * de la aplicación. Se usa por las implementaciones y por el patrón
 * Decorator para componer mensajes.
 */
public interface INotificacion {

    public String asunto();
    public String EnviarNotificacion();
    public String descripcion();

}

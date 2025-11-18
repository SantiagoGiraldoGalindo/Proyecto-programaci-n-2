package co.edu.uniquindio.poo.envioproyecto.model;

/**
 * Implementación base de la abstracción de notificación. Proporciona un
 * constructor tipo Builder y comportamientos por defecto para asunto,
 * descripción y envío que pueden ser decorados o extendidos.
 */
public class NotificacionBase implements INotificacion {

    private String fecha;
    private String hora;
    private Paquete paquete;
    protected Envios envios;

    public NotificacionBase(Builder builder) {
        this.fecha = builder.fecha;
        this.hora = builder.hora;
        this.paquete = builder.paquete;
        this.envios = builder.envios;


    }

    public NotificacionBase(String fecha, String hora, Envios envios, Paquete paquete) {
    }


    @Override
    public String descripcion() {
        return "Notificación base para el envío " + envios.getIdEnvio();
    }

    @Override
    public String EnviarNotificacion() {
        return "Notificación enviada (base).";
    }

    @Override
    public String asunto() {
        return "Aviso de envío";
    }
    public static class Builder{
        private String fecha;
        private String hora;
        private Paquete paquete;
        private Envios envios;

        public Builder fecha(String fecha){
            this.fecha = fecha;
            return this;
        }
        public Builder hora(String hora){
            this.hora = hora;
            return this;
        }
        public Builder paquete(Paquete paquete){
            this.paquete = paquete;
            return this;
        }
        public Builder envios(Envios envios){
            this.envios = envios;
            return this;
        }
        public NotificacionBase build() {
            return new NotificacionBase(this);
        }
    }
}

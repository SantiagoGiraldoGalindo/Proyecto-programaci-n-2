package co.edu.uniquindio.poo.envioproyecto.model;

public class NotificacionBase {

    private String fecha;
    private String hora;
    private Paquete paquete;
    private Envios envios;

    public NotificacionBase(Builder builder) {
        this.fecha = builder.fecha;
        this.hora = builder.hora;
        this.paquete = builder.paquete;
        this.envios = builder.envios;


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

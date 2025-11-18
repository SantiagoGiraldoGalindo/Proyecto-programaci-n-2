package co.edu.uniquindio.poo.envioproyecto.model;

/**
 * Representa una ubicación física (calle y ciudad) asociada a envíos.
 */
public class Ubicacion {
    private int idUbicacion;
    private String calle;
    private String cuidad;

    public Ubicacion(int idUbicacion, String calle, String cuidad) {
        this.idUbicacion = idUbicacion;
        this.calle = calle;
        this.cuidad = cuidad;

    }

    public int getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCuidad() {
        return cuidad;
    }

    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;
    }
}

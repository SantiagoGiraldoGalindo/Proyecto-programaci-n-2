package co.edu.uniquindio.poo.envioproyecto.model;

import java.util.ArrayList;
import java.util.List;

public class Repartidor {

    private String nombre;
    private String cedula;
    private int idRepartidor;
    private String correo;
    private Estado estado;
    private List<Envios> listEnvios;

    public Repartidor(String nombre, String cedula, int idRepartidor, String correo,Estado estado) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.idRepartidor = idRepartidor;
        this.correo = correo;
        this.estado = estado;
        this.listEnvios = new ArrayList<Envios>();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getIdRepartidor() {
        return idRepartidor;
    }

    public void setIdRepartidor(int idRepartidor) {
        this.idRepartidor = idRepartidor;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setListEnvios(List<Envios> listEnvios) {
        this.listEnvios = listEnvios;
    }

    public List<Envios> getListEnvios() {
        return listEnvios;
    }

}

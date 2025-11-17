package co.edu.uniquindio.poo.envioproyecto.model;

import java.util.ArrayList;
import java.util.List;

public final class EmpresaEnvios {
    private String nombre;
    private String ubicacion;
    private static EmpresaEnvios instancia;
    private List<Envios> listEnvios;
    private List<Paquete> listPaquete;
    private List<Pago> listPago;
    private List<Ubicacion> listUbicacion;
    private List<Repartidor> listRepartidor;

    private EmpresaEnvios (String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.listEnvios = new ArrayList<>();
        this.listPaquete = new ArrayList<>();
        this.listPago = new ArrayList<>();
        this.listUbicacion = new ArrayList<>();
        this.listRepartidor = new ArrayList<>();

    }

    public static EmpresaEnvios getinstancia() {
        if (instancia == null) {
            instancia = new EmpresaEnvios("", "0");
        }
        return instancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public static EmpresaEnvios getInstancia() {
        return instancia;
    }

    public static void setInstancia(EmpresaEnvios instancia) {
        EmpresaEnvios.instancia = instancia;
    }

    public List<Envios> getListEnvios() {
        return listEnvios;
    }

    public void setListEnvios(List<Envios> listEnvios) {
        this.listEnvios = listEnvios;
    }

    public List<Paquete> getListPaquete() {
        return listPaquete;
    }

    public void setListPaquete(List<Paquete> listPaquete) {
        this.listPaquete = listPaquete;
    }

    public List<Pago> getListPago() {
        return listPago;
    }

    public void setListPago(List<Pago> listPago) {
        this.listPago = listPago;
    }

    public List<Ubicacion> getListUbicacion() {
        return listUbicacion;
    }

    public void setListUbicacion(List<Ubicacion> listUbicacion) {
        this.listUbicacion = listUbicacion;
    }

    public List<Repartidor> getListRepartidor() {
        return listRepartidor;
    }

    public void setListRepartidor(List<Repartidor> listRepartidor) {
        this.listRepartidor = listRepartidor;
    }

    public void agregarRepartidor(Repartidor repartidor) {
        listRepartidor.add(repartidor);
    }

    public void eliminarRepartidor(Repartidor repartidor) {
        listRepartidor.remove(repartidor);
    }

    public Repartidor buscarRepartidorPorCedula(String cedula) {
        if (cedula == null) return null;
        for (Repartidor r : listRepartidor) {
            if (cedula.equals(r.getCedula())) return r;
        }
        return null;
    }


}

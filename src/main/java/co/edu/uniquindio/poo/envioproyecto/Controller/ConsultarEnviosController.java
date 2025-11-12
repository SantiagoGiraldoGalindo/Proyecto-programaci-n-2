package co.edu.uniquindio.poo.envioproyecto.Controller;

import co.edu.uniquindio.poo.envioproyecto.model.Envios;
import co.edu.uniquindio.poo.envioproyecto.model.EstadoEnvio;
import java.util.ArrayList;
import java.util.List;

public class ConsultarEnviosController {

    // Lista que almacena todos los envíos registrados
    private static List<Envios> envios = new ArrayList<>();

    public static List<Envios> obtenerEnvios() {
        return envios;
    }

    public static void agregarEnvio(Envios envio) {
        envios.add(envio);
    }

    public static boolean eliminarEnvio(String idEnvio) {
        Envios envio = buscarEnvioPorId(idEnvio);
        if (envio != null) {
            envios.remove(envio);
            return true;
        }
        return false;
    }

    public static boolean actualizarEnvio(String idEnvio, String destino, int peso, String tamano, String fecha, EstadoEnvio estadoEnvio) {
        Envios envio = buscarEnvioPorId(idEnvio);
        if (envio != null) {
            envio.setDestino(destino);
            envio.setPeso(peso);
            envio.setTamano(tamano);
            envio.setFecha(fecha);
            envio.setEstadoEnvio(estadoEnvio);
            return true;
        }
        return false;
    }

    public static Envios buscarEnvioPorId(String idEnvio) {
        for (Envios e : envios) {
            if (e.getIdEnvio().equals(idEnvio)) {
                return e;
            }
        }
        return null;
    }
}

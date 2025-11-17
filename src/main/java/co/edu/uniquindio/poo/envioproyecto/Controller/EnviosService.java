package co.edu.uniquindio.poo.envioproyecto.Controller;

import co.edu.uniquindio.poo.envioproyecto.model.Envios;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EnviosService {
    public static final ObservableList<Envios> listaEnvios = FXCollections.observableArrayList();

    public static void agregarEnvio(Envios envios) {
        listaEnvios.add(envios);

    }

    public static Envios buscarPorId(String id) {
        return listaEnvios.stream().filter(e -> e.getIdEnvio().equals(id)).findFirst().orElse(null);
    }

    public static boolean eliminarEnvio(String id) {
        return listaEnvios.removeIf(e -> e.getIdEnvio().equals(id));
    }

    public static boolean actualizarEnvio(Envios envios) {
        int index = listaEnvios.indexOf(buscarPorId(envios.getIdEnvio()));
        if (index != -1) {
            listaEnvios.set(index, envios);
 
            return true;
        }
        return false;
    }

    public static ObservableList<Envios> obtenerEnviosUsuario(Integer usuarioId) {
        if (usuarioId == null) return FXCollections.observableArrayList();
        ObservableList<Envios> filtrados = FXCollections.observableArrayList();
        for (Envios e : listaEnvios) {
            if (e.getUsuarioId() != null && e.getUsuarioId().equals(usuarioId)) {
                filtrados.add(e);
            }
        }
        return filtrados;
    }
}

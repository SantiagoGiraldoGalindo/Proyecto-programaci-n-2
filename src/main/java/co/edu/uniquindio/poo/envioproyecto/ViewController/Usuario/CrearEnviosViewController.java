package co.edu.uniquindio.poo.envioproyecto.ViewController.Usuario;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.model.Envios;
import co.edu.uniquindio.poo.envioproyecto.model.EstadoEnvio;
import co.edu.uniquindio.poo.envioproyecto.Controller.EnviosService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class CrearEnviosViewController {

    @FXML private TextField TxfIdEnvio;
    @FXML private TextField TxfTamano;
    @FXML private TextField TxfFecha;
    @FXML private TextField TxfDestino;
    @FXML private TextField TxfPeso;

    @FXML public void OnVolver(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Usuario/Envios.fxml", event);
    }

    @FXML void OnGestionarPaquete(ActionEvent event) {
        try {
            String idEnvio = TxfIdEnvio.getText().trim();
            String destino = TxfDestino.getText().trim();
            String pesoStr = TxfPeso.getText().trim();
            String tamano = TxfTamano.getText().trim();
            String fecha = TxfFecha.getText().trim();
            String usuarioId = "user1";  // Reemplaza con usuario logueado

            if (idEnvio.isEmpty() || destino.isEmpty() || pesoStr.isEmpty() || tamano.isEmpty() || fecha.isEmpty()) {
                mostrarMensaje("Completa todos los campos.");
                return;
            }

            int peso = Integer.parseInt(pesoStr);


          //  Envios envios = new Envios(idEnvio, destino, peso, tamano, fecha, usuarioId,estado);

            // Verifica si ya existe (similar a tu Service check)
            if (EnviosService.buscarPorId(idEnvio) != null) {
                mostrarMensaje("Ya existe un envío con ese ID.");
            } else {
                EnviosService.agregarEnvio(envios);

                // Limpieza inline si éxito
                TxfIdEnvio.clear();
                TxfDestino.clear();
                TxfPeso.clear();
                TxfTamano.clear();
                TxfFecha.clear();

                mostrarMensaje("Envío registrado exitosamente.");

                // Navega a GestionarPaquete
                App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Usuario/GestionarPaquete.fxml", event);
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            mostrarMensaje("Peso inválido: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            mostrarMensaje("Error al registrar envío: " + e.getMessage());
        }
    }
    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}

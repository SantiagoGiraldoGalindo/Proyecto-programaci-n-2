package co.edu.uniquindio.poo.envioproyecto.ViewController.Usuario;

import co.edu.uniquindio.poo.envioproyecto.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Controller de la pantalla que agrupa acciones del usuario sobre envíos
 * (crear, consultar). Simplemente enruta a las vistas correspondientes.
 */
public class EnviosViewController {

    @FXML private Button BtnVolver;
    @FXML private Button BtnPedirEnvio;
    @FXML private Button BtnConsultarEnvios;

    @FXML public void OnVolver(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Inicio.fxml", event);
    }
    @FXML public void OnPedir(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Usuario/CrearEnvios.fxml", event);
    }
    @FXML public void OnConsultar(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Usuario/ConsultarEnvios.fxml", event);

    }
}

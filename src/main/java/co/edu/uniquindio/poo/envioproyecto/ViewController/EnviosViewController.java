package co.edu.uniquindio.poo.envioproyecto.ViewController;

import co.edu.uniquindio.poo.envioproyecto.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static co.edu.uniquindio.poo.envioproyecto.App.cambiarVista;

public class EnviosViewController {

    @FXML private Button BtnVolver;
    @FXML private Button BtnPedirEnvio;
    @FXML private Button BtnConsultarEnvios;

    @FXML public void OnVolver(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Inicio.fxml", event);
    }
    @FXML public void OnPedir(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/CrearEnvios.fxml", event);
    }
    @FXML public void OnConsultar(ActionEvent event) {

    }
}

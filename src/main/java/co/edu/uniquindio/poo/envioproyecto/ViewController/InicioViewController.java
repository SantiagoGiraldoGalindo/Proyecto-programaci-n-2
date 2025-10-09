package co.edu.uniquindio.poo.envioproyecto.ViewController;

import co.edu.uniquindio.poo.envioproyecto.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InicioViewController {

    @FXML private Button BtnAdministrador;
    @FXML private Button BtnUsuario;
    @FXML private Button BtnRepartidor;

    @FXML public void OnRegistroUsuario(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/LoginUsuario.fxml", event);

    }
    @FXML public void OnloginAdministrador(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/LoginAdministrador.fxml", event);

    }
    @FXML public void OnLoginRepartidor(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/LoginRepartidor.fxml", event);

    }

}

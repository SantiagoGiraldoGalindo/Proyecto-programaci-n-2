package co.edu.uniquindio.poo.envioproyecto.ViewController;

import co.edu.uniquindio.poo.envioproyecto.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Controller para la vista inicial de la aplicación. Expone botones para
 * navegar a las pantallas de administrador, usuario y repartidor.
 */
public class InicioViewController {

    @FXML private Button BtnAdministrador;
    @FXML private Button BtnUsuario;
    @FXML private Button BtnRepartidor;

    /** Navega a la vista de login/registro de usuarios. */
    @FXML public void OnRegistroUsuario(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Usuario/LoginUsuario.fxml", event);

    }

    /** Navega a la vista de login de administrador. */
    @FXML public void OnloginAdministrador(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Admin/LoginAdministrador.fxml", event);

    }

    /** Navega a la vista de login de repartidor. */
    @FXML public void OnLoginRepartidor(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Repartidor/LoginRepartidor.fxml", event);

    }

}

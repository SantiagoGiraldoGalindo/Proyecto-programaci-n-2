package co.edu.uniquindio.poo.envioproyecto.ViewController;

import co.edu.uniquindio.poo.envioproyecto.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdministradorGestionViewController {

    @FXML
    private Button BtnGestionarU;
    @FXML private Button BtnGestionarR;
    @FXML private Button BtnGestionarE;
    @FXML private Button BtnConsultarE;
    @FXML private Button BtnVolver;

    @FXML public void OnGestionarU (ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/GestionarUsuarios.fxml",event);
    }
    @FXML public void OnGestionarR (ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/GestionarRepartidores.fxml",event);
    }
    @FXML public void OnGestionarE (ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/GestionarEnvios.fxml",event);
    }
    @FXML public void OnPanel (ActionEvent event) {

    }
    @FXML public void OnVolver (ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/LoginAdministrador.fxml", event);
    }
}

package co.edu.uniquindio.poo.envioproyecto.ViewController.Admin;

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
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Admin/GestionarUsuarios.fxml",event);
    }
    @FXML public void OnGestionarR (ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Admin/GestionarRepartidores.fxml",event);
    }
    @FXML public void OnGestionarE (ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Admin/GestionarEnvios.fxml",event);
    }
    @FXML public void OnPanel (ActionEvent event) {

    }
    @FXML public void OnVolver (ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Admin/LoginAdministrador.fxml", event);
    }
}

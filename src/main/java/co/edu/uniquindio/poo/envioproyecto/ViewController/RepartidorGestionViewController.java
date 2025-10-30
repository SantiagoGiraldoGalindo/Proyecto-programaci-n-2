package co.edu.uniquindio.poo.envioproyecto.ViewController;

import co.edu.uniquindio.poo.envioproyecto.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static co.edu.uniquindio.poo.envioproyecto.App.cambiarVista;

public class RepartidorGestionViewController {

    @FXML
    private Button BtnConsultarR;
    @FXML private Button BtnVolver;
    @FXML private Button BtnCambiarD;
    @FXML private Button BtnGestionarD;

    @FXML public void OnConsultarEnv (ActionEvent event) {
        cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Inicio.fxml", event);
    }
    @FXML public void OnCambiarD (ActionEvent event) {

    }
    @FXML public void OnConsultarE (ActionEvent event) {

    }
    @FXML public void OnVolver (ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Inicio.fxml", event);
    }

}

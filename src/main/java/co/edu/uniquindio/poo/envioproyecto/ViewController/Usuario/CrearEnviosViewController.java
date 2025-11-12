package co.edu.uniquindio.poo.envioproyecto.ViewController.Usuario;

import co.edu.uniquindio.poo.envioproyecto.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CrearEnviosViewController {

    @FXML
    private TextField TxfIdEnvio;
    @FXML private TextField TxfTamano;
    @FXML private TextField TxfFecha;
    @FXML private TextField TxfDestino;
    @FXML private TextField TxfPeso;




    @FXML public void OnVolver(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Usuario/Envios.fxml",event);

    }
    @FXML public void OnGestionarPaquete (ActionEvent event) {

        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Usuario/GestionarPaquete.fxml", event);

    }

}

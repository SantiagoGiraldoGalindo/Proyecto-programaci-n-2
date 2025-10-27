package co.edu.uniquindio.poo.envioproyecto.ViewController;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.model.EstadoEnvio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CrearEnviosViewController {

    @FXML
    private TextField TxfIdEnvio;
    @FXML private TextField TxfTamano;
    @FXML private TextField TxfFecha;
    @FXML private TextField TxfDestino;
    @FXML private TextField TxfPeso;

    @FXML private ComboBox<EstadoEnvio> CboxEstado;


    @FXML public void OnVolver(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Envios.fxml",event);

    }
    @FXML public void OnGestionarPaquete (ActionEvent event) {
        App.cambiarVista("", event);

    }

}

package co.edu.uniquindio.poo.envioproyecto.ViewController.Usuario;

import co.edu.uniquindio.poo.envioproyecto.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GestionarPaqueteViewController {

    @FXML
    private Button BtnVolver;
    @FXML private Button BtnPagar;
    @FXML private TextField TxfPeso;
    @FXML private TextField TxfVolumen;
    @FXML private TextField TxfTamano;


    @FXML public void OnVolver(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Usuario/CrearEnvios.fxml",event);
    }
    @FXML public void OnPagar(ActionEvent event) {
App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Usuario/Pagar.fxml",event);
    }
}

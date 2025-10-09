package co.edu.uniquindio.poo.envioproyecto.ViewController;

import co.edu.uniquindio.poo.envioproyecto.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class LoginUsuarioViewController {

    @FXML
    private TextField TxfNombre;
    @FXML private TextField TxfApellido;
    @FXML private TextField TxfCorreo;
    @FXML private TextField TxfTelefono;
    @FXML private TextField TxfDireccion;
    @FXML private Button BtnContinuar;
    @FXML private Button BtnVolver;
    @FXML private ComboBox CboxMetodoPago;

    @FXML public void OnContinuar(ActionEvent event) {

    }
    @FXML public void OnVolver(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Inicio.fxml", event);
    }
}

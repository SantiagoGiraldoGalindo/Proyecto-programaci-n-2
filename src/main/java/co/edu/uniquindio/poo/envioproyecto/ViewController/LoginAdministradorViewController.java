package co.edu.uniquindio.poo.envioproyecto.ViewController;

import co.edu.uniquindio.poo.envioproyecto.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginAdministradorViewController {
    @FXML
    private TextField TxfUsuario;
    @FXML private TextField TxfContrasena;
    @FXML private Button BtnVolver;
    @FXML private Button BtnContinuar;

    @FXML public void OnVolver(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Inicio.fxml", event);
    }
    @FXML public void OnContinuar(ActionEvent event) {

    }
}

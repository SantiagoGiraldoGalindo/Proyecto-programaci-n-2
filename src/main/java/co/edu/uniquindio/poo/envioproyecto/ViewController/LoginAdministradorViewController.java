package co.edu.uniquindio.poo.envioproyecto.ViewController;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.Controller.LoginAdministradorController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static co.edu.uniquindio.poo.envioproyecto.App.cambiarVista;

public class LoginAdministradorViewController {
    @FXML
    private TextField TxfUsuario;
    @FXML private  TextField TxfContrasena;
    @FXML private Button BtnVolver;
    @FXML private Button BtnContinuar;

    @FXML public void OnVolver(ActionEvent event) {
        cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Inicio.fxml", event);
    }
    @FXML public void OnContinuar(ActionEvent event) {
        String passwordIngresada = TxfContrasena.getText();

        if (LoginAdministradorController.verificarContrasena(passwordIngresada)) {
            cambiarVista("/co/edu/uniquindio/poo/envioproyecto/AdministradorGestion.fxml", event);
        } else {
            System.out.println("Contraseña incorrecta");
        }
    }
    }





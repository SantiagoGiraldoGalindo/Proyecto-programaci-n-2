package co.edu.uniquindio.poo.envioproyecto.ViewController;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.Controller.LoginUsuarioController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

import static co.edu.uniquindio.poo.envioproyecto.App.cambiarVista;

public class LoginUsuarioViewController {

    private App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BtnAbrirRegistrar;

    @FXML
    private Button BtnIniciarSesion;

    @FXML
    private Button BtnVolver;

    @FXML
    private TextField TxfIdUsuario;

    @FXML
    private TextField TxfNombre;

    @FXML
    public void OnAbrirRegistrar(ActionEvent event) throws Exception {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/RegistroUsuario.fxml", event);
    }

    @FXML
    void OnContinuar(ActionEvent event) {
        String passwordIngresada = TxfIdUsuario.getText();

        if (LoginUsuarioController.verificarContrasena(passwordIngresada)) {
            System.out.println("Inicio de sesión correcto");
            App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/UsuarioGestion.fxml", event);
        } else {
            System.out.println(" Contraseña incorrecta o usuario no registrado");
        }
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Envios.fxml", event);
    }

    @FXML
    public void OnVolver(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Inicio.fxml", event);
    }

    @FXML
    void initialize() {
        assert BtnAbrirRegistrar != null : "fx:id=\"BtnAbrirRegistrar\" was not injected: check your FXML file 'LoginUsuario.fxml'.";
        assert BtnIniciarSesion != null : "fx:id=\"BtnIniciarSesion\" was not injected: check your FXML file 'LoginUsuario.fxml'.";
        assert BtnVolver != null : "fx:id=\"BtnVolver\" was not injected: check your FXML file 'LoginUsuario.fxml'.";
        assert TxfIdUsuario != null : "fx:id=\"TxfIdUsuario\" was not injected: check your FXML file 'LoginUsuario.fxml'.";
        assert TxfNombre != null : "fx:id=\"TxfNombre\" was not injected: check your FXML file 'LoginUsuario.fxml'.";
    }

    public void setApp(App app) {
        this.app = app;
    }
}

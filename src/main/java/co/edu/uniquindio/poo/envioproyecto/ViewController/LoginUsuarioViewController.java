package co.edu.uniquindio.poo.envioproyecto.ViewController;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.Controller.LoginUsuarioController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    public void OnAbrirRegistrar(ActionEvent event) throws IOException {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/RegistroUsuario.fxml", event);
    }

    @FXML
    void OnContinuar(ActionEvent event) {

        String passwordIngresada = TxfIdUsuario.getText();

        if (LoginUsuarioController.verificarContrasena(passwordIngresada)) {
            cambiarVista("/co/edu/uniquindio/poo/envioproyecto/UsuarioGestion.fxml", event);
        } else {
            System.out.println("Contraseña incorrecta");
        }
    }

    @FXML
    void OnVolver(ActionEvent event) {

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


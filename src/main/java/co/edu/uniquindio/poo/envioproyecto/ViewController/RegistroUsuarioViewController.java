package co.edu.uniquindio.poo.envioproyecto.ViewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.Controller.LoginUsuarioController;
import co.edu.uniquindio.poo.envioproyecto.Controller.RegistroUsuarioController;
import co.edu.uniquindio.poo.envioproyecto.model.MetodoPago;
import co.edu.uniquindio.poo.envioproyecto.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

    public class RegistroUsuarioViewController {

        private App app;
        private RegistroUsuarioController registroUsuarioController;
        private ObservableList<Usuario> usuarios;


        public RegistroUsuarioViewController( ) {
            this.registroUsuarioController = new RegistroUsuarioController();
            this.usuarios = FXCollections.observableArrayList();
            this.app = app;
        }

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button BtnRegistro;

        @FXML
        private Button BtnVolver;

        @FXML
        private ComboBox<MetodoPago> CboxMetodoPago;

        @FXML
        private TextField TxfApellido;

        @FXML
        private TextField TxfCorreo;

        @FXML
        private TextField TxfIdUsuario;


        @FXML
        private TextField TxfDireccion;

        @FXML
        private TextField TxfNombre;

        @FXML
        private TextField TxfTelefono;



        @FXML
            void OnRegistrar(ActionEvent event) {
            String Nombre = TxfNombre.getText();
            String Apellido = TxfApellido.getText();
            String Correo = TxfCorreo.getText();
            String Direccion = TxfDireccion.getText();
            String Telefono = TxfTelefono.getText();
            int IdUsuario = Integer.parseInt(TxfIdUsuario.getText());
            MetodoPago MetodoPago = CboxMetodoPago.getSelectionModel().getSelectedItem();
            if (registroUsuarioController.RegistrarUsuario(Nombre,Apellido,Correo,Direccion,Telefono,IdUsuario,MetodoPago)) {
                mostrarMensaje("Usuario registrado exitosamente.");
            } else {
                mostrarMensaje("Ya existe un Usuario con ese Id.");
            }

        }

        @FXML
        void OnVolver(ActionEvent event) {

        }

        @FXML
        void initialize() {
           CboxMetodoPago.getItems().setAll(MetodoPago.values());
            assert BtnRegistro != null : "fx:id=\"BtnRegistro\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
            assert BtnVolver != null : "fx:id=\"BtnVolver\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
            assert TxfApellido != null : "fx:id=\"TxfApellido\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
            assert TxfCorreo != null : "fx:id=\"TxfCorreo\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
            assert TxfIdUsuario != null : "fx:id=\"TxfIdUsuario\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
            assert TxfDireccion != null : "fx:id=\"TxfDireccion\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
            assert TxfNombre != null : "fx:id=\"TxfNombre\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";
            assert TxfTelefono != null : "fx:id=\"TxfTelefono\" was not injected: check your FXML file 'RegistroUsuario.fxml'.";

        }

        public void setApp(App app) {
            this.app = app;
        }
        private void mostrarMensaje(String mensaje) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mensaje");
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.showAndWait();
        }

    }


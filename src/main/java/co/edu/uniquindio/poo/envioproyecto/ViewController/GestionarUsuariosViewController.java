package co.edu.uniquindio.poo.envioproyecto.ViewController;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.model.Envios;
import co.edu.uniquindio.poo.envioproyecto.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class GestionarUsuariosViewController {
    @FXML
    private Button BtnActualizar;
    @FXML private Button BtnEliminar;
    @FXML private Button BtnAgregar;
    @FXML private Button BtnVolver;
    @FXML private TableView<Usuario> TvUsuario;

    @FXML public void OnAgregar(ActionEvent event) {

    }
    @FXML public void OnActualizar(ActionEvent event) {

    }
    @FXML public void OnEliminar(ActionEvent event) {

    }
    @FXML public void OnVolver(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/AdministradorGestion.fxml",event);
    }
}

package co.edu.uniquindio.poo.envioproyecto.ViewController;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.model.Envios;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class GestionarEnviosViewController {

    @FXML
    private Button BtnActualizar;
    @FXML private Button BtnEliminar;

    @FXML private Button BtnVolver;
    @FXML private TableView<Envios> TvEnvios;


    @FXML public void OnActualizar(ActionEvent event) {

    }
    @FXML public void OnEliminar(ActionEvent event) {

    }
    @FXML public void OnVolver(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/AdministradorGestion.fxml",event);
    }
}

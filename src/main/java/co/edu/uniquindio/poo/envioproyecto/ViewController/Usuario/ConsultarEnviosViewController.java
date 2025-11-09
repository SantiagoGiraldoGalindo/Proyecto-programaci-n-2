package co.edu.uniquindio.poo.envioproyecto.ViewController.Usuario;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.model.Envios;
import co.edu.uniquindio.poo.envioproyecto.model.EstadoEnvio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ConsultarEnviosViewController {

    @FXML private Button BtnVolver;
    @FXML private Button BtnEliminar;
    @FXML private Button BtnActualizar;
    @FXML private TableView<Envios> TvEnvios;
    @FXML private TableColumn<Envios, Integer> TcIdEnvio ;
    @FXML private TableColumn<Envios, String> TcDestino;
    @FXML private TableColumn<Envios, String> TcPeso;
    @FXML private TableColumn<Envios, String> TcTamano;
    @FXML private TableColumn<Envios, String> TcFecha;
    @FXML private TableColumn<Envios, EstadoEnvio> TcEstado;



    @FXML public void OnVolver (ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Usuario/Envios.fxml", event);
    }
    @FXML public void OnEliminar (ActionEvent event) {

    }
    @FXML public void OnActualizar (ActionEvent event) {

    }
}

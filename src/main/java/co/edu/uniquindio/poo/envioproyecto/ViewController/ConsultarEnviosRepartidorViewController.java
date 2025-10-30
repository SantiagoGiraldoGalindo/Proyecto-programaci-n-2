package co.edu.uniquindio.poo.envioproyecto.ViewController;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.model.Envios;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ConsultarEnviosRepartidorViewController {
    @FXML private TableView<Envios> TvEnvios;
    @FXML private TableColumn<Envios, Integer> TcIdEnvio ;
    @FXML private TableColumn<Envios, String> TcDestino;
    @FXML private TableColumn<Envios, String> TcPeso;
    @FXML private TableColumn<Envios, String> TcTamano;
    @FXML private TableColumn<Envios, String> TcFecha;

    @FXML public void OnVolver (ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/RepartidorGestion.fxml", event);
    }
}

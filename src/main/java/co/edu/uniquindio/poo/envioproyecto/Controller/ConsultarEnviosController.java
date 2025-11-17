package co.edu.uniquindio.poo.envioproyecto.Controller;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.ViewController.Repartidor.RepartidorGestionViewController;
import co.edu.uniquindio.poo.envioproyecto.model.Envios;
import co.edu.uniquindio.poo.envioproyecto.model.Repartidor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ConsultarEnviosController implements Initializable {

    @FXML private TableView<Envios> TvEnvios;
    @FXML private TableColumn<Envios, Integer> TcIdEnvio;
    @FXML private TableColumn<Envios, String> TcDestino;
    @FXML private TableColumn<Envios, String> TcPeso;
    @FXML private TableColumn<Envios, String> TcTamano;
    @FXML private TableColumn<Envios, String> TcFecha;

    private Repartidor repartidorLogueado;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TcIdEnvio.setCellValueFactory(new PropertyValueFactory<>("idEnvio"));
        TcDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
        TcPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        TcTamano.setCellValueFactory(new PropertyValueFactory<>("tamano"));
        TcFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));

        // Si ya hay repartidor (porque initData ya lo puso), cargar envíos
        if (repartidorLogueado != null) {
            cargarEnvios(repartidorLogueado);
        }
    }

    private void cargarEnvios(Repartidor repartidor) {
        List<Envios> envios = repartidor.getListEnvios();
        ObservableList<Envios> enviosObservable = FXCollections.observableArrayList(envios);
        TvEnvios.setItems(enviosObservable);
    }

    public void initData(Repartidor repartidor) {
        this.repartidorLogueado = repartidor;
        cargarEnvios(repartidor);
    }

    @FXML
    public void OnVolver(ActionEvent event) {
        App.cambiarVistaRepartidor(
                "/co/edu/uniquindio/poo/envioproyecto/Repartidor/RepartidorGestion.fxml",
                event,
                controller -> {
                    ((RepartidorGestionViewController) controller).initData(repartidorLogueado);
                }
        );
    }
}

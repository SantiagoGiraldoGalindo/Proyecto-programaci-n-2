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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controlador de la vista que permite a un repartidor ver sus envíos y
 * marcarlos como entregados o con incidencia (fallados). Se integra con
 * `EnviosService` para persistencia en memoria y con `App` para navegación.
 */
public class ConsultarEnviosController implements Initializable {

    @FXML private TableView<Envios> TvEnvios;
    @FXML private TableColumn<Envios, Integer> TcIdEnvio;
    @FXML private TableColumn<Envios, String> TcDestino;
    @FXML private TableColumn<Envios, String> TcPeso;
    @FXML private TableColumn<Envios, String> TcTamano;
    @FXML private TableColumn<Envios, String> TcFecha;
    @FXML private Button BtnEntregar;
    @FXML private Button BtnFallar;

    private Repartidor repartidorLogueado;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TcIdEnvio.setCellValueFactory(new PropertyValueFactory<>("idEnvio"));
        TcDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
        TcPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        TcTamano.setCellValueFactory(new PropertyValueFactory<>("tamano"));
        TcFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));

        
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
    public void OnEntregar(ActionEvent event) {
        Envios seleccionado = TvEnvios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            Alert a = new Alert(Alert.AlertType.WARNING, "Selecciona un envío para marcar como entregado.");
            a.showAndWait();
            return;
        }

        seleccionado.entregar();
        boolean actualizado = EnviosService.actualizarEnvio(seleccionado);
        if (actualizado) {
            TvEnvios.refresh();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Envío marcado como entregado.");
            a.showAndWait();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "No se pudo actualizar el envío en el servicio.");
            a.showAndWait();
        }
    }

    @FXML
    public void OnFallar(ActionEvent event) {
        Envios seleccionado = TvEnvios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            Alert a = new Alert(Alert.AlertType.WARNING, "Selecciona un envío para marcar como fallado.");
            a.showAndWait();
            return;
        }

        seleccionado.fallar();
        boolean actualizado = EnviosService.actualizarEnvio(seleccionado);
        if (actualizado) {
            TvEnvios.refresh();
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Envío marcado como fallado (incidencia).");
            a.showAndWait();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "No se pudo actualizar el envío en el servicio.");
            a.showAndWait();
        }
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

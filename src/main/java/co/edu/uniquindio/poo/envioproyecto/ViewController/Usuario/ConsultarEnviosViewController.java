package co.edu.uniquindio.poo.envioproyecto.ViewController.Usuario;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.model.Envios;
import co.edu.uniquindio.poo.envioproyecto.model.EstadoEnvio;  // Tu enum
import co.edu.uniquindio.poo.envioproyecto.Controller.EnviosService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class ConsultarEnviosViewController implements Initializable {

    @FXML private Button BtnVolver;
    @FXML private Button BtnEliminar;
    @FXML private Button BtnActualizar;
    @FXML private TableView<Envios> TvEnvios;
    @FXML private TableColumn<Envios, String> TcIdEnvio;  // String para ID
    @FXML private TableColumn<Envios, String> TcDestino;
    @FXML private TableColumn<Envios, String> TcPeso;  // String para mostrar peso
    @FXML private TableColumn<Envios, String> TcTamano;
    @FXML private TableColumn<Envios, String> TcFecha;
    @FXML private TableColumn<Envios, EstadoEnvio> TcEstado;  // Usa tu enum EstadoEnvio

    private ObservableList<Envios> listaEnvios = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Configurar columnas similar a GestionarUsuarios (usa getters de Envios)
        TcIdEnvio.setCellValueFactory(new PropertyValueFactory<>("idEnvio"));
        TcDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
        TcPeso.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPeso())));  // int a String
        TcTamano.setCellValueFactory(new PropertyValueFactory<>("tamano"));
        TcFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        TcEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));  // Muestra enum: SOLICITADO, etc.

        // Cargar lista filtrada por el usuario actualmente logueado
        Integer uid = co.edu.uniquindio.poo.envioproyecto.Controller.Session.getCurrentUserId();
        listaEnvios = FXCollections.observableArrayList(EnviosService.obtenerEnviosUsuario(uid));
        TvEnvios.setItems(listaEnvios);

        // Log para depuración (similar a tu ejemplo)
        System.out.println("Envíos cargados en la tabla:");
        EnviosService.listaEnvios.forEach(e ->
                System.out.println(e.getIdEnvio() + " - " + e.getDestino() + " - Estado: " + e.getEstado()));
    }

    @FXML public void OnVolver(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Usuario/Envios.fxml", event);
    }

    @FXML public void OnEliminar(ActionEvent event) {
        Envios envioSeleccionado = TvEnvios.getSelectionModel().getSelectedItem();

        if (envioSeleccionado != null) {
                // Solo eliminar si estado permite (ej. no ENRUTA o ENTREGADO)
                if (envioSeleccionado.getEstado() == EstadoEnvio.ASIGNADO) {
                boolean eliminado = EnviosService.eliminarEnvio(envioSeleccionado.getIdEnvio());
                if (eliminado) {
                    TvEnvios.getItems().remove(envioSeleccionado);
                    System.out.println("Envío eliminado: " + envioSeleccionado.getIdEnvio());
                } else {
                    System.out.println("Error al eliminar el envío.");
                }
            } else {
                System.out.println("No se puede eliminar envíos en ruta, entregados o con incidencia.");
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("No se puede eliminar envíos en progreso.");
                alert.show();
            }
        } else {
            System.out.println("Debe seleccionar un envío para eliminar.");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Selecciona un envío.");
            alert.show();
        }
    }

    @FXML public void OnActualizar(ActionEvent event) {
        // Similar a actualizar usuario: refresca lista y tabla para reflejar cambios (ej. post-pago a ENRUTA)
        Envios envioSeleccionado = TvEnvios.getSelectionModel().getSelectedItem();
        if (envioSeleccionado != null) {
            // Opcional: Actualiza en service (ej. sync BD)
            boolean actualizado = EnviosService.actualizarEnvio(envioSeleccionado);
            if (actualizado) {
                TvEnvios.refresh();
                System.out.println("Envío actualizado: " + envioSeleccionado.getIdEnvio() + " - Estado: " + envioSeleccionado.getEstado());
            } else {
                System.out.println("Error al actualizar el envío.");
            }
        } else {
            System.out.println("Debe seleccionar un envío para actualizar.");
            // Refresca general (muestra cambios desde PagarView, ej. SOLICITADO → ENRUTA)
            Integer uid2 = co.edu.uniquindio.poo.envioproyecto.Controller.Session.getCurrentUserId();
            listaEnvios.setAll(EnviosService.obtenerEnviosUsuario(uid2));
            TvEnvios.refresh();
        }
    }
}

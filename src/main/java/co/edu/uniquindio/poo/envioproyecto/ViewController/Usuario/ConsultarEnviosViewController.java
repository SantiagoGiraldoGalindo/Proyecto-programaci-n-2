package co.edu.uniquindio.poo.envioproyecto.ViewController.Usuario;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.Controller.ConsultarEnviosController;
import co.edu.uniquindio.poo.envioproyecto.Controller.RegistroUsuarioController;
import co.edu.uniquindio.poo.envioproyecto.model.Envios;
import co.edu.uniquindio.poo.envioproyecto.model.EstadoEnvio;
import co.edu.uniquindio.poo.envioproyecto.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import co.edu.uniquindio.poo.envioproyecto.model.Envios;
import co.edu.uniquindio.poo.envioproyecto.model.EstadoEnvio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ConsultarEnviosViewController {
    @FXML private TableView<Envios> TvEnvios;
    @FXML private TableColumn<Envios, String> TcIdEnvio;
    @FXML private TableColumn<Envios, String> TcDestino;
    @FXML private TableColumn<Envios, Integer> TcPeso;
    @FXML private TableColumn<Envios, String> TcTamano;
    @FXML private TableColumn<Envios, String> TcFecha;
    @FXML private TableColumn<Envios, EstadoEnvio> TcEstado;

    @FXML private Button btnAgregar;
    @FXML private Button btnActualizar;
    @FXML private Button btnEliminar;
    @FXML private Button btnVolver;

    private ObservableList<Envios> listaEnvios;

    @FXML
    public void initialize() {
        listaEnvios = FXCollections.observableArrayList(ConsultarEnviosController.obtenerEnvios());
        TvEnvios.setItems(listaEnvios);

        TcIdEnvio.setCellValueFactory(new PropertyValueFactory<>("idEnvio"));
        TcDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
        TcPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        TcTamano.setCellValueFactory(new PropertyValueFactory<>("tamano"));
        TcFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        TcEstado.setCellValueFactory(new PropertyValueFactory<>("estadoEnvio"));
    }

    @FXML
    private void onAgregar(ActionEvent event) {
        // Aquí deberías abrir la vista de registro (RegistrarEnviosView)
        mostrarAlerta("Agregar", "Abriendo ventana para registrar nuevo envío...");
    }

    @FXML
    private void OnActualizar(ActionEvent event) {
        Envios seleccionado = TvEnvios.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            boolean actualizado = ConsultarEnviosController.actualizarEnvio(
                    seleccionado.getIdEnvio(),
                    seleccionado.getDestino(),
                    seleccionado.getPeso(),
                    seleccionado.getTamano(),
                    seleccionado.getFecha(),
                    seleccionado.getEstadoEnvio()
            );
            if (actualizado) {
                TvEnvios.refresh();
                mostrarAlerta("Actualizado", "El envío fue actualizado correctamente.");
            } else {
                mostrarAlerta("Error", "No se pudo actualizar el envío.");
            }
        } else {
            mostrarAlerta("Advertencia", "Seleccione un envío para actualizar.");
        }
    }

    @FXML
    private void OnEliminar(ActionEvent event) {
        Envios seleccionado = TvEnvios.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            boolean eliminado = ConsultarEnviosController.eliminarEnvio(seleccionado.getIdEnvio());
            if (eliminado) {
                listaEnvios.remove(seleccionado);
                mostrarAlerta("Eliminado", "El envío fue eliminado correctamente.");
            } else {
                mostrarAlerta("Error", "No se pudo eliminar el envío.");
            }
        } else {
            mostrarAlerta("Advertencia", "Seleccione un envío para eliminar.");
        }
    }

    @FXML
    private void OnVolver(ActionEvent event) {
       App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Usuario/Envios.fxml",event);
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}


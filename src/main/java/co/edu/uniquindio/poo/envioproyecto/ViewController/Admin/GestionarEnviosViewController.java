package co.edu.uniquindio.poo.envioproyecto.ViewController.Admin;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.Controller.EnviosService;
import co.edu.uniquindio.poo.envioproyecto.model.Envios;
import co.edu.uniquindio.poo.envioproyecto.model.EstadoEnvio;
import co.edu.uniquindio.poo.envioproyecto.model.Repartidor;
import co.edu.uniquindio.poo.envioproyecto.model.EmpresaEnvios;
import co.edu.uniquindio.poo.envioproyecto.model.Estado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class GestionarEnviosViewController {

    @FXML
    private Button BtnActualizar;
    @FXML private Button BtnEliminar;

    @FXML private Button BtnVolver;
    @FXML private TableView<Envios> TvEnvios;

    private ObservableList<Envios> listaEnvios = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        TableColumn<Envios, String> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("idEnvio"));

        TableColumn<Envios, String> colDestino = new TableColumn<>("Destino");
        colDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));

        TableColumn<Envios, Integer> colPeso = new TableColumn<>("Peso");
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));

        TableColumn<Envios, String> colTamano = new TableColumn<>("Tamaño");
        colTamano.setCellValueFactory(new PropertyValueFactory<>("tamano"));

        TableColumn<Envios, String> colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(
            cell.getValue() != null ? cell.getValue().getEstadoDescripcion() : ""));

        TvEnvios.getColumns().setAll(colId, colDestino, colPeso, colTamano, colEstado);
        listaEnvios = FXCollections.observableArrayList(EnviosService.listaEnvios);
        TvEnvios.setItems(listaEnvios);
    }


    @FXML public void OnActualizar(ActionEvent event) {
        Envios seleccionado = TvEnvios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) return;
        ChoiceDialog<EstadoEnvio> dialog = new ChoiceDialog<>(EstadoEnvio.ASIGNADO, EstadoEnvio.values());
        dialog.setTitle("Cambiar estado");
        dialog.setHeaderText("Estado actual: " + (seleccionado.getEstado()!=null?seleccionado.getEstado().name():""));
        dialog.setContentText("Selecciona nuevo estado:");
        EstadoEnvio nuevo = dialog.showAndWait().orElse(null);
        if (nuevo != null) {
            seleccionado.setEstadoEnvio(nuevo);
            EnviosService.actualizarEnvio(seleccionado);
            TvEnvios.refresh();
        }
    }
    @FXML public void OnAsignar(ActionEvent event) {
        Envios seleccionado = TvEnvios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            Alert a = new Alert(Alert.AlertType.WARNING, "Selecciona un envío para asignar.");
            a.showAndWait();
            return;
        }

        if (seleccionado.getEstado() == EstadoEnvio.ENRUTA || seleccionado.getEstado() == EstadoEnvio.ENTREGADO || seleccionado.getEstado() == EstadoEnvio.INCIDENCIA) {
            Alert a = new Alert(Alert.AlertType.WARNING, "No se puede asignar un envío que ya está en ruta/entregado/incidencia.");
            a.showAndWait();
            return;
        }

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Asignar repartidor");
        dialog.setHeaderText(null);
        dialog.setContentText("Ingresa la cédula del repartidor:");
        String cedula = dialog.showAndWait().orElse("");
        if (cedula.isEmpty()) return;

        Repartidor r = EmpresaEnvios.getinstancia().buscarRepartidorPorCedula(cedula);
        if (r == null) {
            Alert a = new Alert(Alert.AlertType.ERROR, "No existe repartidor con esa cédula.");
            a.showAndWait();
            return;
        }

        if (r.getEstado() != Estado.ACTIVO) {
            Alert a = new Alert(Alert.AlertType.WARNING, "No se puede asignar un repartidor inactivo o que ya esté en ruta.");
            a.showAndWait();
            return;
        }

        if (!r.getListEnvios().contains(seleccionado)) {
            r.getListEnvios().add(seleccionado);
        }

        r.setEstado(Estado.ENRUTA);
        seleccionado.enCamino();
        EnviosService.actualizarEnvio(seleccionado);
        TvEnvios.refresh();

        Alert ok = new Alert(Alert.AlertType.INFORMATION, "Envío asignado al repartidor " + r.getNombre());
        ok.showAndWait();
    }
    @FXML public void OnEliminar(ActionEvent event) {
        Envios seleccionado = TvEnvios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) return;
        boolean eliminado = EnviosService.eliminarEnvio(seleccionado.getIdEnvio());
        if (eliminado) listaEnvios.remove(seleccionado);
    }
    @FXML public void OnVolver(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Admin/AdministradorGestion.fxml",event);
    }
}

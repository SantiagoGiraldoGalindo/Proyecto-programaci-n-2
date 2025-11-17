package co.edu.uniquindio.poo.envioproyecto.ViewController.Admin;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.Controller.EnviosService;
import co.edu.uniquindio.poo.envioproyecto.model.Envios;
import co.edu.uniquindio.poo.envioproyecto.model.EstadoEnvio;
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
                cell.getValue().getEstado() != null ? cell.getValue().getEstado().name() : ""));

        TvEnvios.getColumns().setAll(colId, colDestino, colPeso, colTamano, colEstado);
        listaEnvios = FXCollections.observableArrayList(EnviosService.listaEnvios);
        TvEnvios.setItems(listaEnvios);
    }


    @FXML public void OnActualizar(ActionEvent event) {
        Envios seleccionado = TvEnvios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) return;
        ChoiceDialog<EstadoEnvio> dialog = new ChoiceDialog<>(EstadoEnvio.SOLICITADO, EstadoEnvio.values());
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

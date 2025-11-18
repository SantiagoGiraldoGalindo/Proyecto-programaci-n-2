package co.edu.uniquindio.poo.envioproyecto.ViewController.Usuario;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.model.Envios;
import co.edu.uniquindio.poo.envioproyecto.model.EstadoEnvio;  // Tu enum
import co.edu.uniquindio.poo.envioproyecto.Controller.EnviosService;
import co.edu.uniquindio.poo.envioproyecto.Controller.ReportService;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import java.util.List;
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

/**
 * Controller que muestra la lista de envíos del usuario logueado y permite
 * operaciones básicas como eliminar o actualizar (refrescar) el estado.
 */
public class ConsultarEnviosViewController implements Initializable {

    @FXML private Button BtnVolver;
    @FXML private Button BtnEliminar;
    @FXML private Button BtnActualizar;
    @FXML private TableView<Envios> TvEnvios;
    @FXML private TableColumn<Envios, String> TcIdEnvio;  
    @FXML private TableColumn<Envios, String> TcDestino;
    @FXML private TableColumn<Envios, String> TcPeso; 
    @FXML private TableColumn<Envios, String> TcTamano;
    @FXML private TableColumn<Envios, String> TcFecha;
    @FXML private TableColumn<Envios, EstadoEnvio> TcEstado;  

    private ObservableList<Envios> listaEnvios = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TcIdEnvio.setCellValueFactory(new PropertyValueFactory<>("idEnvio"));
        TcDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
        TcPeso.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPeso())));  // int a String
        TcTamano.setCellValueFactory(new PropertyValueFactory<>("tamano"));
        TcFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        TcEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));  // Muestra enum: SOLICITADO, etc.

        Integer uid = co.edu.uniquindio.poo.envioproyecto.Controller.Session.getCurrentUserId();
        listaEnvios = FXCollections.observableArrayList(EnviosService.obtenerEnviosUsuario(uid));
        TvEnvios.setItems(listaEnvios);

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
        Envios envioSeleccionado = TvEnvios.getSelectionModel().getSelectedItem();
        if (envioSeleccionado != null) {
            boolean actualizado = EnviosService.actualizarEnvio(envioSeleccionado);
            if (actualizado) {
                TvEnvios.refresh();
                System.out.println("Envío actualizado: " + envioSeleccionado.getIdEnvio() + " - Estado: " + envioSeleccionado.getEstado());
            } else {
                System.out.println("Error al actualizar el envío.");
            }
        } else {
            System.out.println("Debe seleccionar un envío para actualizar.");
            Integer uid2 = co.edu.uniquindio.poo.envioproyecto.Controller.Session.getCurrentUserId();
            listaEnvios.setAll(EnviosService.obtenerEnviosUsuario(uid2));
            TvEnvios.refresh();
        }
    }

    /**
     * Exporta la lista de envíos del usuario a PDF. Muestra un FileChooser
     * para seleccionar la ruta de salida y muestra una alerta en caso de
     * éxito o error.
     */
    @FXML public void OnExportPdf(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        chooser.setInitialFileName("envios.pdf");
        File target = chooser.showSaveDialog(BtnVolver.getScene().getWindow());
        if (target != null) {
            try {
                List<Envios> toExport = TvEnvios.getItems();
                ReportService.exportToPdf(toExport, target);
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("PDF generado correctamente: " + target.getAbsolutePath());
                a.show();
            } catch (IOException ex) {
                ex.printStackTrace();
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Error al generar PDF: " + ex.getMessage());
                a.show();
            }
        }
    }

    /**
     * Exporta la lista de envíos del usuario a CSV.
     */
    @FXML public void OnExportCsv(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        chooser.setInitialFileName("envios.csv");
        File target = chooser.showSaveDialog(BtnVolver.getScene().getWindow());
        if (target != null) {
            try {
                List<Envios> toExport = TvEnvios.getItems();
                ReportService.exportToCsv(toExport, target);
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("CSV generado correctamente: " + target.getAbsolutePath());
                a.show();
            } catch (IOException ex) {
                ex.printStackTrace();
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Error al generar CSV: " + ex.getMessage());
                a.show();
            }
        }
    }
}

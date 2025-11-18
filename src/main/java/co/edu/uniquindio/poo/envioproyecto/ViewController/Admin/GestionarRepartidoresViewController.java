package co.edu.uniquindio.poo.envioproyecto.ViewController.Admin;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.Controller.RepartidorGestionController;
import co.edu.uniquindio.poo.envioproyecto.model.EmpresaEnvios;
import co.edu.uniquindio.poo.envioproyecto.model.Repartidor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Vista para la administración de repartidores. Permite agregar, actualizar
 * y eliminar repartidores usando diálogos simples y delega la lógica al
 * {@link co.edu.uniquindio.poo.envioproyecto.Controller.RepartidorGestionController}.
 */
public class GestionarRepartidoresViewController {
    @FXML
    private Button BtnActualizar;
    @FXML private Button BtnEliminar;
    @FXML private Button BtnAgregar;
    @FXML private Button BtnVolver;
    @FXML private TableView<Repartidor> TvRepartidores;
    private ObservableList<Repartidor> listaRepartidores = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        TableColumn<Repartidor, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("idRepartidor"));

        TableColumn<Repartidor, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Repartidor, String> colCedula = new TableColumn<>("Cédula");
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));

        TableColumn<Repartidor, String> colCorreo = new TableColumn<>("Correo");
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));

        TableColumn<Repartidor, String> colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(
                cell.getValue().getEstado() != null ? cell.getValue().getEstado().name() : ""));

        TvRepartidores.getColumns().setAll(colId, colNombre, colCedula, colCorreo, colEstado);

        listaRepartidores = FXCollections.observableArrayList(EmpresaEnvios.getinstancia().getListRepartidor());
        TvRepartidores.setItems(listaRepartidores);
    }

    @FXML public void OnAgregar(ActionEvent event) {
        TextInputDialog idDialog = new TextInputDialog();
        idDialog.setTitle("Agregar repartidor");
        idDialog.setHeaderText(null);
        idDialog.setContentText("Id repartidor (número):");
        String idStr = idDialog.showAndWait().orElse("");
        if (idStr.isEmpty()) return;
        int id;
        try { id = Integer.parseInt(idStr); } catch (NumberFormatException e) { return; }

        TextInputDialog nombreDialog = new TextInputDialog();
        nombreDialog.setTitle("Agregar repartidor");
        nombreDialog.setHeaderText(null);
        nombreDialog.setContentText("Nombre:");
        String nombre = nombreDialog.showAndWait().orElse("");

        TextInputDialog cedulaDialog = new TextInputDialog();
        cedulaDialog.setTitle("Agregar repartidor");
        cedulaDialog.setHeaderText(null);
        cedulaDialog.setContentText("Cédula:");
        String cedula = cedulaDialog.showAndWait().orElse("");

        TextInputDialog correoDialog = new TextInputDialog();
        correoDialog.setTitle("Agregar repartidor");
        correoDialog.setHeaderText(null);
        correoDialog.setContentText("Correo:");
        String correo = correoDialog.showAndWait().orElse("");

        Repartidor nuevo = new Repartidor(nombre, cedula, id, correo, co.edu.uniquindio.poo.envioproyecto.model.Estado.ACTIVO);
        boolean ok = RepartidorGestionController.agregarRepartidor(nuevo);
        if (ok) {
            listaRepartidores.add(nuevo);
            TvRepartidores.setItems(listaRepartidores);
        }
    }
    @FXML public void OnActualizar(ActionEvent event) {
        Repartidor seleccionado = TvRepartidores.getSelectionModel().getSelectedItem();
        if (seleccionado == null) return;

        TextInputDialog nombreDialog = new TextInputDialog(seleccionado.getNombre());
        nombreDialog.setTitle("Actualizar repartidor");
        nombreDialog.setHeaderText(null);
        nombreDialog.setContentText("Nombre:");
        String nombre = nombreDialog.showAndWait().orElse(seleccionado.getNombre());

        TextInputDialog cedulaDialog = new TextInputDialog(seleccionado.getCedula());
        cedulaDialog.setTitle("Actualizar repartidor");
        cedulaDialog.setHeaderText(null);
        cedulaDialog.setContentText("Cédula:");
        String cedula = cedulaDialog.showAndWait().orElse(seleccionado.getCedula());

        TextInputDialog correoDialog = new TextInputDialog(seleccionado.getCorreo());
        correoDialog.setTitle("Actualizar repartidor");
        correoDialog.setHeaderText(null);
        correoDialog.setContentText("Correo:");
        String correo = correoDialog.showAndWait().orElse(seleccionado.getCorreo());

        boolean actualizado = RepartidorGestionController.actualizarRepartidor(seleccionado.getIdRepartidor(), nombre, cedula, correo);
        if (actualizado) TvRepartidores.refresh();
    }
    @FXML public void OnEliminar(ActionEvent event) {
        Repartidor seleccionado = TvRepartidores.getSelectionModel().getSelectedItem();
        if (seleccionado == null) return;
        boolean eliminado = RepartidorGestionController.eliminarRepartidor(seleccionado.getIdRepartidor());
        if (eliminado) listaRepartidores.remove(seleccionado);
    }
    @FXML public void OnVolver(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Admin/AdministradorGestion.fxml",event);
    }
}

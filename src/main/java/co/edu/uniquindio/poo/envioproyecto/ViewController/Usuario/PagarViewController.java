package co.edu.uniquindio.poo.envioproyecto.ViewController.Usuario;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.Controller.PagoController;
import co.edu.uniquindio.poo.envioproyecto.model.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PagarViewController implements Initializable {

    @FXML private Button BtnVolver;
    @FXML private Button BtnProcesarPago;
    @FXML private ComboBox<MetodoPago> comboMetodoPago;
    @FXML private TextField txtMonto;
    @FXML private TextField txtFecha;
    @FXML private Label lblResultado;
    @FXML private TableView<Pago> tablePagos;

    private PagoController pagoController;
    private Usuario usuarioActual;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.pagoController = new PagoController();

        comboMetodoPago.setItems(FXCollections.observableArrayList(MetodoPago.values()));
        comboMetodoPago.setCellFactory(p -> new ListCell<MetodoPago>() {
            @Override
            protected void updateItem(MetodoPago item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item.name());
            }
        });

        comboMetodoPago.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                lblResultado.setText("Método: " + newVal.name() + ". Ingresa monto y fecha.");
                lblResultado.setStyle("-fx-text-fill: blue;");
            }
        });

        if (usuarioActual != null && usuarioActual.getMetodoPago() != null) {
            comboMetodoPago.getSelectionModel().select(usuarioActual.getMetodoPago());
        }

        if (tablePagos != null) {
            TableColumn<Pago, String> colId = new TableColumn<>("ID");
            colId.setCellValueFactory(new PropertyValueFactory<>("idPago"));
            TableColumn<Pago, Double> colMonto = new TableColumn<>("Monto");
            colMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
            TableColumn<Pago, String> colFecha = new TableColumn<>("Fecha");
            colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
            TableColumn<Pago, String> colResultado = new TableColumn<>("Resultado");
            colResultado.setCellValueFactory(new PropertyValueFactory<>("resultado"));
            tablePagos.getColumns().addAll(colId, colMonto, colFecha, colResultado);
            tablePagos.setItems(pagoController.getListaPagos());
        }

        txtFecha.setText("2025-11-12");
        lblResultado.setText("Selecciona método para procesar pago.");
    }

    @FXML
    void OnProcesarPago(ActionEvent event) {
        try {
            MetodoPago metodo = comboMetodoPago.getValue();
            if (metodo == null) {
                lblResultado.setText("Selecciona método.");
                lblResultado.setStyle("-fx-text-fill: red;");
                return;
            }

            double monto = Double.parseDouble(txtMonto.getText().trim());
            String fecha = txtFecha.getText().trim();

            if (monto <= 0 || !fecha.matches("\\d{4}-\\d{2}-\\d{2}")) {
                lblResultado.setText("Monto positivo y fecha YYYY-MM-DD.");
                lblResultado.setStyle("-fx-text-fill: red;");
                return;
            }

            String resultado = pagoController.procesarPago(metodo, monto, fecha, usuarioActual);

            if (tablePagos != null) {
                tablePagos.refresh();
            }

            if (usuarioActual != null && usuarioActual.getMetodoPago() != metodo) {
                usuarioActual.setMetodoPago(metodo);
            }

            lblResultado.setText(resultado);
            lblResultado.setStyle(resultado.contains("Error") ? "-fx-text-fill: red;" : "-fx-text-fill: green;");

            txtMonto.clear();
        } catch (NumberFormatException e) {
            lblResultado.setText("Monto inválido.");
            lblResultado.setStyle("-fx-text-fill: red;");
        } catch (Exception e) {
            lblResultado.setText("Error: " + e.getMessage());
            lblResultado.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    void OnVolver(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Usuario/Envios.fxml", event);
    }

    public void setUsuarioActual(Usuario usuario) {
        this.usuarioActual = usuario;
        if (comboMetodoPago.getValue() == null && usuario != null && usuario.getMetodoPago() != null) {
            comboMetodoPago.getSelectionModel().select(usuario.getMetodoPago());
        }
    }
}
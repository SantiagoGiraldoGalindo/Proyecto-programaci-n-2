package co.edu.uniquindio.poo.envioproyecto.ViewController.Usuario;

import co.edu.uniquindio.poo.envioproyecto.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import co.edu.uniquindio.poo.envioproyecto.Controller.CotizacionService;
import co.edu.uniquindio.poo.envioproyecto.Controller.TarifaService;
import javafx.scene.control.Alert;
// import javafx.scene.control.ButtonType;  // eliminado: ya no se usa
import javafx.scene.control.CheckBox;

public class GestionarPaqueteViewController {

    @FXML
    private Button BtnVolver;
    @FXML private Button BtnPagar;
    @FXML private TextField TxfPeso;
    @FXML private TextField TxfVolumen;
    @FXML private TextField TxfTamano;
    @FXML private CheckBox ChkPrioridad;


    @FXML public void OnVolver(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Usuario/CrearEnvios.fxml",event);
    }
    @FXML public void OnPagar(ActionEvent event) {
        try {
            String pesoStr = TxfPeso.getText().trim();
            String volumenStr = TxfVolumen.getText().trim();

            int peso = pesoStr.isEmpty() ? 0 : Integer.parseInt(pesoStr);
            int volumen = volumenStr.isEmpty() ? 1 : Integer.parseInt(volumenStr);

            // Leer prioridad desde el CheckBox en la vista
            boolean prioridad = (ChkPrioridad != null) && ChkPrioridad.isSelected();

            // Usamos destino como null (o podrías extraer desde el envío activo)
            String origen = "CiudadOrigen";
            String destino = "CiudadDestino";

            double cotizacion = TarifaService.cotizar(origen, destino, peso, volumen, prioridad);
            CotizacionService.setUltimaCotizacion(cotizacion);

            App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Usuario/Pagar.fxml", event);
        } catch (NumberFormatException e) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Peso o volumen inválido.");
            a.showAndWait();
        }
    }
}

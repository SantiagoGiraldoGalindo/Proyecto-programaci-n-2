package co.edu.uniquindio.poo.envioproyecto.ViewController.Admin;

import co.edu.uniquindio.poo.envioproyecto.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Panel principal del administrador que enlaza a las vistas de gestión
 * (usuarios, repartidores, envíos) dentro del área de administración.
 */
public class AdministradorGestionViewController {

    @FXML
    private Button BtnGestionarU;
    @FXML private Button BtnGestionarR;
    @FXML private Button BtnGestionarE;
    @FXML private Button BtnConsultarE;
    @FXML private Button BtnVolver;

    @FXML public void OnGestionarU (ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Admin/GestionarUsuarios.fxml",event);
    }
    @FXML public void OnGestionarR (ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Admin/GestionarRepartidores.fxml",event);
    }
    @FXML public void OnGestionarE (ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Admin/GestionarEnvios.fxml",event);
    }
    @FXML public void OnPanel (ActionEvent event) {
        co.edu.uniquindio.poo.envioproyecto.Controller.MetricsService.Metrics metrics = co.edu.uniquindio.poo.envioproyecto.Controller.MetricsService.calculateMetrics();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Tiempos promedio de entrega (días): %.2f\n", metrics.avgDeliveryDays));

        sb.append("\nServicios/ tamaños más usados:\n");
        metrics.topSizes.forEach((k,v) -> sb.append(String.format(" - %s: %d\n", k, v)));

        sb.append(String.format("\nIngresos estimados (suma cotizaciones): $%.2f\n", metrics.estimatedRevenue));

        sb.append("\nIncidencias por zona:\n");
        if (metrics.incidentsByZone.isEmpty()) sb.append(" - Ninguna registrada\n");
        else metrics.incidentsByZone.forEach((z,cnt) -> sb.append(String.format(" - %s: %d\n", z, cnt)));

        javafx.scene.control.Alert a = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        a.setTitle("Métricas del sistema");
        a.setHeaderText("Resumen de métricas");
        a.getDialogPane().setExpandableContent(new javafx.scene.control.TextArea(sb.toString()));
        a.getDialogPane().setPrefWidth(600);
        a.showAndWait();
    }
    @FXML public void OnVolver (ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Admin/LoginAdministrador.fxml", event);
    }
}

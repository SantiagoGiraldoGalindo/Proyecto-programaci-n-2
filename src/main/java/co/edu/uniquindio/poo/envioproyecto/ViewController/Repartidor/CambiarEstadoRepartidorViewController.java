package co.edu.uniquindio.poo.envioproyecto.ViewController.Repartidor;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.model.Estado;
import co.edu.uniquindio.poo.envioproyecto.model.Repartidor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class CambiarEstadoRepartidorViewController implements Initializable {

    @FXML
    private ChoiceBox<Estado> choiceEstado;

    @FXML
    private Button btnGuardar; // si lo tienes en FXML

    private Repartidor repartidor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceEstado.getItems().addAll(Estado.values());
    }

    // Este método será llamado desde RepartidorGestionViewController vía cambiarVistaRepartidor
    public void initData(Repartidor repartidor) {
        this.repartidor = repartidor;
        if (repartidor != null && repartidor.getEstado() != null) {
            choiceEstado.setValue(repartidor.getEstado());
        }
    }

    @FXML
    public void onGuardar(ActionEvent event) {
        Estado seleccionado = choiceEstado.getValue();
        if (repartidor != null && seleccionado != null) {
            repartidor.setEstado(seleccionado);
            System.out.println("Estado actualizado a: " + seleccionado);
        }
    }

    @FXML void OnVolver(ActionEvent event) {
        App.cambiarVistaRepartidor(
                "/co/edu/uniquindio/poo/envioproyecto/Repartidor/RepartidorGestion.fxml",
                event,
                controller -> {
                    ((RepartidorGestionViewController) controller).initData(repartidor);
                }
        );
    }
}

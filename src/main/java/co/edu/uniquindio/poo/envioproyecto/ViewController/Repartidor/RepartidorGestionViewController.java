package co.edu.uniquindio.poo.envioproyecto.ViewController.Repartidor;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.model.Repartidor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RepartidorGestionViewController {

    @FXML private Button BtnVolver;
    @FXML private Button BtnConsultarEnv;
    @FXML private Button BtnCambiarEstado;

    private Repartidor repartidorLogueado;

    public void initData(Repartidor repartidor) {
        this.repartidorLogueado = repartidor;
        System.out.println("Repartidor recibido en Gestión: " + repartidor.getNombre());
    }

    @FXML
    public void OnVolver(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Repartidor/LoginRepartidor.fxml", event);
    }

    @FXML
    public void OnConsultarEnv(ActionEvent event) {

        App.cambiarVistaRepartidor(
                "/co/edu/uniquindio/poo/envioproyecto/Repartidor/ConsultarEnviosRepartidor.fxml",
                event,
                controller -> {
                    co.edu.uniquindio.poo.envioproyecto.Controller.ConsultarEnviosController c =
                            (co.edu.uniquindio.poo.envioproyecto.Controller.ConsultarEnviosController) controller;

                    c.initData(repartidorLogueado);
                }
        );
    }

    @FXML
    public void OnCambiarEstado(ActionEvent event) {

        App.cambiarVistaRepartidor(
                "/co/edu/uniquindio/poo/envioproyecto/Repartidor/CambiarEstadoRepartidor.fxml",
                event,
                controller -> {
                     ((CambiarEstadoRepartidorViewController) controller).initData(repartidorLogueado);
                }
        );
    }
}

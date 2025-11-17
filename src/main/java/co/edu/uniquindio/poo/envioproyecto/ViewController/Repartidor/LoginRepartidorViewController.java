package co.edu.uniquindio.poo.envioproyecto.ViewController.Repartidor;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.Controller.ConsultarEnviosController;
import co.edu.uniquindio.poo.envioproyecto.Controller.LoginRepartidorController;
import co.edu.uniquindio.poo.envioproyecto.model.Repartidor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginRepartidorViewController {

    @FXML private TextField TxfUsuario;      // si lo necesitas después
    @FXML private TextField TxfContrasena;
    @FXML private Button BtnVolver;
    @FXML private Button BtnContinuar;

    @FXML
    public void OnVolver(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Inicio.fxml", event);
    }

    @FXML
    public void OnContinuar(ActionEvent event) {
        String cedulaIngresada = TxfContrasena.getText();

        // 1. Obtener el repartidor real según la cedula digitada
        LoginRepartidorController login = new LoginRepartidorController();
        Repartidor repartidor = login.getRepartidorLogueado(cedulaIngresada);

        if (repartidor != null) {
            // 2. Usar el método nuevo para pasar el repartidor logueado
            App.cambiarVistaRepartidor(
                    "/co/edu/uniquindio/poo/envioproyecto/Repartidor/RepartidorGestion.fxml",
                    event,
                    controller -> {

                        ((RepartidorGestionViewController) controller).initData(repartidor);

                        // Si la vista destino es otra (como RepartidorGestionController),
                        // entonces pasas por allí.
                    }
            );
        } else {
            System.out.println("Cédula incorrecta o repartidor no encontrado");
        }
    }
}

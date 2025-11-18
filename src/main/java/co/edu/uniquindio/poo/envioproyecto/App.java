package co.edu.uniquindio.poo.envioproyecto;

import co.edu.uniquindio.poo.envioproyecto.model.EmpresaEnvios;
import co.edu.uniquindio.poo.envioproyecto.model.Envios;
import co.edu.uniquindio.poo.envioproyecto.model.Estado;
import co.edu.uniquindio.poo.envioproyecto.model.Repartidor;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.function.Consumer;

public class App extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        try {
            co.edu.uniquindio.poo.envioproyecto.Controller.DataSeeder.seed();
        } catch (Exception e) {
            System.err.println("Error al sembrar datos de ejemplo: " + e.getMessage());
        }

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        try {
            String css = App.class.getResource("/co/edu/uniquindio/poo/envioproyecto/styles/app.css").toExternalForm();
            scene.getStylesheets().add(css);
        } catch (Exception e) {
            System.err.println("No se pudo cargar la hoja de estilos: " + e.getMessage());
        }
        stage.setScene(scene);
        stage.show();
    }

    public static void cambiarVista(String rutaFXML, ActionEvent event) {
        try {
            URL fxmlLocation = App.class.getResource(rutaFXML);
            if (fxmlLocation == null) {
                System.err.println("No se encontró el archivo FXML en la ruta: " + rutaFXML);
                return;
            }

            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            try {
                String css = App.class.getResource("/co/edu/uniquindio/poo/envioproyecto/styles/app.css").toExternalForm();
                scene.getStylesheets().add(css);
            } catch (Exception e) {
                System.err.println("No se pudo cargar la hoja de estilos en cambiarVista: " + e.getMessage());
            }
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cambiarVistaRepartidor(String rutaFXML, ActionEvent event,
                                              Consumer<Object> initializer) {
        try {
            URL fxmlLocation = App.class.getResource(rutaFXML);
            if (fxmlLocation == null) {
                System.err.println("No se encontró el archivo FXML en la ruta: " + rutaFXML);
                return;
            }

            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            Parent root = loader.load();

            Object controller = loader.getController();
            if (initializer != null) {
                initializer.accept(controller);
            }

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            try {
                String css = App.class.getResource("/co/edu/uniquindio/poo/envioproyecto/styles/app.css").toExternalForm();
                scene.getStylesheets().add(css);
            } catch (Exception e) {
                System.err.println("No se pudo cargar la hoja de estilos en cambiarVistaRepartidor: " + e.getMessage());
            }
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}

package co.edu.uniquindio.poo.envioproyecto.ViewController.Admin;

import co.edu.uniquindio.poo.envioproyecto.App;
import co.edu.uniquindio.poo.envioproyecto.Controller.GestionarUsuariosController;
import co.edu.uniquindio.poo.envioproyecto.Controller.RegistroUsuarioController;
import co.edu.uniquindio.poo.envioproyecto.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class GestionarUsuariosViewController {
    @FXML
    private Button BtnActualizar;
    @FXML private Button BtnEliminar;
    @FXML private Button BtnAgregar;
    @FXML private Button BtnVolver;
    @FXML private TableView<Usuario> TvUsuario;
    @FXML private TableColumn<Usuario, Integer> colId;
    @FXML private TableColumn<Usuario, String> colNombre;
    @FXML private TableColumn<Usuario, String> colApellido;
    @FXML private TableColumn<Usuario, String> colCorreo;
    @FXML private TableColumn<Usuario, String> colTelefono;
    @FXML private TableColumn<Usuario, String> colDireccion;
    @FXML private TableColumn<Usuario, String> colMetodoPago;

    private ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();



    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colMetodoPago.setCellValueFactory(new PropertyValueFactory<>("metodoPago"));


        listaUsuarios = FXCollections.observableArrayList(RegistroUsuarioController.usuarios);


        TvUsuario.setItems(listaUsuarios);

        System.out.println("Usuarios cargados en la tabla:");
        RegistroUsuarioController.usuarios.forEach(u ->
                System.out.println(u.getIdUsuario() + " - " + u.getNombre()));
    }




    @FXML public void OnAgregar (ActionEvent event) {

    }
    @FXML public void OnActualizar(ActionEvent event) {
        Usuario usuarioSeleccionado = TvUsuario.getSelectionModel().getSelectedItem();

        if (usuarioSeleccionado != null) {
            boolean actualizado = GestionarUsuariosController.actualizarUsuario(
                    usuarioSeleccionado.getIdUsuario(),
                    usuarioSeleccionado.getNombre(),
                    usuarioSeleccionado.getApellido(),
                    usuarioSeleccionado.getCorreo(),
                    usuarioSeleccionado.getTelefono(),
                    usuarioSeleccionado.getDireccion(),
                    usuarioSeleccionado.getMetodoPago()
            );

            if (actualizado) {
                TvUsuario.refresh();
                System.out.println("Usuario actualizado correctamente.");
            } else {
                System.out.println("Error al actualizar el usuario.");
            }
        } else {
            System.out.println("Debe seleccionar un usuario para actualizar.");
        }

    }
    @FXML public void OnEliminar(ActionEvent event) {
        Usuario usuarioSeleccionado = TvUsuario.getSelectionModel().getSelectedItem();

        if (usuarioSeleccionado != null) {
            boolean eliminado = GestionarUsuariosController.eliminarUsuario(usuarioSeleccionado.getIdUsuario());
            if (eliminado) {
                TvUsuario.getItems().remove(usuarioSeleccionado);
                System.out.println("Usuario eliminado correctamente.");
            } else {
                System.out.println("Error al eliminar el usuario.");
            }
        } else {
            System.out.println("Debe seleccionar un usuario para eliminar.");
        }
    }
    @FXML public void OnVolver(ActionEvent event) {
        App.cambiarVista("/co/edu/uniquindio/poo/envioproyecto/Admin/AdministradorGestion.fxml",event);
    }
}

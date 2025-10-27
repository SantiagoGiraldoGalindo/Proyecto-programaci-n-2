package co.edu.uniquindio.poo.envioproyecto.Controller;

import co.edu.uniquindio.poo.envioproyecto.model.MetodoPago;
import co.edu.uniquindio.poo.envioproyecto.model.Usuario;

import static co.edu.uniquindio.poo.envioproyecto.Controller.RegistroUsuarioController.usuarios;

public class GestionarUsuariosController {

    public static boolean eliminarUsuario(int idUsuario) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        if (usuario != null) {
            usuarios.remove(usuario);
            return true;
        }
        return false;
    }
    public static boolean actualizarUsuario(int idUsuario, String nombre, String apellido, String correo, String telefono, String direccion, MetodoPago metodoPago) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        if (usuario != null) {
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setCorreo(correo);
            usuario.setTelefono(telefono);
            usuario.setDireccion(direccion);
            usuario.setMetodoPago(metodoPago);
            return true;
        }
        return false;
    }
    public static Usuario buscarUsuarioPorId(int idUsuario) {
        for (Usuario u : usuarios) {
            if (u.getIdUsuario() == idUsuario) {
                return u;
            }
        }
        return null;
    }
}

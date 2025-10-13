package co.edu.uniquindio.poo.envioproyecto.Controller;

import co.edu.uniquindio.poo.envioproyecto.model.MetodoPago;
import co.edu.uniquindio.poo.envioproyecto.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class RegistroUsuarioController {
    private final List<Usuario> usuarios= new ArrayList<Usuario>();

    public RegistroUsuarioController() {

    }


    public boolean RegistrarUsuario(String nombre, String apellido, String correo, String telefono, String direccion, int IdUsuario, MetodoPago MetodoPago) {
        if (buscarUsuarioPorId(IdUsuario) == null) {
            Usuario nuevo = new Usuario(nombre, apellido,correo,telefono,direccion,IdUsuario,MetodoPago);
            usuarios.add(nuevo);
            return true;
        }
        return false;
    }
    public Usuario buscarUsuarioPorId(int IdUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario() == usuario.getIdUsuario()) {
                return usuario;
            }
        }
        return null;
    }
}

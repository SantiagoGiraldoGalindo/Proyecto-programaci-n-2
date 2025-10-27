package co.edu.uniquindio.poo.envioproyecto.Controller;

import co.edu.uniquindio.poo.envioproyecto.model.MetodoPago;
import co.edu.uniquindio.poo.envioproyecto.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class LoginUsuarioController {
    private static String contrasenaUsuario;
    public static void setContrasenaUsuario(String idUsuario) {
        contrasenaUsuario = idUsuario;
    }


    public static boolean verificarContrasena(String passwordIngresada) {
        if (contrasenaUsuario == null) {
            System.out.println("⚠️ No hay contraseña configurada (usuario no registrado).");
            return false;
        }
        return contrasenaUsuario.equals(passwordIngresada);
    }
}

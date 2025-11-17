package co.edu.uniquindio.poo.envioproyecto.Controller;

import co.edu.uniquindio.poo.envioproyecto.model.MetodoPago;
import co.edu.uniquindio.poo.envioproyecto.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class LoginUsuarioController {

    public static boolean verificarContrasena(String passwordIngresada) {
        if (passwordIngresada == null || passwordIngresada.isBlank()) {
            System.out.println("⚠️ No se ingresó identificador.");
            return false;
        }

        try {
            int id = Integer.parseInt(passwordIngresada);
            RegistroUsuarioController reg = new RegistroUsuarioController();
            return reg.buscarUsuarioPorId(id) != null;
        } catch (NumberFormatException e) {
            System.out.println("⚠️ El identificador debe ser numérico.");
            return false;
        }
    }
}

package co.edu.uniquindio.poo.envioproyecto.Controller;

import co.edu.uniquindio.poo.envioproyecto.model.MetodoPago;
import co.edu.uniquindio.poo.envioproyecto.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class LoginUsuarioController {

    private static final String contrasena = "1234";


    public static boolean verificarContrasena(String passwordIngresada) {

        return contrasena.equals(passwordIngresada);
    }
}

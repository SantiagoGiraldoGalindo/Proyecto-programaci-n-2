package co.edu.uniquindio.poo.envioproyecto.Controller;

public class LoginAdministradorController {


    private static final String contrasena = "Admin123";
    public static boolean verificarContrasena(String passwordIngresada) {

        return contrasena.equals(passwordIngresada);
    }
}

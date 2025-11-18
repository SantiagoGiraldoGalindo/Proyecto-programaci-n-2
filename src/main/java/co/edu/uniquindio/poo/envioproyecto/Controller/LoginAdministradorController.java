package co.edu.uniquindio.poo.envioproyecto.Controller;

/**
 * Controlador simple para autenticar el administrador de la aplicación.
 * En la demo utiliza una contraseña fija.
 */
public class LoginAdministradorController {


    private static final String contrasena = "Admin123";
    public static boolean verificarContrasena(String passwordIngresada) {

        return contrasena.equals(passwordIngresada);
    }
}

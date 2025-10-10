package co.edu.uniquindio.poo.envioproyecto.Controller;

public class LoginRepartidorController {

    private static final String contrasena = "Repartidor123";
    public static boolean verificarContrasena(String passwordIngresada) {

        return contrasena.equals(passwordIngresada);
    }
}

package co.edu.uniquindio.poo.envioproyecto.Controller;

/**
 * Helper singleton para mantener la sesión de la aplicación en memoria.
 * Almacena el usuario actualmente autenticado y se usa para filtrar
 * envíos y permisos en controladores.
 */
public final class Session {
    private static Integer currentUserId = null;

    private Session() {}

    public static void setCurrentUserId(Integer id) {
        currentUserId = id;
    }

    public static Integer getCurrentUserId() {
        return currentUserId;
    }

    public static void clear() {
        currentUserId = null;
    }
}

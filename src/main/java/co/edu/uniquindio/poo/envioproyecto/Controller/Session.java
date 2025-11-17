package co.edu.uniquindio.poo.envioproyecto.Controller;

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

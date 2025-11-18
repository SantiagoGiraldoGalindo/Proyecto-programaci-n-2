package co.edu.uniquindio.poo.envioproyecto.model;

/**
 * Representa un administrador del sistema. Actualmente contiene campos
 * básicos como nombre e id y puede ampliarse con privilegios y acciones
 * de gestión en el futuro.
 */
public class Administrador {

    private String nombre;
    private int id;

    public Administrador(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }
}

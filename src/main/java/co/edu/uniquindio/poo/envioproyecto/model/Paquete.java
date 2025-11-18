package co.edu.uniquindio.poo.envioproyecto.model;

/**
 * Representa las características físicas de un paquete a enviar.
 * Se utiliza para la cotización y para decidir prioridades de manipulación.
 */
public class Paquete {

    private int peso;
    private int volumen;
    private int tamano;
    private boolean prioridad;

    public Paquete(int peso, int volumen, int tamano, boolean prioridad) {
        this.peso = peso;
        this.volumen = volumen;
        this.tamano = tamano;
        this.prioridad = prioridad;
    }
}

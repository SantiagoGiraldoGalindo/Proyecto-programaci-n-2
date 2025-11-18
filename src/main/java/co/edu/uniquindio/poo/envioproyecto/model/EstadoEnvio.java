package co.edu.uniquindio.poo.envioproyecto.model;

/**
 * Enumeración simple que representa los estados de alto nivel de un envío.
 * Estos valores se usan para mostrar el estado actual en la UI y para
 * mapeos simples cuando no se requiere lógica completa de la máquina de estados.
 */
public enum EstadoEnvio {
    ASIGNADO, PAGADO, ENRUTA, ENTREGADO, INCIDENCIA
}

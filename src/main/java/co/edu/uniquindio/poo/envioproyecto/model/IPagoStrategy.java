package co.edu.uniquindio.poo.envioproyecto.model;

/**
 * Interfaz para implementar distintas estrategias de pago. Cada implementación
 * debe encargarse de procesar el pago y devolver un mensaje o código resultante.
 */
public interface IPagoStrategy {
    /**
     * Procesa el pago usando la estrategia específica
     * @param monto Cantidad a pagar
     * @param fecha Fecha del pago
     * @return Resultado del procesamiento
     */
    String procesarPago(double monto, String fecha);
}

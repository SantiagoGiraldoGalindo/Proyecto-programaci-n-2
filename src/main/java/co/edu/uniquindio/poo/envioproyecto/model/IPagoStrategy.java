package co.edu.uniquindio.poo.envioproyecto.model;

public interface IPagoStrategy {
    /**
     * Procesa el pago usando la estrategia específica
     * @param monto Cantidad a pagar
     * @param fecha Fecha del pago
     * @return Resultado del procesamiento
     */
    String procesarPago(double monto, String fecha);
}

package co.edu.uniquindio.poo.envioproyecto.model;



/**
 * Proxy que añade validaciones y control de reintentos antes de delegar
 * el procesamiento de un pago a `ContextoPago`/`IPagoStrategy`.
 */
public class PagoProxy {
    private int reintentos = 0;
    private static final int MAX_REINTENTOS = 3;

    /**
     * Método principal del Proxy: valida y delega a ContextoPago (sin interfaz)
     * @param estrategia La IPagoStrategy seleccionada (TARJETA, etc.)
     * @param monto Monto del pago
     * @param fecha Fecha del pago
     * @return Mensaje de resultado (error si inválido, o delegación si OK)
     */
    public String procesarPago(IPagoStrategy estrategia, double monto, String fecha) {
        if (monto <= 0) {
            return "Error Proxy: Monto debe ser positivo.";
        }
        if (!fecha.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return "Error Proxy: Fecha inválida (use YYYY-MM-DD).";
        }
        if (reintentos >= MAX_REINTENTOS) {
            return "Error Proxy: Máximo de reintentos (" + MAX_REINTENTOS + ") alcanzado.";
        }

        reintentos++;  
        ContextoPago contexto = new ContextoPago(estrategia);
        return "Validación Proxy OK. " + contexto.ejecutarPago(monto, fecha);
    }

    public void resetReintentos() {
        this.reintentos = 0;
    }
}
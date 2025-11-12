package co.edu.uniquindio.poo.envioproyecto.model;



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
        // Validaciones generales del Proxy (sin saldo fijo)
        if (monto <= 0) {
            return "Error Proxy: Monto debe ser positivo.";
        }
        if (!fecha.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return "Error Proxy: Fecha inválida (use YYYY-MM-DD).";
        }
        if (reintentos >= MAX_REINTENTOS) {
            return "Error Proxy: Máximo de reintentos (" + MAX_REINTENTOS + ") alcanzado.";
        }

        // Delegar directamente al ContextoPago (envuelve la Strategy)
        reintentos++;  // Control de fallos
        ContextoPago contexto = new ContextoPago(estrategia);
        return "Validación Proxy OK. " + contexto.ejecutarPago(monto, fecha);
    }

    // Método helper para reset reintentos (opcional, llamar desde Controller)
    public void resetReintentos() {
        this.reintentos = 0;
    }
}
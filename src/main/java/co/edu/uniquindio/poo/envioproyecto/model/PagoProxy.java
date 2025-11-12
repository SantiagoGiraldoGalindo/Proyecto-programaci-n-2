package co.edu.uniquindio.poo.envioproyecto.model;

public class PagoProxy {
    private double saldoDisponible;
    private int reintentos;
    private final int REINTENTOS_MAXIMOS = 3;
    
    public PagoProxy(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
        this.reintentos = 0;
    }
    
    /**
     * Procesa el pago aplicando validaciones antes de delegar a Strategy
     * @param estrategia Estrategia de pago a usar
     * @param monto Monto a pagar
     * @param fecha Fecha del pago
     * @return Resultado del procesamiento
     */
    public String procesarPago(IPagoStrategy estrategia, double monto, String fecha) {
        // Validación 1: Verificar que haya estrategia
        if (estrategia == null) {
            return "Proxy: Error - No hay estrategia de pago seleccionada";
        }
        
        // Validación 2: Verificar fondos disponibles
        if (!verificarFondos(monto)) {
            return "Proxy: Pago rechazado - Fondos insuficientes. Saldo disponible: $" + saldoDisponible;
        }
        
        // Validación 3: Verificar fecha válida
        if (!verificarFecha(fecha)) {
            return "Proxy: Pago rechazado - Fecha inválida";
        }
        
        // Validación 4: Verificar número de reintentos
        if (reintentos >= REINTENTOS_MAXIMOS) {
            return "Proxy: Pago rechazado - Número máximo de reintentos alcanzado";
        }
        
        // Si todas las validaciones pasan, delegar a Strategy
        ContextoPago contexto = new ContextoPago(estrategia);
        String resultado = contexto.ejecutarPago(monto, fecha);
        
        // Si el pago fue exitoso, actualizar saldo
        if (resultado.contains("exitosamente")) {
            this.saldoDisponible -= monto;
            this.reintentos = 0; // Resetear reintentos
            return "Proxy: " + resultado + " | Saldo restante: $" + saldoDisponible;
        } else {
            this.reintentos++;
            return "Proxy: " + resultado;
        }
    }
    
    /**
     * Verifica si hay fondos suficientes
     */
    private boolean verificarFondos(double monto) {
        return monto > 0 && monto <= saldoDisponible;
    }
    
    /**
     * Verifica si la fecha es válida (formato YYYY-MM-DD)
     */
    private boolean verificarFecha(String fecha) {
        return fecha != null && !fecha.isEmpty() && 
               fecha.matches("\\d{4}-\\d{2}-\\d{2}");
    }
    
    public double getSaldoDisponible() {
        return saldoDisponible;
    }
    
    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }
    
    public int getReintentos() {
        return reintentos;
    }
    
    public void resetearReintentos() {
        this.reintentos = 0;
    }
}
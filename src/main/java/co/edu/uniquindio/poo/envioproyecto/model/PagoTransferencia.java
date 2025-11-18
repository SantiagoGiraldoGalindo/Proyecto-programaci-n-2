package co.edu.uniquindio.poo.envioproyecto.model;

/**
 * Implementación de pago por transferencia bancaria (demo). Valida datos
 * mínimos de cuenta y banco antes de procesar.
 */
public class PagoTransferencia implements IPagoStrategy {
    private String numeroCuenta;
    private String banco;
    private String titularCuenta;
    
    public PagoTransferencia(String numeroCuenta, String banco, String titularCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.banco = banco;
        this.titularCuenta = titularCuenta;
    }
    
    @Override
    public String procesarPago(double monto, String fecha) {
        if (validarCuenta()) {
            return "Pago por Transferencia: $" + monto + " transferido a " + banco + " el " + fecha;
        } else {
            return "Error: Cuenta bancaria inválida";
        }
    }
    
    private boolean validarCuenta() {
        return numeroCuenta != null && !numeroCuenta.isEmpty() &&
               banco != null && !banco.isEmpty();
    }
    
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    public String getBanco() {
        return banco;
    }
    
    public void setBanco(String banco) {
        this.banco = banco;
    }
    
    public String getTitularCuenta() {
        return titularCuenta;
    }
    
    public void setTitularCuenta(String titularCuenta) {
        this.titularCuenta = titularCuenta;
    }
}
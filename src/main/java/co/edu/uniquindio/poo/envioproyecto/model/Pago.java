package co.edu.uniquindio.poo.envioproyecto.model;

public class Pago {
    private String idPago;
    private double monto;
    private String fecha;
    private String resultado;

    public Pago(String idPago, double monto, String fecha, String resultado) {
        this.idPago = idPago;
        this.monto = monto;
        this.fecha = fecha;
        this.resultado = resultado;

    }

    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}

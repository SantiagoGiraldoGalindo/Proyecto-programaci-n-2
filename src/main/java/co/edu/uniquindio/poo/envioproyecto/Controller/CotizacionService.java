package co.edu.uniquindio.poo.envioproyecto.Controller;

public class CotizacionService {
    private static double ultimaCotizacion = 0.0;
    private static String envioIdForPago = null;

    public static void setUltimaCotizacion(double valor) {
        ultimaCotizacion = valor;
    }

    public static double getUltimaCotizacion() {
        return ultimaCotizacion;
    }

    public static void setEnvioIdForPago(String id) { envioIdForPago = id; }
    public static String getEnvioIdForPago() { return envioIdForPago; }
}

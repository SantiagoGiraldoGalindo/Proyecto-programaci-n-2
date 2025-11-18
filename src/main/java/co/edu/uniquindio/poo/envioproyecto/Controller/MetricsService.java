package co.edu.uniquindio.poo.envioproyecto.Controller;

import co.edu.uniquindio.poo.envioproyecto.model.Envios;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Servicio de métricas para el administrador. Calcula estadísticas básicas
 * a partir de la colección en memoria de envíos (EnviosService.listaEnvios).
 *
 * Nota: la implementación usa los campos disponibles en el modelo actual.
 * Algunas métricas (p.ej. tiempo real de entrega) dependen de que el campo
 * `fecha` tenga formato ISO `yyyy-MM-dd` y que el estado `ENTREGADO` exista.
 */
public class MetricsService {

    private static final DateTimeFormatter ISO_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static class Metrics {
        public double avgDeliveryDays;
        public Map<String, Long> topSizes;
        public double estimatedRevenue; // sum of simple cotizaciones
        public Map<String, Long> incidentsByZone;
    }

    /**
     * Calcula métricas globales a partir de los envíos actuales.
     */
    public static Metrics calculateMetrics() {
        ObservableList<Envios> all = EnviosService.listaEnvios;

        Metrics m = new Metrics();

        List<Long> deliveryDays = new ArrayList<>();
        for (Envios e : all) {
            if (e.getEstado() != null && e.getEstado().name().equalsIgnoreCase("ENTREGADO")) {
                String fecha = e.getFecha();
                if (fecha != null) {
                    try {
                        LocalDate d = LocalDate.parse(fecha, ISO_DATE);
                        long days = ChronoUnit.DAYS.between(d, LocalDate.now());
                        deliveryDays.add(days);
                    } catch (Exception ex) {
                        
                    }
                }
            }
        }
        m.avgDeliveryDays = deliveryDays.isEmpty() ? 0.0 : deliveryDays.stream().mapToLong(Long::longValue).average().orElse(0.0);

       
        Map<String, Long> sizeCounts = all.stream()
                .collect(Collectors.groupingBy(e -> Optional.ofNullable(e.getTamano()).orElse("<sin>").trim(), Collectors.counting()));
    
        m.topSizes = sizeCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (a,b) -> a, LinkedHashMap::new));

        double total = 0.0;
        for (Envios e : all) {
            int volumen = mapTamanoToVolume(e.getTamano());
            int peso = e.getPeso();
            double cot = TarifaService.cotizar(null, e.getDestino(), peso, volumen, false);
            total += cot;
        }
        m.estimatedRevenue = total;

        Map<String, Long> incidents = all.stream()
                .filter(e -> e.getEstado() != null && e.getEstado().name().equalsIgnoreCase("INCIDENCIA"))
                .map(e -> extractZone(e.getDestino()))
                .collect(Collectors.groupingBy(z -> z, Collectors.counting()));
        m.incidentsByZone = incidents.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b)->a, LinkedHashMap::new));

        return m;
    }

    private static int mapTamanoToVolume(String tamano) {
        if (tamano == null) return 1;
        String t = tamano.toLowerCase();
        if (t.contains("peque") || t.contains("small")) return 1;
        if (t.contains("med") || t.contains("medium")) return 5;
        if (t.contains("grand") || t.contains("large")) return 10;
        try {
            return Integer.parseInt(t.replaceAll("[^0-9]",""));
        } catch (Exception ex) {
            return 1;
        }
    }

    private static String extractZone(String destino) {
        if (destino == null || destino.trim().isEmpty()) return "<desconocido>";
        String[] parts = destino.split(",");
        // prefer last part if it looks like a city/zone, else first
        if (parts.length > 1) return parts[parts.length-1].trim();
        String[] toks = destino.split("\\s");
        return toks[toks.length-1].trim();
    }
}

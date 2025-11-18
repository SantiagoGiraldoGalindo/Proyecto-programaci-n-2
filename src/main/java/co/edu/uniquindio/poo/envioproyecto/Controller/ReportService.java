package co.edu.uniquindio.poo.envioproyecto.Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import co.edu.uniquindio.poo.envioproyecto.model.Envios;

/**
 * Utility service to export a list of envíos to CSV or a simple PDF.
 */
public class ReportService {

    /**
     * Export envíos to a CSV file.
     * @param envios list of envíos
     * @param target destination file (should end with .csv)
     * @throws IOException if writing fails
     */
    public static void exportToCsv(List<Envios> envios, File target) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            writer.write("idEnvio,destino,peso,tamano,fecha,estado\n");
            for (Envios e : envios) {
                String fecha = e.getFecha() != null ? e.getFecha() : "";
                String estado = escapeCsv(e.getEstadoDescripcion());
                String destino = escapeCsv(e.getDestino() != null ? e.getDestino() : "");
                writer.write(String.format("%s,%s,%.2f,%s,%s,%s\n",
                    e.getIdEnvio(), destino, (double) e.getPeso(), e.getTamano(), fecha, estado));
            }
        }
    }

    private static String escapeCsv(String s) {
        if (s == null) return "";
        if (s.contains(",") || s.contains("\"") || s.contains("\n")) {
            return "\"" + s.replace("\"", "\"\"") + "\"";
        }
        return s;
    }

    /**
     * Export envíos to a simple PDF file using Apache PDFBox.
     * @param envios list of envíos
     * @param target destination file (should end with .pdf)
     * @throws IOException if writing fails
     */
    public static void exportToPdf(List<Envios> envios, File target) throws IOException {
        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage();
            doc.addPage(page);

            PDPageContentStream contents = new PDPageContentStream(doc, page);
            float margin = 50;
            float yStart = page.getMediaBox().getHeight() - margin;
            float x = margin;
            float y = yStart;

            try {
                contents.beginText();
                contents.setFont(PDType1Font.HELVETICA_BOLD, 18);
                contents.newLineAtOffset(x, y);
                contents.showText("Reporte de Envios");
                contents.endText();

                y -= 30;

                contents.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contents.beginText();
                contents.newLineAtOffset(x, y);
                contents.showText("ID");
                contents.newLineAtOffset(50, 0);
                contents.showText("Destino");
                contents.newLineAtOffset(200, 0);
                contents.showText("Peso");
                contents.newLineAtOffset(50, 0);
                contents.showText("Tamano");
                contents.newLineAtOffset(50, 0);
                contents.showText("Fecha");
                contents.newLineAtOffset(120, 0);
                contents.showText("Estado");
                contents.endText();

                y -= 20;
                contents.setFont(PDType1Font.HELVETICA, 11);

                for (Envios e : envios) {
                    if (y < 80) {
                        contents.close();
                        page = new PDPage();
                        doc.addPage(page);
                        contents = new PDPageContentStream(doc, page);
                        y = page.getMediaBox().getHeight() - margin;
                    }

                    String fecha = e.getFecha() != null ? e.getFecha() : "";
                    String estado = e.getEstadoDescripcion();
                    String destino = e.getDestino() != null ? e.getDestino() : "";

                    contents.beginText();
                    contents.newLineAtOffset(x, y);
                    contents.showText(String.valueOf(e.getIdEnvio()));
                    contents.newLineAtOffset(50, 0);
                    contents.showText(truncate(destino, 30));
                    contents.newLineAtOffset(200, 0);
                    contents.showText(String.format("%.2f", (double) e.getPeso()));
                    contents.newLineAtOffset(50, 0);
                    contents.showText(e.getTamano());
                    contents.newLineAtOffset(50, 0);
                    contents.showText(truncate(fecha, 16));
                    contents.newLineAtOffset(120, 0);
                    contents.showText(truncate(estado, 20));
                    contents.endText();

                    y -= 16;
                }
            } finally {
                if (contents != null) contents.close();
            }

            try (FileOutputStream out = new FileOutputStream(target)) {
                doc.save(out);
            }
        }
    }

    private static String truncate(String s, int max) {
        if (s == null) return "";
        if (s.length() <= max) return s;
        return s.substring(0, max - 3) + "...";
    }
}

package com.example.cuestionario;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import java.io.*;
import java.util.List;

import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Documento {

    private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

    private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

    private static final String iTextExampleImage = "/home/xules/codigoxules/iText-Example-image.png";

    /**
     * We create a PDF document with iText using different elements to learn to
     * use this library. Creamos un documento PDF con iText usando diferentes
     * elementos para aprender a usar esta librería.
     *
     * @param pdfNewFile  <code>String</code> pdf File we are going to write.
     * Fichero pdf en el que vamos a escribir.
     */
    public void createPDF(File pdfNewFile, List<Evaluacion> evaluaciones) {
        // Aquí introduciremos el código para crear el PDF.
        Document document = new Document();
        try {
            try {
                PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No such file was found to generate the PDF "
                        + "(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
            }
            document.open();

            // AQUÍ COMPLETAREMOS NUESTRO CÓDIGO PARA GENERAR EL PDF
            // Utilización de PdfPTable
            // Usamos varios elementos para añadir título y subtítulo
            Anchor anchor = new Anchor("Top del cuestionario", categoryFont);
            anchor.setName("Top del cuestionario");

            Chapter chapTitle = new Chapter(new Paragraph(anchor), 2);
            Paragraph paragraph = new Paragraph("", subcategoryFont);
            Section paragraphMore = chapTitle.addSection(paragraph);
            paragraphMore.add(new Paragraph(""));
            Integer numColumns = 3;
            Integer numRows = 120;
            // Creamos la tabla.
            PdfPTable table = new PdfPTable(numColumns);
            // Ahora llenamos la tabla del PDF
            PdfPCell columnHeader;
            //rellenamos las filas de la tabla.
            columnHeader = new PdfPCell(new Phrase("Cuestionario"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);

            columnHeader = new PdfPCell(new Phrase("Sobrenombre"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);

            columnHeader = new PdfPCell(new Phrase("Puntaje total"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);

            table.setHeaderRows(1);
            //rellenamos las filas de la tabla.

            for (int i = 0; i < evaluaciones.size(); i++) {
                table.addCell(evaluaciones.get(i).getNombreCuestionario());
                table.addCell(evaluaciones.get(i).getSobreNombre());
                table.addCell(evaluaciones.get(i).getPuntajeTotal()+"");
            }
            //Añadimos la tabla
            paragraphMore.add(table);
            //Añadimos el elemento con la tabla.
            document.add(chapTitle);

            document.close();
            System.out.println("¡Se ha generado tu hoja PDF!");
        } catch (DocumentException documentException) {
            System.out.println("Se ha producido un error al generar un documento: " + documentException);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

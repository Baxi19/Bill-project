package Class;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Baxi
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws com.itextpdf.text.DocumentException
     */
    public static void main(String[] args) throws FileNotFoundException, DocumentException, BadElementException, IOException {
        /*
        W_Login w = new W_Login();
        w.setVisible(true);
        */
        
        /*-------------------------------------------------------------------*/
        /*Datos de prueba*/
        Item i = new Item(0, 0, "description", "A/L", 0, 0.420, 0.50);
        Item i2 = new Item(0, 0, "description", "A/L", 0, 0.420, 0.50);
        Item i3 = new Item(0, 0, "description", "A/L", 0, 0.420, 0.50);
        Item i4 = new Item(0, 0, "description", "A/L", 0, 0.420, 0.50);
        Item i5 = new Item(0, 0, "description", "A/L", 0, 0.420, 0.50);
        Item i6 = new Item(0, 0, "description", "A/L", 0, 0.420, 0.50);
        Item i7 = new Item(0, 0, "description", "A/L", 0, 0.420, 0.50);
        Item i8 = new Item(0, 0, "description", "A/L", 0, 0.420, 0.50);
        Item i9 = new Item(0, 0, "description", "A/L", 0, 0.420, 0.50);
        Item i10 = new Item(0, 0, "description", "A/L", 0, 0.420, 0.50);
        Item i11 = new Item(0, 0, "description", "A/L", 0, 0.420, 0.50);
        Item i12 = new Item(0, 0, "description", "A/L", 0, 0.420, 0.50);
        
        Methods.getInstance().cart.add(i);
        Methods.getInstance().cart.add(i2);
        Methods.getInstance().cart.add(i3);
        Methods.getInstance().cart.add(i4);
        Methods.getInstance().cart.add(i5);
        Methods.getInstance().cart.add(i6);
        Methods.getInstance().cart.add(i7);
        Methods.getInstance().cart.add(i8);
        Methods.getInstance().cart.add(i9);
        Methods.getInstance().cart.add(i10);
        Methods.getInstance().cart.add(i11);
        Methods.getInstance().cart.add(i12);
        Methods.getInstance().idBill = 420;
        Methods.getInstance().date = "10-01-2020";
        Methods.getInstance().clientId = 1;
        Methods.getInstance().idNotify = 1;
        
        /*--------------------------------------------------------------------*/
        /*Colores*/
        com.itextpdf.text.Font redFont = FontFactory.getFont("Times New Roman", 10, Font.BOLD, new CMYKColor(0, 255, 0, 0));
        com.itextpdf.text.Font blackFont = FontFactory.getFont("Times New Roman", 14, Font.BOLD, new CMYKColor(255, 255, 255, 0));
        com.itextpdf.text.Font lightblackFont = FontFactory.getFont("Times New Roman", 10, Font.BOLD, new CMYKColor(255, 255, 255, 0));
        com.itextpdf.text.Font black2Font = FontFactory.getFont("Times New Roman", 11,  new CMYKColor(255, 255, 255, 0));
        com.itextpdf.text.Font lightblack2Font = FontFactory.getFont("Times New Roman", 11, new CMYKColor(255, 255, 255, 0));
        /*--------------------------------------------------------------------*/
        /*Creamos el documento*/
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Factura"+Methods.getInstance().idBill+".pdf"));
        
        /*--------------------------------------------------------------------*/
        /*Imagen al documento*/
        
           /* Image header = Image.getInstance("src/Images/header.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            
            Paragraph paragraph = new Paragraph();
            paragraph.setAlignment(Paragraph.ALIGN_CENTER);
            paragraph.add("Factura #:\n\n");
            paragraph.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            paragraph.add("Prueba\n\n");
            */
            /*--------------------------------------------------------------------*/
            document.open();
            //document.add(header);
            /*--------------------------------------------------------------------*/
            /*Se crea una tabla para fecha y # factura*/
            PdfPTable table = new PdfPTable(3); // number of columns.
            table.setWidthPercentage(86); //Width %
            table.setSpacingBefore(7f); //Space before table
            table.setSpacingAfter(7f); //Space after table

            //Set Column widths
            float[] columnWidths = {3f,1f, 1f};
            table.setWidths(columnWidths);

            PdfPCell cell1 = new PdfPCell(new Paragraph(""));
            cell1.setBorderColor(BaseColor.WHITE);
            cell1.setPaddingLeft(10);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell2 = new PdfPCell(new Paragraph("\n\n\nFactura #: ", lightblackFont));
            cell2.setBorderColor(BaseColor.WHITE);
            cell2.setPaddingLeft(10);
            cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell3 = new PdfPCell(new Paragraph("\n\n\n"+Methods.getInstance().idBill + "",  redFont));
            cell3.setBorderColor(BaseColor.WHITE);
            cell3.setPaddingRight(10);
            cell3.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell4 = new PdfPCell(new Paragraph("Fecha : ", lightblackFont));
            cell4.setBorderColor(BaseColor.WHITE);
            cell4.setPaddingLeft(10);
            cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell cell5 = new PdfPCell(new Paragraph(Methods.getInstance().date + "", lightblackFont));
            cell5.setBorderColor(BaseColor.WHITE);
            cell5.setPaddingRight(10);
            cell5.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

            
            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell1);
            table.addCell(cell4);
            table.addCell(cell5);
            document.add(table);
            /*----------------------------------------------------------------*/
            /*Se crea una tabla para fecha y # factura*/
            PdfPTable table2 = new PdfPTable(1); // number of columns.
            table2.setWidthPercentage(86); //Width %
            table2.setSpacingBefore(7f); //Space before table
            table2.setSpacingAfter(7f); //Space after table

            PdfPCell cell6 = new PdfPCell(new Paragraph(Methods.getInstance().boss, blackFont));
            cell6.setBorderColor(BaseColor.WHITE);
            cell6.setPaddingLeft(10);
            cell6.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            
            PdfPCell cell7 = new PdfPCell(new Paragraph(Methods.getInstance().info1, black2Font));
            cell7.setBorderColor(BaseColor.WHITE);
            cell7.setPaddingLeft(10);
            cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell8 = new PdfPCell(new Paragraph(Methods.getInstance().info2+ "\n\n", black2Font));
            cell8.setBorderColor(BaseColor.WHITE);
            cell8.setPaddingLeft(10);
            cell8.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            table2.addCell(cell6);
            table2.addCell(cell7);
            table2.addCell(cell8);
            document.add(table2);
            /*--------------------------------------------------------------------*/
            /*Se crea una tabla para informacion de clientes y noticados*/
            PdfPTable table3 = new PdfPTable(3); // number of columns.
            table3.setWidthPercentage(80); //Width %
            table3.setSpacingBefore(7f); //Space before table
            table3.setSpacingAfter(7f); //Space after table
            
            //Set Column widths
            float[] columnWidths3 = {1f,2f, 2f};
            table3.setWidths(columnWidths3);
            /*Se consultan los datos completos a la BD*/
            SQLLiteMethods.getInstance().getClient(Methods.getInstance().clientId);
            SQLLiteMethods.getInstance().getNotifyTo(Methods.getInstance().clientId);
            
            PdfPCell cell9 = new PdfPCell(new Paragraph("Cliente :", black2Font));
            cell9.setBorderColor(BaseColor.WHITE);
            cell9.setPaddingLeft(10);
            cell9.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell10 = new PdfPCell(new Paragraph(Methods.getInstance().client.getClient(), lightblack2Font));
            cell10.setBorderColor(BaseColor.WHITE);
            cell10.setPaddingLeft(10);
            cell10.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell11 = new PdfPCell(new Paragraph("Notificar a:", black2Font));
            cell11.setBorderColor(BaseColor.WHITE);
            cell11.setPaddingLeft(10);
            cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            
            PdfPCell cell12 = new PdfPCell(new Paragraph("Exporte :", black2Font));
            cell12.setBorderColor(BaseColor.WHITE);
            cell12.setPaddingLeft(10);
            cell12.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell13 = new PdfPCell(new Paragraph(Methods.getInstance().client.getExporte(), lightblack2Font));
            cell13.setBorderColor(BaseColor.WHITE);
            cell13.setPaddingLeft(10);
            cell13.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell13.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell14 = new PdfPCell(new Paragraph(Methods.getInstance().clientNotify.getClient(), lightblack2Font));
            cell14.setBorderColor(BaseColor.WHITE);
            cell14.setPaddingLeft(10);
            cell14.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell14.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            
            PdfPCell cell15 = new PdfPCell(new Paragraph("Direción :", black2Font));
            cell15.setBorderColor(BaseColor.WHITE);
            cell15.setPaddingLeft(10);
            cell15.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell15.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell16 = new PdfPCell(new Paragraph(Methods.getInstance().client.getDireccion(), lightblack2Font));
            cell16.setBorderColor(BaseColor.WHITE);
            cell16.setPaddingLeft(10);
            cell16.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell16.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell17 = new PdfPCell(new Paragraph(Methods.getInstance().clientNotify.getExporte(), lightblack2Font));
            cell17.setBorderColor(BaseColor.WHITE);
            cell17.setPaddingLeft(10);
            cell17.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell17.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            
            PdfPCell cell18 = new PdfPCell(new Paragraph("Teléfono :", black2Font));
            cell18.setBorderColor(BaseColor.WHITE);
            cell18.setPaddingLeft(10);
            cell18.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell18.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell19 = new PdfPCell(new Paragraph(Methods.getInstance().client.getTelefono(), lightblack2Font));
            cell19.setBorderColor(BaseColor.WHITE);
            cell19.setPaddingLeft(10);
            cell19.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell19.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell20 = new PdfPCell(new Paragraph(Methods.getInstance().clientNotify.getDireccion(), lightblack2Font));
            cell20.setBorderColor(BaseColor.WHITE);
            cell20.setPaddingLeft(10);
            cell20.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell20.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            
            PdfPCell cell21 = new PdfPCell(new Paragraph("Email :", black2Font));
            cell21.setBorderColor(BaseColor.WHITE);
            cell21.setPaddingLeft(10);
            cell21.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell21.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell22 = new PdfPCell(new Paragraph(Methods.getInstance().client.getEmail(), lightblack2Font));
            cell22.setBorderColor(BaseColor.WHITE);
            cell22.setPaddingLeft(10);
            cell22.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell22.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell23 = new PdfPCell(new Paragraph(Methods.getInstance().clientNotify.getTelefono(), lightblack2Font));
            cell23.setBorderColor(BaseColor.WHITE);
            cell23.setPaddingLeft(10);
            cell23.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell23.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell24 = new PdfPCell(new Paragraph(Methods.getInstance().clientNotify.getEmail(), lightblack2Font));
            cell24.setBorderColor(BaseColor.WHITE);
            cell24.setPaddingLeft(10);
            cell24.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell24.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            table3.addCell(cell9);
            table3.addCell(cell10);
            table3.addCell(cell11);
            table3.addCell(cell12);
            table3.addCell(cell13);
            table3.addCell(cell14);
            table3.addCell(cell15);
            table3.addCell(cell16);
            table3.addCell(cell17);
            table3.addCell(cell18);
            table3.addCell(cell19);
            table3.addCell(cell20);
            table3.addCell(cell21);
            table3.addCell(cell22);
            table3.addCell(cell23);
            table3.addCell(cell1);
            table3.addCell(cell1);
            table3.addCell(cell24);
            document.add(table3);
            
            /*--------------------------------------------------------------------*/

            PdfPTable tableItems = new PdfPTable(7);
            tableItems.addCell("Cajones");
            tableItems.addCell("Unidades");
            tableItems.addCell("Descripción");
            tableItems.addCell("Spec");
            tableItems.addCell("Altura");
            tableItems.addCell("PrecioUnit");
            tableItems.addCell("Total");
            System.out.println(Methods.getInstance().cart.size());
            for (Item item : Methods.getInstance().cart) {
                tableItems.addCell(item.getBox()+"");
                tableItems.addCell(item.getQuantity()+"");
                tableItems.addCell(item.getDescription());
                tableItems.addCell(item.getSpec());
                tableItems.addCell(item.getSize()+"");
                tableItems.addCell(item.getPriceUnit()+"");
                tableItems.addCell(item.getTotal()+"");
            }
            document.add(tableItems);

            document.close();

        

/*-------------------*/
    
        
    }
        

   

}

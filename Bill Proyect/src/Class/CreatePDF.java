/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author Baxi
 */
public class CreatePDF {
    public static CreatePDF instance = null;
    /*------------------------------------------------------------------------*/
    //Singleton
    public static CreatePDF getInstance() {
        if (instance == null) {
            return instance = new CreatePDF();
        }
        return instance;
    }
    /*------------------------------------------------------------------------*/
    public void newPDF(){
        
        /*Colores*/
        com.itextpdf.text.Font redFont = FontFactory.getFont("Times New Roman", 10, Font.BOLD, new CMYKColor(0, 255, 0, 0));
        com.itextpdf.text.Font blackFont = FontFactory.getFont("Times New Roman", 14, Font.BOLD, new CMYKColor(255, 255, 255, 0));
        com.itextpdf.text.Font lightblackFont = FontFactory.getFont("Times New Roman", 10, Font.BOLD, new CMYKColor(255, 255, 255, 0));
        com.itextpdf.text.Font black2Font = FontFactory.getFont("Times New Roman", 11, new CMYKColor(255, 255, 255, 0));
        com.itextpdf.text.Font lightblack2Font = FontFactory.getFont("Times New Roman", 10, new CMYKColor(255, 255, 255, 0));
        com.itextpdf.text.Font lightblack3Font = FontFactory.getFont("Times New Roman", 10, Font.BOLD,new CMYKColor(255, 255, 255, 0));
        BaseColor greenFont = new BaseColor(95,158,160); 
        /*Creamos el documento*/
        Document document = new Document();
        try {
            
        
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Factura"+Methods.getInstance().idBill+".pdf"));
        
        /*--------------------------------------------------------------------*/
        
            /*--------------------------------------------------------------------*/
            document.open();
            
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
            float[] columnWidths3 = {0.7f,2f, 2f};
            table3.setWidths(columnWidths3);
            /*Se consultan los datos completos a la BD*/
            SQLLiteMethods.getInstance().getClient(Methods.getInstance().clientId);
            SQLLiteMethods.getInstance().getNotifyTo(Methods.getInstance().idNotify);
            
            PdfPCell cell9 = new PdfPCell(new Paragraph("Cliente :", lightblack3Font));
            cell9.setBorderColor(BaseColor.WHITE);
            cell9.setPaddingLeft(10);
            cell9.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell10 = new PdfPCell(new Paragraph(Methods.getInstance().client.getClient(), lightblack2Font));
            cell10.setBorderColor(BaseColor.WHITE);
            cell10.setPaddingLeft(10);
            cell10.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell11 = new PdfPCell(new Paragraph("Notificar a:", lightblack3Font));
            cell11.setBorderColor(BaseColor.WHITE);
            cell11.setPaddingLeft(10);
            cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            
            PdfPCell cell12 = new PdfPCell(new Paragraph("Exporte :", lightblack3Font));
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
            
            
            PdfPCell cell15 = new PdfPCell(new Paragraph("Direción :", lightblack3Font));
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
            
            
            PdfPCell cell18 = new PdfPCell(new Paragraph("Teléfono :", lightblack3Font));
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
            
            
            PdfPCell cell21 = new PdfPCell(new Paragraph("Email :", lightblack3Font));
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
            
            tableItems.setWidthPercentage(86); //Width %
            tableItems.setSpacingBefore(7f); //Space before table
            tableItems.setSpacingAfter(7f); //Space after table
            //Set Column widths
            float[] columnWidths4 = {3f,3f,6f,2f,2f,3f,3f};
            tableItems.setWidths(columnWidths4);
            
            PdfPCell cell_1 = new PdfPCell(new Phrase("Cajones"));
            cell_1.setBackgroundColor(greenFont);
            cell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell_2 = new PdfPCell(new Phrase("Unidades"));
            cell_2.setBackgroundColor(greenFont);
            cell_2.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell_3 = new PdfPCell(new Phrase("Descripción"));
            cell_3.setBackgroundColor(greenFont);
            cell_3.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell_4 = new PdfPCell(new Phrase("Spec"));
            cell_4.setBackgroundColor(greenFont);
            cell_4.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell_5 = new PdfPCell(new Phrase("Altura"));
            cell_5.setBackgroundColor(greenFont);
            cell_5.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell_6 = new PdfPCell(new Phrase("PrecioUnit"));
            cell_6.setBackgroundColor(greenFont);
            cell_6.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell_7 = new PdfPCell(new Phrase("Total"));
            cell_7.setBackgroundColor(greenFont);
            cell_7.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            tableItems.addCell(cell_1);
            tableItems.addCell(cell_2);
            tableItems.addCell(cell_3);
            tableItems.addCell(cell_4);
            tableItems.addCell(cell_5);
            tableItems.addCell(cell_6);
            tableItems.addCell(cell_7);
            
            System.out.println(Methods.getInstance().cart.size());
            for (Item item : Methods.getInstance().cart) {
                tableItems.addCell(item.getBox()+"");
                tableItems.addCell(item.getQuantity()+"");
                tableItems.addCell(item.getDescription());
                tableItems.addCell(item.getSpec());
                tableItems.addCell((item.getSize()+" ″"));
                tableItems.addCell(item.getPriceUnit()+"");
                tableItems.addCell(item.getTotal()+"");
            }
            table.setHorizontalAlignment(Element.ALIGN_LEFT);
            document.add(tableItems);
            
            } catch (DocumentException | FileNotFoundException e) {
        }
            /*--------------------------------------------------------------------*/
            document.close();
    }
}

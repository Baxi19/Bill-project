/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
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
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
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
        com.itextpdf.text.Font black = FontFactory.getFont("Times New Roman", 10, Font.BOLD , new CMYKColor(255, 255, 255, 0));
        com.itextpdf.text.Font blackLight = FontFactory.getFont("Times New Roman", 10 ,Font.BOLD , new CMYKColor(255, 255, 255, 0));
        BaseColor greenFont = new BaseColor(95,158,160); 
        
        /*Creamos el documento*/
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Factura"+Methods.getInstance().idBill+".pdf"));
            
            document.addAuthor("Plantas Hermanos Araya");
            document.addCreator("Carlos Manuel Araya Castro");
            document.addTitle("Factura"+Methods.getInstance().idBill);
            document.addSubject("Email: arca56@hotmail.com 1km Oeste de la Guardia Rural La Tigra, San Carlos");
            /*--------------------------------------------------------------------*/
            document.open();
            /*--------------------------------------------------------------------*/
            /*Date and bill information*/
            PdfPTable tableBillInformation = new PdfPTable(3); // number of columns.
            tableBillInformation.setWidthPercentage(86); //Width %
            tableBillInformation.setSpacingBefore(7f); //Space before table
            tableBillInformation.setSpacingAfter(7f); //Space after table

            //Set Column widths
            float[] columnWidths = {3f,1f, 1f};
            tableBillInformation.setWidths(columnWidths);

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

            PdfPCell cell5 = new PdfPCell(new Paragraph(Methods.getInstance().dateNewBill + "", lightblackFont));
            cell5.setBorderColor(BaseColor.WHITE);
            cell5.setPaddingRight(10);
            cell5.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

            
            tableBillInformation.addCell(cell1);
            tableBillInformation.addCell(cell2);
            tableBillInformation.addCell(cell3);
            tableBillInformation.addCell(cell1);
            tableBillInformation.addCell(cell4);
            tableBillInformation.addCell(cell5);
            document.add(tableBillInformation);
            /*----------------------------------------------------------------*/
            /*Boss information*/
            PdfPTable tableBossInformation = new PdfPTable(1); // number of columns.
            tableBossInformation.setWidthPercentage(86); //Width %
            tableBossInformation.setSpacingBefore(7f); //Space before table
            tableBossInformation.setSpacingAfter(7f); //Space after table

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
            
            tableBossInformation.addCell(cell6);
            tableBossInformation.addCell(cell7);
            tableBossInformation.addCell(cell8);
            document.add(tableBossInformation);
            
            /*--------------------------------------------------------------------*/
            /*clients information*/
            PdfPTable tableClientsInformation = new PdfPTable(3); // number of columns.
            tableClientsInformation.setWidthPercentage(80); //Width %
            tableClientsInformation.setSpacingBefore(7f); //Space before table
            tableClientsInformation.setSpacingAfter(7f); //Space after table
            
            //Set Column widths
            float[] columnWidths3 = {0.7f,2f, 2f};
            tableClientsInformation.setWidths(columnWidths3);
            
            SQLiteMethods.getInstance().getClient(Methods.getInstance().clientId);
            SQLiteMethods.getInstance().getNotifyTo(Methods.getInstance().idNotify);
            
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
            
            PdfPCell cell20 = new PdfPCell(new Paragraph(Methods.getInstance().clientNotify.getDireccion(), lightblack2Font));
            cell20.setBorderColor(BaseColor.WHITE);
            cell20.setPaddingLeft(10);
            cell20.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell20.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
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
            
            PdfPCell cell23 = new PdfPCell(new Paragraph(Methods.getInstance().clientNotify.getTelefono(), lightblack2Font));
            cell23.setBorderColor(BaseColor.WHITE);
            cell23.setPaddingLeft(10);
            cell23.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell23.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
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
            
            PdfPCell cell24 = new PdfPCell(new Paragraph(Methods.getInstance().clientNotify.getEmail(), lightblack2Font));
            cell24.setBorderColor(BaseColor.WHITE);
            cell24.setPaddingLeft(10);
            cell24.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell24.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            tableClientsInformation.addCell(cell9);
            tableClientsInformation.addCell(cell10);
            tableClientsInformation.addCell(cell11);
            tableClientsInformation.addCell(cell12);
            tableClientsInformation.addCell(cell13);
            tableClientsInformation.addCell(cell14);
            tableClientsInformation.addCell(cell15);
            tableClientsInformation.addCell(cell16);
            tableClientsInformation.addCell(cell20);
            tableClientsInformation.addCell(cell18);
            tableClientsInformation.addCell(cell19);
            tableClientsInformation.addCell(cell23);
            tableClientsInformation.addCell(cell21);
            tableClientsInformation.addCell(cell22);
            tableClientsInformation.addCell(cell24);
            document.add(tableClientsInformation);
            
            /*--------------------------------------------------------------------*/
            /*Products information*/
            PdfPTable tableItems = new PdfPTable(7);
            tableItems.setWidthPercentage(86); //Width %
            tableItems.setSpacingBefore(7f); //Space before table
            tableItems.setSpacingAfter(7f); //Space after table
            //Set Column widths
            float[] columnWidths4 = {3f,3f,6f,2f,2f,3f,3f};
            tableItems.setWidths(columnWidths4);
            /*Header*/
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
            /*Body table's information*/
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
            //tableItems.setHorizontalAlignment(Element.ALIGN_LEFT);
            document.add(tableItems);
            /*--------------------------------------------------------------------*/
            /*Sum of items*/
            PdfPTable tableCalculateSum = new PdfPTable(7); // number of columns.
            tableCalculateSum.setWidthPercentage(86); //Width %
            tableCalculateSum.setSpacingBefore(7f); //Space before table
            tableCalculateSum.setSpacingAfter(7f); //Space after table
            //Set Column widths
           
            float[] columnWidths5 = {3f,3f,8f,0f,5f,1f,3f};
            tableCalculateSum.setWidths(columnWidths5);
            
            PdfPCell cell_10 = new PdfPCell(new Phrase(Methods.getInstance().totalBox+"", black));
            cell_10.setBorderColor(BaseColor.WHITE);
            cell_10.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell_10.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell_11 = new PdfPCell(new Phrase(Methods.getInstance().totalQuantity+"", black));
            cell_11.setBorderColor(BaseColor.WHITE);
            cell_11.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell_11.setVerticalAlignment(Element.ALIGN_MIDDLE);
             
            PdfPCell cell_12 = new PdfPCell(new Phrase(Methods.getInstance().plants+"", black));
            cell_12.setBorderColor(BaseColor.WHITE);
            cell_12.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell_12.setVerticalAlignment(Element.ALIGN_MIDDLE);
             
            PdfPCell cell_13 = new PdfPCell(new Phrase("Subtotal:", black));
            cell_13.setBorderColor(BaseColor.WHITE);
            cell_13.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell_13.setVerticalAlignment(Element.ALIGN_MIDDLE);
             
            PdfPCell cell_14 = new PdfPCell(new Phrase(Methods.getInstance().subTotal+"", black));
            cell_14.setBorderColor(BaseColor.WHITE);
            cell_14.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell_14.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell_15 = new PdfPCell(new Phrase("Costo embarque:", black));
            cell_15.setBorderColor(BaseColor.WHITE);
            cell_15.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell_15.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            if(Methods.getInstance().embarque == null){
                Methods.getInstance().embarque = 0.0;
            }
            
            PdfPCell cell_16 = new PdfPCell(new Phrase(Methods.getInstance().embarque+"", black));
            cell_16.setBorderColor(BaseColor.WHITE);
            cell_16.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell_16.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell_17 = new PdfPCell(new Phrase("Descuento:", black));
            cell_17.setBorderColor(BaseColor.WHITE);
            cell_17.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell_17.setVerticalAlignment(Element.ALIGN_MIDDLE);
             
            PdfPCell cell_18 = new PdfPCell(new Phrase(Methods.getInstance().disccount+ "", black));
            cell_18.setBorderColor(BaseColor.WHITE);
            cell_18.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell_18.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cell_19 = new PdfPCell(new Phrase("Total:", black));
            cell_19.setBorderColor(BaseColor.WHITE);
            cell_19.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell_19.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            String aux = Methods.getInstance().df2.format(Double.parseDouble(Methods.getInstance().total+""));
            
            PdfPCell cell_20 = new PdfPCell(new Phrase(Double.parseDouble(aux)+ "", black));
            cell_20.setBorderColor(BaseColor.WHITE);
            cell_20.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell_20.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell cel = new PdfPCell(new Paragraph(" $ ", black));
            cel.setBorderColor(BaseColor.WHITE);
            cel.setHorizontalAlignment(Element.ALIGN_LEFT);
            cel.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            tableCalculateSum.addCell(cell_10);
            tableCalculateSum.addCell(cell_11);
            tableCalculateSum.addCell(cell_12);
            tableCalculateSum.addCell(cell1);
            tableCalculateSum.addCell(cell_13);
            tableCalculateSum.addCell(cel);
            tableCalculateSum.addCell(cell_14);
            
            tableCalculateSum.addCell(cell1);
            tableCalculateSum.addCell(cell1);
            tableCalculateSum.addCell(cell1);
            tableCalculateSum.addCell(cell1);
            tableCalculateSum.addCell(cell_15);
            tableCalculateSum.addCell(cel);
            tableCalculateSum.addCell(cell_16);
            
            tableCalculateSum.addCell(cell1);
            tableCalculateSum.addCell(cell1);
            tableCalculateSum.addCell(cell1);
            tableCalculateSum.addCell(cell1);
            tableCalculateSum.addCell(cell_17);
            tableCalculateSum.addCell(cel);
            tableCalculateSum.addCell(cell_18);
            
            tableCalculateSum.addCell(cell1);
            tableCalculateSum.addCell(cell1);
            tableCalculateSum.addCell(cell1);
            tableCalculateSum.addCell(cell1);
            tableCalculateSum.addCell(cell_19);
            tableCalculateSum.addCell(cel);
            tableCalculateSum.addCell(cell_20);
            
            document.add(tableCalculateSum);
            /*----------------------------------------------------------------*/
            /*Aditional information*/
            PdfPTable tableAditionalInformation = new PdfPTable(4); // number of columns.
            tableAditionalInformation.setWidthPercentage(86); //Width %
            tableAditionalInformation.setSpacingBefore(7f); //Space before table
            tableAditionalInformation.setSpacingAfter(7f); //Space after table
            //Set Column widths
           
            float[] columnWidthsAditionalInfo = {1.7f,3f,2.3f,3.3f};
            tableAditionalInformation.setWidths(columnWidthsAditionalInfo);
            /*--------------------*/
            PdfPCell c0 = new PdfPCell(new Paragraph("Embarque: ", black));
            c0.setBorderColor(BaseColor.WHITE);
            c0.setPaddingLeft(10);
            c0.setHorizontalAlignment(Element.ALIGN_LEFT);
            c0.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Chunk underlineShipment = new Chunk(Methods.getInstance().modifyString(Methods.getInstance().shipment), black);
            underlineShipment.setUnderline(0.1f, -2f); 
            
            PdfPCell c1 = new PdfPCell(new Phrase(underlineShipment));
            c1.setBorderColor(BaseColor.WHITE);
            c1.setPaddingLeft(10);
            c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            c1.setBorderColorTop(BaseColor.BLACK);
            
            /*--------------------*/
            PdfPCell c2 = new PdfPCell(new Paragraph("Marchamo: ", black));
            c2.setBorderColor(BaseColor.WHITE);
            c2.setPaddingLeft(10);
            c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Chunk underlineLabel = new Chunk(Methods.getInstance().modifyString(Methods.getInstance().label), black);
            underlineLabel.setUnderline(0.1f, -2f); 
            
            PdfPCell c3 = new PdfPCell(new Phrase(underlineLabel));
            c3.setBorderColor(BaseColor.WHITE);
            c3.setPaddingLeft(10);
            c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            /*--------------------*/
            PdfPCell c4 = new PdfPCell(new Paragraph("Peso Neto: ", black));
            c4.setBorderColor(BaseColor.WHITE);
            c4.setPaddingLeft(10);
            c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Chunk underlineNetWeight = new Chunk(Methods.getInstance().modifyString(Methods.getInstance().netWeight), blackLight);
            underlineNetWeight.setUnderline(0.1f, -2f); 
            
            PdfPCell c5 = new PdfPCell(new Phrase(underlineNetWeight));
            c5.setBorderColor(BaseColor.WHITE);
            c5.setPaddingLeft(10);
            c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            c5.setBorderColorTop(BaseColor.BLACK);
            /*--------------------*/
            PdfPCell c6 = new PdfPCell(new Paragraph("Booking: ", black));
            c6.setBorderColor(BaseColor.WHITE);
            c6.setPaddingLeft(10);
            c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Chunk underlineBooking = new Chunk(Methods.getInstance().modifyString(Methods.getInstance().booking), blackLight);
            underlineBooking.setUnderline(0.1f, -2f); 
            
            PdfPCell c7 = new PdfPCell(new Phrase(underlineBooking));
            c7.setBorderColor(BaseColor.WHITE);
            c7.setPaddingLeft(10);
            c7.setHorizontalAlignment(Element.ALIGN_LEFT);
            c7.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            /*--------------------*/
            PdfPCell c8 = new PdfPCell(new Paragraph("Peso Bruto: ", black));
            c8.setBorderColor(BaseColor.WHITE);
            c8.setPaddingLeft(10);
            c8.setHorizontalAlignment(Element.ALIGN_LEFT);
            c8.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Chunk underlineGrossWeight = new Chunk(Methods.getInstance().modifyString(Methods.getInstance().grossWeight), blackLight);
            underlineGrossWeight.setUnderline(0.1f, -2f); 
            
            PdfPCell c9 = new PdfPCell(new Phrase(underlineGrossWeight));
            c9.setBorderColor(BaseColor.WHITE);
            c9.setPaddingLeft(10);
            c9.setHorizontalAlignment(Element.ALIGN_LEFT);
            c9.setVerticalAlignment(Element.ALIGN_MIDDLE);
            c9.setBorderColorTop(BaseColor.BLACK);
            
            /*--------------------*/
            PdfPCell c10 = new PdfPCell(new Paragraph("Puerto de salida: ", black));
            c10.setBorderColor(BaseColor.WHITE);
            c10.setPaddingLeft(10);
            c10.setHorizontalAlignment(Element.ALIGN_LEFT);
            c10.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            
            String outPort = Methods.getInstance().outPort;
            String[] dataOutPort = outPort.split("\\) ");
            Chunk underlineOutPort = new Chunk(Methods.getInstance().modifyString(dataOutPort[1]), black);
            underlineOutPort.setUnderline(0.1f, -2f); 
            
            PdfPCell c11 = new PdfPCell(new Phrase(underlineOutPort));
            c11.setBorderColor(BaseColor.WHITE);
            c11.setPaddingLeft(10);
            c11.setHorizontalAlignment(Element.ALIGN_LEFT);
            c11.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            /*--------------------*/
            PdfPCell c12 = new PdfPCell(new Paragraph("Contenedor: ", black));
            c12.setBorderColor(BaseColor.WHITE);
            c12.setPaddingLeft(10);
            c12.setHorizontalAlignment(Element.ALIGN_LEFT);
            c12.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            
            Chunk underlineContainer = new Chunk(Methods.getInstance().modifyString(Methods.getInstance().container), black);
            underlineContainer.setUnderline(0.1f, -2f); 
            
            PdfPCell c13 = new PdfPCell(new Phrase(underlineContainer));
            c13.setBorderColor(BaseColor.WHITE);
            c13.setPaddingLeft(10);
            c13.setHorizontalAlignment(Element.ALIGN_LEFT);
            c13.setVerticalAlignment(Element.ALIGN_MIDDLE);
            c13.setBorderColorTop(BaseColor.BLACK);
            /*--------------------*/
            PdfPCell c14 = new PdfPCell(new Paragraph("Puerto de entrada: ", black));
            c14.setBorderColor(BaseColor.WHITE);
            c14.setPaddingLeft(10);
            c14.setHorizontalAlignment(Element.ALIGN_LEFT);
            c14.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            String inPort = Methods.getInstance().inPort;
            String[] dataInPort = inPort.split("\\) ");
            Chunk underlineInPort = new Chunk(Methods.getInstance().modifyString(dataInPort[1]), black);
            underlineInPort.setUnderline(0.1f, -2f); 
            
            PdfPCell c15 = new PdfPCell(new Phrase(underlineInPort));
            c15.setBorderColor(BaseColor.WHITE);
            c15.setPaddingLeft(10);
            c15.setHorizontalAlignment(Element.ALIGN_LEFT);
            c15.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            /*--------------------*/
            PdfPCell c16 = new PdfPCell(new Paragraph("Barco: ", black));
            c16.setBorderColor(BaseColor.WHITE);
            c16.setPaddingLeft(10);
            c16.setHorizontalAlignment(Element.ALIGN_LEFT);
            c16.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            
            Chunk underlineShip = new Chunk(Methods.getInstance().modifyString(Methods.getInstance().ship), black);
            underlineShip.setUnderline(0.1f, -2f); 
            
            PdfPCell c17 = new PdfPCell(new Phrase(underlineShip));
            c17.setBorderColor(BaseColor.WHITE);
            c17.setPaddingLeft(10);
            c17.setHorizontalAlignment(Element.ALIGN_LEFT);
            c17.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            /*--------------------*/
            PdfPCell c18 = new PdfPCell(new Paragraph("País origen: ", black));
            c18.setBorderColor(BaseColor.WHITE);
            c18.setPaddingLeft(10);
            c18.setHorizontalAlignment(Element.ALIGN_LEFT);
            c18.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            String originCountry = Methods.getInstance().originCountry;
            String[] dataOriginCountry = originCountry.split("\\) ");
            Chunk underlineOriginCountry = new Chunk(Methods.getInstance().modifyString(dataOriginCountry[1]), black);
            underlineOriginCountry.setUnderline(0.1f, -2f); 
            
            PdfPCell c19 = new PdfPCell(new Phrase(underlineOriginCountry));
            c19.setBorderColor(BaseColor.WHITE);
            c19.setPaddingLeft(10);
            c19.setHorizontalAlignment(Element.ALIGN_LEFT);
            c19.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            /*--------------------*/
            PdfPCell c20 = new PdfPCell(new Paragraph("País destino: ", black));
            c20.setBorderColor(BaseColor.WHITE);
            c20.setPaddingLeft(10);
            c20.setHorizontalAlignment(Element.ALIGN_LEFT);
            c20.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            String destinationCountry = Methods.getInstance().destinationCountry;
            String[] dataDestinationCountry = destinationCountry.split("\\) ");
            Chunk underlineDestinationCountry = new Chunk(Methods.getInstance().modifyString(dataDestinationCountry[1]), black);
            underlineDestinationCountry.setUnderline(0.1f, -2f); 
            
            PdfPCell c21 = new PdfPCell(new Phrase(underlineDestinationCountry));
            c21.setBorderColor(BaseColor.WHITE);
            c21.setPaddingLeft(10);
            c21.setHorizontalAlignment(Element.ALIGN_LEFT);
            c21.setVerticalAlignment(Element.ALIGN_MIDDLE);
            /*--------------------*/
            
            tableAditionalInformation.addCell(c0);
            tableAditionalInformation.addCell(c1);
            tableAditionalInformation.addCell(c2);
            tableAditionalInformation.addCell(c3);
            
            tableAditionalInformation.addCell(c4);
            tableAditionalInformation.addCell(c5);
            tableAditionalInformation.addCell(c6);
            tableAditionalInformation.addCell(c7);
            
            tableAditionalInformation.addCell(c8);
            tableAditionalInformation.addCell(c9);
            tableAditionalInformation.addCell(c10);
            tableAditionalInformation.addCell(c11);
            
            tableAditionalInformation.addCell(c12);
            tableAditionalInformation.addCell(c13);
            tableAditionalInformation.addCell(c14);
            tableAditionalInformation.addCell(c15);
            
            tableAditionalInformation.addCell(c16);
            tableAditionalInformation.addCell(c17);
            tableAditionalInformation.addCell(c18);
            tableAditionalInformation.addCell(c19);
            
            tableAditionalInformation.addCell(cell1);
            tableAditionalInformation.addCell(cell1);
            tableAditionalInformation.addCell(c20);
            tableAditionalInformation.addCell(c21);
            
            document.add(tableAditionalInformation);
            /*----------------------------------------------------------------*/
            /*Sing*/
            PdfPTable tableSing = new PdfPTable(1); // number of columns.
            tableSing.setWidthPercentage(86); //Width %
            tableSing.setSpacingBefore(7f); //Space before table
            tableSing.setSpacingAfter(7f); //Space after table

            PdfPCell c_1 = new PdfPCell(new Paragraph(Methods.getInstance().line, blackLight));
            c_1.setBorderColor(BaseColor.WHITE);
            c_1.setPaddingLeft(10);
            c_1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell c_2 = new PdfPCell(new Paragraph(Methods.getInstance().ced, blackLight));
            c_2.setBorderColor(BaseColor.WHITE);
            c_2.setPaddingLeft(10);
            c_2.setHorizontalAlignment(Element.ALIGN_CENTER);
            c_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell c_3 = new PdfPCell(new Paragraph(Methods.getInstance().shortLine, blackLight));
            c_3.setBorderColor(BaseColor.WHITE);
            c_3.setPaddingLeft(10);
            c_3.setHorizontalAlignment(Element.ALIGN_CENTER);
            c_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            tableSing.addCell(cell1);
            tableSing.addCell(c_1);
            tableSing.addCell(c_2);
            tableSing.addCell(c_3);
            document.add(tableSing);
            
            /*Chunk linebreak = new Chunk(new DottedLineSeparator());
            document.add(linebreak);*/
            /*----------------------------------*/
          /*  PdfPTable table = new PdfPTable(4); // number of columns.
            table.setWidthPercentage(86); //Width %
            table.setSpacingBefore(7f); //Space before table
            table.setSpacingAfter(7f); //Space after table
            
            float[] columnWidthsTable = {1.3f,2f,2f,3f};
            table.setWidths(columnWidthsTable);
            
            PdfPCell a_1 = new PdfPCell(new Paragraph("Embarque: ", black));
            a_1.setBorderColor(BaseColor.WHITE);
            a_1.setPaddingLeft(10);
            a_1.setHorizontalAlignment(Element.ALIGN_LEFT);
            a_1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell a_2 = new PdfPCell(new Paragraph(new Chunk(new DottedLineSeparator())));
            a_2.setBorderColor(BaseColor.WHITE);
            a_2.setPaddingLeft(10);
            a_2.setHorizontalAlignment(Element.ALIGN_LEFT);
            a_2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell a_3 = new PdfPCell(new Paragraph("Marchamo:", black));
            a_3.setBorderColor(BaseColor.WHITE);
            a_3.setPaddingLeft(10);
            a_3.setHorizontalAlignment(Element.ALIGN_LEFT);
            a_3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Chunk underline = new Chunk(Methods.getInstance().modifyString(""), black);
            underline.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
            
            PdfPCell a_4 = new PdfPCell(new Paragraph(underline));
            a_4.setBorderColor(BaseColor.WHITE);
            a_4.setPaddingLeft(10);
            a_4.setHorizontalAlignment(Element.ALIGN_LEFT);
            a_4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            table.addCell(a_1);
            table.addCell(a_2);
            table.addCell(a_3);
            table.addCell(a_4);
            
            document.add(table);
            */
            
            
            } catch (DocumentException | FileNotFoundException e) {
                System.out.println("Error = " + e);
            }
        
        document.close();
        /*----------------------------------------------------------------*/
        
    }
}

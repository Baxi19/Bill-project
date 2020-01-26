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
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Baxi
 */
public class Methods {
    /*------------------------------------------------------------------------*/
    /*VARS*/
    public static Methods instance = null;
    public ArrayList<Item> cart = new ArrayList<Item>();
    public int idBill;
    public String date;
    public int clientId;
    public int idNotify;
    public Client client = new Client();
    public Client clientNotify = new Client();
    public DecimalFormat df2 = new DecimalFormat("#.##");
    public String boss = "Carlos Manuel Araya Castro, Plantas Hnos Araya";
    public String info1 = "Ced: 2-356-370 Cod.Exportador: FR4 Telefax: +506 2468 8037 Celular :+506 8340 4813";
    public String info2 = "Email: arca56@hotmail.com 1km Oeste de la Guardia Rural La Tigra, San Carlos";
    /*------------------------------------------------------------------------*/
    //Singleton
    public static Methods getInstance() {
        if (instance == null) {
            return instance = new Methods();
        }
        return instance;
    }
    /*------------------------------------------------------------------------*/
    public String getLocalDate() {
        String fecha = "Fecha : " 
                        + LocalDate.now().getDayOfMonth() + "-" 
                        + LocalDate.now().getMonthValue() + "-" 
                        + LocalDate.now().getYear()+"             ";
        return fecha;
    }
    /*------------------------------------------------------------------------*/
    public Document  setAtributes(Document document, String author, String creator, int numero_factura ){
        document.addAuthor(author);/*Nombre Empresa Vendedora*/
        document.addCreationDate();
        document.addCreator(creator);/*Dueno de empresa*/
        document.addTitle("Factura : " + numero_factura);/*Numero Ingresado por usuario*/
        return document;
    }
    /*------------------------------------------------------------------------*/
    public void closeSystem(){    
        try {
            int dialoButton = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, 
                    "Desea cerrar el sistema?", "Salir", dialoButton);
            if (result == 0) {
                System.exit(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /*------------------------------------------------------------------------*/
    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    /*------------------------------------------------------------------------*/
    public boolean delete(String item) {
        int dialoButton = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null,
                "Desea eliminar ¿" + item+" ?" , "Eliminar", dialoButton);
        if (result == 0) {
            return true;
            
        } else {
            return false;
        }

    }
    /*------------------------------------------------------------------------*/
    public Document generatePDF(){
        Document document = new Document();
        try {
            /*Nombre del documento*/
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Factura" + idBill+".pdf"));
            /*Abrimos el documento*/
            document.open();
            
            
            
            /*Se agregan los parrafos que van a la derecha*/
            Paragraph p1 = new Paragraph("Factura #:                          ");
            p1.setAlignment(Element.ALIGN_RIGHT);
            document.add(p1);
            
            Paragraph p2 = new Paragraph(Methods.getInstance().date);
            p2.setAlignment(Element.ALIGN_RIGHT);
            document.add(p2);
            
            /*Se cierra el documento*/
            document.close();
            
            writer.close();
            
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return document;
    }
    /*------------------------------------------------------------------------*/
}

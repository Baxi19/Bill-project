/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Baxi
 */
public class Methods {
    /*------------------------------------------------------------------------*/
    /*VARS*/
    public static Methods instance = null;
    public String boss = "Carlos Manuel Araya Castro, Plantas Hnos Araya";
    public String info1 = "Ced: 2-356-370 Cod.Exportador: FR4 Telefax: +506 2468 8037 Celular :+506 8340 4813";
    public String info2 = "Email: arca56@hotmail.com 1km Oeste de la Guardia Rural La Tigra, San Carlos";
    public Client client = new Client();
    public Client clientNotify = new Client();
    public DecimalFormat df2 = new DecimalFormat("#.##");
    public String dateNewBill;
    public String idBill;
    
    /*Bill information*/
    public String currentDateTime;
    public Double subTotal;
    public Double disccount;
    public Double total;
    public Double embarque;
    public int clientId;
    public int idNotify;
    
    /*Products*/
    public ArrayList<Item> cart = new ArrayList<Item>();
    public int totalBox;
    public int totalQuantity;
    public String plants = "Plantas vivas ornamentales";
    
    /*Aditional Information*/
    public String shipment          ="__________________";
    public String netWeight         ="__________________";
    public String grossWeight       ="__________________";
    public String container         ="__________________";
    public String ship              ="__________________";
    public String label             ="__________________";
    public String booking           ="__________________";
    public String outPort           ="__________________";
    public String inPort            ="__________________";
    public String originCountry     ="__________________";
    public String destinationCountry="__________________";
    /*sign's Boss*/
    public String line              ="_________________________________________________________";
    public String ced               ="               Firma        Céd: 2-356-370               ";
    public String shortLine         ="----------------------------------------------------------------------------------------------------------------------------------";
    public boolean one = false;
    public boolean two = false;
    public boolean added = false;
    
    
    
    /*------------------------------------------------------------------------*/
    //Singleton
    public static Methods getInstance() {
        if (instance == null) {
            return instance = new Methods();
        }
        return instance;
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
            
            Paragraph p2 = new Paragraph(Methods.getInstance().dateNewBill);
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
    public DefaultListModel getCartInfo(){
        totalBox = 0;
        totalQuantity = 0;
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < cart.size(); i++) {
            model.addElement("---------------------------------------");
            model.addElement("Item #: "+ (i+1) );
            model.addElement("Cajas : "+cart.get(i).getBox());
            totalBox += cart.get(i).getBox();
            model.addElement("Cantidad: "+cart.get(i).getQuantity());
            totalQuantity += cart.get(i).getQuantity();
            model.addElement("Tipo: "+cart.get(i).getDescription());
            model.addElement("Spec: "+cart.get(i).getSpec());
            model.addElement("Tamaño: "+cart.get(i).getSize());
            model.addElement("Precio U: "+cart.get(i).getPriceUnit());
            model.addElement("Total: "+cart.get(i).getTotal());
        }
        return model;
    }
    public String modifyString(String s){
        int size = s.length();
        for (int i = size; i < 20; i++) {
            s+=" ";
        }
        return s;
    }
    public void reset(){
        Methods.getInstance().cart.clear();
        Methods.getInstance().one = false;
        Methods.getInstance().two = false;
    }
    
    public void getCurrentTime(){
        currentDateTime =  java.time.LocalDateTime.now().toString();
    }
    
}

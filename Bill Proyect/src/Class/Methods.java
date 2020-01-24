/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import com.itextpdf.text.Document;
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
    public int nameNotify;
    
    
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
    
    /*------------------------------------------------------------------------*/
}

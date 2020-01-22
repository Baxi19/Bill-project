/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.time.LocalDate;

/**
 *
 * @author Baxi
 */
public class Methods {
    /*------------------------------------------------------------------------*/
    /*VARS*/
    public static Methods instance = null;
    
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
    
    /*------------------------------------------------------------------------*/
    
    /*------------------------------------------------------------------------*/
    
    /*------------------------------------------------------------------------*/
}

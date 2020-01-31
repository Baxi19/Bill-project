package Class;

import Windows.W_Login;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import java.io.File;
import java.io.FileNotFoundException;
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
    public static void main(String[] args) throws FileNotFoundException, DocumentException,  IOException {
        
        W_Login w = new W_Login();
        w.setVisible(true);
    }
        

   

}

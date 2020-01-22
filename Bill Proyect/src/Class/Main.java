package Class;

import Windows.W_Login;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import static com.itextpdf.text.TabStop.Alignment.RIGHT;
import com.itextpdf.text.api.Indentable;
import com.itextpdf.text.api.Spaceable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author Baxi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        W_Login w = new W_Login();
        w.setVisible(true);
        
                
        Document document = new Document();
        try {
            /*Nombre del documento*/
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Factura.pdf"));
            /*Abrimos el documento*/
            document.open();
            
            /*Se agregan los parrafos que van a la derecha*/
            Paragraph p1 = new Paragraph("Factura #:                          ");
            p1.setAlignment(Element.ALIGN_RIGHT);
            document.add(p1);
            
            Paragraph p2 = new Paragraph(Methods.getInstance().getLocalDate());
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
    }

    

}

import java.io.IOException; 
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
  
public class Document_Creation {
    
   public static void main (String args[]) throws IOException {
       
      //Creating PDF document object 
      PDDocument document = new PDDocument(); 
      PDPage my_page = new PDPage();
      document.addPage(my_page);
       
      //Saving the document
      document.save("./files/hello.pdf");
         
      System.out.println("PDF created");  
    
      //Closing the document  
      document.close();

   }  
}
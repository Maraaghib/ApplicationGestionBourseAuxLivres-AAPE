import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class Adding_Pages {

   public static void main(String args[]) throws IOException {
       
      //Creating PDF document object 
      PDDocument document = new PDDocument();

      for (int i=0; i<10; i++) {
         //Creating a blank page 
         PDPage blankPage = new PDPage();

         //Adding the blank page to the document
         document.addPage( blankPage );
      } 
     
      //Saving the document
      document.save("./files/hello.pdf");
      System.out.println("Pages added");
      
      //Closing the document
      document.close();

   }  
}
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

public class Removing_Pages {

   public static void main(String args[]) throws IOException {

      //Loading an existing document
      File file = new File("./files/hello.pdf");
      PDDocument document = PDDocument.load(file);
       
      //Listing the number of existing pages
      int noOfPages= document.getNumberOfPages();
      System.out.println(noOfPages + " pages");
       
      //Removing the pages
      document.removePage(2);
      
      System.out.println("Page removed");

      //Saving the document
      document.save("./files/hello.pdf");

      //Closing the document
      document.close();

   }
}
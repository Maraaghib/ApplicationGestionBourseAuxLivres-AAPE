import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class LoadingExistingFile{

	public static void main(String[] args) throws IOException{
		File file = new File("./files/hello.pdf");
		PDDocument document = PDDocument.load(file);
		PDPage my_page = new PDPage();
		document.addPage(my_page);
		System.out.println("File loaded and modified");
		
		document.save("./files/hello.pdf");
		document.close();
	}

}

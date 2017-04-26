import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class GenererFacture {
	
	public static final int titleFontSize = 16; 
	public static final int subtitleFontSize = 14; 
	public static final int fontSize = 10; 
	
	public static void addPages(PDDocument document, int nbPages){
		for (int i = 0; i < nbPages; i++) {
			//Creating a blank page 
			PDPage blankPage = new PDPage();
			//Adding the blank page to the document
			document.addPage(blankPage);
		} 
	}
	
	public static int newLine(PDPageContentStream contentStream, String message, int x, int height, PDType1Font typeFont, int fontSize) throws IOException{
		contentStream.beginText();
		contentStream.setFont(typeFont, fontSize);
		contentStream.newLineAtOffset(x, height);
		contentStream.showText(message);
		contentStream.endText();
		return height-15;
	}
	
	
	public static void facture(PDDocument document) throws IOException{
		PDPage page1 = document.getPage(0);  
		PDPageContentStream contentStream = new PDPageContentStream(document, page1);
		int height = 750; //base de la facture
		
		//valeurs codées en dur pour l'instant
		String name = "Noel";
		String year = "17.";
		String valTel = "0600000000";
		int priceAdhesion = 15;
		int nbLivresTotal = 0;
		int firstSubTotal = priceAdhesion + 3;
		int secondSubTotal = 0;
		int total = firstSubTotal + secondSubTotal;
		int account = 15;
		
		
		/**All strings**/
		String title = "A.A.P.E de Gradignan";
		String subTitle = "Isabelle LAVRAND - 31, Allée P.Cézanne - 33170 GRADIGNAN - 06 21 64 00 18";
		String mailTitle = "aape.lyceedesgraves@gmail.com";
		String nameUser = "M.    " + name;
		String tel = "Tel.  " + valTel;
		String info = "Le présent document vaut carte d'adhésion";
		
		/***************/
		
		
		/**Insertion image**/
		PDImageXObject pdImage = PDImageXObject.createFromFile("./files/aape.jpg", document); 
		contentStream.drawImage(pdImage, 30, 680);
		/*******************/
		
		
		/*******Insertion texte*******/ 
		/*titre*/
		height = newLine(contentStream, title, 250, height, PDType1Font.HELVETICA_BOLD, titleFontSize);
		height = newLine(contentStream, subTitle, 160, height, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, mailTitle, 250, height, PDType1Font.HELVETICA, fontSize);
		
		/*infos utilisateur*/
		height = newLine(contentStream, nameUser, 400, height - 10, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, year, 220, height, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, tel, 400, height, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, info, 50, height-10, PDType1Font.HELVETICA, subtitleFontSize);
		
		/*sur la même ligne*/
		height = newLine(contentStream, "État", 60, height - 15, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "Désignation", 130, height + 15, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "Prix", 400, height + 15, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "Qté", 550, height + 15, PDType1Font.HELVETICA, fontSize);
		
		/*haut du contenu*/
		height = newLine(contentStream, "ADHESIONS ET AUTRES PRESTATIONS", 130, height - 15, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "Adhésion formule membres", 130, height, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "15,00 €", 400, height + 15, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "Frais de préparations des commandes", 130, height, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "3,00 €", 400 , height + 15, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "Sous-total", 130, height, PDType1Font.HELVETICA_BOLD, fontSize);
		height = newLine(contentStream, String.valueOf(firstSubTotal) + ",00€", 400, height +15, PDType1Font.HELVETICA, fontSize);
		
		/*livres*/
		height = newLine(contentStream, "Français", 130, height - 15, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "- Collection Empreintes littéraires", 220, height + 15, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "- Méthodes & techniques 2nde", 220, height, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "Histoire 1ère", 130, height - 5, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "Géographie 1ère", 130, height, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "ANGLAIS 1ère LV1 et LV2", 130, height, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "ESPAGNOL 1ère LV2", 130, height, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "ITALIEN 2nde LV2", 130, height, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "PORTUGAIS 2nde LV2", 130, height, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "LATIN", 130, height - 5, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "- Manuel de latin 1ère", 220, height + 15, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "- Précis de grammaire latine", 220, height, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "- Dictionnaire latin/français", 220, height, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "GREC", 130, height - 5, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "- Manuel de grec 1ère", 220, height + 15, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "- Dictionnaire grec/français", 220, height, PDType1Font.HELVETICA, fontSize);
		
		/*S L et ES*/
		height = newLine(contentStream, "........................................................................................",
				130, height + 9, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "1ère S", 130, height, PDType1Font.HELVETICA_BOLD, fontSize);
		height = newLine(contentStream, "- Maths 1ère S", 220, height + 15, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "- Physiques - Chimie 1ère S", 220, height, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "- S.V.T 1ère S", 220, height, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "........................................................................................",
				130, height + 9, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "1ère L", 130, height, PDType1Font.HELVETICA_BOLD, fontSize);
		height = newLine(contentStream, "- Maths 1ère L", 220, height + 15, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "- Physiques et S.V.T", 220, height, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "........................................................................................",
				130, height + 9, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "1ère ES", 130, height, PDType1Font.HELVETICA_BOLD, fontSize);
		height = newLine(contentStream, "- Maths 1ère ES", 220, height + 15, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "- Physiques et S.V.T", 220, height, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "- S.E.S 1ère ES", 220, height, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "........................................................................................",
				130, height + 9, PDType1Font.HELVETICA, fontSize);
		
		/*fin du document*/
		height = newLine(contentStream, "Livres invendus", 130, height, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "Sous-total", 220, height, PDType1Font.HELVETICA_BOLD, fontSize);
		height = newLine(contentStream, "0,00 €", 400, height + 15, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "Nb articles", 470, height + 15, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, String.valueOf(nbLivresTotal), 550, height + 15, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "Total dû", 280, height - 30, PDType1Font.HELVETICA_BOLD, fontSize);
		height = newLine(contentStream, String.valueOf(total) + ",00 €", 400, height + 15, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "Acompte", 280, height, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, String.valueOf(account)+ ",00 €", 400, height + 15, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "Reprise", 280, height, PDType1Font.HELVETICA, fontSize);
		height = newLine(contentStream, "MONTANT À PAYER", 280, height - 15, PDType1Font.HELVETICA_BOLD, fontSize);
		height = newLine(contentStream, String.valueOf(total - account) + ",00 €", 400, height + 15, PDType1Font.HELVETICA, fontSize);
		
		/*****************************/

		contentStream.close();
	}
	
	
	public static void main(String[] args) throws IOException {
		//Create new document
		String path = "./files/";
		String fileName = "Facture1ere.pdf";
		PDDocument documentPremiere = new PDDocument();
		PDPage my_page = new PDPage();
		documentPremiere.addPage(my_page);
		
	    facture(documentPremiere);
	    
	    documentPremiere.save(path + fileName);
	    documentPremiere.close();
	    
	}

}

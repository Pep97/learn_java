package java_19_06.pdf_project;


// C:\Users\Dell\eclipse-workspace\pdf_project

import org.apache.pdfbox.pdmodel.PDDocument; // contenitore PDF
import org.apache.pdfbox.pdmodel.PDPage; // singole pagine
import org.apache.pdfbox.pdmodel.PDPageContentStream; // gestire flusso dati -->  contenuto all'interno delle pagine
import org.apache.pdfbox.pdmodel.font.PDType1Font; // font pagine
import org.apache.pdfbox.pdmodel.common.PDRectangle; // gestire il corretto formato carta
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;// gestione delle immagini
import java.io.IOException;

public class pdfLogo {

	public static void main(String[] args) {
		
		// percorso del file da salvare
		String filePath = "C:\\Users\\Dell\\Desktop\\tutorial programming\\bitcamp\\Fattura.pdf"; // percorso assoluto
		// una volta messo il percorso il file "Fattura.pdf" viene creato
		 String filePath2 = "fatture/Fattura.pdf"; // percorso relativo -> di solito viene utilizzato questo tipo di salvataggio
		// perché a volte non c'é "C" o il tuo programma non ha le autorizzazioni necessarie per salvare li

		// percorso immagine da caricare
		String logopath = "img/loghino.png";
		
		// creazione del documento pdf
		PDDocument document = new PDDocument();
		
		// creazione di una pagina pdf in formato A4
		PDPage page = new PDPage(PDRectangle.A4);
		
		// aggiunta della pagina al documento
		document.addPage(page);
		
		// apertura dello stream per scrivere nel pdf
		try(PDPageContentStream contentStream = new PDPageContentStream(document, page)){
			// carica immagine del nostro logo
			PDImageXObject logo = PDImageXObject.createFromFile(logopath, document); // 1) percorso dell'img 2) dove applicare l'immagine
			
			// scriviamo le coordinate e le dimensioni dell'immagine
			float logoX = 50; // posizione asse X
			float logoY = 700; // posizione asse Y
			float logoWidth = 100;
			float logoHeight = 100;
			
			// disegnamo il logo sulla pagina
			contentStream.drawImage(logo, logoX, logoY, logoWidth, logoHeight);
			
			
			// impostiamo il font per il testo della fattura
			
			//titolo fattura
			contentStream.setFont(PDType1Font.HELVETICA_BOLD, 18);
			contentStream.beginText();
			contentStream.newLineAtOffset(220, 700);
			contentStream.showText("Titolo Fattura");
			contentStream.endText();
			
			// scriviamo corpo fattura
			contentStream.setFont(PDType1Font.HELVETICA, 12);
			contentStream.beginText();
			contentStream.newLineAtOffset(50, 650);
			contentStream.showText("Dettagli della fattura");
			contentStream.endText();
			
			// chiusura di contentStream
			contentStream.close();
			
			// salvataggio documento
			document.save(filePath2);
			
			System.out.println("PDF creato!");
			
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				document.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

		
	}

}
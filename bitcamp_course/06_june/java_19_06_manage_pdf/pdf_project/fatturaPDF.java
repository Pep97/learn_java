package java_19_06.pdf_project;


// https://pdfbox.apache.org

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.io.IOException;


public class fatturaPDF {

	public static void main(String[] args) {
		
		// crea un nuovo documento PDF
		PDDocument document = new PDDocument();
		
		// apriamo il costrutto try per gestire eventuali errori di scrittura
		try {
			// aggiunta di una pagina al documento pdf
			PDPage page = new PDPage();
			document.addPage(page);
			
			// creazione dello stream per la scrittura sulla pagina
			PDPageContentStream contentStream = new PDPageContentStream(document, page); 
			// richiede 2 argomenti: 1) il documento nel quale vuoi scrivere 2) in quale pagina vuoi scrivere
			
			// imposta il font per la dimensione del testo
			contentStream.setFont(PDType1Font.HELVETICA_BOLD,18); // 1) font 2) dimensione
			
			//scrittura del titolo della fattura
			contentStream.beginText(); // apriamo la scrittura sulla riga
			contentStream.newLineAtOffset(220,750); 
			// 1) valore x 2) valore Y -> foglio A4  21cm larghezza 30 altezza | punti massimi (595,842) -> cerca online tool per lavorarci
			contentStream.showText("Fattura");
			contentStream.endText();
			
			// cambio del font
			contentStream.setFont(PDType1Font.HELVETICA, 12);
			
			// scriviamo i dettagli della fattura
			contentStream.beginText();
			contentStream.newLineAtOffset(50,700);
			contentStream.showText("Cliente: Mario Rossi");
			contentStream.endText();

			contentStream.beginText();
			contentStream.newLineAtOffset(50,680);
			contentStream.showText("Indirizzo: Via dei Salici, 12, Milano");
			contentStream.endText();
			
			contentStream.beginText();
			contentStream.newLineAtOffset(50,660);
			contentStream.showText("Data: 19 Giugno 2024");
			contentStream.endText();
			
			// dettaglia articoli fattura
			
			contentStream.beginText();
			contentStream.newLineAtOffset(50,620);
			contentStream.showText("Descrizione    Quantitá    Prezzo    Totale");
			contentStream.endText();
			
			contentStream.beginText();
			contentStream.newLineAtOffset(50,600);
			contentStream.showText("Articolo 1    2    50.00€    100.00€");
			contentStream.endText();
			
			contentStream.beginText();
			contentStream.newLineAtOffset(50,580);
			contentStream.showText("Articolo 2    1    75.00€    75.00€");
			contentStream.endText();
			
			// totale della fattura
			
			contentStream.beginText();
			contentStream.newLineAtOffset(50,540);
			contentStream.showText("Totale:                175.00€");
			contentStream.endText();
			
			// chiusura dello stream dati (flusso binario)
			contentStream.close();
			
			// salvataggio del documento sulla macchina
			document.save("Fattura.pdf"); // al momento te lo salva all'interno di pdf_project -> qui dovresti mettere la directory di dove vuoi salvare il file
			
			System.out.println("Fattura PDF creata con successo!");
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			// chiudiamo il document
			try {
				document.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

	}

}

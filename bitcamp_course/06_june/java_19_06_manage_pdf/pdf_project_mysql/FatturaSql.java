package java_19_06.pdf_project_mysql;


// directory per controllare il file
//C:\Users\Dell\eclipse-workspace\pdf_project

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import java.sql.*;
import java.io.IOException;

public class FatturaSql {
	
	public static void main(String[] args) {
		// Gestione della connessione al database
				
		String url = "jdbc:mysql://localhost:3306/FattureDatabase";
		String user = "root";
		String password = "localbombcomputer";
		
		
		// connesione al database
		try( Connection conn = DriverManager.getConnection(url, user, password);
			 Statement stmt = conn.createStatement();
			){
			
			 // query di estrazione
			 String query = "SELECT Descrizione, Quantita, Prezzo FROM Fatture";
			 ResultSet rs = stmt.executeQuery(query);
			 
			 // Creazione del documento pdf
			 PDDocument document = new PDDocument();
			 PDPage page = new PDPage(PDRectangle.A4);
			 document.addPage(page);
			 
			 // apertura del contentStream
			 PDPageContentStream contentStream = new PDPageContentStream(document, page);
			 
			 // impostiamo il font e il testo del documento
			 contentStream.setFont(PDType1Font.HELVETICA_BOLD, 18);
			 contentStream.beginText();
			 contentStream.newLineAtOffset(220, 750);
			 contentStream.showText("Fattura");
			 contentStream.endText();
			 
			 contentStream.setFont(PDType1Font.HELVETICA, 12);
			 
			 
			 // definiamo la tabella che conterra i dati
			 //intestazione tabella
			 float yPosition = 700;
			 contentStream.beginText();
			 contentStream.newLineAtOffset(50, yPosition);
			 contentStream.showText("Descrizione");
			 contentStream.newLineAtOffset(200, 0); // se fai "0" lui la esegue come la linea precedentemente usata quindi "yPosition"
			 contentStream.showText("Quantitá");
			 contentStream.newLineAtOffset(100, 0); // se fai "0" lui la esegue come la linea precedentemente usata quindi "yPosition"
			 contentStream.showText("Prezzo");
			 contentStream.endText();
			 
			 yPosition -=20;
			 // lettura da rs e scrittura su pdf
			 while(rs.next()) {
				 String descrizione = rs.getString("Descrizione");
				 int quantita = rs.getInt("Quantita");
				 double prezzo = rs.getDouble("Prezzo");
				 
				 // puntiamo sul pdf
				 contentStream.beginText();
				 contentStream.newLineAtOffset(50, yPosition);
				 contentStream.showText(descrizione);
				 contentStream.newLineAtOffset(200, 0);
				 contentStream.showText(String.valueOf(quantita));
				 contentStream.newLineAtOffset(100,  0);
				 contentStream.showText(String.format("%.2f", prezzo)); // ti mostra tutti i dati prima della virgola e i 2 numeri dopo la virgola
				 // non puoi convertire in maniera diretta con valueOf()
				 contentStream.endText();
				 
				 yPosition -= 20;

			 }
			 
			 // Chiusura dello Stream
			 contentStream.close();
			 
			 // Salvataggio del documento
			 document.save("FatturaMysql.pdf");
			 
			 // chiusura documento
			 document.close();
			 
			 System.out.println("PDF creato!");
			 

			 
			 
			
		} catch(SQLException | IOException e) { // gestisci due eccezzioni con un unico try / catch
			e.printStackTrace();
		}
	
		
		
		
	}


}

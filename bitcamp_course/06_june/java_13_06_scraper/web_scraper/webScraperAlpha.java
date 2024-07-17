package java_13_06_scraper_html.web_scraper;



import org.jsoup.Jsoup; // connessione all'url
import org.jsoup.nodes.Document; // controlla il DOM
import java.io.IOException; // gestione di ingresso e uscita dei dati


public class webScraperAlpha {

	public static void main(String[] args) {

		String url = "https://www.bitcamp.it";
		
		try {
			
			// connessione e recupero del DOM dell'url passato
			Document doc = Jsoup.connect(url).get();
			
			// manipolazione del DOM per recuperare gli elementi della pagina HTML
			String title = doc.title();
			String body = doc.body().text();
			
			// stampa delle informazioni
			
			System.out.println("Titolo: " + title);
			System.out.println("Body: " + body);

			
		} catch(IOException e) {
			System.out.println("Errore: " + e.getMessage());
		}
				
				
	}
	
	

}
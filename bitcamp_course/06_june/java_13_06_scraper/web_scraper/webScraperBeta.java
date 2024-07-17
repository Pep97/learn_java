package java_13_06_scraper_html.web_scraper;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element; // gestire gli ID di un documento HTML 
import org.jsoup.select.Elements; // gestire le classi di un documento HTML 

public class webScraperBeta {

	public static void main(String[] args) {

		String url = "https://www.bitcamp.it";
		
		try {
			// connessione
			Document doc = Jsoup.connect(url).get();
			
			// esempio di estrazione di testo su un elemento con un determinato ID
			Element idElement = doc.getElementById("form-corso-full");
			String idElementText = idElement.text();
			
			System.out.println("Testo dell'elemento specifico ID: " + idElementText);
			
			// esempio di estrazione di testo da elementi caratterizzati da una classe
			Elements elementsClass = doc.getElementsByClass("small text-white");
			for(Element element : elementsClass) {
				System.out.println("Testo dell'elemento classe: " + element.text());
			}
			
			
			
		} catch(IOException e) {
			System.out.println("Errore :" + e.getMessage());
		}
		
		
	}

}

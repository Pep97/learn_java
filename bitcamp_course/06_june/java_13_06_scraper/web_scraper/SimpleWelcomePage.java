package java_13_06_scraper_html.web_scraper;

import com.sun.net.httpserver.HttpServer; // ilbreria per creare il server http
import com.sun.net.httpserver.HttpHandler; // libreria per gestire le chiamate in entrata da parte del browser
import com.sun.net.httpserver.HttpExchange; // gestire lo scambio di informazioni in I/O
import java.io.*; // libreria per gestire i flussi di dati
import java.net.InetSocketAddress; // per creare e gestire un indirizzo IP e la sua porta


public class SimpleWelcomePage {

	public static void main(String[] args) throws IOException { // l'errore viene gestito dalla libreria

		// creazione di un server HTTP sulla porta 8080
		HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0); 
		// paramentri: server, numero massimo di connessione per quel server
		// con "0" lasci la piena gestione al tuo sistema operativo e lui se la gestisce
		
		
		// gestione degli handler per le richieste GET da parte del browser
		// gestione della richiesta GET per la pagina di benvenuto
		
		server.createContext("/", new WelcomePageHandler()); // createContext -> stai creando l'handler che risponde al server che abbiamo creato prima
		//e lo stai mandando nel "/" quindi in index.html che é la pagina di default.
		// e poi chiami l'handler
		
		// handler 2
		// handler 3
		// etc...
		
		
		// avvio del server
		server.start();
		System.out.println("Server in esecuzione sulla porta 8080");
	
	}
	
	static class WelcomePageHandler implements HttpHandler {
		
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			// definizione del contenuto della pagina web di benvenuto
			String htmlResponse = "<html>"
								+ "<head><title>Benvenuto</title></head>"
								+ "<body>"
								+ "<h1>Benvenuto</h1>"
								+ "<p>Questa é una pagina di benvenuto gestita dal tuo server Java.</p>"
								+ "</body>"
								+ "</html>";
			
			// gestiamo la risposta impostando l'intestazione attesa dal browser
			exchange.getRequestHeaders().set("Content-Type", "text/html"); // specificare il contenuto e tipo di documento
			
			// imposta lo status code e la lunghezza della risposta
//			exchange.sendResponseHeaders(200, htmlResponse.length());
			// la lunghezza viene richiesta per capire se c'é un attacco e serve per riconosce la richiesta originale e controllarla una volta che server riceve i dati.
			
            int contentLength = htmlResponse.getBytes("UTF-8").length;
            exchange.sendResponseHeaders(200, contentLength);


			
			// scriviamo la risposta con intestazione piú corpo in formato stream
			OutputStream os = exchange.getResponseBody();
			
			os.write(htmlResponse.getBytes()); // i bytes ti servono perché poi verranno trasformati in bit
			os.close();
			
		}
		
		
	}
	
	
	
	
}

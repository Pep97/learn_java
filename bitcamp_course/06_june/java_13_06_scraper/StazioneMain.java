package java_13_06_scraper_html;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.net.InetSocketAddress;
import java.sql.*;
import java.util.*;

public class StazioneMain {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/stazione";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "localbombcomputer";

	public static void main(String[] args) throws IOException {

		// creazione del server
		HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);
		
		
		// creazione handler
		server.createContext("/", new HomePageHandler());
		server.createContext("/venditaBiglietto",new VenditaBigliettoHandler());
		server.createContext("/riepilogoBiglietti", new RiepilogoBigliettiHandler());
		
		// avvio del server
		server.start();
		System.out.println("Server in esecuzione");
		
	}
	
	static class HomePageHandler implements HttpHandler{
		@Override
		public void handle(HttpExchange exchange) throws IOException{
			
			// creazione del documento web per la home page dell'applicativo
			String htmlResponse = "<html>"
								+ "<head>"
								+ "<title>Home</title>"
								+ "</head>"
								+ "<body>"
								+ "<h1>Benvenuti nella homepage della biglietteria della stazione</h1>"
								+ "<ul>"
								+ "<li><a href='/venditaBiglietto'>Vendita Biglietto</a></li>"
								+ "<li><a href='/riepilogoBiglietti'>Riepilogo Biglietti</a></li>"
								+ "</ul>"
								+ "</body>"
								+ "</html>";
			
			// impostare la risposta con intestazione con status code e lunghezza
			
			exchange.getResponseHeaders().set("Content-type", "text/html");
			exchange.sendResponseHeaders(200, htmlResponse.length());
			
			// inviamo la risposta al client
			OutputStream os = exchange.getResponseBody();
			os.write(htmlResponse.getBytes());
			os.close();
			
		}
	}
	// GET per ottenere dati
	// POST per mandare dati
	
	static class VenditaBigliettoHandler implements HttpHandler{
		@Override
		public void handle(HttpExchange exchange) throws IOException{
			
			// domandarsi se il browser richiede dei dati GET o se invia dei dati POST
			if(exchange.getRequestMethod().equalsIgnoreCase("GET")) {
				
				// form HTML per la vendita del biglietto
				String htmlResponse = "<html>"
					    + "<head>"
					    + "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH' crossorigin='anonymous'>"
					    + "<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz' crossorigin='anonymous'></script>"
					    + "<title>Vendita Biglietto</title>"
					    + "<style>"
					    + "body {"
					    + " background-image: url('https://media.meer.com/attachments/7725bcd94bc0c8c2ce869c13a78ea1fabf73f134/store/fill/1090/613/4685b5227116ad2c93693dbe5655b2d30d7daee84bbab531998b864b7166/Stazione-treno-Luogo-reale-eppure-simile-alla-leggenda.jpg');"
					    + " background-size: cover;"
					    + " background-position: center;"
					    + " background-repeat: no-repeat;"
					    + " background-attachment: fixed;"
					    + " color: white;"
					    + "}"
					    + ".container {"
					    + " padding-top:50px;"
					    + "}"
					    + "</style>"
					    + "</head>"
					    + "<body>"
					    + "<div class='container'>"
					    + " <h1 class='mt-5'>Vendita Biglietto</h1>"
					    + " <form id='venditaForm' class='mt-3' method='post' action='/venditaBiglietto'>"
					    + "  <div class='form-group'>"
					    + "   <label for='data'>Data:</label>"
					    + "   <input type='text' class='form-control' id='data' name='data'>"
					    + "  </div>"
					    + "  <div class='form-group'>"
					    + "   <label for='destinazione'>Destinazione:</label>"
					    + "   <input type='text' class='form-control' id='destinazione' name='destinazione'>"
					    + "  </div>"
					    + "  <div class='form-group'>"
					    + "   <label for='prezzo'>Prezzo:</label>"
					    + "   <input type='text' class='form-control' id='prezzo' name='prezzo'>"
					    + "  </div>"
					    + "  <button type='submit' class='btn btn-primary mt-2'>Vendi</button>"
					    + " </form>"
					    + "</div>"
					    + "</body>"
					    + "</html>";
				
				// gestiamo la risposta al browser
				
				exchange.getResponseHeaders().set("Content-type", "text/html");
				exchange.sendResponseHeaders(200, htmlResponse.length());
				
				OutputStream os = exchange.getResponseBody(); // con getResponseBody -> noi mandiamo il valore al browser
				os.write(htmlResponse.getBytes());
				os.close();
				
			} else if(exchange.getRequestMethod().equalsIgnoreCase("POST")) {
				
				// dati che noi riceviamo quando il cliente compila il form
				// data=14/06/24&destinazione=Roma&prezzo=200
				// STEPS
				// 1- divisione degli elementi in base dell'&
				// 2 - prendere i valori
				
				// -------------------------------------------------------------------------------
				
				// RECUPERA I DATI DAL FORM
				
				// intercettiamo il flusso di bit in entrata sul server
				InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");  // con getRequestBody -> noi riceviamo il valore dal browser
				
				// convertiamo il flusso in byte
				BufferedReader br = new BufferedReader(isr);
				
				// convertiamo i byte in una stringa di testo
				String formData = br.readLine(); // prendi l'informazioni e la trasformi in una stringa
				
				// split della riga nelle sue componenti di base
				String[] formDataArray = formData.split("&"); // {data=14/06/24 , destinazione=Roma , prezzo=200}
				
				// recuperiamo i singoli valori
				String data = formDataArray[0].split("=")[1].replace("%2F", "/"); // con [1] specifici che vuoi la seconda parte, quindi "14/06/24"
				String destinazione = formDataArray[1].split("=")[1];
				Double prezzo = Double.parseDouble(formDataArray[2].split("=")[1]);
					
				
				// NumberException e -> crea un try/catch nei singoli valori per controllo
				
				// connessione al database
				try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
					String query = "INSERT INTO biglietti(data, destinazione, prezzo) VALUES (?,?,?)";
					
					try(PreparedStatement pstmt = conn.prepareStatement(query)){
						pstmt.setString(1, data);
						pstmt.setString(2, destinazione);
						pstmt.setDouble(3, prezzo);
						pstmt.executeUpdate();

					}
					
					
					
				} catch(SQLException e) {
					e.printStackTrace();
				}

				// dopo l'inserimento del biglietto rimandiamo l'utente all'homepage
				exchange.getResponseHeaders().set("Location", "/");				
				exchange.sendResponseHeaders(302, -1); // conferma che l'operazione é riuscita -> 302 é il codice per il browser che l'operazione é avvenuta e stiamo reindirizzando l'utente.

				
				
			} else {
				exchange.sendResponseHeaders(405, -1); // ritorna la dicitura "error 405 method not allowed"
			}
			
			
		}
	}
	
	
	static class RiepilogoBigliettiHandler implements HttpHandler{
		@Override
		public void handle(HttpExchange exchange) throws IOException{
			
				// connessione al database e recupero dei biglietti
				List<String> biglietti = new ArrayList<>();
				
				try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
					String query = "SELECT * FROM biglietti";
					
					try(PreparedStatement pstmt = conn.prepareStatement(query)){
						ResultSet rs = pstmt.executeQuery();
						while(rs.next()) {
							String data = rs.getString("data");
							String destinazione = rs.getString("destinazione");
							double prezzo = rs.getDouble("prezzo");
							
							biglietti.add("Data: " + data + ", Destinazione: " + destinazione + ", Prezzo: " + prezzo);
						}
					}
					
				} catch(SQLException e) {
					e.printStackTrace();
				}
				
				// risposta al client
				StringBuilder response = new StringBuilder(); // StringBuilder crea degli arraylist di stringhe
				response.append("<html><body>");
				response.append("<h1>Riepilogo dei biglietti venduti</h1>");

				// creo dinamicamente il contenuto web con un foreach su array
				for(String biglietto : biglietti) {
					response.append("<p>").append(biglietto).append("</p>");
				}
				
				response.append("</body></html>");

				// gestiamo la risposta al browser
				
				exchange.getResponseHeaders().set("Content-type", "text/html");
				exchange.sendResponseHeaders(200, response.length());
				
				OutputStream os = exchange.getResponseBody();
				os.write(response.toString().getBytes()); // response é un arraylist, la convertiamo in String.
				os.close();

				
				
		}
	}
	
	

	
	
}

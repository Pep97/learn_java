package java_14_06;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange; 
import java.io.*;
import java.net.InetSocketAddress;
import java.sql.*;
import java.util.*;

public class AppuntamentiStudio {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/studio_medico_html";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "localbombcomputer";

	public static void main(String[] args) throws IOException {

		// creazione del server
		HttpServer server = HttpServer.create(new InetSocketAddress(8081),0);
		
		
		// creazione handler
		server.createContext("/", new HomePageHandler());
		server.createContext("/informazioniAggiuntive",new InformazioniAggiuntiveHandler());
		
		// avvio del server
		server.start();
		System.out.println("Server in esecuzione");
		
	}
	
	static class HomePageHandler implements HttpHandler{
		@Override
		public void handle(HttpExchange exchange) throws IOException{
			
			if(exchange.getRequestMethod().equalsIgnoreCase("GET")) {
				
				// connessione al database e recupero dei biglietti
				List<String> appuntamenti = new ArrayList<>();
				
				try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
					String query = "SELECT * FROM appuntamenti";
					
					try(PreparedStatement pstmt = conn.prepareStatement(query)){
						ResultSet rs = pstmt.executeQuery();
						while(rs.next()) {
							String data = rs.getString("data");
							String ora = rs.getString("ora");
							
							appuntamenti.add("<td> Data: " + data + "</td><td> Ora: " + ora + "</td>");
						}
					}
					
				} catch(SQLException e) {
					e.printStackTrace();
				}
				
				// risposta al client
				StringBuilder response = new StringBuilder(); // StringBuilder crea degli arraylist di stringhe
				response.append("<html lang='en' xmlns='http://www.w3.org/1999/xhtml'>\r\n"
						+ "<head>\r\n"
						+ "    <meta name='viewport' content='width=device-width, initial-scale=1' />\r\n"
						+ "    <meta charset='utf-8' />\r\n"
						+ "    <meta name='description' content='Homepage Studio Medico BitCamp' />\r\n"
						+ "    <meta name='keywords' content='studio medico, prenotazione appuntamenti, servizi medici' />\r\n"
						+ "    <meta name='author' content='Vincenzo Barone, Giuseppe Boinega' />\r\n"
						+ "    <title>Studio Medico</title>\r\n"
						+ "    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH' crossorigin='anonymous'>\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "    <style>\r\n"
						+ "        body {\r\n"
						+ "            margin: 0;\r\n"
						+ "            padding: 0;\r\n"
						+ "            font-family: Arial,sans-serif;\r\n"
						+ "            background: url('https://i.ibb.co/C59RgwZ/sfondo.jpg') fixed;\r\n"
						+ "            background-size: cover;\r\n"
						+ "            color: #333;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        header {\r\n"
						+ "            text-align: center;\r\n"
						+ "            background-color: rgba(0,0,0,0.7);\r\n"
						+ "            color: #fff;\r\n"
						+ "            padding: 50px;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "        nav {\r\n"
						+ "            text-align: center;\r\n"
						+ "            background: #333;\r\n"
						+ "            padding: 10px;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "            nav a {\r\n"
						+ "                color: #fff;\r\n"
						+ "                text-decoration: none;\r\n"
						+ "                margin: 0 15px;\r\n"
						+ "            }\r\n"
						+ "\r\n"
						+ "        form {\r\n"
						+ "            max-width: 600px;\r\n"
						+ "            margin: 50px auto;\r\n"
						+ "            padding: 20px;\r\n"
						+ "            background: rgba(255,255,255,0.8);\r\n"
						+ "            border-radius: 10px;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "            form label {\r\n"
						+ "                display: block;\r\n"
						+ "                margin-bottom: 8px;\r\n"
						+ "            }\r\n"
						+ "\r\n"
						+ "            form input, form select {\r\n"
						+ "                width: 97%;\r\n"
						+ "                padding: 10px;\r\n"
						+ "                margin-bottom: 20px;\r\n"
						+ "                border: 1px solid #ccc;\r\n"
						+ "                border-radius: 5px;\r\n"
						+ "            }\r\n"
						+ "\r\n"
						+ "            form button {\r\n"
						+ "                background: #3498db;\r\n"
						+ "                color: #fff;\r\n"
						+ "                padding: 10px 15px;\r\n"
						+ "                border: none;\r\n"
						+ "                border-radius: 5px;\r\n"
						+ "                cursor: pointer;\r\n"
						+ "            }\r\n"
						+ "\r\n"
						+ "        section {\r\n"
						+ "            text-align: center;\r\n"
						+ "            padding: 50px;\r\n"
						+ "            background: rgba(255,255,255,0.8);\r\n"
						+ "            border-radius: 10px;\r\n"
						+ "            margin: 20px;\r\n"
						+ "        }\r\n"
						+ "\r\n"
						+ "            section h2 {\r\n"
						+ "                color: #333;\r\n"
						+ "            }\r\n"
						+ "\r\n"
						+ "            section ul {\r\n"
						+ "                list-style: none;\r\n"
						+ "                padding: 0;\r\n"
						+ "            }\r\n"
						+ "\r\n"
						+ "            section li {\r\n"
						+ "                margin-bottom: 10px;\r\n"
						+ "            }\r\n"
						+ "\r\n"
						+ "        footer {\r\n"
						+ "            text-align: center;\r\n"
						+ "            padding: 20px;\r\n"
						+ "            background: #333;\r\n"
						+ "            color: #fff;\r\n"
						+ "        }\r\n"
						+ "    </style>\r\n"
						+ "\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "    <header>\r\n"
						+ "        <h1>Studio Medico BitCamp</h1>\r\n"
						+ "        <p>La tua salute è la nostra priorità</p>\r\n"
						+ "    </header>\r\n"
						+ "    <!--Sezione dedicata ai collegamenti-->\r\n"
						+ "    <nav>\r\n"
						+ "      <a href = '/'>Home</a>\r\n"
						+ "      <a href = '#'>Chi Siamo</a>\r\n"
						+ "      <a href = '#'>Servizi</a>\r\n"
						+ "      <a href = '/informazioniAggiuntive'>Informazioni Aggiuntive</a>\r\n"
						+ "      <a href = '#'>Contatti</a>\r\n"
						+ "   </nav>\r\n"
						+ "\r\n"
						+ "    <!--Form per gestione appuntamenti-->\r\n"
						+ "    <form action='/' method ='post'>\r\n"
						+ "        <label for='data'>Data dell' appuntamento:</label>\r\n"
						+ "        <input type='date' id='data' name='data' required />\r\n"
						+ "\r\n"
						+ "        <label for='ora'>Ora dell' appuntamento:</label>\r\n"
						+ "        <input type='time' id='ora' name='ora' required />\r\n"
						+ "\r\n"
						+ "        <button type='submit'>Prenota Appuntamento</button>\r\n"
						+ "    </form>\r\n"
						+ "\r\n"
						+ "    <!--Sezione per elencare i servizi dello studio-->\r\n"
						+ "    <section>\r\n"
						+ "        <h2>Servizi Offerti</h2>\r\n"
						+ "        <ul>\r\n"
						+ "            <li>Medicina Generale</li>\r\n"
						+ "            <li>Pediatria</li>\r\n"
						+ "            <li>Cardiologia</li>\r\n"
						+ "            <li>Dermatologia</li>\r\n"
						+ "            <li>Ortopedia</li>\r\n"
						+ "        </ul>\r\n"
						+ "    </section>\r\n"
						+ "\r\n"
						+ "    <!--Sezione Informazioni Studio-->\r\n"
						+ "    <section>\r\n"
						+ "        <h2>Chi Siamo</h2>\r\n"
						+ "        <p>Lo Studio Medico BitCamp si impegna a fornire servizi medici di alta qualità per migliorare la salute e il benessere dei propri studenti di programmazione.></p>\r\n"
						+ "    </section>\r\n"
						+ "\r\n"
						+ "    <!--Sezione dei contatti-->\r\n"
						+ "    <section>\r\n"
						+ "        <h2>Contatti</h2>\r\n"
						+ "        <p>Indirizzo: Via delle Cure, 123 - 00123 Roma</p>\r\n"
						+ "        <p>Email: info@studiomedicobit.it</p>\r\n"
						+ "        <p>Telefono: 0123-45789</p>\r\n"
						+ "    </section>\r\n"
						+ "\r\n"
						+ "    <!--tabella per prenotazioni-->\r\n"
						+ "    <h2>Prenotazioni</h2>\r\n"
						+ "    <table class=\"table\">\r\n"
						+ "        <thead>\r\n"
						+ "            <tr>\r\n"
						+ "                <th>Data</th>\r\n"
						+ "                <th>Ora</th>\r\n"
						+ "            </tr>\r\n"
						+ "        </thead>\r\n"
						+ "        <tbody id=\'tabella\'>");

				// creo dinamicamente il contenuto web con un foreach su array
				for(String appuntamento : appuntamenti) {
					response.append("<tr>").append(appuntamento).append("</tr>");
				}
				
				response.append("        </tbody>\r\n"
						+ "    </table>\r\n"
						+ "    <footer>\r\n"
						+ "        <p>&copy; 2024 Studio Medico BitCamp. Tutti i diritti riservati.</p>\r\n"
						+ "    </footer>\r\n"
						+ "</body>\r\n"
						+ "</html>");
				
				
				
				
				//Gestiamo la risposta al browser data la richiesta get iniziale
				exchange.getResponseHeaders().set("Content-Type", "text/html");
				int contentLength = response.toString().getBytes("UTF-8").length;
				exchange.sendResponseHeaders(200, contentLength);
				
				OutputStream os = exchange.getResponseBody();
				os.write(response.toString().getBytes()); // response é un arraylist, la convertiamo in String.
				os.close();
				
				
				
			} else if(exchange.getRequestMethod().equalsIgnoreCase("POST")) {  // gestione form
				
				
				InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8"); 
				
				BufferedReader br = new BufferedReader(isr);
				
				String formData = br.readLine(); 
				
				String[] formDataArray = formData.split("&"); 
				
				// recuperiamo i singoli valori
				String data = formDataArray[0].split("=")[1].replace("%2F", "/");
				String ora = formDataArray[1].split("=")[1].replace("%3A", ":");
					
											
				// connessione al database
				try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
					String query = "INSERT INTO appuntamenti(data, ora) VALUES (?,?)";
					
					try(PreparedStatement pstmt = conn.prepareStatement(query)){
						pstmt.setString(1, data);
						pstmt.setString(2, ora);
						pstmt.executeUpdate();

					}
					
					
					
					
					
				} catch(SQLException e) {
					e.printStackTrace();
				}
				
				// dopo l'inserimento del appuntamento ricarichiamo la pagina
				exchange.getResponseHeaders().set("Location", "/");				
				exchange.sendResponseHeaders(302, -1); // conferma che l'operazione é riuscita -> 302 é il codice per il browser che l'operazione é avvenuta e stiamo reindirizzando l'utente.

				
				
			} else {
				exchange.sendResponseHeaders(405, -1); // ritorna la dicitura "error 405 method not allowed"
			}
			
			
		

}
}
// GET per ottenere dati
// POST per mandare dati

	static class InformazioniAggiuntiveHandler implements HttpHandler{
	@Override
		public void handle(HttpExchange exchange) throws IOException{
		
		String htmlResponse = "\r\n"
				+ "<html lang='en' xmlns='http://www.w3.org/1999/xhtml'>\r\n"
				+ "<head>\r\n"
				+ "    <meta name='viewport' content='width=device-width, initial-scale=1' />\r\n"
				+ "    <meta charset='utf-8' />\r\n"
				+ "    <meta name='description' content='Informazioni-Aggiuntivei Studio Medico' />\r\n"
				+ "    <meta name='keywords' content='studio medico, prenotazione appuntamenti, servizi medici' />\r\n"
				+ "    <meta name='author' content='Vincenzo Barone, Giuseppe Boinega' />\r\n"
				+ "    <meta charset='utf-8' />\r\n"
				+ "    <title>Informazioni Aggiuntive - Studio Medico</title>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "    <style>\r\n"
				+ "        body {\r\n"
				+ "            margin: 0;\r\n"
				+ "            padding: 0;\r\n"
				+ "            font-family: Arial,sans-serif;\r\n"
				+ "            background: url('https://i.ibb.co/C59RgwZ/sfondo.jpg') fixed;\r\n"
				+ "            background-size: cover;\r\n"
				+ "            color: #333;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        header {\r\n"
				+ "            text-align: center;\r\n"
				+ "            background-color: rgba(0,0,0,0.7);\r\n"
				+ "            color: #fff;\r\n"
				+ "            padding: 50px;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        nav {\r\n"
				+ "            text-align: center;\r\n"
				+ "            background: #333;\r\n"
				+ "            padding: 10px;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "            nav a {\r\n"
				+ "                color: #fff;\r\n"
				+ "                text-decoration: none;\r\n"
				+ "                margin: 0 15px;\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "        form {\r\n"
				+ "            max-width: 600px;\r\n"
				+ "            margin: 50px auto;\r\n"
				+ "            padding: 20px;\r\n"
				+ "            background: rgba(255,255,255,0.8);\r\n"
				+ "            border-radius: 10px;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "            form label {\r\n"
				+ "                display: block;\r\n"
				+ "                margin-bottom: 8px;\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "            form input, form select {\r\n"
				+ "                width: 97%;\r\n"
				+ "                padding: 10px;\r\n"
				+ "                margin-bottom: 20px;\r\n"
				+ "                border: 1px solid #ccc;\r\n"
				+ "                border-radius: 5px;\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "            form button {\r\n"
				+ "                background: #3498db;\r\n"
				+ "                color: #fff;\r\n"
				+ "                padding: 10px 15px;\r\n"
				+ "                border: none;\r\n"
				+ "                border-radius: 5px;\r\n"
				+ "                cursor: pointer;\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "        section {\r\n"
				+ "            text-align: center;\r\n"
				+ "            padding: 50px;\r\n"
				+ "            background: rgba(255,255,255,0.8);\r\n"
				+ "            border-radius: 10px;\r\n"
				+ "            margin: 20px;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "            section h2 {\r\n"
				+ "                color: #333;\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "            section ul {\r\n"
				+ "                list-style: none;\r\n"
				+ "                padding: 0;\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "            section li {\r\n"
				+ "                margin-bottom: 10px;\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "        footer {\r\n"
				+ "            text-align: center;\r\n"
				+ "            padding: 20px;\r\n"
				+ "            background: #333;\r\n"
				+ "            color: #fff;\r\n"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <header>\r\n"
				+ "        <h1>Informazioni Aggiuntive</h1>\r\n"
				+ "        <p>Scopri di più su Studio Medico BitCamp</p>\r\n"
				+ "    </header>\r\n"
				+ "\r\n"
				+ "    <nav>\r\n"
				+ "        <a href='/'>Home</a>\r\n"
				+ "        <a href='#'>Servizi</a>\r\n"
				+ "        <a href='#'>Contatti</a>\r\n"
				+ "    </nav>\r\n"
				+ "\r\n"
				+ "    <section>\r\n"
				+ "        <h2>Ulteriori Dettagli</h2>\r\n"
				+ "        <p>Lo Studio medico bitcamp offre una vasta gamma di servizi specialistici tra cui></p>\r\n"
				+ "        <ul>\r\n"
				+ "            <li>Ginecologia</li>\r\n"
				+ "            <li>Oncologia</li>\r\n"
				+ "            <li>Neurologia</li>\r\n"
				+ "            <li>Psicologia</li>\r\n"
				+ "        </ul>\r\n"
				+ "        <p>Per ulteriori informazioni non esitare a contattarci</p>\r\n"
				+ "    </section>\r\n"
				+ "\r\n"
				+ "    <footer>\r\n"
				+ "        <p>&copy;2024 Studio Medico BitCamp. Tutti i diritti riservati. </p>\r\n"
				+ "    </footer>\r\n"
				+ "</body>\r\n"
				+ "</html>";
		
		
		
		//Gestiamo la risposta al browser data la richiesta get iniziale
		exchange.getResponseHeaders().set("Content-Type", "text/html");
		int contentLength = htmlResponse.getBytes("UTF-8").length;
		exchange.sendResponseHeaders(200, contentLength);

		//Inviamo la risposta al client
		OutputStream os = exchange.getResponseBody();
		os.write(htmlResponse.getBytes());
		os.close();
		
		}
	}

}

package java_04_06.centro_estetico.CentroEstetico;

import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class Cliente {
	//attributi
	private static Connection conn;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	private static final String DB_URL = "jdbc:mysql://localhost:3306/centro_estetico_test";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "B4n4n4Spl1t!";

	private int idCliente;
	private String nomeCliente;
	private String cognomeCliente;
	private String telefonoCliente;
	private String emailCliente;
	private String codiceFiscaleCliente;
	private String note;




	//costruttore vuoto
	public Cliente() {

	}

	public Cliente(String nomeCliente, String cognomeCliente, String telefonoCliente,String emailCliente, String codiceFiscaleCliente,String note ) {
		this.idCliente = 0;
		this.nomeCliente = nomeCliente;
		this.cognomeCliente = cognomeCliente;
		this.telefonoCliente = telefonoCliente;
		this.emailCliente = emailCliente;
		this.codiceFiscaleCliente = codiceFiscaleCliente;
		this.note = note;
	}

	//metodi get e set
	public String getNomeCliente() {
		return nomeCliente;
	}
	public String getCognomeCliente() {
		return cognomeCliente;
	}
	public String getTelefonoCliente() {
		return telefonoCliente;
	}
	public String getEmailCliente() {
		return emailCliente;
	}
	public String getCodiceFiscaleCliente() {
		return codiceFiscaleCliente;
	}
	public String getNote() {
		return note;
	}
	public int getIdCliente() {
		return idCliente;
	}

	//setter
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public void setCognomeCliente(String cognomeCliente) {
		this.cognomeCliente = cognomeCliente;
	}
	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	public void setCodifceFiscaleCliente(String codiceFiscaleCliente) {
		this.codiceFiscaleCliente = codiceFiscaleCliente;
	}
	public void setNote(String note) {
		this.note=note;
	}


	//metodi crud
	
	public String visualizzaTuttiClienti() {
		String risultato = "";
		try {
			String queryVisualizza= "SELECT * FROM clienti";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryVisualizza);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				this.idCliente= rs.getInt("id_cliente");
				this.nomeCliente = rs.getString("nome_cliente");
				this.cognomeCliente = rs.getString("cognome_cliente");
				this.telefonoCliente = rs.getString("telefono_cliente");
				this.emailCliente = rs.getString("email_cliente");
				this.codiceFiscaleCliente = rs.getString("codice_fiscale_cliente");
				this.note = rs.getString("preferenze");
				risultato += idCliente + ";" + nomeCliente +";"+ cognomeCliente+";"+telefonoCliente+";"+emailCliente+";"+codiceFiscaleCliente+";"+note +"\n";
			}

			//pulitura dei campi


			rs.close();
			pstmt.close();
			conn.close();
			

		}catch(SQLException e) {
			e.printStackTrace();

		}
		return risultato;
	}
	
	public String visualizzaClienteId(int idCliente) {
		String risultato = "";
		try {
			String queryVisualizza= "SELECT * FROM clienti WHERE id_cliente = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryVisualizza);
			pstmt.setInt(1, idCliente);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				this.idCliente= rs.getInt("id_cliente");
				this.nomeCliente = rs.getString("nome_cliente");
				this.cognomeCliente = rs.getString("cognome_cliente");
				this.telefonoCliente = rs.getString("telefono_cliente");
				this.emailCliente = rs.getString("email_cliente");
				this.codiceFiscaleCliente = rs.getString("codice_fiscale_cliente");
				this.note = rs.getString("preferenze");
				risultato = this.idCliente + ";" + nomeCliente +";"+ cognomeCliente+";"+telefonoCliente+";"+emailCliente+";"+codiceFiscaleCliente+";"+note;
			}

			//pulitura dei campi


			rs.close();
			pstmt.close();
			conn.close();
			

		}catch(SQLException e) {
			e.printStackTrace();

		}
		return risultato;
	}
	public String visualizzaClienteNome(String nomeCliente) {
		String risultato ="";
		try {
			String queryVisualizza= "SELECT * FROM clienti WHERE nome_cliente = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryVisualizza);
			pstmt.setString(1, nomeCliente);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				this.idCliente= rs.getInt("id_cliente");
				this.nomeCliente = rs.getString("nome_cliente");
				this.cognomeCliente = rs.getString("cognome_cliente");
				this.telefonoCliente = rs.getString("telefono_cliente");
				this.emailCliente = rs.getString("email_cliente");
				this.codiceFiscaleCliente = rs.getString("codice_fiscale_cliente");
				this.note = rs.getString("preferenze");
				risultato += idCliente + ";" + this.nomeCliente +";"+ cognomeCliente+";"+telefonoCliente+";"+emailCliente+";"+codiceFiscaleCliente+";"+note+"\n";
				
			}
			
			//pulitura dei campi

			
			rs.close();
			pstmt.close();
			conn.close();

		}catch(SQLException e) {
			e.printStackTrace();

		}
		return risultato;
		
	}
	//aggiunta da comunicare
	public String visualizzaClienteNomeCognome(String nomeCliente, String cognomeCliente) {
		String risultato = "";
		try {
			String queryVisualizza= "SELECT * FROM clienti WHERE nome_cliente = ? AND cognome_cliente = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryVisualizza);
			pstmt.setString(1, nomeCliente);
			pstmt.setString(2, cognomeCliente);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				this.idCliente= rs.getInt("id_cliente");
				this.nomeCliente = rs.getString("nome_cliente");
				this.cognomeCliente = rs.getString("cognome_cliente");
				this.telefonoCliente = rs.getString("telefono_cliente");
				this.emailCliente = rs.getString("email_cliente");
				this.codiceFiscaleCliente = rs.getString("codice_fiscale_cliente");
				this.note = rs.getString("preferenze");
				risultato += idCliente + ";" + this.nomeCliente +";"+ this.cognomeCliente+";"+telefonoCliente+";"+emailCliente+";"+codiceFiscaleCliente+";"+note+"\n";
				
			}
			
			//pulitura dei campi

			
			rs.close();
			pstmt.close();
			conn.close();

		}catch(SQLException e) {
			e.printStackTrace();

		}
		return risultato;
		
	}
	public String visualizzaClienteCognome(String cognomeCliente) {
		String risultato = "";
		try {
			String queryVisualizza= "SELECT * FROM clienti WHERE cognome_cliente = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryVisualizza);
			pstmt.setString(1, cognomeCliente);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				this.idCliente= rs.getInt("id_cliente");
				this.nomeCliente = rs.getString("nome_cliente");
				this.cognomeCliente = rs.getString("cognome_cliente");
				this.telefonoCliente = rs.getString("telefono_cliente");
				this.emailCliente = rs.getString("email_cliente");
				this.codiceFiscaleCliente = rs.getString("codice_fiscale_cliente");
				this.note = rs.getString("preferenze");
				risultato += idCliente + ";" + nomeCliente +";"+ this.cognomeCliente+";"+telefonoCliente+";"+emailCliente+";"+codiceFiscaleCliente+";"+note+"\n";
			}
			//pulitura dei campi
			rs.close();
			pstmt.close();
			conn.close();

		}catch(SQLException e) {
			e.printStackTrace();

		}
		return risultato;
	}
	public String visualizzaClienteTelefono(String telefonoCliente) {
		String risultato = "";
		try {
			String queryVisualizza= "SELECT * FROM clienti WHERE telefono_cliente = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryVisualizza);
			pstmt.setString(1, telefonoCliente);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				this.idCliente= rs.getInt("id_cliente");
				this.nomeCliente = rs.getString("nome_cliente");
				this.cognomeCliente = rs.getString("cognome_cliente");
				this.telefonoCliente = rs.getString("telefono_cliente");
				this.emailCliente = rs.getString("email_cliente");
				this.codiceFiscaleCliente = rs.getString("codice_fiscale_cliente");
				this.note = rs.getString("preferenze");
				risultato += idCliente + ";" + nomeCliente +";"+ cognomeCliente+";"+this.telefonoCliente+";"+emailCliente+";"+codiceFiscaleCliente+";"+note+"\n";
			}

			//pulitura dei campi


			rs.close();
			pstmt.close();
			conn.close();

		}catch(SQLException e) {
			e.printStackTrace();

		}
		return risultato;
	}
	public String visualizzaClienteEmail(String emailCliente) {
		String risultato ="";
		try {
			String queryVisualizza= "SELECT * FROM clienti WHERE email_cliente = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryVisualizza);
			pstmt.setString(1, emailCliente);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				this.idCliente= rs.getInt("id_cliente");
				this.nomeCliente = rs.getString("nome_cliente");
				this.cognomeCliente = rs.getString("cognome_cliente");
				this.telefonoCliente = rs.getString("telefono_cliente");
				this.emailCliente = rs.getString("email_cliente");
				this.codiceFiscaleCliente = rs.getString("codice_fiscale_cliente");
				this.note = rs.getString("preferenze");
				risultato += idCliente + ";" + nomeCliente +";"+ cognomeCliente+";"+telefonoCliente+";"+this.emailCliente+";"+codiceFiscaleCliente+";"+note+"\n";
			}

			//pulitura dei campi


			rs.close();
			pstmt.close();
			conn.close();

		}catch(SQLException e) {
			e.printStackTrace();

		}
		return risultato;
	}
	public String visualizzaClienteCodiceFiscale(String codiceFiscaleCliente) {
		String risultato = "";
		try {
			String queryVisualizza= "SELECT * FROM clienti WHERE codice_fiscale_cliente = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryVisualizza);
			pstmt.setString(1, codiceFiscaleCliente);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				this.idCliente= rs.getInt("id_cliente");
				this.nomeCliente = rs.getString("nome_cliente");
				this.cognomeCliente = rs.getString("cognome_cliente");
				this.telefonoCliente = rs.getString("telefono_cliente");
				this.emailCliente = rs.getString("email_cliente");
				this.codiceFiscaleCliente = rs.getString("codice_fiscale_cliente");
				this.note = rs.getString("preferenze");
				risultato += idCliente + ";" + nomeCliente +";"+ cognomeCliente+";"+telefonoCliente+";"+emailCliente+";"+this.codiceFiscaleCliente+";"+note+"\n";
			}

			//pulitura dei campi


			rs.close();
			pstmt.close();
			conn.close();

		}catch(SQLException e) {
			e.printStackTrace();

		}
		return risultato;
	}
	public String visualizzaClienteNote(String note) {
		String risultato = "";
		try {
			String queryVisualizza= "SELECT * FROM clienti WHERE preferenze = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryVisualizza);
			pstmt.setString(1, note);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				this.idCliente= rs.getInt("id_cliente");
				this.nomeCliente = rs.getString("nome_cliente");
				this.cognomeCliente = rs.getString("cognome_cliente");
				this.telefonoCliente = rs.getString("telefono_cliente");
				this.emailCliente = rs.getString("email_cliente");
				this.codiceFiscaleCliente = rs.getString("codice_fiscale_cliente");
				this.note = rs.getString("preferenze");
				risultato += idCliente + ";" + nomeCliente +";"+ cognomeCliente+";"+telefonoCliente+";"+emailCliente+";"+codiceFiscaleCliente+";"+this.note+"\n";
			}

			//pulitura dei campi


			rs.close();
			pstmt.close();
			conn.close();

		}catch(SQLException e) {
			e.printStackTrace();

		}
		return risultato;
	}
	
	//metodo inserisci cliente
	public int inserisciCliente(String nomeCliente,String cognomeCliente,String telefonoCliente,String emailCliente,String codiceFiscaleCliente,String note) {
		try {
			String queryInserisci = "INSERT INTO clienti(nome_cliente, cognome_cliente, telefono_cliente, email_cliente, codice_fiscale_cliente, preferenze) VALUES(?, ?, ?, ?, ?, ?)";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryInserisci);
			pstmt.setString(1, nomeCliente);
			pstmt.setString(2, cognomeCliente);
			pstmt.setString(3, telefonoCliente);
			pstmt.setString(4, emailCliente);
			pstmt.setString(5, codiceFiscaleCliente);
			pstmt.setString(6, note);
			
			pstmt.executeUpdate();
			
			//pulitura dei campi
			//chiusura connessioni
			pstmt.close();
			conn.close();
			return 1;
			

		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("oops qualcosa è andato storto");
			return -1;
		}
	}
	//da modificare !!
	public int modificaCliente(int idCliente, String nomeCliente,String cognomeCliente,String telefonoCliente,String emailCliente,String codiceFiscaleCliente,String note) {
		try {
			String queryAggiornamento= "UPDATE clienti SET nome_cliente = ?, cognome_cliente = ?, telefono_cliente = ?, email_cliente = ?, codice_fiscale_cliente = ?, preferenze = ? WHERE id_cliente = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryAggiornamento);
			
			pstmt.setString(1, nomeCliente);
			pstmt.setString(2, cognomeCliente);
			pstmt.setString(3, telefonoCliente);
			pstmt.setString(4, emailCliente);
			pstmt.setString(5, codiceFiscaleCliente);
			pstmt.setString(6, note);
			pstmt.setInt(7, idCliente);
			
			pstmt.executeUpdate();
			
			//pulitura dei campi
			
			//chiusura connessioni
			pstmt.close();
			conn.close();
			return 1;

			

		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Errore durante la connessione al database.");
			return -1;
		}
	}
	
	public int eliminaCliente(int idCliente) {
		try {
			String queryEliminazione= "DELETE FROM clienti WHERE id_cliente = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryEliminazione);
			
			pstmt.setInt(1, idCliente);
			
			pstmt.executeUpdate();
		
			//chiusura connessioni
			pstmt.close();
			conn.close();
			return 1;
			

		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Errore durante la connessione al database.");
			System.out.println("oops qualcosa è andato storto");
			return -1;
			
		}
	}
	
	

}


package java_04_06.centro_estetico.CentroEstetico;

import java.sql.*;
import javax.swing.*;
import java.awt.*;


public class Macchinario {

	private static Connection conn;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	private static final String DB_URL = "jdbc:mysql://localhost:3306/centro_estetico_test";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "<Biagio3237>";


	int idMacchinario;
	String nomeMacchinario;
	String descrizioneMacchinario;
	int idServizio;
	int idStanza;

	//Costruttore
	public Macchinario(String nomeMacchinario, String descrizioneMacchinario, int idServizio, int idStanza) {
		this.idMacchinario = 0;
		this.nomeMacchinario = nomeMacchinario;
		this.descrizioneMacchinario = descrizioneMacchinario;
		this.idServizio = idServizio;
		this.idStanza = idStanza;
	}
	public Macchinario() {}

	//Metodi Getter
	public String getNomeMacchinario() {
		return nomeMacchinario;
	}
	public String getDescrizioneMacchinario() {
		return descrizioneMacchinario;
	}
	public int getIdServizio() {
		return idServizio;
	}
	public int getidStanza() {
		return idStanza;
	}
	public int getidMacchinario() {
		return idMacchinario;
	}

	//Metodi Setter
	public void setNomeMacchinario(String nomeMacchinario) {
		this.nomeMacchinario = nomeMacchinario;
	}
	public void setDescrizioneMacchinario(String descrizioneMacchinario) {
		this.descrizioneMacchinario = descrizioneMacchinario;
	}
	public void setIdServizio(int idServizio) {
		this.idServizio = idServizio;
	}
	public void setIdStanza(int idStanza) {
		this.idStanza = idStanza;
	}

	//VISUALIZZA MACCHINARIO PER ID
	private String visualizzaMacchinarioId(int idMacchinario) {
		String risultato = "";
		try {
			String queryVisualizza= "SELECT * FROM macchinari WHERE id_macchinario = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryVisualizza);
			pstmt.setInt(1, idMacchinario);
			rs = pstmt.executeQuery(queryVisualizza);
			while(rs.next()) {
				this.idMacchinario = rs.getInt("id_macchinario");
				this.nomeMacchinario = rs.getString("nome_macchinario");
				this.descrizioneMacchinario = rs.getString("descrizione_macchinario");
				this.idServizio = rs.getInt("id_servizio");
				this.idStanza = rs.getInt("id_stanza");

				risultato = this.idMacchinario + ";" + nomeMacchinario + ";" + descrizioneMacchinario + ";" + idServizio +";" + idStanza;
			}

			rs.close();
			pstmt.close();
			conn.close();

		}catch(SQLException e) {
			e.printStackTrace();

		}
		return risultato;
	}

	//VISUALIZZA TUTTI I MACCHINARI
	public String visualizzaTuttiMacchinari() {
		String risultato = "";
		try {
			String queryVisualizzaTutto= "SELECT * FROM macchinari";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(queryVisualizzaTutto);

			while(rs.next()) {
				this.idMacchinario = rs.getInt("id_macchinario");
				this.nomeMacchinario = rs.getString("nome_macchinario");
				this.descrizioneMacchinario = rs.getString("descrizione_macchinario");
				this.idServizio = rs.getInt("id_servizio");
				this.idStanza = rs.getInt("id_stanza");
				risultato += idMacchinario + ";" + nomeMacchinario + ";" + descrizioneMacchinario + ";" + idServizio +";" + idStanza + "\n";
				/*int idMacchinario = rs.getInt("id_macchinario");
				String nomeMacchinario = rs.getString("nome_macchinario");
				String descrizioneMacchinario = rs.getString("descrizione_macchinario");
				int idServizio = rs.getInt("id_servizio");
				int idStanza = rs.getInt("id_stanza");*/
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return risultato;
	}

	//VISUALIZZA MACCHINARIO PER NOME
	public String visualizzaMacchinarioNome(String nomeMacchinario) {
		String risultato = "";
		try {
			String queryVisualizza= "SELECT * FROM macchinari WHERE nome_macchinario = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryVisualizza);
			pstmt.setString(1, nomeMacchinario);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				this.idMacchinario = rs.getInt("id_macchinario");
				this.nomeMacchinario = rs.getString("nome_macchinario");
				this.descrizioneMacchinario = rs.getString("descrizione_macchinario");
				this.idServizio = rs.getInt("id_servizio");
				this.idStanza = rs.getInt("id_stanza");

				risultato += idMacchinario + ";" + this.nomeMacchinario + ";" + descrizioneMacchinario + ";" + idServizio +";" + idStanza + "\n";

			}

			rs.close();
			pstmt.close();
			conn.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return risultato;
	}

	//VISUALIZZA MACCHINARIO PER ID SERVIZIO
	public String visualizzaMacchinarioIdServizio(int idServizio) {
		String risultato = "";
		try {
			String queryVisualizza= "SELECT * FROM macchinari WHERE id_servizio = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryVisualizza);
			pstmt.setInt(1, idServizio);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				this.idMacchinario = rs.getInt("id_macchinario");
				this.nomeMacchinario = rs.getString("nome_macchinario");
				this.descrizioneMacchinario = rs.getString("descrizione_macchinario");
				this.idServizio = rs.getInt("id_servizio");
				this.idStanza = rs.getInt("id_stanza");

				risultato += idMacchinario + ";" + nomeMacchinario + ";" + descrizioneMacchinario + ";" + this.idServizio +";" + idStanza + "\n";

			}

			rs.close();
			pstmt.close();
			conn.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return risultato;
	}

	//VISUALIZZA MACCHINARIO PER ID STANZA
	public String visualizzaMacchinarioIdStanza(int idStanza) {
		String risultato = "";
		try {
			String queryVisualizza= "SELECT * FROM macchinari WHERE id_stanza = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryVisualizza);
			pstmt.setInt(1, idStanza);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				this.idMacchinario = rs.getInt("id_macchinario");
				this.nomeMacchinario = rs.getString("nome_macchinario");
				this.descrizioneMacchinario = rs.getString("descrizione_macchinario");
				this.idServizio = rs.getInt("id_servizio");
				this.idStanza = rs.getInt("id_stanza");

				risultato += this.idMacchinario + ";" + nomeMacchinario + ";" + descrizioneMacchinario + ";" + idServizio +";" + this.idStanza + "\n";

			}

			rs.close();
			pstmt.close();
			conn.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return risultato;
	}
	//INSERIMENTO NUOVO MACCHINARIO
	public int inserisciMacchinario(String nomeMacchinario, String descrizioneMacchinario, int idServizio, int idStanza) {
		try {
			String queryInserisci = "INSERT INTO macchinari(nome_macchinario,descrizione_macchinario, id_servizio, id_stanza) VALUES(?, ?, ?, ?)";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryInserisci);

			//VALORIZZAZIONE DEI PLACEHOLDER
			pstmt.setString(1, nomeMacchinario);
			pstmt.setString(2, descrizioneMacchinario);
			pstmt.setInt(3, idServizio);
			pstmt.setInt(4, idStanza);
			//ESECUZIONE DELLA QUERY
			pstmt.executeUpdate();
			
			
			pstmt.close();
			conn.close();
			return 1;
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("OPS Qualcosa è andato storto!");
			return -1;
		}
	
	}

	//AGGIORNAMENTO MACCHINARIO 
	public int modificaMacchinario(int idMacchinario, String nomeMacchinario, String descrizioneMacchinario, int idServizio, int idStanza) {
		try {
			String queryModifica = "UPDATE macchinari SET nome_macchinario = ?, descrizione_macchinario = ?, id_servizio = ?, id_stanza = ? WHERE id_macchinario = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryModifica);
			//VALORIZZAZIONE DEI PLACEHOLDER
			pstmt.setString(1, nomeMacchinario);
			pstmt.setString(2, descrizioneMacchinario);
			pstmt.setInt(3, idServizio);
			pstmt.setInt(4, idStanza);
			pstmt.setInt(5, idMacchinario);
			//ESECUZIONE DELLA QUERY
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			return 1;
			

		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("OPS Qualcosa è andato storto!");
			return -1;
		}
	}

	//ELIMINAZIONE MACCHINARIO
	public int eliminaMacchinario(int idMacchinario) {
		try {
			String queryElimina = "DELETE FROM macchinari WHERE id_macchinario = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryElimina);
			//VALORIZZAZIONE DEI PLACEHOLDER
			pstmt.setInt(1, idMacchinario);
			//ESECUZIONE DELLA QUERY
			pstmt.executeUpdate();

			
			pstmt.close();
			conn.close();
			return 1;
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("OPS Qualcosa è andato storto!");
			return -1;
		}
	}

}

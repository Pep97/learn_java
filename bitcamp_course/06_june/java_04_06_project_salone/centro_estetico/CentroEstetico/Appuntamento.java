package java_04_06.centro_estetico.CentroEstetico;

import java.sql.*;


public class Appuntamento {

	private static Connection conn;
	//private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	private static final String DB_URL = "jdbc:mysql://localhost:3306/centro_estetico_test";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	private int idAppuntamento;
	private String dataInizio;
	private String dataFine;
	private String durataAppuntamento;
	private int idStanza;
	private int idCliente;
	private int idServizio;
	private int idDipendente;
	private int idMacchinario;


	public Appuntamento() {

	}

	public Appuntamento(String dataInizio, String dataFine, String durataAppuntamento, int idServizio, int idDipendente, int idMacchinario, int idStanza, int idCliente) {
		this.idAppuntamento = 0;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.durataAppuntamento = durataAppuntamento;
		this.idServizio = idServizio;
		this.idDipendente = idDipendente;
		this.idMacchinario = idMacchinario;
		this.idStanza = idStanza;
		this.idCliente = idCliente;

	}



	//metodo get
	public String getDataInizio() {
		return dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}
	public String getDurataAppuntamento() {
		return durataAppuntamento;
	}
	public int getIdServizio() {
		return idServizio;
	}
	public int getIdDipendente() {
		return idDipendente;

	}public int getIdMacchinario() {
		return idMacchinario;
	}
	public int getIdAppuntamento() {
		return idAppuntamento;
	}
	public int getIdStanza() {
		return idStanza;
	}
	public int getIdCliente() {
		return idCliente;
	}

	//metodo set
	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}
	public void setDataFine(String dataFine) {
		this.dataFine = dataFine; 
	}
	public void setDataAppuntamento(String durataAppuntamento) {
		this.durataAppuntamento = durataAppuntamento; 
	}
	public void setIdServizio(int idServizio) {
		this.idServizio = idServizio; 
	}
	public void setIdDipendente(int idDipendente) {
		this.idDipendente = idDipendente; 
	}
	public void setIdMacchinario(int idMacchinario) {
		this.idMacchinario = idMacchinario; 
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public void setIdStanza(int idStanza) {
		this.idStanza = idStanza;
	}

	public int inserisciAppuntamento(String dataInizio, String dataFine, String durataAppuntamento, int idServizio, int idDipendente, int idMacchinario, int idStanza, int idCliente) {
		try {
			String queryInserisci = "INSERT INTO appuntamenti(data_inizio, data_fine, durata_appuntamento, id_servizio, id_dipendente, id_macchinario, id_stanza, id_cliente) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryInserisci);
			pstmt.setString(1, dataInizio);
			pstmt.setString(2, dataFine);
			pstmt.setString(3, durataAppuntamento);
			pstmt.setInt(4, idServizio);
			pstmt.setInt(5, idDipendente);
			pstmt.setInt(6, idMacchinario);
			pstmt.setInt(7, idStanza);
			pstmt.setInt(8, idCliente);

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
	public int modificaAppuntamento(int idAppuntamento, String dataInizio, String dataFine, String dataAppuntamento, int idServizio, int idDipendente, int idMacchinario, int idStanza, int idCliente) {
		try {
			String queryAggiornamento= "UPDATE appuntamenti SET data_inizio = ?, data_fine = ?, durata_appuntamento = ?, id_servizio = ?, id_dipendente = ?, id_macchinario = ?, id_stanza = ?, id_cliente = ? WHERE id_appuntamento = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryAggiornamento);

			pstmt.setString(1, dataInizio);
			pstmt.setString(2, dataFine);
			pstmt.setString(3, dataAppuntamento);
			pstmt.setInt(4, idServizio);
			pstmt.setInt(5, idDipendente);
			pstmt.setInt(6, idMacchinario);
			pstmt.setInt(7, idStanza);
			pstmt.setInt(8, idCliente);
			pstmt.setInt(9, idAppuntamento);

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
	public int eliminaAppuntamento(int idAppuntamento) {
		String DELETE_QUERY = "DELETE FROM appuntamenti WHERE id_appuntamento = ? ";

		try {
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(DELETE_QUERY);

			pstmt.setInt(1, idAppuntamento);
			pstmt.executeUpdate();
			System.out.println("Appuntamento eliminato con successo");

			pstmt.close();
			conn.close();
			return 1;
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Qualcosa è andato storto!");
			return -1;

		}
	}


	public String visualizzaTuttiAppuntamenti() {
		String risultato = "";
		try {
			String queryVisualizza= "SELECT * FROM appuntamenti";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryVisualizza);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				this.idAppuntamento= rs.getInt("id_appuntamento");
				this.dataInizio = rs.getString("data_inizio");
				this.dataFine = rs.getString("data_fine");
				this.durataAppuntamento = rs.getString("durata_appuntamento");
				this.idServizio = rs.getInt("id_servizio");
				this.idDipendente = rs.getInt("id_dipendente");
				this.idMacchinario = rs.getInt("id_macchinario");
				this.idStanza = rs.getInt("id_stanza");
				this.idCliente = rs.getInt("id_cliente");

				risultato += idAppuntamento + ";" + dataInizio +";"+ dataFine+";"+durataAppuntamento+";"+idServizio+";"+idDipendente+";"+idMacchinario+";"+idStanza+";"+idCliente +"\n";
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
	public String visualizzaAppuntamenti(int idAppuntamento) {
		String risultato = "";
		try {
			String queryVisualizza= "SELECT * FROM appuntamenti WHERE id_appuntamento = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryVisualizza);
			pstmt.setInt(1, idAppuntamento);
			rs = pstmt.executeQuery();
			while(rs.next()) {

				this.idAppuntamento = rs.getInt("id_cliente");
				this.dataInizio = rs.getString("data_inizio");
				this.dataFine = rs.getString("data_fine");
				this.durataAppuntamento = rs.getString("durata_appuntamento");
				this.idServizio = rs.getInt("id_servizio");
				this.idDipendente = rs.getInt("id_dipendente");
				this.idMacchinario = rs.getInt("id_macchinario");
				this.idStanza = rs.getInt("id_stanza");
				this.idCliente = rs.getInt("id_cliente");
				risultato += this.idAppuntamento + ";" + dataInizio +";"+ dataFine+";"+durataAppuntamento+";"+idServizio+";"+idDipendente+";"+idMacchinario+";"+idStanza+";"+idCliente+"\n";
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

	public String visualizzaAppuntamentiPerData(String dataInizio) {
		String risultato = "";
		try {
			String queryVisualizza= "SELECT * FROM appuntamenti WHERE data_inizio = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryVisualizza);
			pstmt.setString(1, dataInizio);
			rs = pstmt.executeQuery();
			while(rs.next()) {

				this.idAppuntamento = rs.getInt("id_cliente");
				this.dataInizio = rs.getString("data_inizio");
				this.dataFine = rs.getString("data_fine");
				this.durataAppuntamento = rs.getString("durata_appuntamento");
				this.idServizio = rs.getInt("id_servizio");
				this.idDipendente = rs.getInt("id_dipendente");
				this.idMacchinario = rs.getInt("id_macchinario");
				this.idStanza = rs.getInt("id_stanza");
				this.idCliente = rs.getInt("id_cliente");
				risultato += idAppuntamento + ";" + this.dataInizio +";"+ dataFine+";"+durataAppuntamento+";"+idServizio+";"+idDipendente+";"+idMacchinario+";"+idStanza+";"+idCliente+"\n";
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
	public String visualizzaAppuntamentiPerDurata(String durataAppuntamento) {

		String SELECT_QUERY= "SELECT * FROM appuntamenti WHERE durata_appuntamento = ?";

		String risultato = "";

		try {
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(SELECT_QUERY);

			pstmt.setString(1, durataAppuntamento);
			rs = pstmt.executeQuery();

			while(rs.next()) {

				this.idAppuntamento= rs.getInt("id_appuntamento");
				this.dataInizio = rs.getString("data_inizio");
				this.dataFine = rs.getString("data_fine");
				this.durataAppuntamento = rs.getString("durata_appuntamento");
				this.idServizio = rs.getInt("id_servizio");
				this.idDipendente = rs.getInt("id_dipendente");
				this.idMacchinario = rs.getInt("id_macchinario");
				this.idStanza = rs.getInt("id_stanza");
				this.idCliente = rs.getInt("id_cliente");

				risultato += idAppuntamento + ";" + dataInizio +";"+ dataFine+";"+ this.durataAppuntamento+";"+idServizio+";"+idDipendente+";"+idMacchinario+";"+idStanza+";"+idCliente +"\n";
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
	public String visualizzaAppuntamentiPerDipendente(int idDipendente) {
		String risultato = "";
		try {
			String queryVisualizza= "SELECT * FROM appuntamenti WHERE id_dipendente = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryVisualizza);
			pstmt.setInt(1, idDipendente);
			rs = pstmt.executeQuery();
			while(rs.next()) {

				this.idAppuntamento = rs.getInt("id_cliente");
				this.dataInizio = rs.getString("data_inizio");
				this.dataFine = rs.getString("data_fine");
				this.durataAppuntamento = rs.getString("durata_appuntamento");
				this.idServizio = rs.getInt("id_servizio");
				this.idDipendente = rs.getInt("id_dipendente");
				this.idMacchinario = rs.getInt("id_macchinario");
				this.idStanza = rs.getInt("id_stanza");
				this.idCliente = rs.getInt("id_cliente");
				risultato += idAppuntamento + ";" + dataInizio +";"+ dataFine+";"+durataAppuntamento+";"+idServizio+";"+this.idDipendente+";"+idMacchinario+";"+idStanza+";"+idCliente+"\n";
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
	public String visualizzaAppuntamentiPerMacchinario(int idMacchinario) {
		String risultato = "";
		try {
			String queryVisualizza= "SELECT * FROM appuntamenti WHERE id_macchinario = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryVisualizza);
			pstmt.setInt(1, idMacchinario);
			rs = pstmt.executeQuery();
			while(rs.next()) {

				this.idAppuntamento = rs.getInt("id_cliente");
				this.dataInizio = rs.getString("data_inizio");
				this.dataFine = rs.getString("data_fine");
				this.durataAppuntamento = rs.getString("durata_appuntamento");
				this.idServizio = rs.getInt("id_servizio");
				this.idDipendente = rs.getInt("id_dipendente");
				this.idMacchinario = rs.getInt("id_macchinario");
				this.idStanza = rs.getInt("id_stanza");
				this.idCliente = rs.getInt("id_cliente");
				risultato += idAppuntamento + ";" + dataInizio +";"+ dataFine+";"+durataAppuntamento+";"+idServizio+";"+idDipendente+";"+this.idMacchinario+";"+idStanza+";"+idCliente+"\n";
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
	public String visualizzaAppuntamentiPerStanza(int idStanza) {
		String risultato = "";
		try {
			String queryVisualizza= "SELECT * FROM appuntamenti WHERE id_stanza = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryVisualizza);
			pstmt.setInt(1,  idStanza);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				this.idAppuntamento= rs.getInt("id_appuntamento");
				this.dataInizio = rs.getString("data_inizio");
				this.dataFine = rs.getString("data_fine");
				this.durataAppuntamento = rs.getString("durata_appuntamento");
				this.idServizio = rs.getInt("id_servizio");
				this.idDipendente = rs.getInt("id_dipendente");
				this.idMacchinario = rs.getInt("id_macchinario");
				this.idStanza = rs.getInt("id_stanza");
				this.idCliente = rs.getInt("id_cliente");

				risultato += idAppuntamento + ";" + dataInizio +";"+ dataFine+";"+durataAppuntamento+";"+idServizio+";"+idDipendente+";"+idMacchinario+";"+this.idStanza+";"+idCliente +"\n";
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

	public String visualizzaAppuntamentiPerServizio(int idServizio) {
		String risultato = "";
		try {
			String queryVisualizza= "SELECT * FROM appuntamenti WHERE id_servizio = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryVisualizza);
			pstmt.setInt(1, idServizio);
			rs = pstmt.executeQuery();
			while(rs.next()) {

				this.idAppuntamento = rs.getInt("id_cliente");
				this.dataInizio = rs.getString("data_inizio");
				this.dataFine = rs.getString("data_fine");
				this.durataAppuntamento = rs.getString("durata_appuntamento");
				this.idServizio = rs.getInt("id_servizio");
				this.idDipendente = rs.getInt("id_dipendente");
				this.idMacchinario = rs.getInt("id_macchinario");
				this.idStanza = rs.getInt("id_stanza");
				this.idCliente = rs.getInt("id_cliente");
				risultato += idAppuntamento + ";" + dataInizio +";"+ dataFine+";"+durataAppuntamento+";"+this.idServizio+";"+this.idDipendente+";"+idMacchinario+";"+idStanza+";"+idCliente+"\n";
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
	public String visualizzaAppuntamentiPerCliente(int idCliente) {
		String risultato = "";
		try {
			String queryVisualizza= "SELECT * FROM appuntamenti WHERE id_cliente = ?";
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			pstmt = conn.prepareStatement(queryVisualizza);
			pstmt.setInt(1, idCliente);
			rs = pstmt.executeQuery();
			while(rs.next()) {

				this.idAppuntamento = rs.getInt("id_cliente");
				this.dataInizio = rs.getString("data_inizio");
				this.dataFine = rs.getString("data_fine");
				this.durataAppuntamento = rs.getString("durata_appuntamento");
				this.idServizio = rs.getInt("id_servizio");
				this.idDipendente = rs.getInt("id_dipendente");
				this.idMacchinario = rs.getInt("id_macchinario");
				this.idStanza = rs.getInt("id_stanza");
				this.idCliente = rs.getInt("id_cliente");
				risultato += idAppuntamento + ";" + dataInizio +";"+ dataFine+";"+durataAppuntamento+";"+idServizio+";"+idDipendente+";"+idMacchinario+";"+idStanza+";"+this.idCliente+"\n";
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
}


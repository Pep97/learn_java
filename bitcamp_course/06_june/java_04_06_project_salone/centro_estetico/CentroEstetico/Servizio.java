package java_04_06.centro_estetico.CentroEstetico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

public class Servizio {


	private static final String DB_URL="jdbc:mysql://localhost:3306/centro_estetico_test";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	private static Connection conn ;
	private static PreparedStatement pstmt;
	//private static Statement stmt;
	private static ResultSet rs;

	private int idServizio;
	private String nomeServizio;
	private String descrizioneServizio;
	private  String durataServizio;
	private double prezzoUnitario;
	private int idDipendente;

	public Servizio(String nomeServizio, String descrizioneServizio, String durataServizio, double prezzoUnitario, int idDipendente) {
		this.idServizio = 0;
		this.descrizioneServizio = descrizioneServizio;
		this.durataServizio = durataServizio;
		this.prezzoUnitario = prezzoUnitario;
		this.nomeServizio = nomeServizio;
		this.idDipendente = idDipendente;

	}

	public Servizio() {}


	public void setNomeServizio(String nomeServizio) {
		this.nomeServizio = nomeServizio;

	}

	public void setDescrizioneServizio(String descrizioneServizio) {
		this.descrizioneServizio = descrizioneServizio;
	}

	public void setDurataServizio(String durataServizio) {
		this.durataServizio = durataServizio;
	}

	public void setPrezzoUnitario(double prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}

	public void setIdDipendente(int idDipendente) {
		this.idDipendente = idDipendente;

	}

	public String getNomeServizio() {
		return nomeServizio;
	}

	public String getDescrizioneServizio() {
		return descrizioneServizio;
	}

	public String getDurataServizio() {
		return durataServizio;
	}

	public double getPrezzoUnitario() {
		return prezzoUnitario;
	}

	public int getIdDipendente() {
		return idDipendente;
	}

	public int getIdServizio() {
		return idServizio;
	}


	public String visualizzaServizioPerIdDipendente(int idDipendente) {
		 String risultato="";
		try {

			conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
           


			String queryVisualizza="SELECT * FROM servizi WHERE id_dipendente = ?";
			pstmt=conn.prepareStatement(queryVisualizza);


			pstmt.setInt(1, idDipendente);

			rs = pstmt.executeQuery();

			while(rs.next()) {

				this.idDipendente = rs.getInt("id_dipendente");
				this.nomeServizio = rs.getString("nome_servizio");
				this.descrizioneServizio = rs.getString("descrizione_servizio");
				this.durataServizio = rs.getString("durata_servizio");
				this.prezzoUnitario = rs.getDouble("prezzo_unitario");
				this.idServizio = rs.getInt("id_servizio");

				 risultato += idServizio+";"+nomeServizio+";"+descrizioneServizio+";"+durataServizio+";"+prezzoUnitario+";"+this.idDipendente+"\n";
				

			}





			//Chiusura DB rs e pstmt
			rs.close();
			pstmt.close();
			conn.close();


		}catch(SQLException e){

			e.printStackTrace();
			System.out.println("oops qualcosa è andato storto");

		}
		
		return risultato;
	}


	public String visualizzaServizioPerNomeServizio(String nomeServizio) {
      String risultato="";
		try {

			conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);



			String queryVisualizza="SELECT * FROM servizi WHERE nome_servizio = ?";
			pstmt=conn.prepareStatement(queryVisualizza);


			pstmt.setString(1, nomeServizio);

			rs = pstmt.executeQuery();

			while(rs.next()) {

				this.idDipendente = rs.getInt("id_dipendente");
				this.nomeServizio = rs.getString("nome_servizio");
				this.descrizioneServizio = rs.getString("descrizione_servizio");
				this.durataServizio = rs.getString("durata_servizio");
				this.prezzoUnitario = rs.getDouble("prezzo_unitario");
				this.idServizio = rs.getInt("id_servizio");

				 risultato += idServizio+";"+this.nomeServizio+";"+descrizioneServizio+";"+durataServizio+";"+prezzoUnitario+";"+idDipendente+"\n";

			}




			//Chiusura DB rs e pstmt
			rs.close();
			pstmt.close();
			conn.close();


		}catch(SQLException e){

			e.printStackTrace();
			System.out.println("oops qualcosa è andato storto");

		}
		
		return risultato;
	}



	public String visualizzaServizioPerPrezzoUnitario(double prezzoUnitario) {

		String risultato="";
		
		try {

			conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);



			String queryVisualizza="SELECT * FROM servizi WHERE prezzo_unitario = ?";
			pstmt=conn.prepareStatement(queryVisualizza);


			pstmt.setDouble(1, prezzoUnitario);

			rs = pstmt.executeQuery();

			while(rs.next()) {

				this.idDipendente = rs.getInt("id_dipendente");
				this.nomeServizio = rs.getString("nome_servizio");
				this.descrizioneServizio = rs.getString("descrizione_servizio");
				this.durataServizio = rs.getString("durata_servizio");
				this.prezzoUnitario = rs.getDouble("prezzo_unitario");
				this.idServizio = rs.getInt("id_servizio");

				risultato += idServizio+";"+nomeServizio+";"+descrizioneServizio+";"+durataServizio+";"+this.prezzoUnitario+";"+idDipendente+"\n";

			}





			//Chiusura DB rs e pstmt
			rs.close();
			pstmt.close();
			conn.close();


		}catch(SQLException e){

			e.printStackTrace();
			System.out.println("oops qualcosa è andato storto");

		}
		
		return risultato;
	}


	public String visualizzaServizioPerIdServizio(int idServizio) {
         String risultato="";
		try {

			conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);



			String queryVisualizza="SELECT * FROM servizi WHERE id_servizio = ?";
			pstmt=conn.prepareStatement(queryVisualizza);


			pstmt.setInt(1, idServizio);

			rs = pstmt.executeQuery();

			while(rs.next()) {

				this.idDipendente = rs.getInt("id_dipendente");
				this.nomeServizio = rs.getString("nome_servizio");
				this.descrizioneServizio = rs.getString("descrizione_servizio");
				this.durataServizio = rs.getString("durata_servizio");
				this.prezzoUnitario = rs.getDouble("prezzo_unitario");
				this.idServizio = rs.getInt("id_servizio");

				risultato += this.idServizio+";"+nomeServizio+";"+descrizioneServizio+";"+durataServizio+";"+prezzoUnitario+";"+idServizio+"\n";

			}


			//Chiusura DB rs e pstmt
			rs.close();
			pstmt.close();
			conn.close();


		}catch(SQLException e){

			e.printStackTrace();
			System.out.println("oops qualcosa è andato storto");

		}
		
		return risultato;
	}



	public int inserisciServizio(String nomeServizio,String descrizioneServizio, String durataServizio, double prezzoUnitario,int idDipendente) {

		try {

			conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);



			String queryInserisciServizio="INSERT INTO  servizi (nome_servizio,descrizione_servizio,durata_servizio,prezzo_unitario,id_dipendente) VALUES(?,?,?,?,?)";
			pstmt=conn.prepareStatement(queryInserisciServizio);


			pstmt.setString(1,nomeServizio);
			pstmt.setString(2, descrizioneServizio);
			pstmt.setString(3, durataServizio);
			pstmt.setDouble(4, prezzoUnitario);
			pstmt.setInt(5, idDipendente);

			pstmt.executeUpdate();

			//Chiusura DB rs e pstmt
			pstmt.close();
			conn.close();
			return 1;

		}catch(SQLException e){

			e.printStackTrace();
			System.out.println("oops qualcosa è andato storto");
			return -1;

		}

	}


	public int modificaServizio(int idServizio, String nomeServizio,String descrizioneServizio, String durataServizio, double prezzoUnitario,int idDipendente) {
		try {

			conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);



			String queryModificaServizio="UPDATE servizi SET nome_servizio = ? , descrizione_servizio = ?,durata_servizio = ?, prezzo_unitario=?, id_dipendente = ? where id_servizio = ?";
			pstmt=conn.prepareStatement(queryModificaServizio);


			pstmt.setString(1,nomeServizio);
			pstmt.setString(2, descrizioneServizio);
			pstmt.setString(3, durataServizio);
			pstmt.setDouble(4, prezzoUnitario);
			pstmt.setInt(5, idDipendente);
			pstmt.setInt(6, idServizio);

			pstmt.executeUpdate();

			//Chiusura DB rs e pstmt
			pstmt.close();
			conn.close();
			return 1;

		}catch(SQLException e){

			e.printStackTrace();
			System.out.println("oops qualcosa è andato storto");
			return -1;

		}
	}

	public int eliminaServizio(int idServizio) {
		try {

			conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);



			String queryEliminaServizio="DELETE FROM  servizi WHERE id_servizio=?";
			pstmt=conn.prepareStatement(queryEliminaServizio);


			pstmt.setInt(1,idServizio);


			pstmt.executeUpdate();

			//Chiusura DB rs e pstmt
			pstmt.close();
			conn.close();
			return 1;

		}catch(SQLException e){

			e.printStackTrace();
			System.out.println("oops qualcosa è andato storto");
			return -1;

		}
	}




}

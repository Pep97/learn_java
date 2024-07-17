package java_04_06.centro_estetico.CentroEstetico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Stanza {

	//Attributi
	private int idStanza;
	private String nomeStanza;
	private String descrizioneStanza;
	private String tipologiaStanza;
	
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection conn;
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/centro_estetico_test";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	//Costruttore
	public Stanza(int idStanza, String nomeStanza, String descrizioneStanza, String tipologiaStanza) {
		this.idStanza = 0;
		this.nomeStanza = nomeStanza;
		this.descrizioneStanza = descrizioneStanza;
		this.tipologiaStanza = tipologiaStanza;
	}

	//Costruttore vuoto
	public Stanza() {
		
	}

	//Metodi Getter & Setter 
	public String getNomeStanza() {
		return nomeStanza;
	}

	public void setNomeStanza(String nomeStanza) {
		this.nomeStanza = nomeStanza;
	}

	public String getDescrizioneStanza() {
		return descrizioneStanza;
	}

	public void setDescrizioneStanza(String descrizioneStanza) {
		this.descrizioneStanza = descrizioneStanza;
	}

	public String getTipologiaStanza() {
		return tipologiaStanza;
	}

	public void setTipologiaStanza(String tipologiaStanza) {
		this.tipologiaStanza = tipologiaStanza;
	}
	
	
	
	//METODI CRUD
	
		//Visualizza per ID
		public String visualizzaStanzaPerIdStanza(int idStanza) {
			
			String risultato = "";
			
			try {
				
				conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
				
				
				
				String queryVisualizza="SELECT * FROM stanze WHERE id_stanza = ?";
				pstmt=conn.prepareStatement(queryVisualizza);
				
				
				pstmt.setInt(1, idStanza);
				
			    rs = pstmt.executeQuery();
			    
			    while(rs.next()) {
			    	
			    	  this.idStanza = rs.getInt("id_stanza");
			    	  this.nomeStanza = rs.getString("nome_stanza");
			    	  this.descrizioneStanza = rs.getString("descrizione_stanza");
			          this.tipologiaStanza = rs.getString("tipologia_stanza");
			          
			          risultato += this.idStanza+";"+nomeStanza+";"+descrizioneStanza+";"+tipologiaStanza;
			    	
			    }
				
			   
			    
			    
			    //pulizia dei campi
			    
			    rs.close();
			    pstmt.close();
			    conn.close();
				
				
			}catch(SQLException e){
				
				e.printStackTrace();
				System.out.println("oops qualcosa è andato storto");
				
			}
			return risultato;
		}
		
		//Visualizza per NOME
		public String visualizzaStanzaPerNomeStanza(String nomeStanza) {

			String risultato = "";
			
	        try {

	            conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);



	            String queryVisualizza="SELECT * FROM stanze WHERE nome_stanza = ?";
	            pstmt=conn.prepareStatement(queryVisualizza);


	            pstmt.setString(1, nomeStanza);

	            rs = pstmt.executeQuery();

	            while(rs.next()) {

	                  this.idStanza = rs.getInt("id_stanza");
	                  this.nomeStanza = rs.getString("nome_stanza");
	                  this.descrizioneStanza = rs.getString("descrizione_stanza");
	                  this.tipologiaStanza = rs.getString("tipologia_stanza");
	                  

	                  risultato += this.idStanza +";"+nomeStanza+";"+ descrizioneStanza +";"+descrizioneStanza+";"+idStanza;

	            }




	            //pulitura dei campi

	            rs.close();
	            pstmt.close();
	            conn.close();



	        }catch(SQLException e){

	            e.printStackTrace();
	            System.out.println("oops qualcosa è andato storto");


	        }
	        return risultato;
	    }
		
		//Visualizza per TIPOLOGIA
		public String visualizzaStanzaPerTipologiaStanza(String tipologiaStanza) {
			
			String risultato = "";
			
			try {
				
				conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
				
				
				
				String queryVisualizza="SELECT * FROM stanze WHERE tipologia_stanza = ?";
				pstmt=conn.prepareStatement(queryVisualizza);
				
				
				pstmt.setString(1, tipologiaStanza);
				
			    rs = pstmt.executeQuery();
			    
			    while(rs.next()) {
			    	
			    	  this.idStanza = rs.getInt("id_stanza");
			    	  this.nomeStanza = rs.getString("nome_stanza");
			    	  this.descrizioneStanza = rs.getString("descrizione_stanza");
			          this.tipologiaStanza = rs.getString("tipologia_stanza");
			          
			          risultato += idStanza+";"+nomeStanza+";"+descrizioneStanza+";"+this.tipologiaStanza;
			    	
			    }
				
			   
			    
			    
			    //pulizia dei campi
			    
			    rs.close();
			    pstmt.close();
			    conn.close();
				
				
			}catch(SQLException e){
				
				e.printStackTrace();
				System.out.println("oops qualcosa è andato storto");
				
			}
			return risultato;
		}
	
		//Visualizza per DESCRIZIONE
		public String visualizzaDescrizioneStanza(String descrizioneStanza) {

			String risultato = "";
			
	        try {

	            conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);



	            String queryVisualizza="SELECT * FROM Stanze WHERE descrizione_stanza = ?";
	            pstmt=conn.prepareStatement(queryVisualizza);


	            pstmt.setString(1, descrizioneStanza);

	            rs = pstmt.executeQuery();

	            while(rs.next()) {

	                  this.idStanza = rs.getInt("id_stanza");
	                  this.nomeStanza = rs.getString("nome_stanza");
	                  this.descrizioneStanza = rs.getString("descrizione_Stanza");
	                  this.tipologiaStanza = rs.getString("tipologia_stanza");


	                  risultato +=idStanza +";"+nomeStanza+";"+ this.descrizioneStanza +";"+tipologiaStanza;

	            }




	            //pulitura dei campi

	            rs.close();
	            pstmt.close();
	            conn.close();



	        }catch(SQLException e){

	            e.printStackTrace();
	            System.out.println("oops qualcosa è andato storto");


	        }
	        return risultato;
	    }
		
		//INSERISCI
	    public int inserisciStanza(String nomeStanza, String descrizioneStanza, String categoriaStanza) {

	        try {

	                conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);



	                String queryInserisciStanza="INSERT INTO  stanze (nome_stanza,descrizione_stanza,tipologia_stanza) VALUES(?,?,?)";
	                pstmt=conn.prepareStatement(queryInserisciStanza);


	                pstmt.setString(1,nomeStanza);
	                pstmt.setString(2,descrizioneStanza);
	                pstmt.setString(3,categoriaStanza);



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
	    
	  //MODIFICA prodotto
		public int modificaStanza(int idStanza,String nomeStanza, String descrizioneStanza, String tipologiaStanza) {
			
			try {
					
					conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
					
					
					
					String queryInserisciProdotto="UPDATE stanze SET nome_stanza = ? , descrizione_stanza = ?,tipologia_stanza = ? where id_stanza = ?";
					pstmt=conn.prepareStatement(queryInserisciProdotto);
					
					
					pstmt.setString(1,nomeStanza);
					pstmt.setString(2,descrizioneStanza);
					pstmt.setString(3,tipologiaStanza);
			        pstmt.setInt(4, idStanza);
				   
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
		
		//ELIMINA stanza
		public int eliminaStanza(int idStanza) {
	        try {

	            conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);



	            String queryEliminaStanza="DELETE FROM  stanze WHERE id_stanza=?";
	            pstmt=conn.prepareStatement(queryEliminaStanza);


	            pstmt.setInt(1,idStanza);


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


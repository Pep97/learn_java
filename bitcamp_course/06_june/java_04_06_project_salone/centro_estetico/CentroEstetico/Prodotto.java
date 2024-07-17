package java_04_06.centro_estetico.CentroEstetico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Prodotto {

	//Attributi
	private int idProdotto;
	private String nomeProdotto;  
	private String categoriaProdotto;
	private String descrizioneProdotto;
	private int quantitaProdotto;
	private double prezzoUnitario;
	
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection conn;
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/centro_estetico_test";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	//Costruttore
	public Prodotto(int idProdotto, String nomeProdotto, String categoriaProdotto, String descrizioneProdotto,
			int quantitaProdotto, double prezzoUnitario) {
		this.idProdotto = 0;
		this.nomeProdotto = nomeProdotto;
		this.categoriaProdotto = categoriaProdotto;
		this.descrizioneProdotto = descrizioneProdotto;
		this.quantitaProdotto = quantitaProdotto;
		this.prezzoUnitario = prezzoUnitario;
		
	}

	//Costruttore vuoto
	public Prodotto() {
		
	}

	//Metodi Getter & Setter 
	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	public String getCategoriaProdotto() {
		return categoriaProdotto;
	}

	public void setCategoriaProdotto(String categoriaProdotto) {
		this.categoriaProdotto = categoriaProdotto;
	}

	public String getDescrizioneProdotto() {
		return descrizioneProdotto;
	}

	public void setDescrizioneProdotto(String descrizioneProdotto) {
		this.descrizioneProdotto = descrizioneProdotto;
	}

	public int getQuantitaProdotto() {
		return quantitaProdotto;
	}

	public void setQuantitaProdotto(int quantitaProdotto) {
		this.quantitaProdotto = quantitaProdotto;
	}

	public double getPrezzoUnitario() {
		return prezzoUnitario;
	}

	public void setPrezzoUnitario(double prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}
	
	
	//METODI CRUD
	
	//Visualizza per ID
	public String visualizzaProdottoPerIdProdotto(int idProdotto) {
		
		String risultato = "";
		
		try {
			
			conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			
			
			
			String queryVisualizza="SELECT * FROM prodotti WHERE id_prodotto = ?";
			pstmt=conn.prepareStatement(queryVisualizza);
			
			
			pstmt.setInt(1, idProdotto);
			
		    rs = pstmt.executeQuery();
		    
		    while(rs.next()) {
		    	
		    	  this.idProdotto = rs.getInt("id_prodotto");
		    	  this.nomeProdotto = rs.getString("nome_prodotto");
		    	  this.descrizioneProdotto = rs.getString("descrizione_prodotto");
		          this.prezzoUnitario = rs.getDouble("prezzo_unitario_prodotto");
		          this.categoriaProdotto = rs.getString("categoria_prodotto");
		          this.quantitaProdotto = rs.getInt("quantita_prodotto");
		          
		          risultato += this.idProdotto+";"+nomeProdotto+";"+descrizioneProdotto+";"+categoriaProdotto+";"+prezzoUnitario+";"+quantitaProdotto+"\n";
		    	
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
	public String visualizzaProdottoPerNomeProdotto(String nomeProdotto) {

		String risultato = "";
		
        try {

            conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);



            String queryVisualizza="SELECT * FROM prodotti WHERE nome_prodotto = ?";
            pstmt=conn.prepareStatement(queryVisualizza);


            pstmt.setString(1, nomeProdotto);

            rs = pstmt.executeQuery();

            while(rs.next()) {

                  this.idProdotto = rs.getInt("id_prodotto");
                  this.nomeProdotto = rs.getString("nome_prodotto");
                  this.descrizioneProdotto = rs.getString("descrizione_prodotto");
                  this.categoriaProdotto = rs.getString("categoria_prodotto");
                  this.prezzoUnitario = rs.getDouble("prezzo_unitario_prodotto");
                  this.idProdotto = rs.getInt("id_prodotto");

                   risultato += this.idProdotto +";"+nomeProdotto+";"+ descrizioneProdotto +";"+categoriaProdotto+";"+prezzoUnitario+";"+idProdotto;

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
	
	//Visualizza per CATEGORIA
	public String visualizzaProdottoPerCategoriaProdotto(String categoriaProdotto) {
		
		String risultato = "";
		try {
			
			conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			
			
			
			String queryVisualizza="SELECT * FROM prodotti WHERE categoria_prodotto = ?";
			pstmt=conn.prepareStatement(queryVisualizza);
			
			
			pstmt.setString(1, categoriaProdotto);
			
		    rs = pstmt.executeQuery();
		    
		    while(rs.next()) {
		    	
		    	  this.idProdotto = rs.getInt("id_prodotto");
		    	  this.nomeProdotto = rs.getString("nome_prodotto");
		    	  this.descrizioneProdotto = rs.getString("descrizione_prodotto");
		          this.prezzoUnitario = rs.getDouble("prezzo_unitario_prodotto");
		          this.categoriaProdotto = rs.getString("categoria_prodotto");
		          this.quantitaProdotto = rs.getInt("quantita_prodotto");
		          
		           risultato += this.idProdotto+";"+nomeProdotto+";"+descrizioneProdotto+";"+categoriaProdotto+";"+prezzoUnitario+";"+quantitaProdotto;
		    	
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
	
	//Visualizza per PREZZO
	public String visualizzaProdottoPerPrezzo(double prezzoUnitario) {

		String risultato = "";
		
        try {

            conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);



            String queryVisualizza="SELECT * FROM prodotti WHERE prezzo_unitario_prodotto = ?";
            pstmt=conn.prepareStatement(queryVisualizza);


            pstmt.setDouble(1, prezzoUnitario);

            rs = pstmt.executeQuery();

            while(rs.next()) {

                  this.idProdotto = rs.getInt("id_prodotto");
                  this.nomeProdotto = rs.getString("nome_prodotto");
                  this.descrizioneProdotto = rs.getString("descrizione_prodotto");
                  this.categoriaProdotto = rs.getString("categoria_prodotto");
                  this.prezzoUnitario = rs.getDouble("prezzo_unitario_prodotto");
                  this.quantitaProdotto = rs.getInt("quantita_prodotto");

                 risultato += this.idProdotto +";"+nomeProdotto+";"+ descrizioneProdotto +";"+categoriaProdotto+";"+prezzoUnitario+";"+quantitaProdotto;

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
	public int inserisciProdotto(String nomeProdotto, String descrizioneProdotto, String categoriaProdotto,double prezzoUnitario,int quantitaProdotto) {
		
		try {
				
				conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
				
				
				
				String queryInserisciProdotto="INSERT INTO  prodotti (nome_prodotto,descrizione_prodotto,categoria_prodotto,prezzo_unitario_prodotto,quantita_prodotto) VALUES(?,?,?,?,?)";
				pstmt=conn.prepareStatement(queryInserisciProdotto);
				
				
				pstmt.setString(1,nomeProdotto);
				pstmt.setString(2,descrizioneProdotto);
				pstmt.setString(3,categoriaProdotto);
		        pstmt.setDouble(4,prezzoUnitario);
		        pstmt.setInt(5,quantitaProdotto);
			   
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
	public int modificaProdotto(int idProdotto,String nomeProdotto, String descrizioneProdotto, String categoriaProdotto,double prezzoUnitario,int quantitaProdotto) {
		
		try {
				
				conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
				
				
				
				String queryInserisciProdotto="UPDATE prodotti SET nome_prodotto = ? , descrizione_prodotto = ?,categoria_prodotto = ?, prezzo_unitario_prodotto=?, quantita_prodotto = ? where id_prodotto = ?";
				pstmt=conn.prepareStatement(queryInserisciProdotto);
				
				
				pstmt.setString(1,nomeProdotto);
				pstmt.setString(2,descrizioneProdotto);
				pstmt.setString(3,categoriaProdotto);
		        pstmt.setDouble(4,prezzoUnitario);
		        pstmt.setInt(5,quantitaProdotto);
		        pstmt.setInt(6, idProdotto);
			   
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
	
	
	//ELIMINA prodotto
    public int eliminaProdotto(int idProdotto) {
        try {

            conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);



            String queryEliminaProdotto="DELETE FROM  prodotti WHERE id_prodotto=?";
            pstmt=conn.prepareStatement(queryEliminaProdotto);


            pstmt.setInt(1,idProdotto);


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

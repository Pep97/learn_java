package java_04_06.centro_estetico.CentroEstetico;

import java.sql.*;


public class DettagliVendite {
	//Attributi
	private int idDettagliVendita;
	private int numeroUnivoco;
	private String tipoPagamento;
	private double prezzoFinale;
	private String dataOrdine;
	private int idVenditaProdotto;
	private int idAppuntamento;
	
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection conn;
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/centro_estetico_test";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	//costruttore
	public DettagliVendite(int numeroUnivoco, String tipoPagamento, int idVenditaProdotto, int idAppuntamento, String dataOrdine) {
		
		this.numeroUnivoco = numeroUnivoco;
		this.tipoPagamento = tipoPagamento;
		this.idVenditaProdotto = idVenditaProdotto;
		this.idAppuntamento = idAppuntamento;
		this.dataOrdine = dataOrdine;
	}
	
	//Costrutto vuoto
		public DettagliVendite() {
			
		}
	
	//Metodi Getter & Setter
		
	public int getIdDettagliVendita() {
			return idDettagliVendita;
	}
	
	public int getNumeroUnivoco() {
		return numeroUnivoco;
	}

	public void setNumeroUnivoco(int numeroUnivoco) {
		this.numeroUnivoco = numeroUnivoco;
	}


	public String getTipoPagamento() {
		return tipoPagamento;
	}


	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public int getIdVenditaProdotto() {
		return idVenditaProdotto;
	}


	public void setIdVenditaProdotto(int idVenditaProdotto) {
		this.idVenditaProdotto = idVenditaProdotto;
	}


	public int getIdAppuntamento() {
		return idAppuntamento;
	}


	public void setIdAppuntamento(int idAppuntamento) {
		this.idAppuntamento = idAppuntamento;
	}
	
	public String getDataOrdine() {
		return dataOrdine;
	}

	public void setDataOrdine(String dataOrdine) {
		this.dataOrdine = dataOrdine;
	}

	//METODI CRUD
	
	//Visualizza
	

	//Visualizza per ID DETTAGLI VENDITA
	public String visualizzaProdottoPerIdDettagliVendita(int idDettagliVendita) {
		
		String risultato = "";
		
		try {
			
			conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			
			
			
			String queryVisualizza="SELECT * FROM dettagli_vendite WHERE id_dettaglio_vendita = ?";
			pstmt=conn.prepareStatement(queryVisualizza);
			
			
			pstmt.setInt(1, idDettagliVendita);
			
		    rs = pstmt.executeQuery();
		    
		    while(rs.next()) {
		    	
		    	  this.idDettagliVendita = rs.getInt("id_dettaglio_vendita");
		    	  this.numeroUnivoco = rs.getInt("numero_univoco");
		    	  this.tipoPagamento = rs.getString("tipo_pagamento");
		          this.prezzoFinale = rs.getDouble("prezzo_finale");
		          this.dataOrdine = rs.getString("data_ordine");
		          this.idVenditaProdotto = rs.getInt("id_vendita_prodotto");
		          this.idAppuntamento = rs.getInt("id_appuntamento");
		          
		          risultato += this.idDettagliVendita+";"+numeroUnivoco+";"+tipoPagamento+";"+prezzoFinale+";"+idVenditaProdotto+";"+idAppuntamento+"\n";
		    	
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
	
	//Visualizza per NUMERO UNIVOCO
	  public String visualizzaDegliVendita(int numeroUnivoco) {
  	    String risultato = "";

  	    try {
  	        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

  	        String queryVisualizza = "SELECT * FROM dettagli_vendite WHERE numero_univoco = ?";
  	        PreparedStatement pstmt = conn.prepareStatement(queryVisualizza);
  	        pstmt.setInt(1, numeroUnivoco);

  	        ResultSet rs = pstmt.executeQuery();

  	        while (rs.next()) {
  	            this.idDettagliVendita = rs.getInt("id_dettaglio_vendita");
  	            this.numeroUnivoco = rs.getInt("numero_univoco");
  	            this.tipoPagamento = rs.getString("tipo_pagamento");
  	            this.prezzoFinale = rs.getDouble("prezzo_finale");
  	            this.dataOrdine = rs.getString("data_ordine");
  	            this.idVenditaProdotto = rs.getInt("id_vendita_prodotto");
  	            this.idAppuntamento = rs.getInt("id_appuntamento");

  	            risultato += idDettagliVendita + ";" + numeroUnivoco + ";" + tipoPagamento + ";" + prezzoFinale + ";" + idVenditaProdotto + ";" + idAppuntamento + ";" + dataOrdine + "\n";
  	        }

  	        rs.close();
  	        pstmt.close();
  	        conn.close();
  	    } catch (SQLException e) {
  	        e.printStackTrace();
  	        System.out.println("Oops, qualcosa è andato storto");
  	    }
  	    return risultato;
  	}

	//Visualizza per ID VENDITA PRODOTTO 
  	public String visualizzaDettagliVenditaPerIdProdotto(int idVenditaProdotto) {
        String risultato = "";
        String visualizzaSql = "SELECT * FROM dettagli_vendite WHERE id_vendita_prodotto = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(visualizzaSql)) {

            pstmt.setInt(1, idVenditaProdotto);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int idDettagliVendita = rs.getInt("id_dettaglio_vendita");
                int numeroUnivoco = rs.getInt("numero_univoco");
                String tipoPagamento = rs.getString("tipo_pagamento");
                double prezzoFinale = rs.getDouble("prezzo_finale");
                int idAppuntamento = rs.getInt("id_appuntamento");
                String dataOrdine = rs.getString("data_ordine");

                risultato += idDettagliVendita + ";" + numeroUnivoco + ";" + tipoPagamento + ";" + prezzoFinale + ";" + idVenditaProdotto + ";" + idAppuntamento + ";" + dataOrdine + ";" + "\n";
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la visualizzazione dei dettagli vendita.");
        }
        return risultato;
    }
    
    
	//Visualizza per TIPO PAGAMENTO
	public String visualizzaPerTipoPagamento(String tipoPagamento) {
		
		String risultato = "";
		
		try {
			
			conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			
			
			
			String queryVisualizza="SELECT * FROM dettagli_vendite WHERE tipo_pagamento = ?";
			pstmt=conn.prepareStatement(queryVisualizza);
			
			
			pstmt.setString(1, tipoPagamento);
			
		    rs = pstmt.executeQuery();
		    
		    while(rs.next()) {
		    	
		    	  this.idDettagliVendita = rs.getInt("id_dettaglio_vendita");
		    	  this.numeroUnivoco = rs.getInt("numero_univoco");
		    	  this.tipoPagamento = rs.getString("tipo_pagamento");
		          this.prezzoFinale = rs.getDouble("prezzo_finale");
		          this.dataOrdine = rs.getString("data_ordine");
		          this.idVenditaProdotto = rs.getInt("id_vendita_prodotto");
		          this.idAppuntamento = rs.getInt("id_appuntamento");
		          
		          risultato += idDettagliVendita+";"+numeroUnivoco+";"+this.tipoPagamento+";"+prezzoFinale+";"+idVenditaProdotto+";"+idAppuntamento+"\n";
		    	
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
	
	//VISUALIZZA per ID APPUNTAMENTO
	public String visualizzaIdAppuntamento(int idAppuntamento) {
	    String risultato = "";

	    try {
	        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

	        String queryVisualizza = "SELECT * FROM dettagli_vendite WHERE id_appuntamento = ?";
	        PreparedStatement pstmt = conn.prepareStatement(queryVisualizza);
	        pstmt.setInt(1, idAppuntamento);

	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            this.idDettagliVendita = rs.getInt("id_dettaglio_vendita");
	            this.numeroUnivoco = rs.getInt("numero_univoco");
	            this.tipoPagamento = rs.getString("tipo_pagamento");
	            this.prezzoFinale = rs.getDouble("prezzo_finale");
	            this.dataOrdine = rs.getString("data_ordine");
	            this.idVenditaProdotto = rs.getInt("id_vendita_prodotto");
	            this.idAppuntamento = rs.getInt("id_appuntamento");

	            risultato += idDettagliVendita + ";" + numeroUnivoco + ";" + tipoPagamento + ";" + prezzoFinale + ";" + idVenditaProdotto + ";" + idAppuntamento + ";" + dataOrdine + "\n";
	        }

	        rs.close();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Oops, qualcosa è andato storto");
	    }
	    return risultato;
	}

	//VISUALIZZA per PREZZO FINALE
	 public String visualizzaDettagliVenditaPerPrezzoFinale(double prezzoFinale) {
         String risultato = "";
         String visualizzaSql = "SELECT * FROM dettagli_vendite WHERE prezzo_finale = ?";
         
         try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
              PreparedStatement pstmt = conn.prepareStatement(visualizzaSql)) {

             pstmt.setDouble(1, prezzoFinale);

             ResultSet rs = pstmt.executeQuery();

             while (rs.next()) {
                 int idDettagliVendita = rs.getInt("id_dettaglio_vendita");
                 int numeroUnivoco = rs.getInt("numero_univoco");
                 String tipoPagamento = rs.getString("tipo_pagamento");
                 double prezzo = rs.getDouble("prezzo_finale");
                 int idVenditaProdotto = rs.getInt("id_vendita_prodotto");
                 int idAppuntamento = rs.getInt("id_appuntamento");
                 String dataOrdine = rs.getString("data_ordine");

                 risultato += idDettagliVendita + ";" + numeroUnivoco + ";" + tipoPagamento + ";" + prezzo + ";" + idVenditaProdotto + ";" + idAppuntamento + ";" + dataOrdine + ";" + "\n";
             }

             rs.close();
             pstmt.close();
             conn.close();

         } catch (SQLException e) {
             e.printStackTrace();
             System.out.println("Errore durante la visualizzazione dei dettagli vendita.");
         }
         return risultato;
     }
	 
	 //VISUALIZZA per DATA ORDINE
	  public String visualizzaDettagliVenditaPerDataOrdine(String dataOrdine) {
          String risultato = "";

          try {
              Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

              String queryVisualizza = "SELECT * FROM dettagli_vendite WHERE data_ordine = ?";
              PreparedStatement pstmt = conn.prepareStatement(queryVisualizza);

              pstmt.setString(1, dataOrdine);

              ResultSet rs = pstmt.executeQuery();

              while (rs.next()) {
                  int idDettagliVendita = rs.getInt("id_dettaglio_vendita");
                  int numeroUnivoco = rs.getInt("numero_univoco");
                  String tipoPagamento = rs.getString("tipo_pagamento");
                  double prezzoFinale = rs.getDouble("prezzo_finale");
                  int idVenditaProdotto = rs.getInt("id_vendita_prodotto");
                  int idAppuntamento = rs.getInt("id_appuntamento");

                  risultato += idDettagliVendita + ";" + numeroUnivoco + ";" + tipoPagamento + ";" + prezzoFinale + ";" + idVenditaProdotto + ";" + idAppuntamento + ";" + dataOrdine + "\n";
              }

              // Pulizia dei campi
              rs.close();
              pstmt.close();
              conn.close();

          } catch (SQLException e) {
              e.printStackTrace();
              System.out.println("Errore durante la visualizzazione dei dettagli vendita.");
          }
          return risultato;
      }
	  
	//INSERISCI
	public int aggiungiDettagliVendita(int numeroUnivoco, String tipoPagamento, double prezzoFinale, int idVenditaProdotto, int idAppuntamento, String dataOrdine) {
        String aggiungiSql = "INSERT INTO dettagli_vendite (numero_univoco, tipo_pagamento, prezzo_finale, id_vendita_prodotto, id_appuntamento, data_ordine) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(aggiungiSql)) {

            pstmt.setInt(1, numeroUnivoco);
            pstmt.setString(2, tipoPagamento);
            pstmt.setDouble(3, prezzoFinale);
            pstmt.setInt(4, idVenditaProdotto);
            pstmt.setInt(5, idAppuntamento);
            pstmt.setString(6, dataOrdine);

            pstmt.executeUpdate();
            System.out.println("Dettagli vendita aggiunti con successo.");

            pstmt.close();
            conn.close();
            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante l'aggiunta dei dettagli vendita.");
            return -1;
        }
    }
	
	//MODIFICA
	public int modificaDettagliVendita(int idDettagliVendita,int numeroUnivoco, String tipoPagamento,double prezzoFinale,String dataOrdine, int idVenditaProdotto, int idAppuntamento) {
		
		try {
				
				conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
				
				
				
				String queryInserisciDettagliProdotto="UPDATE dettagli_vendite SET numero_univoco = ? , tipo_pagamento = ?, prezzo_finale=?, data_ordine= ?, id_vendita_prodotto = ?, id_appuntamento=? where id_dettaglio_vendita = ?";
				pstmt=conn.prepareStatement(queryInserisciDettagliProdotto);
				
				
				pstmt.setInt(1,numeroUnivoco);
				pstmt.setString(2,tipoPagamento);
				pstmt.setDouble(3,prezzoFinale);
				pstmt.setString(4,dataOrdine);
		        pstmt.setInt(5,idVenditaProdotto);
		        pstmt.setInt(6,idAppuntamento);
		        pstmt.setInt(7, idDettagliVendita);
			   
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
	
	//ELIMINA 
    public int eliminaDettagliVendita(int idDettagliVendita) {
        try {

            conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);



            String queryEliminaDettagliVendita="DELETE FROM  dettagli_vendite WHERE id_dettaglio_vendita=?";
            pstmt=conn.prepareStatement(queryEliminaDettagliVendita);


            pstmt.setInt(1,idDettagliVendita);


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

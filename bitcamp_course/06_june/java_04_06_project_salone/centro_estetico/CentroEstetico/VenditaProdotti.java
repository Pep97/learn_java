package java_04_06.centro_estetico.CentroEstetico;

import java.sql.*;

public class VenditaProdotti {
	
	private static final String DB_URL="jdbc:mysql://localhost:3306/centro_estetico_test";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	private static Connection conn ;
	private static PreparedStatement pstmt;
	private static Statement stmt;
	private static ResultSet rs;
	
	private int idVenditaProdotto;
	private int quantitaProdotto;
    private int idProdotto;
    private int idCliente;
    
    
    public VenditaProdotti(int quantitaProdotto,int idProdotto, int idCliente) {
    	
    	
    	this.quantitaProdotto = quantitaProdotto;
    	this.idProdotto = idProdotto;
    	this.idCliente = idCliente;
    	
    }
    
    public VenditaProdotti() { }
    
    //Getter
    public int getIdVenditaProdotto() {
        return idVenditaProdotto;
    }
    public int getQuantitaProdotto() {
        return quantitaProdotto;
    }
    public int getIdProdotto() {
        return idProdotto;
    }
    public int getIdCliente() {
        return idCliente;
    }
    
    public void setQuantitaProdotto(int quantitaProdotto) {
        this.quantitaProdotto = quantitaProdotto;
    }
    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
    public String visualizzaTutteVenditeProdotti() {
        String risultato = "";
        try {
            String queryVisualizza= "SELECT * FROM vendite_prodotti";
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryVisualizza);
            while(rs.next()) {
                this.idVenditaProdotto = rs.getInt("id_vendita_prodotto");
                this.quantitaProdotto = rs.getInt("quantita_prodotto");
                this.idProdotto = rs.getInt("id_prodotto");
                this.idCliente = rs.getInt("id_cliente");

                risultato += idVenditaProdotto + ";" + quantitaProdotto + ";" + idProdotto + ";" + idCliente+"\n";
            }

            rs.close();
            stmt.close();
            conn.close();

        }catch(SQLException e) {
            e.printStackTrace();

        }
        return risultato;
    }
    
    public String visualizzaVenditeProdottiId(int idVenditaProdotto) {
        String risultato = "";
        try {
            String queryVisualizza= "SELECT * FROM vendite_prodotti WHERE id_vendita_prodotto = ?";
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            pstmt = conn.prepareStatement(queryVisualizza);
            pstmt.setInt(1, idVenditaProdotto);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                this.idVenditaProdotto = rs.getInt("id_vendita_prodotto");
                this.quantitaProdotto = rs.getInt("quantita_prodotto");
                this.idProdotto = rs.getInt("id_prodotto");
                this.idCliente = rs.getInt("id_cliente");

                risultato += this.idVenditaProdotto + ";" + quantitaProdotto + ";" + idProdotto + ";" + idCliente+"\n";
            }

            rs.close();
            pstmt.close();
            conn.close();

        }catch(SQLException e) {
            e.printStackTrace();

        }
        return risultato;
    }
    
    public String visualizzaVenditeProdottiQuantita(int quantitaProdotto) {
        String risultato = "";
        try {
            String queryVisualizza= "SELECT * FROM vendite_prodotti WHERE quantita_prodotto = ?";
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            pstmt = conn.prepareStatement(queryVisualizza);
            pstmt.setInt(1, quantitaProdotto);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                this.idVenditaProdotto = rs.getInt("id_vendita_prodotto");
                this.quantitaProdotto = rs.getInt("quantita_prodotto");
                this.idProdotto = rs.getInt("id_prodotto");
                this.idCliente = rs.getInt("id_cliente");

                risultato += this.idVenditaProdotto + ";" + this.quantitaProdotto + ";" + idProdotto + ";" + idCliente+"\n";
            }

            rs.close();
            pstmt.close();
            conn.close();

        }catch(SQLException e) {
            e.printStackTrace();

        }
        return risultato;
    }
    
    
    public String visualizzaVenditeProdottiIdCliente(int idCliente) {
        String risultato = "";
        try {
            String queryVisualizza= "SELECT * FROM vendite_prodotti WHERE id_cliente = ?";
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            pstmt = conn.prepareStatement(queryVisualizza);
            pstmt.setInt(1, idCliente);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                this.idVenditaProdotto = rs.getInt("id_vendita_prodotto");
                this.quantitaProdotto = rs.getInt("quantita_prodotto");
                this.idProdotto = rs.getInt("id_prodotto");
                this.idCliente = rs.getInt("id_cliente");

                risultato += this.idVenditaProdotto + ";" + quantitaProdotto + ";" + idProdotto + ";" + this.idCliente+"\n";
            }

            rs.close();
            pstmt.close();
            conn.close();

        }catch(SQLException e) {
            e.printStackTrace();

        }
        return risultato;
    }
    
    
    public String visualizzaVenditeProdottiIdProdotto(int idProdotto) {
        String risultato = "";
        try {
            String queryVisualizza= "SELECT * FROM vendite_prodotti WHERE id_prodotto = ?";
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            pstmt = conn.prepareStatement(queryVisualizza);
            pstmt.setInt(1, idProdotto);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                this.idVenditaProdotto = rs.getInt("id_vendita_prodotto");
                this.quantitaProdotto = rs.getInt("quantita_prodotto");
                this.idProdotto = rs.getInt("id_prodotto");
                this.idCliente = rs.getInt("id_cliente");

                risultato += this.idVenditaProdotto + ";" + quantitaProdotto + ";" + this.idProdotto + ";" + idCliente+"\n";
            }

            rs.close();
            pstmt.close();
            conn.close();

        }catch(SQLException e) {
            e.printStackTrace();

        }
        return risultato;
    }
    
    public int inserisciVenditaProdotto(int quantitaProdotto,int idProdotto, int idCliente) {

		try {

			conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);



			String queryInserisciVenditaProdotto="INSERT INTO  vendite_prodotti (quantita_prodotto,id_prodotto,id_cliente) VALUES(?,?,?)";
			pstmt=conn.prepareStatement(queryInserisciVenditaProdotto);


			pstmt.setInt(1,quantitaProdotto);
			pstmt.setInt(2, idProdotto);
			pstmt.setInt(3, idCliente);
			

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


	public int modificaVenditaProdotto(int idVenditaProdotto,int quantitaProdotto,int idProdotto, int idCliente) {
		try {

			conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);



			String queryModificaServizio="UPDATE vendite_prodotti SET quantita_prodotto = ? , id_prodotto = ?, id_cliente = ? where id_vendita_prodotto = ?";
			pstmt=conn.prepareStatement(queryModificaServizio);


			pstmt.setInt(1,quantitaProdotto);
			pstmt.setInt(2, idProdotto);
			pstmt.setInt(3, idCliente);
			pstmt.setDouble(4, idVenditaProdotto);

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

	public int eliminaVenditaProdotto(int idVenditaProdotto) {
		try {

			conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);



			String queryEliminaServizio="DELETE FROM  vendite_prodotti WHERE id_vendita_prodotto=?";
			pstmt=conn.prepareStatement(queryEliminaServizio);


			pstmt.setInt(1,idVenditaProdotto);


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


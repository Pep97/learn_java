package java_04_06.centro_estetico.CentroEstetico;

import java.sql.*;

import javax.swing.JOptionPane;

public class Dipendenti {
	
	//Attributi 
	
	private int idDipendente;
	private String nomeDipendente;
	private String cognomeDipendente;
	private String ruoloDipendente;
	private String emailDipendente;
	private String telefonoDipendente;
	private int livelloAdmin;
	private String turnoPersonale;
	private double pagaOraria;
	
	//Costruttore vuoto
	public Dipendenti() {}
	
	//Costruttore
	public Dipendenti(int id_dipendente, String nome, String cognome, String ruolo, String email, String telefono, int livelloAdmin, String turnoPersonale, double pagaOraria) {
		
		//this.idDipendente= idDipendente;
		this.idDipendente = id_dipendente;
		this.nomeDipendente = nome;
		this.cognomeDipendente = cognome;
		this.ruoloDipendente = ruolo;
		this.emailDipendente = email;
		this.telefonoDipendente = telefono;
		this.livelloAdmin = livelloAdmin;
		this.turnoPersonale = turnoPersonale;
		this.pagaOraria = pagaOraria;
	}
	
	//Metodo Getter
	
	public int getIdDipendente() {
		return idDipendente;
	}

	
	public String getNomeDipendente() {
		return nomeDipendente;
	}
	
	public String getCognomeDipendente() {
		return cognomeDipendente;
	}
	
	public String getRuoloDipendente() {
		return ruoloDipendente;
	}
	
	public String getEmailDipendente() {
		return emailDipendente;
	}
	
	public String getTelefonoDipendente() {
		return telefonoDipendente;
	}
	
	public int getLivelloAdmin() {
		return livelloAdmin;
	}
	
	public String getTurnoPersonale() {
		return turnoPersonale;
	}
	
	public double getPagaOraria() {
		return pagaOraria;
	}
	
	//Metodo Setter
	
	public void setIdDipendente(int idDipendente) {
		this.idDipendente = idDipendente;
	}
	
	public void setNomeDipendente(String nome) {
		this.nomeDipendente = nome;
	}
	
	public void setCognomeDipendente(String cognome) {
		this.cognomeDipendente = cognome;
	}
	
	public void setRuoloDipendente(String ruolo) {
		this.ruoloDipendente = ruolo;
	}
	
	public void setEmailDipendente(String email) {
		this.emailDipendente = email;
	}
	
	public void setTelefonoDipendente(String telefono) {
		this.telefonoDipendente = telefono;
	}
	
	public void setLivelloAdmin(int livelloAdmin) {
		this.livelloAdmin = livelloAdmin;
	}
	
	public void setTurnoPersonale(String turnoPersonale) {
		this.turnoPersonale = turnoPersonale;
	}
	
	public void setPagaOraria(double pagaOraria) {
		this.pagaOraria = pagaOraria;
	}
	
	//Parametri per CONNESSIONE DATABASE
	 private static final String DB_URL = "jdbc:mysql://localhost:3306/centro_estetico";
	 private static final String DB_USER = "root";
	 private static final String DB_PASSWORD = "LautaroCapitano";

	    
// Metodo Aggiunta Dipendente

public int aggiungiDipendente(Dipendenti dipendente) {
    String aggiuntaSql = "INSERT INTO dipendenti (nome_dipendente, cognome_dipendente, ruolo_dipendente, email_dipendente, telefono_dipendente, livello_admin, turno_personale, paga_oraria) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement pstmt = conn.prepareStatement(aggiuntaSql)) {

        pstmt.setString(1, dipendente.getNomeDipendente());
        pstmt.setString(2, dipendente.getCognomeDipendente());
        pstmt.setString(3, dipendente.getRuoloDipendente());
        pstmt.setString(4, dipendente.getEmailDipendente());
        pstmt.setString(5, dipendente.getTelefonoDipendente());
        pstmt.setInt(6, dipendente.getLivelloAdmin());
        pstmt.setString(7, dipendente.getTurnoPersonale());
        pstmt.setDouble(8, dipendente.getPagaOraria());

        pstmt.executeUpdate();
        System.out.println("Dipendente aggiunto con successo.");
        
        pstmt.close();
        conn.close();
        return 1;
        
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Errore durante l'aggiunta del dipendente.");
        return -1;
    }
}

//Metodo Aggiorna Dipendente

public int aggiornaDipendente(Dipendenti dipendente) {
    String aggiornaSql = "UPDATE dipendenti SET nome_dipendente = ?, cognome_dipendente = ?, ruolo_dipendente = ?, email_dipendente = ?, telefono_dipendente = ?, livello_admin = ?, turno_personale = ?, paga_oraria = ? WHERE id_dipendente = ?";
    
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement pstmt = conn.prepareStatement(aggiornaSql)) {

        pstmt.setString(1, dipendente.getNomeDipendente());
        pstmt.setString(2, dipendente.getCognomeDipendente());
        pstmt.setString(3, dipendente.getRuoloDipendente());
        pstmt.setString(4, dipendente.getEmailDipendente());
        pstmt.setString(5, dipendente.getTelefonoDipendente());
        pstmt.setInt(6, dipendente.getLivelloAdmin());
        pstmt.setString(7, dipendente.getTurnoPersonale());
        pstmt.setDouble(8, dipendente.getPagaOraria());
        pstmt.setInt(9, dipendente.getIdDipendente());

        pstmt.executeUpdate();
        
        
        pstmt.close();
        conn.close();
        return 1;
        
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Errore durante l'aggiornamento del dipendente.");
        return -1;
    }
}

//Metodo Elimina Dipendente

public int eliminaDipendente(int idDipendente) {
    String eliminaSql = "DELETE FROM dipendenti WHERE id_dipendente = ?";
    
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement pstmt = conn.prepareStatement(eliminaSql)) {

        pstmt.setInt(1, idDipendente);

        pstmt.executeUpdate();
        System.out.println("Dipendente eliminato con successo.");
        
        pstmt.close();
        conn.close();
        return 1;
        
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Errore durante l'eliminazione del dipendente.");
        return -1;
    }
}

//Metodo Ricerca Dipendente
  
public static  Dipendenti ricercaDipendente(int idDipendente) {
    String ricercaSql = "SELECT * FROM dipendenti WHERE id_dipendente = ?";
    Dipendenti dipendente = null;

    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement pstmt = conn.prepareStatement(ricercaSql)) {

        pstmt.setInt(1, idDipendente);

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            dipendente = new Dipendenti(
            		rs.getInt("id_dipendente"),
                    rs.getString("nome_dipendente"),
                    rs.getString("cognome_dipendente"),
                    rs.getString("ruolo_dipendente"),
                    rs.getString("email_dipendente"),
                    rs.getString("telefono_dipendente"),
                    rs.getInt("livello_admin"),
                    rs.getString("turno_personale"),
                    rs.getDouble("paga_oraria")
            );
        }
        
        rs.close();
        pstmt.close();
        conn.close();
        
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Errore durante la ricerca del dipendente.");
    }

    return dipendente;
    }
    
 // Metodo per visualizzare tutti i dipendenti
    public String visualizzaTuttiDipendenti() {
    	String risultato = "";
        String visualizzaSql = "SELECT * FROM dipendenti";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(visualizzaSql)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_dipendente");
                String nome = rs.getString("nome_dipendente");
                String cognome = rs.getString("cognome_dipendente");
                String ruolo = rs.getString("ruolo_dipendente");
                String email = rs.getString("email_dipendente");
                String telefono = rs.getString("telefono_dipendente");
                int livelloAdmin = rs.getInt("livello_admin");
                String turno = rs.getString("turno_personale");
                double paga = rs.getDouble("paga_oraria");

                risultato += id + ";" + nome + ";" + cognome + ";" + ruolo + ";" + email + ";" + telefono + ";" + livelloAdmin + ";" + turno + ";" + paga + ";" + "\n";
            }
            
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la visualizzazione dei dipendenti.");
        }
        return risultato;
        
    }  
    
    //Metodo visualizza dipendente per ID
    
    public String visualizzaDipendentePerId(int idDipendente) {
    	String risultato = "";
        String visualizzaPerId = "SELECT * FROM dipendenti WHERE id_dipendente = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(visualizzaPerId)) {

            pstmt.setInt(1, idDipendente);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_dipendente");
                String nome = rs.getString("nome_dipendente");
                String cognome = rs.getString("cognome_dipendente");
                String ruolo = rs.getString("ruolo_dipendente");
                String email = rs.getString("email_dipendente");
                String telefono = rs.getString("telefono_dipendente");
                int livelloAdmin = rs.getInt("livello_admin");
                String turno = rs.getString("turno_personale");
                double paga = rs.getDouble("paga_oraria");
                
                risultato += id + ";" + nome + ";" + cognome + ";" + ruolo + ";" + email + ";" + telefono + ";" + livelloAdmin + ";" + turno + ";" + paga + ";" + "\n";

                
            }  
            
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la visualizzazione del dipendente.");
        }
        return risultato;
    }
    
    //metodo visualizza dipendente per NOME
    
    public String visualizzaDipendentePerNome(String nomeDipendente) {
    	String risultato = "";
    	String visualizzaPerNome = "SELECT * FROM dipendenti WHERE nome_dipendente = ?";
    	try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    			PreparedStatement pstmt = conn.prepareStatement(visualizzaPerNome)){
    		
    		pstmt.setString(1, nomeDipendente);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_dipendente");
                String nome = rs.getString("nome_dipendente");
                String cognome = rs.getString("cognome_dipendente");
                String ruolo = rs.getString("ruolo_dipendente");
                String email = rs.getString("email_dipendente");
                String telefono = rs.getString("telefono_dipendente");
                int livelloAdmin = rs.getInt("livello_admin");
                String turno = rs.getString("turno_personale");
                double paga = rs.getDouble("paga_oraria");
                
                risultato += id + ";" + nome + ";" + cognome + ";" + ruolo + ";" + email + ";" + telefono + ";" + livelloAdmin + ";" + turno + ";" + paga + ";" + "\n";

                
            }  
            
            rs.close();
            pstmt.close();
            conn.close();
            
    	}catch(SQLException e) {
    		e.printStackTrace();
            System.out.println("Errore durante la visualizzazione del dipendente.");
        }
    	return risultato;

    	
    }
    
    //metodo per visualizzare dipendente per COGNOME
    
    public String visualizzaDipendentePerCognome(String cognomeDipendente) {
    	String risultato = "";
        String visualizzaPerCognome = "SELECT * FROM dipendenti WHERE cognome_dipendente = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(visualizzaPerCognome)) {

            pstmt.setString(1, cognomeDipendente);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_dipendente");
                String nome = rs.getString("nome_dipendente");
                String cognome = rs.getString("cognome_dipendente");
                String ruolo = rs.getString("ruolo_dipendente");
                String email = rs.getString("email_dipendente");
                String telefono = rs.getString("telefono_dipendente");
                int livelloAdmin = rs.getInt("livello_admin");
                String turno = rs.getString("turno_personale");
                double paga = rs.getDouble("paga_oraria");
                
                risultato += id + ";" + nome + ";" + cognome + ";" + ruolo + ";" + email + ";" + telefono + ";" + livelloAdmin + ";" + turno + ";" + paga + ";" + "/n";

               
            } 
            
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la visualizzazione del dipendente.");
        }
        return risultato;
    }
    
    //Metodo per visualizzare dipendente per RUOLO
    
    public String visualizzaDipendentePerRuolo(String ruoloDipendente) {
    	String risultato = "";
        String visualizzaPerRuolo = "SELECT * FROM dipendenti WHERE ruolo_dipendente = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(visualizzaPerRuolo)) {

            pstmt.setString(1, ruoloDipendente);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_dipendente");
                String nome = rs.getString("nome_dipendente");
                String cognome = rs.getString("cognome_dipendente");
                String ruolo = rs.getString("ruolo_dipendente");
                String email = rs.getString("email_dipendente");
                String telefono = rs.getString("telefono_dipendente");
                int livelloAdmin = rs.getInt("livello_admin");
                String turno = rs.getString("turno_personale");
                double paga = rs.getDouble("paga_oraria");
                
                risultato += id + ";" + nome + ";" + cognome + ";" + ruolo + ";" + email + ";" + telefono + ";" + livelloAdmin + ";" + turno + ";" + paga + ";" + "\n";

                
            } 
            
            rs.close();
            pstmt.close();
            conn.close();
            

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la visualizzazione del dipendente.");
        }
        return risultato;
    }
    
}



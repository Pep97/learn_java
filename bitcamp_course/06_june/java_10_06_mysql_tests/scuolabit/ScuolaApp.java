package java_10_06.scuolabit;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;


public class ScuolaApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SwingUtilities.invokeLater(()->{
			JFrame frame = new JFrame("Gestione Scuola"); // Creazione del frame principale
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Si imposta la chiusura dell'applicazione
			frame.setSize(600,400); // Dimnensioni del frame
			
			JPanel panel = new JPanel(); 
			// tutti i tipi di JPanel
			
			// FlowLayout -> un elemento dopo l'altro   
			// BridLayout -> crea una griglia con righe e colonne 
			// BorderLayout -> divides the container into five regions: North, South, East, West, and Center. Each region (area) can contain a component, and when the window is resized, the components are automatically resized.			
			JTable table = new JTable();
			
			panel.add(new JScrollPane(table), BorderLayout.CENTER);
			frame.add(panel);
			
            frame.setVisible(true);
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
            
			// carica i dati dal DB e gli mostra nella tabella
			try {
				 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scuolabit","root","localbombcomputer");
				
				 stmt = conn.createStatement();
				// creazione dell'oggetto che ti permette di trasformare l'oggetto in una stringa e poi dei pacchetti di dati
				
				 rs = stmt.executeQuery("SELECT studenti.nome, studenti.cognome, corsi.nome AS corso, corsi.docente " + 
												 "FROM iscrizioni " +
												 "JOIN studenti ON inscrizioni.id_studente = studenti.id " +
												 "JOIN corsi ON iscrizioni.id_corso = corsi.id"); 
				// creazione alias -> corsi.nome si chiamerá corso
				
				// arraylist per memorizzare i dati di rs
				ArrayList<String[]> data = new ArrayList<>();
				
				while(rs.next()) {
					String nomeStudente = rs.getString("nome");
					String cognomeStudente = rs.getString("cognome");
					String nomeCorso = rs.getString("corso");
					String docente = rs.getString("docente");
					
					// aggiungiamo i dati presi all'interno di data
					data.add(new String[] {nomeStudente, cognomeStudente, nomeCorso, docente});

					String[] ColumnNames = {"Nome Studente", "Cognome Studente", "Corso", "Docente"};
					
					// creazione tabella bidimensionale con i dati dei risultati della query
					String[][] dataArray = new String[data.size()][4];
					
					// conversione di arraylist in array bidimensionale
					data.toArray(dataArray); // riscrive i dati all'interno? e come fa a sapere che deve modificare la seconda array?
					
					// impostiamo il modello della tabella
					table.setModel(new javax.swing.table.DefaultTableModel(dataArray, ColumnNames));
					
					
                }
                    

				
			} catch(SQLException e) {
				// stampa dello stack trace in caso di eccezzione
				e.printStackTrace();
			} finally{
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
	                
				} catch (SQLException e){			
					e.printStackTrace();
				};
			}
			
		});
		
		
		
		
		
		
	}

}


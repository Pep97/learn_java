package java_10_06.scuola_v2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;



public class ScuolaApp {

	// attributi reperibili dall'intera classe
	private JFrame frame; //finestra principale
	private CardLayout cardLayout; // layout per cambiare i panelli
	private JPanel mainPanel; // pannello contenente i diversi pannelli secondari
	private JTable table; // per visualizzare i dati
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/scuolabit";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "localbombcomputer";

	
	// eventuali ulteriori variabili da utilizzare
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(ScuolaApp::new); // abbrevia la scrittura estesa
		
	}
	
	// costruttore della classe
	public ScuolaApp() {
		frame = new JFrame("Gestionale Scuola V2.0"); // creazione finestra principale
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		
		// barra dei menu
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu"); //menu principale
		JMenuItem viewItem = new JMenuItem("Visualizza");
		JMenuItem insertItem = new JMenuItem("Inserisci");
		JMenuItem updateItem = new JMenuItem("Modifica");
		JMenuItem deleteItem = new JMenuItem("Elimina");

		// aggiunta degli item al menu
		menu.add(viewItem);
		menu.add(insertItem);
		menu.add(updateItem);
		menu.add(deleteItem);

		// aggiunta del JMenu al JMenuBar
		menuBar.add(menu);
		
		// Aggiunta del menuBar al frame
		frame.setJMenuBar(menuBar);

		// inizializzazione del cardLayout
		cardLayout = new CardLayout();
		
		// inizializzazione pannello principale
		mainPanel = new JPanel(cardLayout);
		
		// creazione ed aggiunta di pannelli secondari all'interno di mainPanel
		
		mainPanel.add(createViewPanel(), "Visualizza"); // i parametri sono:  il pannello da mostrare e un etichetta con il quale lo vuoi salvare
		mainPanel.add(createInsertPanel(), "Inserisci");
		mainPanel.add(createUpdatePanel(), "Modifica");
		mainPanel.add(createDeletePanel(), "Elimina");
		
		// definire le azioni corrispondenti al click sui menu
		
		viewItem.addActionListener(e -> cardLayout.show(mainPanel, "Visualizza")); 
		// i parametri sono: su quale finestra si visualizza il pannello che si sta richiamando, il secondo parametro richiede il nome dell'etichetta con il quale é stato salvato il pannello
		insertItem.addActionListener(e -> cardLayout.show(mainPanel, "Inserisci")); 
		updateItem.addActionListener(e -> cardLayout.show(mainPanel, "Modifica")); 
		deleteItem.addActionListener(e -> cardLayout.show(mainPanel, "Elimina")); 

		// aggiunta del mainPanel al frame
		frame.add(mainPanel);
		frame.setVisible(true);
		
		
		
	}
	
	private JPanel createViewPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		table = new JTable();
		panel.add(new JScrollPane(table), BorderLayout.CENTER);
		loadTableData(); // funzione per connessione al DB e query di visualizzazione
		
		return panel;
		
	}
	
	private JPanel createInsertPanel() {
		JPanel panel = new JPanel(new GridLayout(7,2));
		JTextField nomeStudenteField = new JTextField();
		JTextField cognomeStudenteField = new JTextField();
		JTextField matricolaField = new JTextField();
		JTextField nomeCorsoField = new JTextField();
		JTextField docenteField = new JTextField();
		JButton insertButton = new JButton("Inserisci");
		
			
		panel.add(new JLabel("Nome Studente: "));
		panel.add(nomeStudenteField);
		panel.add(new JLabel("Cognome Studente: "));
		panel.add(cognomeStudenteField);
		panel.add(new JLabel("Matricola: "));
		panel.add(matricolaField);
		panel.add(new JLabel("Nome Corso: "));
		panel.add(nomeCorsoField);
		panel.add(new JLabel("Docente: "));
		panel.add(docenteField);
		panel.add(new JLabel()); // placeholder per cella vuota
		panel.add(insertButton);

		// gestione evento bottone
		insertButton.addActionListener(e -> {
			// azione da eseguire a seguito dell'evento
			String nomeStudente = nomeStudenteField.getText();
			String cognomeStudente = cognomeStudenteField.getText();
			String matricola = matricolaField.getText();
			String nomeCorso = nomeCorsoField.getText();
			String docente = docenteField.getText();
			// richiamo la funzione per gestire la query di inserimento
			insertStudentAndCourse(nomeStudente, cognomeStudente, matricola, nomeCorso, docente);
			
			// ricarichiamo i dati all'interno della tabella
			loadTableData();
			
		});
		
		return panel;
	}
	
	private JPanel createUpdatePanel() {
		
		JPanel panel = new JPanel(new GridLayout(8,2)); 
		// creazione degli input necessari per le modifiche ai record
		JTextField idField = new JTextField();
		JTextField nomeStudenteField = new JTextField();
		JTextField cognomeStudenteField = new JTextField();
		JTextField matricolaField = new JTextField();
		JTextField nomeCorsoField = new JTextField();
		JTextField docenteField = new JTextField();
		JButton updateButton = new JButton("Modifica");
		
		// inserimento dei campi
		panel.add(new JLabel("ID: "));
		panel.add(idField);
		panel.add(new JLabel("Nome Studente:"));
		panel.add(nomeStudenteField);
		panel.add(new JLabel("Cognome Studente: "));
		panel.add(cognomeStudenteField);
		panel.add(new JLabel("Matricola: "));
		panel.add(matricolaField);
		panel.add(new JLabel("Nome Corso: "));
		panel.add(nomeCorsoField);
		panel.add(new JLabel("Docente: "));
		panel.add(docenteField);
		panel.add(new JLabel()); // placeholder per cella vuota
		panel.add(updateButton);
		
		//gestiamo evento del bottone
		updateButton.addActionListener(e -> {
			
			int id = Integer.parseInt(idField.getText());
			String nomeStudente = nomeStudenteField.getText();
			String cognomeStudente = cognomeStudenteField.getText();
			String matricola = matricolaField.getText();
			String nomeCorso = nomeCorsoField.getText();
			String docente = docenteField.getText();
			// chiama alla funzione per aggiornare i record
			updateStudentAndCourse(id, nomeStudente, cognomeStudente, matricola, nomeCorso, docente);
			// aggiorniamo la tabella
			loadTableData();
			
			
		});
		
		return panel;
		
	}
	
	private JPanel createDeletePanel() {
		JPanel panel = new JPanel(new GridLayout(3,2));
		JTextField idField = new JTextField();
		JButton deleteButton = new JButton("Elimina");
		
		panel.add(new JLabel("ID: "));
		panel.add(idField);
		panel.add(new JLabel());
		panel.add(deleteButton);
		
		deleteButton.addActionListener(e ->{
			
			// acquisizione dei dati da input
			int id = Integer.parseInt(idField.getText());
			// richiama la funzione per eseguire la query 
			deleteStudentAndCourse(id);
			// ricarichiamo il contenuto della tabella
			loadTableData();
		});
		return panel;
		
	}
	
	private void loadTableData() {
		try (
		        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT studenti.id, studenti.nome, studenti.cognome," +
												 "studenti.matricola, corsi.nome AS corso, corsi.docente " +
												 "FROM iscrizioni "+
												 "JOIN studenti ON iscrizioni.id_studente = studenti.id " +
												 "JOIN corsi ON iscrizioni.id_corso = corsi.id")
			){
			
			// Caricamento dei dati dalal tabella iscrizione unendo la tabella studenti e corsi
			ArrayList<String[]> data = new ArrayList<>(); // lista per memorizzare i record
			while(rs.next()) {
				int id = rs.getInt("id");
				String nomeStudente = rs.getString("nome");
				String cognomeStudente = rs.getString("cognome");
				String matricola = rs.getString("matricola");
				String nomeCorso = rs.getString("corso");
				String docente = rs.getString("docente");
				
				data.add(new String[] { String.valueOf(id), nomeStudente, cognomeStudente, matricola, nomeCorso, docente});
			}
			
			// creazione della tabella che conterra l'arraylist data
			String[][] dataArray = new String[data.size()][6];
			data.toArray(dataArray); // conversione dei dati in arraylist all'interno della matrice
			String[] columnNames = {"ID", "Nome Studente", "Cognome Studente", "Matricola", "Nome Corso", "Docente"};
			table.setModel(new javax.swing.table.DefaultTableModel(dataArray, columnNames));
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		};
		
	}
	
	private void insertStudentAndCourse(String nomeStudente, String cognomeStudente, String matricola, String nomeCorso, String docente) {
		
		try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
			// disabilitiamo il metodo predefinito della scrittura dati su DB
			conn.setAutoCommit(false);
			// se avviene un errore, sql inserisce i dati e poi ti manda il messaggio di errore
			// peró cosi vai ad occupare delle linee record sul DB
			// con il commit noi controlliamo quando l'informazione viene aggiunta e noi possiamo poi quando aggiungere l'informazione
			
			try(PreparedStatement pstmtStudente = conn.prepareStatement("INSERT INTO  studenti(nome,cognome,matricola) VALUES (?,?,?)",
					Statement.RETURN_GENERATED_KEYS); // ritorna il numero dell'id
						PreparedStatement pstmtCorso = conn.prepareStatement("INSERT INTO corsi(nome, docente) VALUES (?,?)",
						Statement.RETURN_GENERATED_KEYS) ;
							PreparedStatement pstmtIscrizione = conn.prepareStatement("INSERT INTO iscrizioni(id_studente, id_corso) VALUES (?,?)")
					){
				
				// inserimento studente
					pstmtStudente.setString(1, nomeStudente);
					pstmtStudente.setString(2, cognomeStudente);
					pstmtStudente.setString(3, matricola);
					
					pstmtStudente.executeUpdate(); // il valore generate ora ha una ID che ci facciamo ritornare con Statement.RETURN_GENERATED_KEYS
					// ritorno della chiave primaria del record appena inserito
					
					ResultSet rsStudente = pstmtStudente.getGeneratedKeys();
					rsStudente.next();
					int studenteId = rsStudente.getInt(1);
				// inserimento corso
					pstmtCorso.setString(1,  nomeCorso);
					pstmtCorso.setString(2, docente);
					
					pstmtCorso.executeUpdate(); 
					
					ResultSet rsCorso = pstmtCorso.getGeneratedKeys();
					rsCorso.next();
					int corsoId = rsCorso.getInt(1);
				// inserimento iscrizione
					pstmtIscrizione.setInt(1, studenteId);
					pstmtIscrizione.setInt(2, corsoId);
					
					pstmtIscrizione.executeUpdate(); 

				// ora possiamo avviare la transazione 
				conn.commit();

				
			} catch(SQLException e) {
				conn.rollback(); // in questo modo annulli l'inserimento dei dati se c'é un errore
				e.printStackTrace();
			} finally {
				// ripristinare l'autocomit -> altrimenti diventebbe fisso
				conn.setAutoCommit(true);
			}

		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void updateStudentAndCourse(int id, String nomeStudente, String cognomeStudente, String matricola, String nomeCorso, String docente) {
		try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
			
			conn.setAutoCommit(false);
			
			try(
					PreparedStatement pstmtStudente = conn.prepareStatement("UPDATE studenti SET nome = ?, cognome = ?, matricola = ? WHERE id = ? ");    
		            PreparedStatement pstmtCorso = conn.prepareStatement("UPDATE corsi SET  nome = ?, docente = ? WHERE id = (SELECT id_corso FROM iscrizioni WHERE id_studente = ?)");
		            PreparedStatement pstmtIscrizione = conn.prepareStatement("UPDATE iscrizioni SET id_corso = (SELECT id FROM corsi WHERE nome = ? AND docente = ?) WHERE id_studente = ?")
			){
				pstmtStudente.setString(1, nomeStudente);
				pstmtStudente.setString(2, cognomeStudente);
				pstmtStudente.setString(3, matricola);
				pstmtStudente.setInt(4, id);
				pstmtStudente.executeUpdate();

				pstmtCorso.setString(1, nomeCorso);
				pstmtCorso.setString(2, docente);
				pstmtCorso.setInt(3, id);
				pstmtCorso.executeUpdate();
				
				pstmtIscrizione.setString(1, nomeCorso);
				pstmtIscrizione.setString(2, docente);
				pstmtIscrizione.setInt(3, id);
				pstmtIscrizione.executeUpdate();

				// conferma invio dati
				conn.commit();


				
			} catch(SQLException e) {
				conn.rollback();
				e.printStackTrace();
				
			} finally {
				conn.setAutoCommit(true);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void deleteStudentAndCourse(int id) {
		
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
			
			conn.setAutoCommit(false);
		
			try(PreparedStatement pstmtIscrizione = conn.prepareStatement ("DELETE FROM iscrizioni WHERE id_studente = ?");
				PreparedStatement pstmtStudente = conn.prepareStatement("DELETE FROM studenti WHERE id = ?");
		            PreparedStatement pstmtCorso = conn.prepareStatement("DELETE FROM corsi WHERE id IN (SELECT id_corso FROM iscrizioni WHERE id_studente = ?)")
				){
				
				pstmtIscrizione.setInt(1, id);
				pstmtIscrizione.executeUpdate();
				
				pstmtStudente.setInt(1, id);
				pstmtStudente.executeUpdate();
				
				pstmtCorso.setInt(1, id);
				pstmtCorso.executeUpdate();
				
				conn.commit();

				
			} catch(SQLException e){
				conn.rollback();
				e.printStackTrace();
				
			} finally {
				conn.setAutoCommit(true);
			}
			
		} catch(SQLException e){
			e.printStackTrace();

		}
	}
	
	
	
	

}

package java_12_06.progetto_meccanico;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;


public class AppuntamentiMeccanico1 {

	private JFrame frame; 
	private CardLayout cardLayout; 
	private JPanel mainPanel; 
	private JTable table;
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/appuntamenti_meccanico";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "localbombcomputer";

	
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(AppuntamentiMeccanico::new); 
		
	}
    // done
    public AppuntamentiMeccanico1() {
		frame = new JFrame("Gestione Appuntamenti Meccanico"); 
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
    // done
    

	private JPanel createViewPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		table = new JTable();
		panel.add(new JScrollPane(table), BorderLayout.CENTER);
		loadTableData();
		
		return panel;
		
	}
	// done
	private JPanel createInsertPanel() {
		JPanel panel = new JPanel(new GridLayout(10,2));
		JTextField nomeClienteField = new JTextField();
		JTextField cognomeClienteField = new JTextField();
		JTextField modelloMacchinaField = new JTextField();
        JTextField nomeServizioField = new JTextField();
		JTextField descrizioneServizioField = new JTextField();
		JTextField costoField = new JTextField();
		JTextField noteAggiuntiveField = new JTextField();
		JTextField dataInizioField = new JTextField();
        JTextField dataFineField = new JTextField();


		JButton insertButton = new JButton("Inserisci");
		
			
		panel.add(new JLabel("Nome Cliente: "));
		panel.add(nomeClienteField);
		panel.add(new JLabel("Cognome Cliente: "));
		panel.add(cognomeClienteField);
		panel.add(new JLabel("Modello Macchina: "));
		panel.add(modelloMacchinaField);
		panel.add(new JLabel("Nome Servizio: "));
		panel.add(nomeServizioField);
        panel.add(new JLabel("Descrizione Servizio: "));
		panel.add(descrizioneServizioField);
		panel.add(new JLabel("Costo Servizio: "));
		panel.add(costoField);
        panel.add(new JLabel("Note Aggiuntive: "));
		panel.add(noteAggiuntiveField);
		panel.add(new JLabel("Data e Ora di Inizio Appuntamento  (es. 2023-01-01 09:00:00): "));
		panel.add(dataInizioField);
        panel.add(new JLabel("Data e Ora di Fine Appuntamento  (es. 2023-01-01 10:00:00): "));
		panel.add(dataFineField);
		panel.add(new JLabel());
		panel.add(insertButton);

		// gestione evento bottone
		insertButton.addActionListener(e -> {
			// azione da eseguire a seguito dell'evento
			String nomeCliente = nomeClienteField.getText();
			String cognomeCliente = cognomeClienteField.getText();
			String modelloMacchina = modelloMacchinaField.getText();
			String nomeServizio = nomeServizioField.getText();
			String descrizioneServizio = descrizioneServizioField.getText();
            String costo = costoField.getText();
			String noteAggiuntive = noteAggiuntiveField.getText();
			String dataInizio = dataInizioField.getText();
			String dataFine = dataFineField.getText();

			
			// richiamo la funzione per gestire la query di inserimento
			insertAppuntamentoAndServizio(nomeCliente, cognomeCliente, modelloMacchina, nomeServizio, descrizioneServizio, costo, noteAggiuntive, dataInizio, dataFine);
			
			// ricarichiamo i dati all'interno della tabella
			loadTableData();
			
		});
		
		return panel;
	}
	// done
	private JPanel createUpdatePanel() {
		
		JPanel panel = new JPanel(new GridLayout(11,2));
        JTextField idField = new JTextField();
		JTextField nomeClienteField = new JTextField();
		JTextField cognomeClienteField = new JTextField();
		JTextField modelloMacchinaField = new JTextField();
        JTextField nomeServizioField = new JTextField();
		JTextField descrizioneServizioField = new JTextField();
		JTextField costoField = new JTextField();
		JTextField noteAggiuntiveField = new JTextField();
		JTextField dataInizioField = new JTextField();
        JTextField dataFineField = new JTextField();
		JButton updateButton = new JButton("Modifica");
		
        panel.add(new JLabel("ID: "));
		panel.add(idField);
		panel.add(new JLabel("Nome Cliente: "));
		panel.add(nomeClienteField);
		panel.add(new JLabel("Cognome Cliente: "));
		panel.add(cognomeClienteField);
		panel.add(new JLabel("Modello Macchina: "));
		panel.add(modelloMacchinaField);
		panel.add(new JLabel("Nome Servizio: "));
		panel.add(nomeServizioField);
        panel.add(new JLabel("Descrizione Servizio: "));
		panel.add(descrizioneServizioField);
		panel.add(new JLabel("Costo Servizio: "));
		panel.add(costoField);
        panel.add(new JLabel("Note Aggiuntive: "));
		panel.add(noteAggiuntiveField);
		panel.add(new JLabel("Data e Ora di Inizio Appuntamento  (es. 2023-01-01 09:00:00): "));
		panel.add(dataInizioField);
        panel.add(new JLabel("Data e Ora di Fine Appuntamento  (es. 2023-01-01 10:00:00): "));
		panel.add(dataFineField);
		panel.add(new JLabel());
		panel.add(updateButton);
		
		
		//gestiamo evento del bottone
		updateButton.addActionListener(e -> {
			
			int id = Integer.parseInt(idField.getText());
            String nomeCliente = nomeClienteField.getText();
			String cognomeCliente = cognomeClienteField.getText();
			String modelloMacchina = modelloMacchinaField.getText();
			String nomeServizio = nomeServizioField.getText();
			String descrizioneServizio = descrizioneServizioField.getText();
            String costo = costoField.getText();
			String noteAggiuntive = noteAggiuntiveField.getText();
			String dataInizio = dataInizioField.getText();
			String dataFine = dataFineField.getText();
			
			// richiamo la funzione per gestire la query di inserimento
			updateAppuntamentoAndServizio(id, nomeCliente, cognomeCliente, modelloMacchina, nomeServizio, descrizioneServizio, costo, noteAggiuntive, dataInizio, dataFine);
			
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
			deleteAppuntamentoAndServizio(id);
			// ricarichiamo il contenuto della tabella
			loadTableData();
		});
		return panel;
		
	}
	
	private void loadTableData() {
		try (
		        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT appuntamenti.id, appuntamenti.nome_cliente, appuntamenti.cognome_cliente, appuntamenti.modello_macchina, " +
                                                "servizi.nome_servizio AS servizio, servizi.descrizione_servizio, servizi.costo, appuntamenti.note_aggiuntive, appuntamenti.data_inizio, appuntamenti.data_fine " +
                                                "FROM appuntamenti "+
                                                "JOIN servizi ON appuntamenti.id_servizi = servizi.id ")
			){
			
			// Caricamento dei dati dalla tabella iscrizione unendo la tabella studenti e corsi
			ArrayList<String[]> data = new ArrayList<>(); // lista per memorizzare i record
			while(rs.next()) {
				int id = rs.getInt("id");
				String nomeCliente = rs.getString("nome_cliente");
				String cognomeCliente = rs.getString("cognome_cliente");
				String modelloMacchina = rs.getString("modello_macchina");
				String nomeServizio = rs.getString("servizio");
				String descrizioneServizio = rs.getString("descrizione_servizio");
                String costo = Integer.toString(rs.getInt("costo"));
                String noteAggiuntive = rs.getString("note_aggiuntive");
                String dataInizio = rs.getString("data_inizio");
                String dataFine = rs.getString("data_fine");
				
				data.add(new String[] { String.valueOf(id), nomeCliente, cognomeCliente, modelloMacchina, nomeServizio, descrizioneServizio, costo, noteAggiuntive, dataInizio, dataFine});
			}
			
			// creazione della tabella che conterra l'arraylist data
			String[][] dataArray = new String[data.size()][10];
			data.toArray(dataArray); // conversione dei dati in arraylist all'interno della matrice
			String[] columnNames = {"ID", "Nome Cliente", "Cognome Cliente", "Modello Macchina", "Nome Servizio", "Descrizione Servizio", "Costo Servizio", "Note Aggiuntive", "Data e Ora Inizio", "Data e Ora Fine"};
			table.setModel(new javax.swing.table.DefaultTableModel(dataArray, columnNames));
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		};
		
	}
	// done
	private void insertAppuntamentoAndServizio(
        String nomeCliente, String cognomeCliente, String modelloMacchina, String nomeServizio, String descrizioneServizio, String costo, String noteAggiuntive, String dataInizio, String dataFine) {
    
		
		try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
			
			conn.setAutoCommit(false);
			
			try(
				PreparedStatement pstmtAppuntamenti = conn.prepareStatement("INSERT INTO appuntamenti(nome_cliente, cognome_cliente, modello_macchina, note_aggiuntive, data_inizio, data_fine, id_servizi) VALUES (?,?,?,?,?,?,?)");
				PreparedStatement pstmtServizi = conn.prepareStatement("INSERT INTO  servizi(nome_servizio, descrizione_servizio, costo) VALUES (?,?,?)",
				Statement.RETURN_GENERATED_KEYS); // ritorna il numero dell'id
					){
				
                pstmtServizi.setString(1, nomeServizio);
                pstmtServizi.setString(2, descrizioneServizio);
                pstmtServizi.setString(3, costo);

					
                pstmtServizi.executeUpdate(); 
					
				ResultSet rsServizio = pstmtServizi.getGeneratedKeys();
				rsServizio.next();
				int id_servizio = rsServizio.getInt(1);
				
                pstmtAppuntamenti.setString(1, nomeCliente);
                pstmtAppuntamenti.setString(2, cognomeCliente);
                pstmtAppuntamenti.setString(3, modelloMacchina);
                pstmtAppuntamenti.setString(4, noteAggiuntive);
                pstmtAppuntamenti.setString(5, dataInizio);
                pstmtAppuntamenti.setString(6, dataFine);
                pstmtAppuntamenti.setInt(7, id_servizio);

                pstmtAppuntamenti.executeUpdate(); 

				conn.commit();
				JOptionPane.showMessageDialog(null, "L'appuntamento é stato inserito correttamente", "Operazione Completata", JOptionPane.WARNING_MESSAGE);

				
			} catch(SQLException e) {
				conn.rollback();
				JOptionPane.showMessageDialog(null, "c'é un errore: " + e.getMessage(), "Operazione Non Riuscita", JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			} finally {
				conn.setAutoCommit(true);
			}

		} catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	// done
	private void updateAppuntamentoAndServizio(
		int id, String nomeCliente, String cognomeCliente, String modelloMacchina, String nomeServizio, String descrizioneServizio, String costo, String noteAggiuntive, String dataInizio, String dataFine
        ) {
		
			try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
				
				conn.setAutoCommit(false);
				
				try(
			            PreparedStatement pstmtAppuntamento = conn.prepareStatement("UPDATE appuntamenti SET nome_cliente = ?, cognome_cliente = ?, modello_macchina = ?, note_aggiuntive = ?, data_inizio = ?, data_fine = ? WHERE id = ?");
						PreparedStatement pstmtServizio = conn.prepareStatement("UPDATE servizi SET nome_servizio = ?, descrizione_servizio = ?, costo = ? WHERE id = (SELECT id_servizi FROM appuntamenti WHERE id = ?)")
				){

                    pstmtAppuntamento.setString(1, nomeCliente);
                    pstmtAppuntamento.setString(2, cognomeCliente);
                    pstmtAppuntamento.setString(3, modelloMacchina);
                    pstmtAppuntamento.setString(4, noteAggiuntive);
                    pstmtAppuntamento.setString(5, dataInizio);
                    pstmtAppuntamento.setString(6, dataFine);
                    pstmtAppuntamento.setInt(7, id);
                    pstmtAppuntamento.executeUpdate();

                    pstmtServizio.setString(1, nomeServizio);
                    pstmtServizio.setString(2, descrizioneServizio);
                    pstmtServizio.setString(3, costo);
                    pstmtServizio.setInt(4, id);
                    pstmtServizio.executeUpdate();

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
	// done
	private void deleteAppuntamentoAndServizio(
			
		int id) {
		
			try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
				
				conn.setAutoCommit(false);
			
				try(PreparedStatement pstmtAppuntamento = conn.prepareStatement("DELETE FROM appuntamenti WHERE id_servizi = ?");
					PreparedStatement pstmtServizio = conn.prepareStatement("DELETE FROM servizi WHERE id IN (SELECT id_servizi FROM appuntamenti WHERE id = ?)")
						
					){
					
					pstmtAppuntamento.setInt(1, id);
					pstmtAppuntamento.executeUpdate();
					
					pstmtServizio.setInt(1, id);
					pstmtServizio.executeUpdate();
					
					
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
	// done
    
}
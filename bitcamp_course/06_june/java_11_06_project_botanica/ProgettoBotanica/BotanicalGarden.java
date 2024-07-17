package java_11_06.ProgettoBotanica;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class BotanicalGarden {
	

	
	// attributi reperibili dall'intera classe
	private JFrame frame; //finestra principale
	private CardLayout cardLayout; // layout per cambiare i panelli
	private JPanel mainPanel; // pannello contenente i diversi pannelli secondari
	private JTable table; // per visualizzare i dati
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/botanical_garden";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "localbombcomputer";

	
	// eventuali ulteriori variabili da utilizzare
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(BotanicalGarden::new); // abbrevia la scrittura estesa
		
	}
	
	public BotanicalGarden() {
		frame = new JFrame("Giardino Botanico"); // creazione finestra principale
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
		JPanel panel = new JPanel(new GridLayout(6,2));
		JTextField plantNameField = new JTextField();
		JTextField scientificNameField = new JTextField();
		JTextField categoryNameField = new JTextField();
		JTextField categoryDescriptionField = new JTextField();
		JTextField plantingDateField = new JTextField();
		JButton insertButton = new JButton("Inserisci");
		
			
		panel.add(new JLabel("Nome Pianta: "));
		panel.add(plantNameField);
		panel.add(new JLabel("Nome Scientifico: "));
		panel.add(scientificNameField);
		panel.add(new JLabel("Categoria: "));
		panel.add(categoryNameField);
		panel.add(new JLabel("Descrizione Categoria: "));
		panel.add(categoryDescriptionField);
		panel.add(new JLabel("Data pianta piantata (es. 2020-05-25): "));
		panel.add(plantingDateField);
		panel.add(new JLabel()); // placeholder per cella vuota
		panel.add(insertButton);

		// gestione evento bottone
		insertButton.addActionListener(e -> {
			// azione da eseguire a seguito dell'evento
			String plantName = plantNameField.getText();
			String scientificName = scientificNameField.getText();
			String categoryName = categoryNameField.getText();
			String categoryDescription = categoryDescriptionField.getText();
			String plantingDate = plantingDateField.getText();
			
			// richiamo la funzione per gestire la query di inserimento
			insertPlantAndCategory(plantName, scientificName, categoryName, categoryDescription, plantingDate);
			
			// ricarichiamo i dati all'interno della tabella
			loadTableData();
			
		});
		
		return panel;
	}
	
	private JPanel createUpdatePanel() {
		
		JPanel panel = new JPanel(new GridLayout(7,2));
		JTextField idField = new JTextField();
		JTextField plantNameField = new JTextField();
		JTextField scientificNameField = new JTextField();
		JTextField categoryNameField = new JTextField();
		JTextField categoryDescriptionField = new JTextField();
		JTextField plantingDateField = new JTextField();
		JButton updateButton = new JButton("Modifica");
		
		panel.add(new JLabel("ID: "));
		panel.add(idField);
		panel.add(new JLabel("Nome Pianta: "));
		panel.add(plantNameField);
		panel.add(new JLabel("Nome Scientifico: "));
		panel.add(scientificNameField);
		panel.add(new JLabel("Categoria: "));
		panel.add(categoryNameField);
		panel.add(new JLabel("Descrizione Categoria: "));
		panel.add(categoryDescriptionField);
		panel.add(new JLabel("Data pianta piantata (es. 2020-05-25): "));
		panel.add(plantingDateField);
		panel.add(new JLabel()); // placeholder per cella vuota
		panel.add(updateButton);
		
		
		//gestiamo evento del bottone
		updateButton.addActionListener(e -> {
			
			int id = Integer.parseInt(idField.getText());
			String plantName = plantNameField.getText();
			String scientificName = scientificNameField.getText();
			String categoryName = categoryNameField.getText();
			String categoryDescription = categoryDescriptionField.getText();
			String plantingDate = plantingDateField.getText();
			
			// richiamo la funzione per gestire la query di inserimento
			updatePlantAndCategory(id, plantName, scientificName, categoryName, categoryDescription, plantingDate);
			
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
			deletePlantAndCategory(id);
			// ricarichiamo il contenuto della tabella
			loadTableData();
		});
		return panel;
		
	}
	
	private void loadTableData() {
		try (
		        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT plants.id, plants.name, plants.scientific_name," +
												 "categories.name AS category, categories.description, plants.planting_date " +
												 "FROM plants "+
												 "JOIN categories ON plants.category_id = categories.id ")
			){
			
			// Caricamento dei dati dalla tabella iscrizione unendo la tabella studenti e corsi
			ArrayList<String[]> data = new ArrayList<>(); // lista per memorizzare i record
			while(rs.next()) {
				int id = rs.getInt("id");
				String plantName = rs.getString("name");
				String scientificName = rs.getString("scientific_name");
				String categoryName = rs.getString("name");
				String categoryDescription = rs.getString("description");
				String plantingDate = rs.getString("planting_date");
				
				data.add(new String[] { String.valueOf(id), plantName, scientificName, categoryName, categoryDescription, plantingDate});
			}
			
			// creazione della tabella che conterra l'arraylist data
			String[][] dataArray = new String[data.size()][6];
			data.toArray(dataArray); // conversione dei dati in arraylist all'interno della matrice
			String[] columnNames = {"ID", "Nome Pianta", "Nome Scientifico", "Nome Categoria", "Descrizione Categoria", "Data Piantagione"};
			table.setModel(new javax.swing.table.DefaultTableModel(dataArray, columnNames));
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		};
		
	}
	
	private void insertPlantAndCategory(
			String plantName, String scientificName ,String categoryName, String categoryDescription, String plantingDate) {
		
		try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
			
			conn.setAutoCommit(false);
			
			try(
				PreparedStatement pstmtPlant = conn.prepareStatement("INSERT INTO plants(name, scientific_name, category_id, planting_date) VALUES (?,?,?,?)");
				PreparedStatement pstmtCategory = conn.prepareStatement("INSERT INTO  categories(name,description) VALUES (?,?)",
				Statement.RETURN_GENERATED_KEYS); // ritorna il numero dell'id
					){
				
				// inserimento categoria
					pstmtCategory.setString(1, categoryName);
					pstmtCategory.setString(2, categoryDescription);
					
					pstmtCategory.executeUpdate(); 
					
					ResultSet rsCategory = pstmtCategory.getGeneratedKeys();
					rsCategory.next();
					int categoryId = rsCategory.getInt(1);
				
				// inserimento pianta
					pstmtPlant.setString(1, plantName);
					pstmtPlant.setString(2, scientificName);
					pstmtPlant.setInt(3, categoryId);
					pstmtPlant.setString(4, plantingDate);

					
					pstmtPlant.executeUpdate(); // il valore generate ora ha una ID che ci facciamo ritornare con Statement.RETURN_GENERATED_KEYS
					// ritorno della chiave primaria del record appena inserito
					
//					ResultSet rsPlant = pstmtPlant.getGeneratedKeys();
//					rsPlant.next();
//					int plantId = rsPlant.getInt(1);



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
	
	private void updatePlantAndCategory(
		int id, String plantName, String scientificName, String categoryName, String categoryDescription, String plantingDate) {
		
		try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
			
			conn.setAutoCommit(false);
			
			try(
		            PreparedStatement pstmtPlant = conn.prepareStatement("UPDATE plants SET name = ?, scientific_name = ?, planting_date = ? WHERE id = ?");
					PreparedStatement pstmtCategory = conn.prepareStatement("UPDATE categories SET name = ?, description = ? WHERE id = (SELECT category_id FROM plants WHERE id = ?)")
			){
				pstmtPlant.setString(1, plantName);
				pstmtPlant.setString(2, scientificName);
				pstmtPlant.setString(3, plantingDate);
				pstmtPlant.setInt(4, id);
				pstmtPlant.executeUpdate();

				pstmtCategory.setString(1, categoryName);
				pstmtCategory.setString(2, categoryDescription);
				pstmtCategory.setInt(3, id);
				pstmtCategory.executeUpdate();


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
	
	private void deletePlantAndCategory(
			
			int id) {
		
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
			
			conn.setAutoCommit(false);
		
			try(PreparedStatement pstmtPlant = conn.prepareStatement("DELETE FROM plants WHERE category_id = ?");
				PreparedStatement pstmtCategory = conn.prepareStatement("DELETE FROM categories WHERE id IN (SELECT category_id FROM plants WHERE id = ?)")
					
				){
				
				pstmtPlant.setInt(1, id);
				pstmtPlant.executeUpdate();
				
				pstmtCategory.setInt(1, id);
				pstmtCategory.executeUpdate();
				
				
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


package grafiche;

import javax.swing.*;
import javax.swing.table.DefaultTableModel; 
// per prendere i file all'interno delle sottodirectory é necessario dichiararle

public class esempio_frame_con_tabella {
	
	public static void main(String[] args) {
		
		// Finestra
		JFrame frame = new JFrame("Finestra con layout");
				
		// Settings
		frame.setSize(400,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Creazione di dati per la tabella
		Object[][] data = {
				{"Mario", "Rossi", 30},
				{"Giovanna", "Bianchi", 25},
				{"Luca", "Verdi", 35}
		};
		
		// Creazione mono-dimensionale per etichette
		String[] etichette = {"Nome", "Cognome", "Eta"};		
		
        // Creazione del modello della tabella
        DefaultTableModel model = new DefaultTableModel(data, etichette);
        
		// Creazione della tabella
		JTable table = new JTable(model);
		
		// Creazione di uno scrollPane per la tabella
		JScrollPane scrollPane = new JScrollPane(table);
		
		// Aggiunta scrollPane al frame
		frame.add(scrollPane);
		
		// Visualizza
		frame.setVisible(true);
		
		
		
		
		
		
	}


}

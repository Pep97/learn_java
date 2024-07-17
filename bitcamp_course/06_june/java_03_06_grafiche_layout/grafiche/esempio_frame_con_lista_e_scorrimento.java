package grafiche;

import javax.swing.*;

public class esempio_frame_con_lista_e_scorrimento {

	public static void main(String[] args) {

		// Finestra
		JFrame frame = new JFrame("Finesta con lista");
		
		// Setting per la finestra
		frame.setSize(300,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Array per popolare una lista
		String[] data = {"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4"};
		
		// Creazione di una lista(JList) -> manage arrays
		JList<String> list = new JList<>(data);
		
		// Impostazione della selezione sulla lista
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		// Creazione di un pannello a scorrimento(JScrollPane)
		JScrollPane scrollPane = new JScrollPane(list);
		
		// Aggiungiamo il pannello alla finestra
		frame.add(scrollPane);
		
		// Apriamo la finestra
		frame.setVisible(true);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

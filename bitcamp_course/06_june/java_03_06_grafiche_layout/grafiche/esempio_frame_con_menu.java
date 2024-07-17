package grafiche;

import javax.swing.*;

public class esempio_frame_con_menu {

	public static void main(String[] args) {

		// Finestra
		JFrame frame = new JFrame("Finestra con menu");
		
		// Settings
		frame.setSize(300,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Creazione della barra dei menu
		JMenuBar menuBar = new JMenuBar();
		
		// Creazione oggetto menu
		JMenu fileMenu = new JMenu("File");
		JMenu aiutoMenu = new JMenu ("Help");
		
		// Creazione elementi del menu file
		JMenuItem newItem = new JMenuItem("Nuovo");
		JMenuItem openItem = new JMenuItem("Apri");
		JMenuItem exitItem = new JMenuItem("Esci");
		
		// Creazione elementi del menu help
		JMenuItem guideItem = new JMenuItem("Documentazione");
		
		// Aggiunta delle voci del menu
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.addSeparator(); // Aggiunge una linea tra i menu
		fileMenu.add(exitItem);
		aiutoMenu.add(guideItem);
		
		// Aggiunta dei JMenu al contenitore Bar
		menuBar.add(fileMenu);
		menuBar.add(aiutoMenu);
		
		// Aggiunta del menuBar al frame
		frame.setJMenuBar(menuBar);
		
		// Rendere visibile la finestra
		frame.setVisible(true);

		



		
		
		
		
		
		
		
	}

}

package grafiche;

import javax.swing.*;

public class esempio_frame_con_tabbed_panel {

	public static void main(String[] args) {

		// Finestra
		JFrame frame = new JFrame("Finestra con menu");
				
		// Settings
		frame.setSize(400,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Creazione di un pannello tabulare(JTabbedPane)
		JTabbedPane tabbedPane = new JTabbedPane();
		
		// Creazione dei pannelli interni
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		// Aggiunta di contenuto hai panelli
		panel1.add(new JLabel("contenuto Tab 1"));
		JLabel label2 = new JLabel("contenuto Tab 2");
		panel2.add(label2);
		panel3.add(new JLabel("contenuto Tab 3"));		

		// Aggiunta dei panel al TabbedPanel
		
		tabbedPane.add("Tab 1", panel1);
		tabbedPane.add("Tab 2", panel2);
		tabbedPane.add("Tab 3", panel3);

		// Aggiunta del TabbedPanel alla finestra
		frame.add(tabbedPane);
		
		frame.setVisible(true);
		
		
		
		
		
		
	}

}

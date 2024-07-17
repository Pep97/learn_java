package layout;

import javax.swing.*;
import java.awt.*;

public class panel_con_layout {

	public static void main(String[] args) {
		
		// Finestra
		JFrame frame = new JFrame("Finestra con layout");
				
		// Settings
		frame.setSize(300,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Creazione pannello
		JPanel panel = new JPanel();
		
		// Gestione layout pannello
		panel.setLayout(new GridLayout(2,3)); // (righe, colonne)
		
		// Aggiunta di elementi al pannello
		panel.add(new JLabel("Etichetta 1"));
		panel.add(new JLabel()); // questo é un placeholder
		panel.add(new JButton("Pulsante 1"));
		panel.add(new JLabel("Etichetta 2"));
		panel.add(new JTextField(10));
		panel.add(new JButton("Pulsante 2"));
		
		// Aggiunta panello al frame
		frame.add(panel);
		
		frame.setVisible(true);
		

		
		
		
	}

}

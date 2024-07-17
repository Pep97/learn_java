package grafiche;

import javax.swing.*;

public class esempio_frame_con_input_dialog {

	public static void main(String[] args) {

		
		// Finestra
		JFrame frame = new JFrame("Finestra con input");
				
		// Settings
		frame.setSize(300,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Visualizza una finestra di input e salva l'informazione in una variabile
		String nome = JOptionPane.showInputDialog(frame, "Inserisci il tuo nome:");
		
		// Visualizza il messaggio di benvenuto con il nome inserito
		JOptionPane.showMessageDialog(frame, "Benvenuto " + nome + "!");
		
		frame.setVisible(true);
		
		
		
		
		
		
		
		
		
	}

}

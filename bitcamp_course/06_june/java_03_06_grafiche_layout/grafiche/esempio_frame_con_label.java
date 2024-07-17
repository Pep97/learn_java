package grafiche;

import javax.swing.*;

public class esempio_frame_con_label {

	public static void main(String[] args) {
		
		
		// Creazione della finestra
		
		JFrame frame = new JFrame("Finestra con Etichetta");
		
		
		// Creazione di una etichetta (label) con libreria Jlabel
		JLabel label = new JLabel("Bernvenuto!");
		
		// Aggiunta dell'etichetta alla finestra
		frame.add(label);
		
		// Impostazione della dimensione della finestra
		
		frame.setSize(300, 200);
		
		// Impostazione del posizionamento iniziale
		
		frame.setLocationRelativeTo(null);
		
		// Gestione della chiusura della finestra
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Rendiamo la finestra visibile
		
		frame.setVisible(true);
		
		
		
		
		
		
		
		
		
	}

}

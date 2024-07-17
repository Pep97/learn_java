package grafiche;

import javax.swing.*; // Struttura
//iterazione utente
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;


public class esempio_frame_con_pulsante {

	public static void main(String[] args) {
		
		// Creazione finestra
		
		JFrame frame = new JFrame("Finestra con pulsante");
		
		// Creazione di un buttone
		
		JButton button = new JButton("Clicca qui");
		
		// Aggiunta della azione del bottone
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Hai cliccato qui");
				
			}
		});
		
		
		// Aggiunta del botton alla finestra
		
		frame.add(button);
		
		// Impostazione della dimensione della finestra
		
		frame.setSize(300, 200);
		
		// Impostazione del posizionamento iniziale
		
		frame.setLocationRelativeTo(null);
		
		// Chiusura finestra
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//disegnamo la finestra
		frame.setVisible(true);
		
		
		
		
		
		
	}

}

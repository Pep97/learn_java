package grafiche;

import javax.swing.*;
import java.awt.event.*;
// import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;


public class esempio_frame_con_input {

	public static void main(String[] args) {

		
		// Creazione finestra
		
		JFrame frame = new JFrame ("Finestra con campo input");
	
		// Dimensione finestra
		frame.setSize(300,300);
		
		// posizione finestra
		frame.setLocationRelativeTo(null);
		
		//chiusura
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creazione di un campo di testo(JtextField)
		JTextField textField = new JTextField(20); // 20 -> is the characters that is expecting (like on VARCHAR)
		
		// Creazione di una etichetta(JLabel)
		JLabel label = new JLabel("Inserisci qualcosa:");
		
		// Aggiunta di una azione al campo di testo
		textField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("Hai scritto: " + textField.getText());
				
			}
		});
		
		// Creazione di un panello per contenere i diversi elementi
		JPanel panel = new JPanel();
		
		// Aggiunta dei compenenti al pannello
		panel.add(label);
		panel.add(textField);
		
		// Aggiunta del pannello al frame
		frame.add(panel);
		
		// Visualizza frame
		frame.setVisible(true);
		
		
		
		
	}

}

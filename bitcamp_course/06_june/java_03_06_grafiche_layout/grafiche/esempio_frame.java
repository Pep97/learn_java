package grafiche;

import javax.swing.*;

public class esempio_frame {
	
	public static void main(String[] args) {
		
		// creazione di un oggetto Jframe
		JFrame frame = new JFrame("Finestra Semplice");
		
		// Impostazione della dimensione della finestra
		frame.setSize(300, 200); // forma che l'utente finale vedrá
		
		// Impostazione della posizione della finestra sullo schermo
		frame.setLocationRelativeTo(null); 
		// null -> se voglia che si utilizza il posizionamento di default del sistema operativo.
		// 50,100 -> oppure metti i numeri per settare la coordinata specifica.
		
		// alcune app anche se le chiudi premendo sulla "x" poi rimangono aperte nel background
		// Impostazione della chiusura predefinita
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		// ció permette di far funzionare la "x" e di chiudere il programma e non solo la finestra.
		
		// Rendere la finestra visibile
		frame.setVisible(true); 
		
		
		
	}

}

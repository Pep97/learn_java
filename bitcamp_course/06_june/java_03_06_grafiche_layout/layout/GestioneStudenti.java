package layout;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GestioneStudenti extends JFrame{

	// Definizione degli attributi della classe
	private static final String DB_URL = "jdbc:mysql://localhost:3306/scuola";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "localbombcomputer";
	
	private JLabel lblNome, lblCognome, lblEta;
	private JTextField txtNome, txtCognome, txtEta;
	private JButton btnSalva;
	
	// Costruttore della classe
	public GestioneStudenti() {
//		setTitle("Gestione Studenti");
		super("Gestione Studenti");  // with super your calling JFrame, and you're setting the title.
		
		// inizializzazione dei componenti dell'interfaccia grafica
		lblNome = new JLabel("Nome");
		lblCognome = new JLabel("Cognome");
		lblEta = new JLabel("Eta:");
		
		txtNome = new JTextField(20);
		txtCognome = new JTextField(20);
		txtEta = new JTextField(3); 
		
		btnSalva = new JButton("Salva");
		
		// Aggiunta dei componenti all'interfaccia
		JPanel panel = new JPanel(new GridLayout(4,2));
		panel.add(lblNome);
		panel.add(txtNome);
		
		panel.add(lblCognome);
		panel.add(txtCognome);

		panel.add(lblEta);
		panel.add(txtEta);
		
		panel.add(btnSalva);
		
		add(panel);
//		getContentPane().add(panel); -> you could see also this, and it works exactly as add(panel);

		// Aggiunta del Listener per il pulsante Salve -> possible richiesta durante un colloquio tecnico
		// in mysql durante un colloquio tecnico si chiedere: come fare un JOIN
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Recupero dei dati inseriti dall'utente
				String nome = txtNome.getText();
				String cognome = txtCognome.getText();
				int eta = Integer.parseInt(txtEta.getText());

				// Connessione al DB ed inserimento studente
				Connection conn = null;
				PreparedStatement pstmt = null;
				
				try {
					conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
					String sql = "INSERT INTO studenti(nome, cognome, eta) VALUES (?,?,?)";
					
					pstmt = conn.prepareStatement(sql);
					
					// Valorizzazione placeholder
					pstmt.setString(1, nome);
					pstmt.setString(2, cognome);
					pstmt.setInt(3, eta);
					
					// Esecuzione dello statement
					int recordInserito = pstmt.executeUpdate();
					
					if(recordInserito > 0) {
						JOptionPane.showMessageDialog( null, "Studente inserito correttamente"); 
						// panel di riferimento e poi messaggio
						// se vedi "null" é per autoselezionare la tabella
					}
					
									
					
				} catch(SQLException ex) {
					ex.printStackTrace();
				} finally { // é come un blocco finale che viene SEMPRE eseguito alla fine del try/catch
					
					// potrebbe capitare che la connessione non é mai stata aperta, facciamo un controllo.
					
					try {
						
						if(pstmt != null) pstmt.close(); 
						if(pstmt != null) conn.close(); 

						// questo é l'equivalente all if di sotto, é normalmente utilizzato solo quando l'if se positivo esegue il codice dopo
						
						
//						if(pstmt != null) {
//							pstmt.close();
//							conn.close();
//						}
						
												
					}catch(SQLException ek) {
						
						ek.printStackTrace();
						
					}
					
				}
				
				// Reset dei campi del form 
				txtNome.setText("");
				txtCognome.setText("");
				txtEta.setText("");

				
			}
		});
		
		
		// Setting della finestra
		setSize(300,150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		

		
	}
	
	
	// Metodo main
	public static void main(String[] args) {
		new GestioneStudenti();
		// per singla interfaccia lo puoi visualizzare in questa maniera.
		// per piú interfaccie utilizza InvokeLater
//    	SwingUtilities.invokeLater(new Runnable() {
//    		public void GestioneStudenti() {
//    			new interfacciaGestionale().setVisible(true);
//    		}
	}
	
	
	
	
	
	
	
	
	
}

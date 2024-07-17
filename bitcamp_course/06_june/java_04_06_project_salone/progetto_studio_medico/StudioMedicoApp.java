package java_04_06.progetto_studio_medico;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudioMedicoApp extends JFrame {

	// Definizione attributi
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private JTextArea outputTextArea;
	private JTextField txtData;
	private JTextField txtOra;
	private JTextField txtNomeDottore;
	private JTextField txtSpecializzazione;
	private JTextField txtNomeCliente;
	private JTextField txtCognomeCliente;
	
	// Costruttore
	public StudioMedicoApp() {
		setTitle("Studio Medico Manager");
		
		try {
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studio_medico", "root", "localbombcomputer");
			// questo é per simulare dei dati dinamici di ogni utente.
			stmt = conn.createStatement();			
			
			
			
		} catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Impossibile connetersi al database", "Errore", JOptionPane.ERROR_MESSAGE);
			// "this" in questo caso auto selezioni questo pannello
			// 3 paramentro é il titolo
			// 4 paramentro é l'icona di errore
			System.exit(1);
		}
		
		// Pannello output elaborazione dati
		outputTextArea = new JTextArea(20,50); // (righe, colonne)
		JScrollPane scrollPane = new JScrollPane(outputTextArea);
		
		// Pannello comandi(bottoni)
		JPanel btnPanel = new JPanel(new GridLayout(6,1));
		
		JButton btnAppuntamenti = new JButton("Visualizza Appuntamenti");
		btnAppuntamenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAppuntamenti();
			}
		});
		
		JButton btnDottori = new JButton("Visualizza Dottori");
		btnDottori.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDottori();
			}
		});
		
		JButton btnClienti = new JButton("Visualizza Clienti");
		btnClienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showClienti();
			}
		});
		
		JButton btnInserisciAppuntamento = new JButton("Inserisci Appuntamento");
		btnInserisciAppuntamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InserisciAppuntamento();
			}
		});
		
		JButton btnInserisciDottore = new JButton("Inserisci Dottore");
		btnInserisciDottore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InserisciDottore();
			}
		});
		
		JButton btnInserisciCliente = new JButton("Inserisci Cliente");
		btnInserisciCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InserisciCliente();
			}
		});
		
		// Aggiungiamo i bottoni al giusto pannello
		btnPanel.add(btnAppuntamenti);
		btnPanel.add(btnDottori);
		btnPanel.add(btnClienti);
		btnPanel.add(btnInserisciAppuntamento);
		btnPanel.add(btnInserisciDottore);
		btnPanel.add(btnInserisciCliente);

		// Pannello di input
		JPanel inputPanel = new JPanel(new GridLayout(12,1));
		
		// Inizializzazione dei componenti per l'input dei dati
		txtData = new JTextField(20);
		txtOra = new JTextField(20);
		txtNomeDottore = new JTextField(20);
		txtSpecializzazione = new JTextField(20);
		txtNomeCliente = new JTextField(20);
		txtCognomeCliente = new JTextField(20);

		// Aggiunta dei componenti all'interno del pannello di input
		inputPanel.add(new JLabel("Data:"));
		inputPanel.add(txtData);
		inputPanel.add(new JLabel("Ora:"));
		inputPanel.add(txtOra);
		inputPanel.add(new JLabel("Nome Dottore:"));
		inputPanel.add(txtNomeDottore);
		inputPanel.add(new JLabel("Specializzazione:"));
		inputPanel.add(txtSpecializzazione);
		inputPanel.add(new JLabel("Nome Cliente:"));
		inputPanel.add(txtNomeCliente);
		inputPanel.add(new JLabel("Cognome Cliente:"));
		inputPanel.add(txtCognomeCliente);

		// Aggiunta dei alla finestra
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(btnPanel, BorderLayout.EAST);
		getContentPane().add(inputPanel, BorderLayout.WEST);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		pack(); //questo é come setSize() -> tutti i contenuti si addattano al contenuto
		setVisible(true);

		
	}
	
	private void showAppuntamenti() {
		
		outputTextArea.setText("");
		try {
			rs = stmt.executeQuery("SELECT * FROM appuntamenti");
			
			while(rs.next()) {
				
//				String data = rs.getString("data");
				outputTextArea.append(rs.getString("data") + " - " + rs.getString("ora") + " - " + rs.getString("dottore") + " - " + rs.getString("cliente") + "\n");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Errore durante il recupero degli appuntamenti", "Errore", JOptionPane.ERROR_MESSAGE);
			
		}
	
	}
	
	private void showDottori() {
		
		outputTextArea.setText("");
		try {
			rs = stmt.executeQuery("SELECT * FROM dottori");
			
			while(rs.next()) {
				
//				String data = rs.getString("data");
				outputTextArea.append(rs.getString("id") + " - " + rs.getString("nome") + " - " + rs.getString("specializzazione") + "\n");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Errore durante il recupero dei dottori", "Errore", JOptionPane.ERROR_MESSAGE);
			
		}
	
	}
	
	private void showClienti() {
		
		outputTextArea.setText("");
		try {
			rs = stmt.executeQuery("SELECT * FROM clienti");
			
			while(rs.next()) {
				
//				String data = rs.getString("data");
				outputTextArea.append(rs.getString("id") + " - " + rs.getString("nome") + " - " + rs.getString("cognome") + "\n");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Errore durante il recupero dei clienti", "Errore", JOptionPane.ERROR_MESSAGE);
			
		}
	
	}
	
	private void InserisciAppuntamento() {
		
		String data = txtData.getText();
		String ora = txtOra.getText();
		String dottore = txtNomeDottore.getText();
		String cliente = txtNomeCliente.getText() + " " +txtCognomeCliente.getText();
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO appuntamenti (data,ora,dottore,cliente) VALUES (?,?,?,?)");
			pstmt.setString(1, data);
			pstmt.setString(2, ora);
			pstmt.setString(3, dottore);
			pstmt.setString(4, cliente);
			
			pstmt.executeUpdate();
			
			JOptionPane.showMessageDialog(this, "Appuntamento inserito con successo");
			
			
		} catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Errore durante l'inserimento dell'appuntamento", "Errore", JOptionPane.ERROR_MESSAGE);
			
		}
	
	}
	
	private void InserisciDottore() {
		
		String nome = txtNomeDottore.getText();
		String specializzazione = txtSpecializzazione.getText();

		try {
			pstmt = conn.prepareStatement("INSERT INTO dottori (nome,specializzazione) VALUES (?,?)");
			pstmt.setString(1, nome);
			pstmt.setString(2, specializzazione);

			pstmt.executeUpdate();
			
			JOptionPane.showMessageDialog(this, "Dottore inserito con successo");
			
			
		} catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Errore durante l'inserimento del dottore", "Errore", JOptionPane.ERROR_MESSAGE);
			
		}
	
	}
	
private void InserisciCliente() {
    String nome = txtNomeCliente.getText();
    String cognome = txtCognomeCliente.getText();

    try {
        pstmt = conn.prepareStatement("INSERT INTO clienti (nome,cognome) VALUES (?,?)");
        pstmt.setString(1, nome);
        pstmt.setString(2, cognome);

        pstmt.executeUpdate();
        
        JOptionPane.showMessageDialog(this, "Cliente inserito con successo");
        
        
    } catch(SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Errore durante l'inserimento del cliente", "Errore", JOptionPane.ERROR_MESSAGE);
        
    }
}
	
	public static void main(String[] args) {

    	SwingUtilities.invokeLater(new Runnable() {
    		public void run() {
    			new StudioMedicoApp();
    		}
    	});
	}
	

}

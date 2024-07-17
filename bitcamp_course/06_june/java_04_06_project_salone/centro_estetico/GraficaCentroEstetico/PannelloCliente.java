package java_04_06.centro_estetico.GraficaCentroEstetico;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java_04_06.centro_estetico.CentroEstetico.*;

public class PannelloCliente extends JPanel {

	JPanel crudPanelCliente = new JPanel(new FlowLayout(FlowLayout.CENTER, 60,10));
	JPanel clientePanelCenter = new JPanel(); // usato solamente per visualizzare i dati dei clienti -> sezione ancora da costruire
	JPanel clientePanelSouth = new JPanel();


		// crudPanelCliente
		JButton btnAggiungiCliente;
		JButton btnModificaCliente;
		JButton btnEliminaCliente;
		JButton btnVisualizzaCliente;

		// clientePanelCenter

		// clietePanelSouth

			// Per AggiungiClientiPanel
			JPanel clientePanelGriglia = new JPanel(new GridLayout(8,2));
			JPanel aggiungiClientiPanel = new JPanel(new FlowLayout());
			JPanel aggiungiClientiPanelGrid = new JPanel(new GridLayout(6,2));

			private JTextField txtNomeCliente;
			private JTextField txtCognomeCliente; 
			private JTextField txtTelefonoCliente;
			private JTextField txtEmailCliente;
			private JTextField txtCodiceFiscaleCliente;
			private JTextArea txtPreferenzeCliente; 
			private JButton btnInserisciCliente;

		
			// Per ModificaClientiPanel
			JPanel modificaClientiPanel = new JPanel(new GridLayout(10,2));
			
			// Per EliminaClientiPanel
			JPanel eliminaClientiPanel = new JPanel(new GridLayout(10,2));
			
			// Per VisualizzaClientiPanel
			JPanel visualizzaClientiPanel = new JPanel(new GridLayout(10,2));
	

	
	public PannelloCliente(){

		// CREAZIONE SEZIONE crudPanelCliente  (racchiude i bottoni per le operazioni CRUD sui clienti) 

			// bottoni cliente
				btnAggiungiCliente = new JButton("Aggiungi Cliente");
				btnAggiungiCliente.setPreferredSize(new Dimension(150,30));
				btnAggiungiCliente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						aggiungiCliente();
					}
				});
				btnModificaCliente = new JButton("Modifica Cliente");
				btnModificaCliente.setPreferredSize(new Dimension(150,30));
				btnModificaCliente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						modificaCliente();
					}
				});
				btnEliminaCliente = new JButton("Elimina Cliente");
				btnEliminaCliente.setPreferredSize(new Dimension(150,30));
				btnEliminaCliente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						eliminaCliente();
					}
				});
				btnVisualizzaCliente = new JButton("Visualizza Clienti");
				btnVisualizzaCliente.setPreferredSize(new Dimension(150,30));
				btnVisualizzaCliente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						visualizzaCliente();
					}
				});

			// crudPanelCliente
				crudPanelCliente.setPreferredSize(new Dimension(1110,50));
				crudPanelCliente.add(btnAggiungiCliente);
				crudPanelCliente.add(btnModificaCliente);
				crudPanelCliente.add(btnEliminaCliente);
				crudPanelCliente.add(btnVisualizzaCliente);

			add(crudPanelCliente);

		// CREAZIONE SEZIONE clientePanelCenter (ancora da costruire)

			clientePanelCenter.setVisible(false);
			add(clientePanelCenter);

		// CREAZIONE SEZIONE clientePanelSouth (racchiude i pannelli per le operazioni CRUD sui clienti)
			
			clientePanelSouth.setVisible(false);
			add(clientePanelSouth);	

			// // Bottone aggiungi cliente
        

				aggiungiClientiPanel.add(new JLabel("Compila tutti i dati e premi il tasto 'Inserisci' per inserire il nuovo cliente"));

				// Griglia per l'inserimento dei dati del cliente
				txtNomeCliente = new JTextField(45);
				txtCognomeCliente = new JTextField(45);
				txtTelefonoCliente = new JTextField(45);
				txtEmailCliente = new JTextField(45);
				txtCodiceFiscaleCliente = new JTextField(45);
				txtPreferenzeCliente = new JTextArea(2,45);

				aggiungiClientiPanelGrid.add(new JLabel("Nome:      " , JLabel.RIGHT));
				aggiungiClientiPanelGrid.add(txtNomeCliente);
				aggiungiClientiPanelGrid.add(new JLabel("Cognome:     " , JLabel.RIGHT));
				aggiungiClientiPanelGrid.add(txtCognomeCliente);
				aggiungiClientiPanelGrid.add(new JLabel("Telefono:     ", JLabel.RIGHT));
				aggiungiClientiPanelGrid.add(txtTelefonoCliente);
				aggiungiClientiPanelGrid.add(new JLabel("Email:     ", JLabel.RIGHT));
				aggiungiClientiPanelGrid.add(txtEmailCliente);
				aggiungiClientiPanelGrid.add(new JLabel("Codice Fiscale:     ", JLabel.RIGHT));
				aggiungiClientiPanelGrid.add(txtCodiceFiscaleCliente);
				aggiungiClientiPanelGrid.add(new JLabel("Preferenze:     ", JLabel.RIGHT));
				JScrollPane txtPreferenzeClientiscrollPane = new JScrollPane(txtPreferenzeCliente);
				aggiungiClientiPanelGrid.add(txtPreferenzeClientiscrollPane);

				aggiungiClientiPanelGrid.setBorder(new EmptyBorder(20, 0, 0, 500)); // top, left, bottom, right margin
				aggiungiClientiPanel.add(aggiungiClientiPanelGrid);


				btnInserisciCliente = new JButton("Inserisci");
				btnInserisciCliente.setPreferredSize(new Dimension(100,30));
				btnInserisciCliente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						inserisciCliente();
					}
				});

				aggiungiClientiPanel.add(btnInserisciCliente);


			
				// aggiungiClientiPanel.setPreferredSize(new Dimension(1100, 450)); 


				aggiungiClientiPanel.setVisible(false);
				clientePanelSouth.add(aggiungiClientiPanel);
	

			// Bottone modifica cliente	

				// JButton btnModificaCliente = new JButton("Inserisci");
				// btnModificaCliente.setPreferredSize(new Dimension(100,30));
				// btnModificaCliente.addActionListener(new ActionListener() {
				// 	public void actionPerformed(ActionEvent e) {
				// 		modificaCliente();
				// 	}
				// });
				// modificaClientiPanel.add(btnModificaCliente);

				modificaClientiPanel.setVisible(false);
				clientePanelSouth.add(modificaClientiPanel);

			// Bottone elimina cliente

				eliminaClientiPanel.setVisible(false);
				clientePanelSouth.add(eliminaClientiPanel);

			// Bottone visualizza cliente

				visualizzaClientiPanel.setVisible(false);
				clientePanelSouth.add(visualizzaClientiPanel);

		
	}


private void aggiungiCliente() {

	clientePanelCenter.setVisible(false);
	clientePanelSouth.setVisible(true);
	clientePanelSouth.setPreferredSize(new Dimension(1100, 450)); // cambia dimensioni perché in visualizza devone essere differenti
	
	aggiungiClientiPanel.setVisible(true);
	// aggiungiClientiPanelGrid.setVisible(true);


	modificaClientiPanel.setVisible(false);
	eliminaClientiPanel.setVisible(false);
	visualizzaClientiPanel.setVisible(false);


}
	
private void inserisciCliente(){
}

private void modificaCliente() {

	clientePanelCenter.setVisible(false);
    aggiungiClientiPanelGrid.setVisible(false);
    modificaClientiPanel.setVisible(true);
    eliminaClientiPanel.setVisible(false);
    visualizzaClientiPanel.setVisible(false);

	clientePanelCenter.setVisible(false);
	clientePanelSouth.setVisible(true);
	clientePanelSouth.setPreferredSize(new Dimension(1100, 450)); // cambia dimensioni perché in visualizza devone essere differenti
	


}

private void eliminaCliente() {

	clientePanelCenter.setVisible(false);
	clientePanelSouth.setVisible(true);
	clientePanelSouth.setPreferredSize(new Dimension(1100, 450)); // cambia dimensioni perché in visualizza devone essere differenti
	
	
    clientePanelCenter.setVisible(false);
    aggiungiClientiPanelGrid.setVisible(false);
    modificaClientiPanel.setVisible(false);
    eliminaClientiPanel.setVisible(true);
    visualizzaClientiPanel.setVisible(false);


}

private void visualizzaCliente() {

	clientePanelCenter.setVisible(true);
	clientePanelSouth.setVisible(true);
	clientePanelSouth.setPreferredSize(new Dimension(1100, 250));
	
	
    clientePanelCenter.setVisible(false);
    aggiungiClientiPanelGrid.setVisible(false);
    modificaClientiPanel.setVisible(false);
    eliminaClientiPanel.setVisible(true);
    visualizzaClientiPanel.setVisible(false);

}
		
}

     
     
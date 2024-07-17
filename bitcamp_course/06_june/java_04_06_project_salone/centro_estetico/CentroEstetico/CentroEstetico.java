package java_04_06.centro_estetico.CentroEstetico;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java_04_06.centro_estetico.GraficaCentroEstetico.*;


public class CentroEstetico extends JFrame {

// istanze classi
Macchinario macchinari = new Macchinario();

// variabili
JLabel sottotitolo;
JPanel clientePanel = new PannelloCliente1();
JPanel serviziPanel = new JPanel();
JPanel prodottiPanel = new JPanel();
JPanel macchinariPanel = new JPanel();
JPanel stanzePanel = new JPanel();
JPanel dipendentiPanel = new JPanel();
JPanel chartPanel = new JPanel();
CardLayout cardLayout = new CardLayout();
JPanel contenitoreBottoni = new JPanel(cardLayout);


JPanel clientePanelCenter = new JPanel();
JPanel clientePanelSouth = new JPanel();
JPanel clientePanelGriglia = new JPanel(new GridLayout(8,2));



private JTextField txtNomeCliente;
private JTextField txtCognomeCliente; 
private JTextField txtTelefonoCliente;
private JTextField txtEmailCliente;
private JTextField txtCodiceFiscaleCliente;
private JTextArea txtPreferenzeCliente; 





//Costruttore Interfaccia Applicazione
public CentroEstetico() {
	
	//setting del Frame
	setTitle("Magie di Venere - Versione 0.1");
	setSize(1280,720);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	
	//pannello principale
	JPanel mainPanel = new JPanel(new BorderLayout());
	
	//pannello del menu
	JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0,15));
	
	    //impostazione delle dimensioni del menuPanel
	
        menuPanel.setPreferredSize(new Dimension(170,600));
        menuPanel.setBackground(Color.YELLOW);

        JLabel menuPrincipale = new JLabel("Menu");
            menuPrincipale.setFont(new Font("Arial", Font.BOLD, 22));
            menuPrincipale.setBorder(new EmptyBorder(10, 10, 10, 10)); // top, left, bottom, right margin
            menuPanel.add(menuPrincipale);
        
        // icona
        ImageIcon icon = new ImageIcon("img/logoMagieDiVenere.png");
        JLabel immagine = new JLabel(icon);
        
        //Aggiunta di bottoni al menù
        JButton btnCliente = new JButton("Cliente");
            btnCliente.setPreferredSize(new Dimension(100,25));		
            btnCliente.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	// cardLayout.show(contenitoreBottoni, "clientePanel");
                	cardLayout.show(contenitoreBottoni, "clientePanel");
                }
            });
        JButton btnServizi = new JButton("Servizi");
            btnServizi.setPreferredSize(new Dimension(100,25));
            btnServizi.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	cardLayout.show(contenitoreBottoni, "serviziPanel");
                }
            });
        JButton btnProdotti = new JButton("Prodotti");
            btnProdotti.setPreferredSize(new Dimension(100,25));
            btnProdotti.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	cardLayout.show(contenitoreBottoni, "prodottiPanel");
                }
            });
        JButton btnMacchinari = new JButton("Macchinari");
            btnMacchinari.setPreferredSize(new Dimension(100, 25));
            btnMacchinari.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	cardLayout.show(contenitoreBottoni, "macchinariPanel");
                }
            });
        JButton btnStanze = new JButton("Stanze");
            btnStanze.setPreferredSize(new Dimension(100, 25));
            btnStanze.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	cardLayout.show(contenitoreBottoni, "stanzePanel");
                }
            });
        JButton btnDipendenti = new JButton("Dipendenti");
            btnDipendenti.setPreferredSize(new Dimension(100,25));
            btnDipendenti.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	cardLayout.show(contenitoreBottoni, "dipendentiPanel");
                }
            });
        
        //aggiunta al pannello
        menuPanel.add(immagine);
        menuPanel.add(btnCliente);
        menuPanel.add(btnServizi);
        menuPanel.add(btnProdotti);
        menuPanel.add(btnMacchinari);
        menuPanel.add(btnStanze);
        menuPanel.add(btnDipendenti);
	
	//Panenllo del Contenuto
	JPanel contentPanel = new JPanel(new BorderLayout());
	contentPanel.setBackground(Color.LIGHT_GRAY);
	
	
        //Pannello Nord
	    JPanel nord = new JPanel(new BorderLayout());

            JLabel titolo = new JLabel("Benvenuti nel Gestionale per Centro Estetico!");
                titolo.setFont(new Font("Arial", Font.BOLD, 36 ));
                titolo.setBorder(new EmptyBorder(25, 25,0, 0)); // top, left, bottom, right

            sottotitolo = new JLabel("Sei nalla sezione Test, seleziona una delle opzioni qui sotto per iniziare.");
            // il nome della sezione cambierá in base al bottone premuto
                sottotitolo.setFont(new Font("Arial", Font.PLAIN, 20));
                sottotitolo.setBorder(new EmptyBorder(14, 25, 20, 0)); // top, left, bottom, right

        nord.add(titolo, BorderLayout.NORTH);
        nord.add(sottotitolo, BorderLayout.CENTER);

    contentPanel.add(nord,BorderLayout.NORTH);


	        
        // bottoni cliente
   
            
//         JButton btnAggiungiCliente = new JButton("Aggiungi Cliente");
// 	        btnAggiungiCliente.setPreferredSize(new Dimension(150,30));
// 	        btnAggiungiCliente.addActionListener(new ActionListener() {
// 	            public void actionPerformed(ActionEvent e) {
// 	                aggiungiCliente();
// 	            }
// 	        });
//         JButton btnModificaCliente = new JButton("Modifica Cliente");
// 	        btnModificaCliente.setPreferredSize(new Dimension(150,30));
// 	        btnModificaCliente.addActionListener(new ActionListener() {
// 	            public void actionPerformed(ActionEvent e) {
// 	                modificaCliente();
// 	            }
// 	        });
//         JButton btnEliminaCliente = new JButton("Elimina Cliente");
// 	        btnEliminaCliente.setPreferredSize(new Dimension(150,30));
// 	        btnEliminaCliente.addActionListener(new ActionListener() {
// 	            public void actionPerformed(ActionEvent e) {
// 	                eliminaCliente();
// 	            }
// 	        });
//         JButton btnVisualizzaCliente = new JButton("Visualizza Clienti");
// 	        btnVisualizzaCliente.setPreferredSize(new Dimension(150,30));
// 	        btnVisualizzaCliente.addActionListener(new ActionListener() {
// 	            public void actionPerformed(ActionEvent e) {
// 	                visualizzaCliente();
// //	                Cliente.visualizzaTuttiClienti();

// 	            }
// 	        });
	        
        
        // bottoni servizi
        JButton btnAggiungiServizi = new JButton("Aggiungi Servizio");
	        btnAggiungiServizi.setPreferredSize(new Dimension(150,30));
	        btnAggiungiServizi.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                aggiungiServizi();
	            }
	        });
        JButton btnModificaServizi= new JButton("Modifica Servizio");
	        btnModificaServizi.setPreferredSize(new Dimension(150,30));
	        btnModificaServizi.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                modificaServizi();
	            }
	        });
        JButton btnEliminaServizi = new JButton("Elimina Servizio");
	        btnEliminaServizi.setPreferredSize(new Dimension(150,30));
	        btnEliminaServizi.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                eliminaServizi();
	            }
	        });
        JButton btnVisualizzaServizi = new JButton("Visualizza Servizi");
	        btnVisualizzaServizi.setPreferredSize(new Dimension(150,30));
	        btnVisualizzaServizi.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                visualizzaServizi();
	            }
	        });
        
        // bottoni prodotti
        
        JButton btnAggiungiProdotti = new JButton("Aggiungi Prodotto");
	        btnAggiungiProdotti.setPreferredSize(new Dimension(150,30));
	        btnAggiungiProdotti.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                aggiungiProdotti();
	            }
	        });
        JButton btnModificaProdotti= new JButton("Modifica Prodotto");
	        btnModificaProdotti.setPreferredSize(new Dimension(150,30));
	        btnModificaProdotti.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                modificaProdotti();
	            }
	        });
        JButton btnEliminaProdotti = new JButton("Elimina Prodotto");
	        btnEliminaProdotti.setPreferredSize(new Dimension(150,30));
	        btnEliminaProdotti.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                eliminaProdotti();
	            }
	        });
        JButton btnVisualizzaProdotti = new JButton("Visualizza Prodotti");
	        btnVisualizzaProdotti.setPreferredSize(new Dimension(150,30));
	        btnVisualizzaProdotti.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                visualizzaProdotti();
	            }
	        });
        
        // bottoni macchinari
        
        JButton btnAggiungiMacchinari = new JButton("Aggiungi Macchinario");
	        btnAggiungiMacchinari.setPreferredSize(new Dimension(200,30));
	        btnAggiungiMacchinari.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                aggiungiMacchinari();
	            }
	        });
        JButton btnModificaMacchinari= new JButton("Modifica Macchinario");
	        btnModificaMacchinari.setPreferredSize(new Dimension(200,30));
	        btnModificaMacchinari.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                modificaMacchinari();
	            }
	        });
        JButton btnEliminaMacchinari = new JButton("Elimina Macchinario");
	        btnEliminaMacchinari.setPreferredSize(new Dimension(200,30));
	        btnEliminaMacchinari.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                eliminaMacchinari();
	            }
	        });
        JButton btnVisualizzaMacchinari = new JButton("Visualizza Macchinari");
	        btnVisualizzaMacchinari.setPreferredSize(new Dimension(200,30));
	        btnVisualizzaMacchinari.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                visualizzaMacchinari();
//	                Macchinario.visualizzaTuttiMacchinari();
	            }
	        });
        
        // bottoni stanze
        
        JButton btnAggiungiStanze = new JButton("Aggiungi Stanza");
	        btnAggiungiStanze.setPreferredSize(new Dimension(150,30));
	        btnAggiungiStanze.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                aggiungiStanze();
	            }
	        });
        JButton btnModificaStanze= new JButton("Modifica Stanza");
	        btnModificaStanze.setPreferredSize(new Dimension(150,30));
	        btnModificaStanze.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                modificaStanze();
	            }
	        });
        JButton btnEliminaStanze = new JButton("Elimina Stanza");
	        btnEliminaStanze.setPreferredSize(new Dimension(150,30));
	        btnEliminaStanze.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                eliminaStanze();
	            }
	        });
        JButton btnVisualizzaStanze = new JButton("Visualizza Stanze");
	        btnVisualizzaStanze.setPreferredSize(new Dimension(150,30));
	        btnVisualizzaStanze.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                visualizzaStanze();
	            }
	        });
        
        // bottoni dipendenti
        
        JButton btnAggiungiDipendenti = new JButton("Aggiungi Dipendente");
        btnAggiungiDipendenti.setPreferredSize(new Dimension(200,30));
        btnVisualizzaStanze.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aggiungiDipendenti();
            }
        });
        JButton btnModificaDipendenti= new JButton("Modifica Dipendente");
        btnModificaDipendenti.setPreferredSize(new Dimension(200,30));
        btnModificaDipendenti.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificaDipendenti();
            }
        });
        JButton btnEliminaDipendenti = new JButton("Elimina Dipendente");
        btnEliminaDipendenti.setPreferredSize(new Dimension(200,30));
        btnEliminaDipendenti.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminaDipendenti();
            }
        });
        JButton btnVisualizzaDipendenti = new JButton("Visualizza Dipendenti");
        btnVisualizzaDipendenti.setPreferredSize(new Dimension(200,30));
        btnVisualizzaDipendenti.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                visualizzaDipendenti();
            }
        });
        
        // crudPanelCliente
        
	    // JPanel crudPanelCliente = new JPanel(new FlowLayout(FlowLayout.CENTER, 60,10));
	    // crudPanelCliente.setPreferredSize(new Dimension(1110,50));
	    // crudPanelCliente.add(btnAggiungiCliente);
	    // crudPanelCliente.add(btnModificaCliente);
	    // crudPanelCliente.add(btnEliminaCliente);
	    // crudPanelCliente.add(btnVisualizzaCliente);
	    
	    // crudPanelServizi
	    
	    JPanel crudPanelServizi = new JPanel(new FlowLayout(FlowLayout.CENTER, 60,10));
	    crudPanelServizi.setPreferredSize(new Dimension(1110,50));
	    crudPanelServizi.add(btnAggiungiServizi);
	    crudPanelServizi.add(btnModificaServizi);
	    crudPanelServizi.add(btnEliminaServizi);
	    crudPanelServizi.add(btnVisualizzaServizi);
	    
	    // crudPanelProdotti
	    
	    JPanel crudPanelProdotti = new JPanel(new FlowLayout(FlowLayout.CENTER, 60,10));
	    crudPanelProdotti.setPreferredSize(new Dimension(1110,50));
	    crudPanelProdotti.add(btnAggiungiProdotti);
	    crudPanelProdotti.add(btnModificaProdotti);
	    crudPanelProdotti.add(btnEliminaProdotti);
	    crudPanelProdotti.add(btnVisualizzaProdotti);
	    
	    // crudPanelMacchinari
	    
	    JPanel crudPanelMacchinari = new JPanel(new FlowLayout(FlowLayout.CENTER, 60,10));
	    crudPanelMacchinari.setPreferredSize(new Dimension(1110,50));
	    crudPanelMacchinari.add(btnAggiungiMacchinari);
	    crudPanelMacchinari.add(btnModificaMacchinari);
	    crudPanelMacchinari.add(btnEliminaMacchinari);
	    crudPanelMacchinari.add(btnVisualizzaMacchinari);
	    
	    // crudPanelStanze
	    
	    JPanel crudPanelStanze = new JPanel(new FlowLayout(FlowLayout.CENTER, 60,10));
	    crudPanelStanze.setPreferredSize(new Dimension(1110,50));
	    crudPanelStanze.add(btnAggiungiStanze);
	    crudPanelStanze.add(btnModificaStanze);
	    crudPanelStanze.add(btnEliminaStanze);
	    crudPanelStanze.add(btnVisualizzaStanze);
	    
	    // crudPanelDipendenti
	    
	    JPanel crudPanelDipendenti = new JPanel(new FlowLayout(FlowLayout.CENTER, 60,10));
	    crudPanelDipendenti.setPreferredSize(new Dimension(1110,50));
	    crudPanelDipendenti.add(btnAggiungiDipendenti);
	    crudPanelDipendenti.add(btnModificaDipendenti);
	    crudPanelDipendenti.add(btnEliminaDipendenti);
	    crudPanelDipendenti.add(btnVisualizzaDipendenti);


	

	
	
	//Pannello per grafici

        chartPanel.setPreferredSize(new Dimension(650, 560));
        chartPanel.setBackground(Color.GREEN);


        JLabel chartLabel = new JLabel("Grafici");
        chartPanel.add(chartLabel);
        
        clientePanel.setPreferredSize(new Dimension(650, 560));
        clientePanel.setBackground(Color.RED);
        // clientePanel.add(crudPanelCliente);
        
        clientePanelCenter.setVisible(false);
        clientePanel.add(clientePanelCenter);
        clientePanelSouth.setVisible(false);
        clientePanelSouth.add(clientePanelGriglia);
        
        
        // Bottone aggiungi cliente
        
        //inizializzazione dei componenti per l'input dei dati
        // txtNomeCliente = new JTextField(45);
        // txtCognomeCliente = new JTextField(45);
        // txtTelefonoCliente = new JTextField(45);
        // txtEmailCliente = new JTextField(45);
        // txtCodiceFiscaleCliente = new JTextField(45);
        // txtPreferenzeCliente = new JTextArea(2,45);

        // JButton btnInserisciCliente = new JButton("Inserisci");
        // btnInserisciCliente.setPreferredSize(new Dimension(100,30));
        // btnInserisciCliente.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         inserisciCliente();
        //     }
        // });

        // aggiungiClientiPanelGrid.add(new JLabel("Nome:      " , JLabel.RIGHT));
        // aggiungiClientiPanelGrid.add(txtNomeCliente);
        // aggiungiClientiPanelGrid.add(new JLabel("Cognome:     " , JLabel.RIGHT));
        // aggiungiClientiPanelGrid.add(txtCognomeCliente);
        // aggiungiClientiPanelGrid.add(new JLabel("Telefono:     ", JLabel.RIGHT));
        // aggiungiClientiPanelGrid.add(txtTelefonoCliente);
        // aggiungiClientiPanelGrid.add(new JLabel("Email:     ", JLabel.RIGHT));
        // aggiungiClientiPanelGrid.add(txtEmailCliente);
        // aggiungiClientiPanelGrid.add(new JLabel("Codice Fiscale:     ", JLabel.RIGHT));
        // aggiungiClientiPanelGrid.add(txtCodiceFiscaleCliente);
        // aggiungiClientiPanelGrid.add(new JLabel("Preferenze:     ", JLabel.RIGHT));
        // JScrollPane txtPreferenzeClientiscrollPane = new JScrollPane(txtPreferenzeCliente);
        // aggiungiClientiPanelGrid.add(txtPreferenzeClientiscrollPane);
        // // aggiungiClientiPanelGrid.add(btnInserisciCliente);


    
        // // aggiungiClientiPanel.setPreferredSize(new Dimension(1100, 450)); 
        // aggiungiClientiPanelGrid.setBorder(new EmptyBorder(20, 0, 0, 500)); // top, left, bottom, right margin

        // aggiungiClientiPanel.add(new JLabel("Compila tutti i dati e premi il tasto 'Inserisci' per inserire il nuovo cliente"));
        // aggiungiClientiPanel.add(aggiungiClientiPanelGrid);
        // aggiungiClientiPanel.add(btnInserisciCliente);

        // aggiungiClientiPanel.setVisible(false);
        // aggiungiClientiPanelGrid.setVisible(false);
        // modificaClientiPanel.setVisible(false);
        // eliminaClientiPanel.setVisible(false);
        // visualizzaClientiPanel.setVisible(false);

		
        // clientePanelSouth.add(aggiungiClientiPanelGrid);
        // clientePanelSouth.add(modificaClientiPanel);
        // clientePanelSouth.add(eliminaClientiPanel);
        // clientePanelSouth.add(visualizzaClientiPanel);

        // clientePanel.add(clientePanelSouth);

        
        
        // ALTRI
        
        //panel south con gliglia dentro
        
        // VISUALIZZA
        // panel center per la ricerca
        // panel south con dentro la tabella

        
        serviziPanel.setPreferredSize(new Dimension(650, 560));
        serviziPanel.setBackground(Color.GREEN);
        serviziPanel.add(crudPanelServizi);

        
        prodottiPanel.setPreferredSize(new Dimension(650, 560));
        prodottiPanel.setBackground(Color.GREEN);
        prodottiPanel.add(crudPanelProdotti);


        macchinariPanel.setPreferredSize(new Dimension(650, 560));
        macchinariPanel.setBackground(Color.GREEN);
        macchinariPanel.add(crudPanelMacchinari);

        
        stanzePanel.setPreferredSize(new Dimension(650, 560));
        stanzePanel.setBackground(Color.GREEN);
        stanzePanel.add(crudPanelStanze);

        
        dipendentiPanel.setPreferredSize(new Dimension(650, 560));
        dipendentiPanel.setBackground(Color.GREEN);
        dipendentiPanel.add(crudPanelDipendenti);

        
    contenitoreBottoni.add(chartPanel,"chartPanel");
    contenitoreBottoni.add(clientePanel, "clientePanel");
    contenitoreBottoni.add(serviziPanel, "serviziPanel");
    contenitoreBottoni.add(macchinariPanel, "macchinariPanel");
    contenitoreBottoni.add(prodottiPanel, "prodottiPanel");
    contenitoreBottoni.add(stanzePanel, "stanzePanel");
    contenitoreBottoni.add(dipendentiPanel, "dipendentiPanel");


    contentPanel.add(contenitoreBottoni, BorderLayout.SOUTH);
    




	
	//aggiunta dei pannelli menuPanel e contentPanel al mainPanel
	mainPanel.add(menuPanel, BorderLayout.WEST);
	mainPanel.add(contentPanel, BorderLayout.CENTER);

    cardLayout.show(contenitoreBottoni, "chartPanel");
	add(mainPanel);

	
}


//private void showMenuCliente(){
//    //cambio del titolo
//    sottotitolo.setText("Sei nalla sezione Clienti, seleziona una delle opzioni qui sotto per iniziare.");
//
//}

// private void aggiungiCliente() {
	
//     clientePanelCenter.setVisible(false);
//     aggiungiClientiPanel.setVisible(true);
//     aggiungiClientiPanelGrid.setVisible(true);
//     modificaClientiPanel.setVisible(false);
//     eliminaClientiPanel.setVisible(false);
//     visualizzaClientiPanel.setVisible(false);

//     clientePanelSouth.setVisible(true);
// 	clientePanelSouth.setPreferredSize(new Dimension(1100, 450)); // cambia dimensioni
	
// }

// private void inserisciCliente(){
// }

// private void modificaCliente() {
	
//     clientePanelCenter.setVisible(false);
//     aggiungiClientiPanelGrid.setVisible(false);
//     modificaClientiPanel.setVisible(true);
//     eliminaClientiPanel.setVisible(false);
//     visualizzaClientiPanel.setVisible(false);

//     clientePanelSouth.setVisible(true);
// 	clientePanelSouth.setPreferredSize(new Dimension(650, 300)); // cambia dimensioni
	
// }

// private void eliminaCliente() {
	
//     clientePanelCenter.setVisible(false);
//     aggiungiClientiPanelGrid.setVisible(false);
//     modificaClientiPanel.setVisible(false);
//     eliminaClientiPanel.setVisible(true);
//     visualizzaClientiPanel.setVisible(false);

//     clientePanelSouth.setVisible(true);
// 	clientePanelSouth.setPreferredSize(new Dimension(650, 300)); // cambia dimensioni
	
// }

// private void visualizzaCliente() {
	
//     clientePanelCenter.setVisible(false);
//     aggiungiClientiPanelGrid.setVisible(false);
//     modificaClientiPanel.setVisible(false);
//     eliminaClientiPanel.setVisible(true);
//     visualizzaClientiPanel.setVisible(false);

//     clientePanelSouth.setVisible(true);
// 	clientePanelSouth.setPreferredSize(new Dimension(650, 300)); // cambia dimensioni
	
// }

private void aggiungiServizi() {
	
}

private void modificaServizi() {
	
}

private void eliminaServizi() {
	
}

private void visualizzaServizi() {
	
}

private void aggiungiProdotti() {
	
}

private void modificaProdotti() {
	
}

private void eliminaProdotti() {
	
}

private void visualizzaProdotti() {
	
}


private void aggiungiMacchinari() {
	
}

private void modificaMacchinari() {
}

private void eliminaMacchinari() {
	
}

private void visualizzaMacchinari() {
    String risultato = macchinari.visualizzaTuttiMacchinari();
    if (!risultato.equals("")) {
    String[] strMacchinari = risultato.split(";");
    for (int i = 0; i < strMacchinari.length; i++) {
        System.out.println(strMacchinari[i]);
    }
    } else {

        JOptionPane.showMessageDialog(null, "Nessun record trovato", "ERRORE",JOptionPane.ERROR_MESSAGE);
    }
}

// CODICE MANDATO ORIGINALE

//btnVisualizzaMacchinari.addActionListener(new ActionListener() {
//    Macchinario macchinari = new Macchinario();
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        String risultato = macchinari.visualizzaTuttiMacchinari();
//        if (!risultato.equals("")) {
//        String[] strMacchinari = risultato.split(";");
//        for (int i = 0; i < strMacchinari.length; i++) {
//            System.out.println(strMacchinari[i]);
//        }
//        } else {
//
//            JOptionPane.showMessageDialog(null, "Nessun record trovato", "ERRORE",JOptionPane.ERROR_MESSAGE);
//        }
//
//    }
//});

private void aggiungiStanze() {
	
}

private void modificaStanze() {
	
}

private void eliminaStanze() {
	
}

private void visualizzaStanze() {
	
}

private void aggiungiDipendenti() {
	
}

private void modificaDipendenti() {
	
}

private void eliminaDipendenti() {
	
}

private void visualizzaDipendenti() {
	
}


public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			new CentroEstetico().setVisible(true);
		}
	});	

}

}

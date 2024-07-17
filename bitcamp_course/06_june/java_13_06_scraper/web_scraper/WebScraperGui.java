package java_13_06_scraper_html.web_scraper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.InputStreamReader; //gestisce il flusso dei dati, prende i dati e gli trasforma in bit. nel mentre fa diversi controlli.
import java.io.BufferedReader; // prende i bit e gli trasforma in byte, cosí il tuo processore ci puó lavorare.
import java.net.URL;

// The URL class provides methods for working with Uniform Resource Locators, which are pointers to resources on the World Wide Web. 
// It can be used to create an object that represents a URL address. This object can then be used to open a connection to the resource, read from it, or write to it.


public class WebScraperGui extends JFrame{

	private JTextField campoURL;
	private JTextField campoParolaChiave;
	private JTextArea areaRisultato;
	
	public WebScraperGui(){
		
		setTitle("Web Scraper");
		setSize(800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		// pannello per inserimento dei dati
		
		JPanel pannelloInput = new JPanel(new FlowLayout());
		JLabel etichettaURL = new JLabel("URL: ");
		campoURL = new JTextField(30);
		
		// impostiamo un testo predefinito all'interno del field
		campoURL.setText("https://");
		JLabel etichettaParolaChiave = new JLabel("Parole Chiave: ");
		campoParolaChiave = new JTextField(20);
		
		// bottone per effettuare la ricerca 
		JButton bottoneCerca = new JButton("Cerca");
		bottoneCerca.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cerca();
			}
		});
		
		pannelloInput.add(etichettaURL);
		pannelloInput.add(campoURL);
		pannelloInput.add(etichettaParolaChiave);
		pannelloInput.add(campoParolaChiave);
		pannelloInput.add(bottoneCerca);

		areaRisultato = new JTextArea();
		areaRisultato.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(areaRisultato);
		
		add(pannelloInput, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);

		
	}
	
	private void cerca(){
		
		String url = campoURL.getText();
		String parolaChiave = campoParolaChiave.getText();
		
		// controllo presenza dati
		if(url.isEmpty() || parolaChiave.isEmpty()) {
	
			JOptionPane.showMessageDialog(this, "Inserisci un URL e la parola chiave");
			return;
		}
		
		try {
			// inserire metodo per effettuare la ricerca
			List<String> corrispondenza = eseguiScraping(url, parolaChiave);
			
			// inserire metodo per visualizzare il risultato della ricerca
			visualizzaRisultato(corrispondenza);
			
		} catch(IOException e) {
			JOptionPane.showMessageDialog(this, "Errore: " + e.getMessage());
		}
		
		
	}
	
    private List<String> eseguiScraping(String url, String parolaChiave) throws IOException {
        List<String> corrispondenze = new ArrayList<>();
        URL paginaWeb = new URL(url);
        BufferedReader lettore = new BufferedReader(new InputStreamReader(paginaWeb.openStream()));
        // java utilizza una codifica personalizzato per leggere i byte, perció i bit devono essere convertiti in byte, cosiché java puó lavorarci.
		// i dati vengono presi in bit, convertiti in byte, lavorati, convertiti in but e mandati in bit
		

        String riga;
        while((riga = lettore.readLine())!= null) {  // se riga ha un valore il ciclo continua  | si legge ogni riga della pagina web e la  assegna a riga
            if(riga.contains(parolaChiave)) {
                corrispondenze.add(riga);
            }
        }

        lettore.close();
        return corrispondenze;
    };
	
    private void visualizzaRisultato(List<String> corrispondenze) {
        areaRisultato.setText("");
        if(corrispondenze.isEmpty()) {
            areaRisultato.append("Nessuno Corrispondenza Trovata.");
        } else {
            for(String corrispondenza : corrispondenze) {
                areaRisultato.append(corrispondenza + "\n");
            }
        }
    }
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new WebScraperGui().setVisible(true);
		});
	}
	
	
	
}
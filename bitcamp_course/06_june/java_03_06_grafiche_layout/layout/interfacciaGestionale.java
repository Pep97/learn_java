package layout;

import javax.swing.*;
import java.awt.*;

public class interfacciaGestionale extends JFrame{ // la classe eredita tutti gli attributi e metodi di Jframe
	
	// estendere una libreria su una classe
	// vengono passati attributi e metodi ereditati
	
	// classe istanziata vs classe ereditata -> do research difference

	// ------------------------------------------------------
	
	// Costruttore della classe
	
    public interfacciaGestionale() {
        setTitle("Gestionale di Test");
        setSize(800, 600); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
        
        // Pannello principale
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Pannello menu
        JPanel menuPanel = new JPanel();
        
        // Impostazione delle dimensioni del menuPanel
        menuPanel.setPreferredSize(new Dimension(150, 600));
        menuPanel.setBackground(Color.YELLOW);
        
        // Aggiunta di bottoni al menu
        JButton clientiButton = new JButton ("Clienti");
        JButton prodottiButton = new JButton ("Prodotti");
        JButton venditeButton = new JButton ("Vendite");
        menuPanel.add(prodottiButton);
        menuPanel.add(venditeButton);
        menuPanel.add(clientiButton);
                
        // Pannello del contenuto
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.LIGHT_GRAY);
        
        // Aggiunte di componenti al content panel
        JLabel titolo = new JLabel("Benvenuti nel gestionale!");
        titolo.setFont(new Font("Arial", Font.BOLD, 36));
        contentPanel.add(titolo, BorderLayout.NORTH);
        
        JTextArea placeholderArea = new JTextArea(20, 80);
        placeholderArea.setEditable(false);  // il contenuto di questa textarea non puó essere modificato
        // se fosse stato "true" sarebee stato modificabile
        placeholderArea.setText("Questo é un esempio di come potrebbe apparire il contenuto dell'applicazione");
        contentPanel.add(placeholderArea, BorderLayout.CENTER);
        
        // Pannello per grafici
        JPanel chartPanel = new JPanel();
        chartPanel.setPreferredSize(new Dimension(650, 200));
        chartPanel.setBackground(Color.WHITE);
        JLabel chartLabel = new JLabel("Grafici");
        chartPanel.add(chartLabel);
        
        // Aggiunta di chartPanel a contentPanel
        contentPanel.add(chartLabel, BorderLayout.SOUTH);
        
        // Aggiunta dei pannelli menuPanel e contentPanel al mainPanel
        mainPanel.add(menuPanel, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
        add(mainPanel);

        
        
    }
	
    
    public static void main(String[] args) {
    	
    	SwingUtilities.invokeLater(new Runnable() {
    		public void run() {
    			new interfacciaGestionale().setVisible(true);
    		}
    	});
    	
    }
	


}

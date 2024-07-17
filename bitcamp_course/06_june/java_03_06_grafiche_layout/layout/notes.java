package layout;


import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;


public class notes extends JFrame{
	
	
    public notes() {
        setTitle("Gestionale di Test");
        setSize(1000, 800); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
        
//      Pannello principale
      
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        
        
        // -------------------------------------------
        
        
		// Creazione della barra dei menu
		JMenuBar menuBar = new JMenuBar();
		
		// Creazione oggetto menu
		JMenu fileMenu = new JMenu("File");
		JMenu modificaMenu = new JMenu ("Modifica");
		JMenu formatoMenu = new JMenu ("Formato");
		JMenu visualizzaMenu = new JMenu ("Visualizza");


		
		// Creazione elementi del menu file
		JMenuItem newItem = new JMenuItem("Nuovo");
		JMenuItem openItem = new JMenuItem("Apri");
		JMenuItem exitItem = new JMenuItem("Esci");
		
		// Creazione elementi del menu Modifica
		JMenuItem copyItem = new JMenuItem("Copia");
		JMenuItem pasteItem = new JMenuItem("Incolla");
		
		// Creazione elementi del menu Formato
		JMenuItem pdfItem = new JMenuItem("Scarica PDF");
		JMenuItem jpegItem = new JMenuItem("Scarica Jpeg");
		
		// Creazione elementi del menu Visualizza
		JMenuItem zoominItem = new JMenuItem("Zoom in");
		JMenuItem zoomoutItem = new JMenuItem("Zoom out");

		
		// Aggiunta delle voci del menu
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.addSeparator(); // Aggiunge una linea tra i menu
		fileMenu.add(exitItem);
		
		modificaMenu.add(copyItem);
		modificaMenu.add(pasteItem);

		formatoMenu.add(pdfItem);
		formatoMenu.add(jpegItem);

		visualizzaMenu.add(zoominItem);
		visualizzaMenu.add(zoomoutItem);

		
		// Aggiunta dei JMenu al contenitore Bar
		menuBar.add(fileMenu);
		menuBar.add(modificaMenu);
		menuBar.add(formatoMenu);
		menuBar.add(visualizzaMenu);

		
		// Aggiunta del menuBar al frame
		setJMenuBar(menuBar);  
		
		
		// ---------------------------------------

		// TEST
        // Creazione bodyPanel
//		JPanel bodyPanel = new JPanel();
//		
//		// Crazione scrollbar
//		JScrollPane scrollPane = new JScrollPane(bodyPanel);
//		
//		// Creazione textarea
//		JTextField textField = new JTextField();
//		textField.setPreferredSize(new Dimension(970, 680));
//		bodyPanel.add(textField);
//		
//        mainPanel.add(scrollPane);
		

//		// Creazione bodyPanel		
		JPanel bodyPanel = new JPanel(new BorderLayout());
		JTextArea textArea = new JTextArea();
		textArea.setEditable(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		bodyPanel.add(scrollPane, BorderLayout.CENTER);
		mainPanel.add(bodyPanel);

        // --------------------------------------

		// TEST
        
        // JPanel linea = new JPanel();
		// JPanel containerLinea = new JPanel();
		// containerLinea.setSize(850, 95);

		// JLabel colonna1 = new JLabel("Ln 13, Col 1");
		// colonna1.setBorder(new LineBorder(Color.BLUE, 1));
		
		// JLabel colonna2 = new JLabel("200 caratteri");
		// colonna2.setBorder(new LineBorder(Color.BLUE, 1));
		
		// JLabel colonna3 = new JLabel("100%");
		// colonna3.setBorder(new LineBorder(Color.BLUE, 1));
		
		// JLabel colonna4 = new JLabel("Unix(LF)");
		// colonna4.setBorder(new LineBorder(Color.BLUE, 1));
		
		// JLabel colonna5 = new JLabel("UTF-8");
		// colonna5.setBorder(new LineBorder(Color.BLUE, 1));

		// JSeparator separator = new JSeparator();

		// linea.add(separator);
        // linea.add(colonna1);
		// linea.add(separator);
        // linea.add(colonna2);
		// linea.add(separator);
        // linea.add(colonna3);
		// linea.add(separator);
        // linea.add(colonna4);
		// linea.add(separator);
        // linea.add(colonna5);

		// containerLinea.setLayout(new FlowLayout(FlowLayout.RIGHT));
        // containerLinea.add(linea, BorderLayout.SOUTH);
		// mainPanel.add(containerLinea, BorderLayout.SOUTH);

        
        JPanel linea = new JPanel();
        linea.setLayout(new GridLayout(1,5));
        JLabel colonna1 = new JLabel("Ln 13, Col 1");
        JLabel colonna2 = new JLabel("200 caratteri");
        JLabel colonna3 = new JLabel("100%");
        JLabel colonna4 = new JLabel("Unix(LF)");
        JLabel colonna5 = new JLabel("UTF-8");
		
		linea.add(colonna1);
		linea.add(new JSeparator(JSeparator.VERTICAL));
		linea.add(colonna2);
		linea.add(new JSeparator(JSeparator.VERTICAL));
		linea.add(colonna3);
		linea.add(new JSeparator(JSeparator.VERTICAL));
		linea.add(colonna4);
		linea.add(new JSeparator(JSeparator.VERTICAL));
		linea.add(colonna5);

        mainPanel.add(linea, BorderLayout.SOUTH);
        
        // -------------------------------------
        
		add(mainPanel);
		
		
        
    }
	
	


	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new notes().setVisible(true);
			}
		});

	}
    	
}


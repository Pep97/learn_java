package java_22_05.supermercato;

import java.util.Scanner;

public class Supermarket {
	
	public static boolean isNumeric(String str) {
	    try {
	        Double.parseDouble(str);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Supermercato supermercato = new Supermercato();	
		double prezzo = 0;
		String input;

		// creazione di alcuni prodotti

		supermercato.aggiungiProdotto(new Prodotto("Latte","Alimentari",2.5));
        supermercato.aggiungiProdotto(new Prodotto("Shampoo Rinfrescante","Igiene",2.5));
        supermercato.aggiungiProdotto(new Prodotto("Biscotti Mulino Bianco","Alimentari",4.0));
        supermercato.aggiungiProdotto(new Prodotto("Energy Drink","Bevande",3.5));
		
		// creazione di alcune offerte

		Prodotto prodotto = supermercato.getProdotti().get(0);
		supermercato.aggiungiOfferta(new Offerta( prodotto,5,"23-05-2024","25-05-2024"));

		prodotto = supermercato.getProdotti().get(1);
        supermercato.aggiungiOfferta(new Offerta(prodotto ,10,"23-05-2024","25-05-2024"));

		prodotto = supermercato.getProdotti().get(2);
        supermercato.aggiungiOfferta(new Offerta(prodotto,20,"23-05-2024","25-05-2024"));

		prodotto = supermercato.getProdotti().get(3);
        supermercato.aggiungiOfferta(new Offerta(prodotto,5,"23-05-2024","25-05-2024"));
		
		//messaggio di benvenuto
		
		System.out.println("Buongiorno e Benvenuti nel nostro Supermarket");
		System.out.println();
		
		
		while (true) {
		//menù di scelta iniziale
		System.out.println("\nCosa desideri fare?");
		System.out.println("[1] -> Esplora il nostro menù con tutti i prodotti:");
		System.out.println("[2] -> Aggiungi prodotti:");
		System.out.println("[3] -> Offerte:");
		System.out.println("[4] -> Esci.");
		
		//input di scelta per l'utente
		int scelta = scanner.nextInt();
		scanner.nextLine();
		
		switch (scelta) {
		case 1:			
			//descrizione del menù supermercato
			System.out.println("");
			System.out.println("Prodotti:");
			supermercato.visualizzaProdotti();
			
			break;
		case 2:
			
			
			

			System.out.println("\n");
			System.out.println("Aggiungi un nuovo Prodotto.");
			
				
					System.out.println("Inserisci il nome del nuovo prodotto:");
					String nome = scanner.nextLine();

					System.out.println("Inserisci la categoria del prodotto:");
					String categoria = scanner.nextLine();

					prezzo = 0;
					boolean inputCorretto = false;

					while (!inputCorretto) {
						System.out.println("Inserisci il prezzo:");
						input = scanner.nextLine();

						if (isNumeric(input)) {
							prezzo = Double.parseDouble(input);
							System.out.println("\n");
							inputCorretto = true;
						} else {
							System.out.println("Il valore inserito non è un numero valido. Riprova.");
							System.out.println("\n");
						}
					}

					supermercato.aggiungiProdotto(new Prodotto(nome, categoria, prezzo)); 				
					System.out.println("Prodotto aggiunto con successo!");
					System.out.println("\n");

					
				System.out.println("\nEcco la lista completa.");
				supermercato.visualizzaProdotti();
			break;
		case 3:
		
		int scegliOfferta;
		do {
			System.out.println("\nCosa vuoi scegliere?");
			System.out.println("[1] -> Esplora offerte correnti:");
			System.out.println("[2] -> Ricerca offerta per prodotto:");
			System.out.println("[3] -> Ricerca offerta per categoria:");
			System.out.println("[4] -> Aggiungi offerta:");
			System.out.println("[5] -> Modifica offerta:");
			System.out.println("[6] -> Rimuovi offerta:");
			System.out.println("[7] -> Esci.");

			scegliOfferta = scanner.nextInt();
			scanner.nextLine();

			switch (scegliOfferta) {
				case 1:
					// Offerte correnti
					System.out.println("\n");
					System.out.println("Ecco le nostre attuali offerte!");
					supermercato.mostraOfferte();
					break;
				case 2:
					// Ricerca offerte per prodotto
					System.out.println("\n");
					System.out.println("Inserisci il prodotto da Cercare:");

					input = scanner.nextLine();
					supermercato.ricercaNome(input);

					break;
				case 3:
					// Ricerca offerte per categoria
					System.out.println("\n");
					System.out.println("Inserisci la Categoria da Cercare:");
					input = scanner.nextLine();
					supermercato.ricercaCategoria(input);
					break;
				case 4:

					// Aggiungi offerta

					System.out.println("\n");
					System.out.println("Aggiungi una nuova offerta ad un prodotto esistente:");

					supermercato.visualizzaProdotti();

					System.out.println("\nInserisci il numero del prodotto al quale vuoi aggiungere una nuova offerta: ");
					int idProdotto = scanner.nextInt();
					// scanner.nextLine();
					
					prodotto = supermercato.getProdotti().get(idProdotto - 1);
					
					System.out.println("Inserisci lo sconto da applicare: ");
					double sconto = scanner.nextDouble();
					scanner.nextLine();
					
					System.out.println("Data di inizio dell' offerta: ");
					String dataInizio = scanner.nextLine();
					
					System.out.println("Data di fine dell' offerta: ");
					String dataFine = scanner.nextLine();
					
					Offerta offerta = new Offerta(prodotto, sconto, dataInizio, dataFine);
					supermercato.aggiungiOfferta(offerta);
					
					System.out.println("Offerta aggiunta con successo!");
					System.out.println("\n");
					supermercato.mostraOfferte();
					break;

					// caso 4 aggiungere -> la data e controlla che sia valida -> dopo 

				case 5:

					// Modifica offerta
					System.out.println("\n");
					System.out.println("Ecco le offerte attuali:");
					supermercato.mostraOfferte();
					System.out.println("Inserisci il numero del prodotto di cui vuoi modificare l'offerta");
					int idOfferta = scanner.nextInt();
					System.out.println("Inserisci il nuovo sconto");
					sconto = scanner.nextDouble();
					scanner.nextLine();
					System.out.println("Inserisci la nuova data di inizio");
					dataInizio = scanner.nextLine();
					System.out.println("Inserisci la nuova data di fine");
					dataFine = scanner.nextLine();
				
					supermercato.modificaOfferta(idOfferta -1, sconto, dataInizio, dataFine);

					System.out.println("Offerta aggiunta con successo!");
					supermercato.mostraOfferte();


					break;

				case 6:
					// Rimuovi offerta
					System.out.println("\n");

					System.out.println("Ecco le offerte attuali:");
					supermercato.mostraOfferte();

					System.out.println("\n");
					System.out.println("Inserisci il numero dell'offerta da rimuovere:");
					
					idOfferta = scanner.nextInt() - 1;
					supermercato.rimuoviOfferta(idOfferta);

					break;
				case 7:
					// Esci e torna al menù principale
					System.out.println("\n");
					System.out.println("Ritorno al menù principale...");
					break;
				default:
					System.out.println("\n");
					System.out.println("La scelta selezionata non è valida. Riprova.");
			}
		} while (scegliOfferta != 7);
			break;
		case 4:
			System.out.println("Grazie per averci scelto. Alla prossima!");
			System.exit(0);
			break;
		default:
			System.out.println("La scelta effettuata non è valida. Torna al menù principale e riprova!");
		
		   }
	    
		}

	}

    
}

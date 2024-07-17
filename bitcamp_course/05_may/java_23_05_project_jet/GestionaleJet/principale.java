package java_23_05.GestionaleJet;

import java.util.Collections;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class principale {

	public static void main(String[] args) throws ParseException {

		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // Declare and initialize sdf
		Gestionale gestionale = new Gestionale();
		int passeggeri;
		sdf.setLenient(false);

		//CREAZIONE OFFERTE
        gestionale.aggiungiOfferta(new Offerta("Platinum", 15.00));
        gestionale.aggiungiOfferta(new Offerta("Gold", 10.00));
        gestionale.aggiungiOfferta(new Offerta("Silver", 5.00));

		//CREAZIONE SERVIZI JET

		Servizi servizio_wifi_fi = new Servizi("Wi-Fi", 40.00);
		Servizi servizio_pasto_stellato = new Servizi("Pasto Stellato", 300.00);
		Servizi servizio_bar = new Servizi("Bar", 200.00);
		
		
		//CREAZIONE JET + AGGIUNTA SERVIZI

		List<Servizi> TuttiServizi = new ArrayList<>();
		TuttiServizi.add(servizio_wifi_fi);
		TuttiServizi.add(servizio_pasto_stellato);
		TuttiServizi.add(servizio_bar);

		List<Servizi> ServiziJet = new ArrayList<>();

		gestionale.aggiungiJet(new Jet("Boba Jett", 10000.00, 10, 3, ServiziJet));
		gestionale.aggiungiJet(new Jet("JetHro Tull", 25000.00, 22, 1, ServiziJet));
		gestionale.aggiungiJet(new Jet("JetTa The Hutt", 8000.00, 6, 5,  ServiziJet));
		gestionale.aggiungiJet(new Jet ("Darth Jetter", 4000.00, 3, 8, ServiziJet));
		Collections.sort(gestionale.jets, new JetComparator());
		
		//CREAZIONE CLIENTI
		gestionale.aggiungiCliente(new Cliente("Jhonny Bravo", "bravojhonny@tiscali.it"));
		gestionale.aggiungiCliente(new Cliente("Mario Rossi", "mariorossi22@gmail.com"));
		
		
		//credenziali		
		
		String username;
        String password;

        boolean loginValido = false;

        while(!loginValido) {
            System.out.print("Inserisci username (admin) >> ");
            username = scanner.nextLine();
            System.out.print("Inserisci Password (admin1234) >> ");
            password = scanner.nextLine();

            if(username.equals("admin") && password.equals("admin1234")) {
                loginValido = true;
                System.out.println("Login effettuato correttamente!");
            } else {
                System.out.println("Credenziali errate. Riprova.");
            }

        }

		System.out.println("Benvenuti nel Gestionale per Noleggio Jet di Lusso");


		while(true) {
			System.out.println("\nCosa desideri fare?");
			System.out.println("[1] -> Gestione Jet");
			System.out.println("[2] -> Gestione Noleggi");
			System.out.println("[3] -> Gestione Clienti");
			System.out.println("[4] -> Esci");
			System.out.print("Scegli >>");

			//input di scelta per l'utente
			int scelta = scanner.nextInt();
			scanner.nextLine();

			switch(scelta) {
			case 1:
				//Gestione Jet
				int sceltaJet;

				do {
					System.out.println("\nCosa vuoi fare?");
					System.out.println("[1] -> Visualizza i Jet:");
					System.out.println("[2] -> Inserisci un nuovo Jet:");
					System.out.println("[3] -> Rimuovi un Jet:");					
					System.out.println("[4] -> Esci.");
					System.out.print("Scegli >>");

					//
					sceltaJet = scanner.nextInt();
					scanner.nextLine();

					switch(sceltaJet) {
					case 1: 
						//Visualizza i Jet
						System.out.println("\n");
						System.out.println("Ecco i nostri Jet:");
						for (Jet jet : gestionale.jets) {
	                           System.out.println(jet);
	                         }						
						System.out.println();
						break;
					case 2:
						//Inserisci un nuovo Jet
						System.out.println("\n");
						System.out.print("Inserisci il nome del Jet da aggiungere >> ");
						String nome = scanner.nextLine();
						System.out.println();

						System.out.print("Inserisci il prezzo >> ");
						double prezzo = scanner.nextDouble();
						scanner.nextLine();
						System.out.println();

						System.out.print("Qual è il numero di passeggeri massimo trasportabile dal Jet? >> ");
						int posti = scanner.nextInt();
						System.out.println();

						System.out.print("Quanti di questi Jet vuoi aggiungere? >> ");
						int quantita = scanner.nextInt();
						System.out.println();

						ServiziJet = new ArrayList<>();

						//AGGIUNGERE I SERVIZI
						gestionale.aggiungiJet(new Jet(nome, prezzo, posti, quantita, ServiziJet));
						System.out.println("Jet aggiunto con successo!");
						System.out.println("\n");
						
						Collections.sort(gestionale.getJets(), new JetComparator());
						
						break;
					case 3: 
						//Rimuovi un Jet
						System.out.println("\n");
						System.out.println("Ecco la lista dei nostri Jet: ");
						gestionale.visualizzaJet();
						System.out.println();
						
						
						boolean index = false;
						while(!index) {
						System.out.print("Inserisci il numero del Jet da rimuovere >> ");
						int idJet = scanner.nextInt() - 1;
						if (idJet >= 0  && idJet < gestionale.jets.size()) {
							gestionale.rimuoviJet(idJet);
							System.out.println();
							index = true;
						} else {
							System.out.println();
							System.out.println("Il valore inserito non è valido, riprova!");
						}
						}
						break;
					case 4:
						//Esci
						System.out.println("\n");
						System.out.println("Ritorno al menù principale.");
						break;
					default:
						System.out.println("\n");
						System.out.println("La scelta selezionata non è valida. Riprova.");
						break;
					}
				}while(sceltaJet!=4);

				break;
			case 2:
				//Gestione Noleggi
				int sceltaNoleggio;
				do {
					//INSERIRE IN QUESTO MENU L'AGGIUNTA E VISUALIZZAZIONE DELLE OFFERTE??
					System.out.println("\nCosa vuoi fare?");
					System.out.println("[1] -> Inserisci Nuovo Noleggio:");
					System.out.println("[2] -> Rimuovi Noleggio:");
					System.out.println("[3] -> Visualizza Noleggi Correnti:");
					System.out.println("[4] -> Visualizza Storico Noleggi");
					System.out.println("[5] -> Esci.");
					System.out.print("Scegli >>");

					//
					sceltaNoleggio = scanner.nextInt();
					scanner.nextLine();

					switch(sceltaNoleggio) {
					case 1: 
					    // Inserisci un nuovo Noleggio
					    System.out.println("\n");
					    gestionale.visualizzaJet();
					    System.out.println("Ecco i nostri Jet!");
					    System.out.print("Inserisci il numero del Jet da noleggiare >> ");
					    int idJet = scanner.nextInt();
					    scanner.nextLine();
					    System.out.println();

					    Jet jet = gestionale.getJets().get(idJet - 1);
					    if (jet.getQuantita() == 0) {
					        System.out.println("Il jet selezionato non è al momento noleggiabile.");
					        break;
					    }

					    // DATI CLIENTE (NOME, EMAIL)
					    System.out.print("Inserisci il nome del Cliente >> ");
					    String nomeCliente = scanner.nextLine();
					    System.out.println();
					    
					    System.out.print("Inserisci l'email del Cliente >> ");
					    String emailCliente = scanner.nextLine();
					    System.out.println();
					    
					    Cliente cliente = new Cliente(nomeCliente, emailCliente);
					    gestionale.aggiungiCliente(cliente);
					    
					    boolean dataGiusta = false;
					    Date dataInizio = null;
					    Date dataFine = null;
						boolean	dataCorretta = false;

					    while (!dataGiusta) {

							dataCorretta = false;

							while (!dataCorretta) {
							
								System.out.print("Inserisci la data di inizio del noleggio (esempio: 2024/01/10) >> ");

								try{
									dataInizio = sdf.parse(scanner.nextLine());
									System.out.println(); 

									dataCorretta = true;
								}
								catch (ParseException e)
								{
									System.out.println("\nData non corretta, riprova. Assicurati di inserire la data nel formato corretto (esempio: 2024/01/10)");
									System.out.println(); 
								}
								
							}

							dataCorretta = false;

							while (!dataCorretta) {
							
								System.out.print("Inserisci la data di fine del noleggio (esempio: 2024/01/15) >> ");

								try{
									dataFine = sdf.parse(scanner.nextLine());
									dataCorretta = true;
									System.out.println(); 
								}
								catch (ParseException e)
								{
									System.out.println("\nData non corretta, riprova. Assicurati di inserire la data nel formato corretto (esempio: 2024/01/15)");
									System.out.println(); 

								}
								
							}      
					                        
					        if (dataFine.after(dataInizio)) {
					            dataGiusta = true;
					        } else {
					            System.out.println("La data di Fine Noleggio deve essere posteriore a quella di Inizio Noleggio, riprova.");
					        }
					    }
					    

					    List<Servizi> serviziNoleggio = new ArrayList<>();

					    String risposta = "";
					    do {
					        System.out.print("Vuoi inserire dei servizi aggiuntivi? (si/no) >> ");
					        risposta = scanner.nextLine();

					        if (risposta.equals("no")) {
					            continue;
					        }

					        System.out.println("\nEcco i nostri servizi aggiuntivi: ");
					        for (Servizi servizio : TuttiServizi) {
					            System.out.println("Servizio: " + servizio.getServizi() + " | Costo: " + servizio.getPrezzoServizi() + "€");
					        }

					        System.out.println();
					        System.out.print("Inserisci il nome del servizio da aggiungere >> ");
					        String servizioNome = scanner.nextLine();

					        for (Servizi servizio : TuttiServizi) {
					            if (servizioNome.equalsIgnoreCase(servizio.getServizi())) {
					                serviziNoleggio.add(servizio);
					                System.out.println("\nServizio aggiunto con successo!");                                    
					                System.out.println("");                                    
					            }
					        }
					    } while (risposta.equalsIgnoreCase("si"));

					    System.out.println();
					    System.out.print("Inserisci il numero di passeggeri che salirà a bordo >> ");
					    passeggeri = 0;
					    boolean postiGiusti = false;
					    while (!postiGiusti) {
					        passeggeri = scanner.nextInt();
					        scanner.nextLine();
					        if (jet.getPosti() < passeggeri) {                                
					            System.out.println("Il numero dei passeggeri è superiore alla capienza massima del Jet");    
					            System.out.print("Inserisci il numero di passeggeri che salirà a bordo >> ");
					        } else {
					        	
					        	postiGiusti = true;
					        }
					    }
					    
					    risposta = "";
					    System.out.println("");
					    System.out.print("Vuoi proporre un offerta al cliente? (si/no) >> ");
				        risposta = scanner.nextLine();
					    Offerta offerta = null;
					    while (risposta.equals("si")) {
					        if (risposta.equals("no")) {
					            break;
					        }
					        gestionale.visualizzaOfferte();
					        System.out.print("Inserisci il numero dell'offerta da aggiungere >> ");
					        int idOfferta = scanner.nextInt();
						    scanner.nextLine();
						    System.out.println();
						    offerta = gestionale.getOfferte().get(idOfferta - 1);
						    break;
					    	}
					    
					    Noleggio noleggio = new Noleggio(cliente, jet, dataInizio, dataFine, passeggeri, serviziNoleggio, offerta);
			            gestionale.aggiungiNoleggio(noleggio);
					    System.out.println();
					    gestionale.jetNoleggiati();
					  
					    break;
					case 2:
						//Rimuovi Noleggio
						System.out.println("\n");
						System.out.println("Ecco i nostri noleggi in corso: ");
						gestionale.jetNoleggiati();
						System.out.println();
						System.out.println("\n");
//						System.out.println("Inserisci il numero dell'offerta da rimuovere >> ");
//						int idNoleggio = scanner.nextInt() - 1;
//						gestionale.rimuoviNoleggio(idNoleggio);
						
						boolean index = false;
						while(!index) {
						System.out.print("Inserisci il numero del noleggio da rimuovere >> ");
						int idNoleggio = scanner.nextInt() - 1;
						if (idNoleggio >= 0  && idNoleggio < gestionale.noleggi.size()) {
							gestionale.rimuoviNoleggio(idNoleggio);
							System.out.println();
							index = true;
						} else {
							System.out.println();
							System.out.println("Il valore inserito non è valido, riprova!");
						}
						}

						break;
					case 3: 
						//Visualizza Noleggi
						System.out.println("\n");
						System.out.println("Ecco i nostri noleggi in corso: ");
						gestionale.jetNoleggiati();
						System.out.println();

						break;
					case 4:
						//Storico noleggi
						System.out.println("\n");
						System.out.println("Ecco lo storico delle prenotazioni passate:");
						gestionale.prenotazioniPassate();
						System.out.println();
						break;
				
					case 5:
						//Esci
						System.out.println("\n");
						System.out.println("Ritorno al menù principale.");
						break;
					default:
						System.out.println("\n");
						System.out.println("La scelta selezionata non è valida. Riprova.");
					}
				}while(sceltaNoleggio != 5);

				break;
			case 3:
				//Gestione Clienti
				int sceltaClienti;
				do {

					System.out.println("\nCosa vuoi fare?");
					System.out.println("[1] -> Visualizza Cliente:");
					System.out.println("[2] -> Ricerca Noleggi per Cliente:");
					System.out.println("[3] -> Aggiungi un Cliente:");
					System.out.println("[4] -> Esci:");					
					System.out.print("Scegli >>");

					//
					sceltaClienti = scanner.nextInt();
					scanner.nextLine();

					switch(sceltaClienti) {
					case 1: 
						//Visualizza cliente
						System.out.println("\n");
						System.out.println("Ecco i nostri Clienti!");
						System.out.println();
						gestionale.visualizzaClienti();
						break;
					case 2:
                        //Ricerca Noleggi per cliente
                        System.out.println("\n");
                        System.out.print("Inserisci il nome del cliente per visualizzare i relativi noleggi:");
                        String nomeClienteR = scanner.nextLine();
                        System.out.println();
                        gestionale.ricercaNoleggioCliente(nomeClienteR);
                        break;
					
					case 3: 
						//Aggiungi nuovo cliente
						System.out.println("\n");
						System.out.println("Aggiungi un nuovo Cliente.");
						System.out.println();
						System.out.print("Inserisci Nome e Cognome del Cliente >> ");
						String nomeCliente = scanner.nextLine();
						System.out.println();
						
						System.out.print("Inserisci l'email del Cliente >> ");
						String emailCliente = scanner.nextLine();
						System.out.println();
						
						Cliente cliente = new Cliente(nomeCliente, emailCliente);
						gestionale.aggiungiCliente(cliente);
						gestionale.visualizzaClienti();


						break;

					case 4: 
						//Esci
						System.out.println("\n");
						System.out.println("Ritorno al menù principale.");

						break;
					default:
						System.out.println("\n");
						System.out.println("La scelta selezionata non è valida. Riprova.");
					}
				}while(sceltaClienti != 4);

				break;
			case 4:
				//Esci					
				System.out.println("Grazie per averci scelto. Alla prossima!");
				System.exit(0);
				break;
			default:
				System.out.println("\n");
				System.out.println("La scelta selezionata non è valida. Riprova.");
				break;
			}

		}
	}

}
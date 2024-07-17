package java_20_05;

import java.util.Random;
import java.util.Scanner;

public class cavaliere_ultima_versione {
    
    //definizione delle variabili globali (visibili lungo tutto il programma)
		static Scanner scanner = new Scanner(System.in);
		static Random rand = new Random();
		static int livelloGiocatore = 1;
		static int esperienzaGiocatore = 0;
		static int xpPerLivelloSuccessivo = 100;
		static int vitaGiocatore = 100;
		static int monete = 0;
		//variabili globali aggiuntive
		static int classeAttacco = 1;
		static int classeDifesa = 0;
        static int classeAgilita = 0;
		static int vitaMassima = 100;
		
		
		public static void main(String[] args) {
			//Loop Principale
			//messaggio di Benvenuto
			
			String[] castello = {
		            "                                   |>>>",
		            "                                   |",
		            "                    |>>>        _  |  _           |>>>",
		            "                    |          |;| |;| |;|        |",
		            "                 _  |  _      \\\\.    .  /      _  |  _",
		            "                |;||;||;|      \\\\:. ,  /      |;||;||;|",
		            "               \\\\..      /    ||;   . |    \\\\.    .  /",
		            "                \\\\.  ,  /     ||:  .  |     \\\\:  .  /",
		            "                 ||:   |_   _ ||_ . _ | _   _||:   |",
		            "                 ||:  .||||;||;||;||;|_|;||:.  |",
		            "                 ||:   ||.    .     .      . ||:  .|",
		            "                 ||: . || .     . .   .  ,   ||:   |       \\,/",
		            "                 ||:   ||:  ,  _______   .   ||: , |            /`\\",
		            "                 ||:   || .   /+++++++\\    . ||:   |",
		            "                 ||:   ||.    |+++++++| .    ||: . |",
		            "              __ ||: . ||: ,  |+++++++|.  .  ||   |",
		            "     ____--~    '--~~__|.     |+++++__|----~    ~---,              ___",
		            "---                   ---|,--'                  ~----_-'   `~----"
		        };
		        
		        for (String linea : castello) {
		            System.out.println(linea);
		            }
			
			System.out.println("Benvenuto nel Gioco di Ruolo - Un Cavaliere alla scoperta di JAVA!");
			System.out.println("\nUnisciti all'avventura e cerca di diventare il più grande Eroe!!!");
		
			while (vitaGiocatore > 0) {
				//Menu delle scelte
				System.out.println("\nCosa vuoi fare?");
				System.out.println("[1] -> Esplora il Dungeon");
				System.out.println("[2] -> Vai in Taverna");
				System.out.println("[3] -> Statistiche Personaggio");
				System.out.println("[4] -> Esci");
				System.out.println("[5] -> Crediti");
				
				//intercetta la scelta dell'utente
				int scelta = scanner.nextInt();
				//gestione della scelta
				switch(scelta) {
				case 1:
					esplora();
					break;
				case 2:
					riposa();
					break;
				case 3:
					System.out.println("\nSei un Guerriero di livello " + livelloGiocatore +", che infligge un d10 +" + classeAttacco +" di danno.");
					System.out.println("I tuoi punti difesa sono pari a " + classeDifesa + " e hai " + classeAgilita + " punti agilità.");
					System.out.println("I tuoi Punti Vita Totali sono " + vitaMassima + " e hai attualmente ancora " + vitaGiocatore + " Punti Vita.");
					System.out.println("Nella tua sacchetta hai attualmente " + monete + " Monete.");
					System.out.println("I tuoi attuali punti esperienza sono " + esperienzaGiocatore);
					break;
				case 4:
					System.out.println("Grazie per aver giocato! Arrivederci!");
					System.exit(0);
					break;
				case 5:
					System.out.println("Il gioco è stato sviluppado dalla Classe di BitCamp e modificato dal TEAM1!");
					System.out.println("Il Team 1 è formato da:");
					System.out.println("Simone D. - Team Leader");
					System.out.println("Mattia B.");
					System.out.println("Luca T.");
					System.out.println("Giuseppe B.");
					System.out.println("Roberto B.");
					System.out.println("Francesco D.");
					break;
					
				default:
					System.out.println("Il valore inserito non è valido, riprova.");
					break;
					
				}
				
				
				
			}
			//messaggio GAME OVER quando il loop non è più verificato.
			System.out.println("Hai Perso! La tua avventura finisce qui.");


			
		}
	//interno della Classe - realizziamo il metodo esplora
		public static void esplora() {
		    //creazione per le probabilitÃ  di un incontro casuale
		    int probabilitaIncontro = rand.nextInt(100)+1;

		    //gestione dei casi al 50%
		    if(probabilitaIncontro <= 10) {
		        System.out.println("Girando per il Dungeon non scorgi nulla di interessante...");}
		    else if(probabilitaIncontro >11 && probabilitaIncontro <= 29) {
		        System.out.println("Incontri un Mercante Errante lungo la via...");
		        mercante();
		    } else if (probabilitaIncontro >30 && probabilitaIncontro <=39){
		        System.out.println("Esplorando il Dungeon...... incontri un Goblin molto molesto!!!");
		        //Gestione del combattimento.
		        combattiGoblin();
		    } else if (probabilitaIncontro >40 && probabilitaIncontro <=59) {
		        int moneteTrova = rand.
		                nextInt(10)+1;
		        System.out.println("Esplorando il Dungeon..... hai trovato un tesoro con all'interno ben " + moneteTrova + " monete!!!");
		        monete += moneteTrova;
		        System.out.println("Nella tua sacchetta hai ben " + monete + " monete.");

		    } else if(probabilitaIncontro >60 && probabilitaIncontro <=94) { 
		        System.out.println("Esplorando il Dungeon...... incontri un Hobgoblin molto arrabbiato!!!");
		        //Gestione del combattimento.
		        combattiHobgoblin();
		    } else if(probabilitaIncontro >95 && probabilitaIncontro <= 99) {
		        System.out.println("Esplorando il Dungeon...... incontri una creatura epica... una Gigantesca Paperella di Gomma!!!");
		        //Gestione del combattimento.
		        combattiPaperella();
		    }else {
		        int moneteTrova = 50;
		        System.out.println("Esplorando il Duneon..... hai trovato un tesoro EPICO con all'interno ben " + moneteTrova + " monete!!!");
		        monete += moneteTrova;
		        System.out.println("Nella tua sacchetta hai ben " + monete + " monete.");
		        System.out.println("Inoltre trovi uno strano Manufatto!");

                int abilitaCasuale = rand.nextInt(100)+1;

                if (abilitaCasuale <= 20) {

                    System.out.println("Come l'impugni ti senti piú agile!");
                    classeAgilita += 1;
                } else if (abilitaCasuale > 21 && abilitaCasuale <= 40) {
                    System.out.println("Come l'impugni la tua pelle diventa piú dura!");
                    classeDifesa += 1;
                } else {
                    System.out.println("Come l'impugni senti aumentare la tua forza!");
                    classeAttacco += 1;
                }
		        
		    }

		}
		
		//AUMENTO DI LIVELLO
		public static void verificaLivelloSuccessivo() {
			//verifica requisiti per passa a livello successivo
			xpPerLivelloSuccessivo = 100 * livelloGiocatore;
			if (esperienzaGiocatore >= xpPerLivelloSuccessivo) {
				//Il giocatore passa di livello
				livelloGiocatore++;
				esperienzaGiocatore -= xpPerLivelloSuccessivo;
				//Aggiornare le statistiche del giocatore es. (VitaMassima, Attacco, Difesa)
				System.out.println("Sei salito al livello " + livelloGiocatore + "!");
				vitaMassima += 10;
				System.out.println("La tua vita Massima sale a " + vitaMassima);
				System.out.println("Senti la tua forza aumentare.. il tuo valore bonus di attacco è uguale: " + classeAttacco);
				vitaGiocatore = vitaMassima;
				classeAttacco += 1;
			}
			
		}
		
		//RIPOSO IN LOCANDA
		public static void riposa() {
			//definire il costo per recuperare i punti vita
			int costoRecupero = 20;
			System.out.println("\nRiposare presso la locanda costa ben " + costoRecupero + " monete.");
			if (monete >= costoRecupero) {
				vitaGiocatore += 30;
				monete -= costoRecupero;
				if (vitaGiocatore > vitaMassima) {
					vitaGiocatore = vitaMassima;
				}
				System.out.println("hai riposato e recuperato parte della tua vita");
				System.out.println("La tua vita: " + vitaGiocatore);
				System.out.println("Monete rimanenti: " + monete);
			} else {
				System.out.println("Non hai abbastanza monete per riposare!");
			}
				
			
		}
		
		//INCONTRO CONIL MERCANTE
		public static void mercante() {
			//definire il costo per recuperare i punti vita
			int costoRecupero = 5;
			System.out.println("Il Mercante con aria gentile ti dice: 'Salve Viandante hai bisogno di curarti?");
			System.out.println("[1] -> Certo, eccoti 5 monete.");
			System.out.println("[2] -> No grazie.");
			int scelta = scanner.nextInt();
			
			switch (scelta) {
			case 1:
				if (monete >= costoRecupero) {
					vitaGiocatore += 10;
					monete -= costoRecupero;
					if (vitaGiocatore > vitaMassima) {
						vitaGiocatore = vitaMassima;
					}
					System.out.println("\nIl mmercante ti ringrazia per le " + costoRecupero + " monete.");
					System.out.println("Ti senti rinvigorito, curi parte della tua vita");
					System.out.println("La tua vita: " + vitaGiocatore);
					System.out.println("Monete rimanenti: " + monete);
				} else {
					System.out.println("Non hai abbastanza monete per curarti!");
				}				
				
				break;
			case 2:
				System.out.println("Il mercante ti saluta! La tua avventura continua....");
				return;
			default:
				System.out.println("Il valore inserito non è valido, riprova.");
				break;
				
			}
			
			
		}

		//INCONTRO CON IL GOBLIN
		public static void combattiGoblin() {
			//CREAZIONE RANDOMICA DI UN NUOVO MOSTRO
			int vitaGoblin = 15;

			//ATTACCO SPECIALE OGNI DUE
			int counterAttacco = 0;
			
			//LOOP SECONDARIO PER LA GESTIONE DELLE BATTAGLIE
			while(vitaGoblin > 0 && vitaGiocatore > 0) {
				
				//CREAZIONE SOTTOMENU BATTAGLIA
				System.out.println("\nCosa vuoi fare?");
				System.out.println("1. Attacca");
				System.out.println("2. Scappa");
				
				//INTERCETTA SCELTA UTENTE
				//RICREO LA VARIABILE SCELTA POICHE NON VISIBILE NELLA FUNZIONE COMBATTI, E' NEL MAIN
				int scelta = scanner.nextInt();
				switch(scelta) {
				case 1:
					int schivata = rand.nextInt(20)+1;
					counterAttacco++;
					if(counterAttacco % 2 == 0) {
						
						int dannoGiocatoreMax = 10 + classeAttacco; 
						int dannoGoblin = rand.nextInt(8) + 1;
                        int dannoGoblinFinale = dannoGoblin - classeDifesa;
						
						vitaGoblin -= dannoGiocatoreMax;
						System.out.println("Infervorato dalla battaglia sfoderi un colpo critico al massimo della sua potenza! \nHai inflitto ben " + dannoGiocatoreMax + " danni al Goblin!");
						System.out.println("Vita del mostro: " + vitaGoblin);
						//VARIABILI GLOBALI AZZURRE, LOCALI GIALLE, SCOPE DIFFERENTI
						
						
						
						if (schivata + classeAgilita> 10) {
		                    System.out.println("Con un movimento felino schivi l'attacco!");
		                }else {
		                vitaGiocatore -= dannoGoblinFinale;	
		                System.out.println("Il Goblin ha inflitto " + dannoGoblinFinale + " danni a te!");
		                System.out.println("La tua vita: " + vitaGiocatore);
		                }
					} else {

						int dannoGiocatore = rand.nextInt(10) + classeAttacco; //DANNO RANDOMICO
                        int dannoGiocatoreFinale = dannoGiocatore + classeAttacco;
						int dannoGoblin = rand.nextInt(8) + 1;
                        int dannoGoblinFinale = dannoGoblin - classeDifesa;
						
						//VARIABILI GLOBALI AZZURRE, LOCALI GIALLE, SCOPE DIFFERENTI
						
						vitaGoblin -= dannoGiocatoreFinale;
						System.out.println("Infliggi al Goblin ben "+dannoGiocatoreFinale+"!");
						System.out.println("Vita del mostro: " + vitaGoblin);
						//FEEDBACK UTENTE
						if (schivata + classeAgilita > 10) {
		                    System.out.println("Con un movimento felino schivi l'attacco!");
		                }else {
		                vitaGiocatore -= dannoGoblinFinale;	
		                System.out.println("Il Goblin ha inflitto " + dannoGoblinFinale + " danni a te!");
		                System.out.println("La tua vita: " + vitaGiocatore);
		                
		                }
						
						
					}
					
					break;
				case 2:
					//POTREMMO USARE ANCHE IL RANDOMICO PER DARE UNA CASISTICA ALLA FUGA
					System.out.println("Sei riuscito a scappare! La tua avventura continua...");
					return; //NON BREAK COSI SI ESCE DIRETTAMENTE DAL CICLO 
				default:
						System.out.println("Scelta non valida. Riprova.");
						//BREAK NEL DEFAULT SI METTE PER FARLO TORNARE NEL WHILE, SONO VARI BLOCCHI,
						//NELLA PROGRAMMAZIONE MODULARE E A OGGETTI E' BUONA PRATICA INSERIRLO
						break;
				}
			}
				
			//CONTROLLO IN CASO DI SCONFITTA GIOCATORE
			if(vitaGiocatore <= 0) {
				System.out.println("Sei stato sconfitto dal Goblin!");
				System.out.println("\nGAME OVER!");
				//USCIAMO DAL GIOCO
				System.exit(0);
			}
			//CODICE ESEGUITO IN CASO DI VITTORIA
			System.out.println("Hai sconfitto il Goblin! Continua la tua avventura...");
			
			//CALCOLO ESPERIENZA E GESTIONE LIVELLI
			//MINIMO 10 PUNTI
			int xpGuadagnati = 15;
			esperienzaGiocatore += xpGuadagnati;
			int moneteGuadagnate = 3;
			monete += moneteGuadagnate;
			System.out.println("Hai guadagnato " + xpGuadagnati + " punti esperienza e hai trovato ben " + moneteGuadagnate + " monete!");
			
			//RICHIAMA LA FUNZIONE PER IL LIVELLO
			verificaLivelloSuccessivo();
			
			
			
			}
			
		//INCONTRO CONTRO HOBGOBLIN
		public static void combattiHobgoblin() {
			//CREAZIONE RANDOMICA DI UN NUOVO MOSTRO
			int vitaHobgoblin = 22;

			//ATTACCO SPECIALE OGNI DUE
			int counterAttacco = 0;
			
			//LOOP SECONDARIO PER LA GESTIONE DELLE BATTAGLIE
			while(vitaHobgoblin > 0 && vitaGiocatore > 0) {
				
				//CREAZIONE SOTTOMENU BATTAGLIA
				System.out.println("\nCosa vuoi fare?");
				System.out.println("1. Attacca");
				System.out.println("2. Scappa");
				
				//INTERCETTA SCELTA UTENTE
				//RICREO LA VARIABILE SCELTA POICHE NON VISIBILE NELLA FUNZIONE COMBATTI, E' NEL MAIN
				int scelta = scanner.nextInt();
				int dannoGiocatoreMax = 10 + classeAttacco; 
				switch(scelta) {
				case 1:
					int schivata = rand.nextInt(20)+1;
					counterAttacco++;
					if(counterAttacco % 2 == 0) {
						
						
						int dannoHobgoblin = rand.nextInt(10) + 1;
                        int dannoHobgoblinFinale = dannoHobgoblin - classeDifesa;
						
						vitaHobgoblin -= dannoGiocatoreMax;
                        System.out.println("Infervorato dalla battaglia sfoderi un colpo critico al massimo della sua potenza! \nHai inflitto ben " + dannoGiocatoreMax + " danni al Hobgoblin!");
						System.out.println("Vita del mostro: " + vitaHobgoblin);
						//VARIABILI GLOBALI AZZURRE, LOCALI GIALLE, SCOPE DIFFERENTI
						
						
						
						if (schivata + classeAgilita> 12) {
		                    System.out.println("Con un movimento felino schivi l'attacco!");
		                }else {
		                vitaGiocatore -= dannoHobgoblinFinale;	
		                System.out.println("L'Hobgoblin ha inflitto " + dannoHobgoblinFinale + " danni a te!");
		                System.out.println("La tua vita: " + vitaGiocatore);
		                }
					} else {

						int dannoGiocatore = rand.nextInt(10) + 1; //DANNO RANDOMICO
                        int dannoGiocatoreFinale = dannoGiocatore + classeAttacco;
						int dannoHobgoblin = rand.nextInt(10) + 1;
                        int dannoHobgoblinFinale = dannoHobgoblin - classeDifesa;
						
						//VARIABILI GLOBALI AZZURRE, LOCALI GIALLE, SCOPE DIFFERENTI
						
						vitaHobgoblin -= dannoGiocatoreFinale;
						System.out.println("Infliggi all'Hobgoblin ben "+dannoGiocatoreFinale+"!");
						System.out.println("Vita del mostro: " + vitaHobgoblin);
						//FEEDBACK UTENTE
						if (schivata + classeAgilita > 12) {
		                    System.out.println("Con un movimento felino schivi l'attacco!");
		                }else {
		                vitaGiocatore -= dannoHobgoblinFinale;	
		                System.out.println("L'Hobgoblin ha inflitto " + dannoHobgoblinFinale + " danni a te!");
		                System.out.println("La tua vita: " + vitaGiocatore);
		                
		                }
					}
					
					break;
				case 2:
					//POTREMMO USARE ANCHE IL RANDOMICO PER DARE UNA CASISTICA ALLA FUGA
					System.out.println("Sei riuscito a scappare! La tua avventura continua...");
					return; //NON BREAK COSI SI ESCE DIRETTAMENTE DAL CICLO 
				default:
						System.out.println("Scelta non valida. Riprova.");
						//BREAK NEL DEFAULT SI METTE PER FARLO TORNARE NEL WHILE, SONO VARI BLOCCHI,
						//NELLA PROGRAMMAZIONE MODULARE E A OGGETTI E' BUONA PRATICA INSERIRLO
						break;
				}
			}
			//CONTROLLO IN CASO DI SCONFITTA GIOCATORE
			if(vitaGiocatore <= 0) {
				System.out.println("Sei stato sconfitto dall'Hobgoblin!");
				System.out.println("\nGAME OVER!");
				//USCIAMO DAL GIOCO
				System.exit(0);
			}
			//CODICE ESEGUITO IN CASO DI VITTORIA
			System.out.println("Hai sconfitto L'Hobgoblin! Continua la tua avventura...");
			
			//CALCOLO ESPERIENZA E GESTIONE LIVELLI
			//MINIMO 10 PUNTI
			int xpGuadagnati = 25;
			esperienzaGiocatore += xpGuadagnati;
			int moneteGuadagnate = 7;
			monete += moneteGuadagnate;
			System.out.println("Hai guadagnato " + xpGuadagnati + " punti esperienza e hai trovato ben " + moneteGuadagnate + " monete!");
			
			//RICHIAMA LA FUNZIONE PER IL LIVELLO
			verificaLivelloSuccessivo();
			
			}
		
		//INCONTRO PAPERELLA
		public static void combattiPaperella() {
			//CREAZIONE RANDOMICA DI UN NUOVO MOSTRO
			int vitaPaperella = 65;

			//ATTACCO SPECIALE OGNI DUE
			int counterAttacco = 0;
			
			//LOOP SECONDARIO PER LA GESTIONE DELLE BATTAGLIE
			while(vitaPaperella > 0 && vitaGiocatore > 0) {
				
				//CREAZIONE SOTTOMENU BATTAGLIA
				System.out.println("\nCosa vuoi fare?");
				System.out.println("1. Attacca");
				System.out.println("2. Scappa (Forse ti conviene)");
				
				//INTERCETTA SCELTA UTENTE
				//RICREO LA VARIABILE SCELTA POICHE NON VISIBILE NELLA FUNZIONE COMBATTI, E' NEL MAIN
				int scelta = scanner.nextInt();
				switch(scelta) {
				case 1:
					int schivata = rand.nextInt(20)+1;
					counterAttacco++;
					if(counterAttacco % 2 == 0) {
						
						int dannoGiocatoreMax = 10 + classeAttacco - 2;
						int dannoPaperella = rand.nextInt(15) + 1;
                        int dannoPaperellaFinale = dannoPaperella - classeDifesa;
						
						vitaPaperella -= dannoGiocatoreMax;
                        System.out.println("Infervorato dalla battaglia sfoderi un colpo critico al massimo della sua potenza! \nHai inflitto ben " + dannoGiocatoreMax + " danni alla Paperella di Gomma!");
						System.out.println("Vita del mostro: " + vitaPaperella);
						//VARIABILI GLOBALI AZZURRE, LOCALI GIALLE, SCOPE DIFFERENTI
						
						
						
						if (schivata + classeAgilita > 15) {
		                    System.out.println("Con un movimento felino schivi l'attacco!");
		                }else {
		                vitaGiocatore -= dannoPaperellaFinale;	
		                System.out.println("La Paperellla di Gomma ha inflitto " + dannoPaperellaFinale + " danni a te!");
		                System.out.println("La tua vita: " + vitaGiocatore);
		                }
					} else {

						int dannoGiocatore = rand.nextInt(10) + 1; //DANNO RANDOMICO
                        int dannoGiocatoreFinale = dannoGiocatore + classeAttacco - 2;
						int dannoPaperella = rand.nextInt(15) + 1;
                        int dannoPaperellaFinale = dannoPaperella - classeDifesa;
						
						//VARIABILI GLOBALI AZZURRE, LOCALI GIALLE, SCOPE DIFFERENTI
						
						vitaPaperella -= dannoGiocatoreFinale;
						System.out.println("Infliggi alla Paperella di Gomma ben "+dannoGiocatoreFinale+"!");
						System.out.println("Vita del mostro: " + vitaPaperella);
						//FEEDBACK UTENTE
						if (schivata + classeAgilita > 15) {
		                    System.out.println("Con un movimento felino schivi l'attacco!");
		                }else {
		                	
		                vitaGiocatore -= dannoPaperellaFinale;	
		                System.out.println("La Paperella di Gomma ha inflitto " + dannoPaperellaFinale + " danni a te!");
		                System.out.println("La tua vita: " + vitaGiocatore);
		                
		                }
					}
					
					break;
				case 2:
					//POTREMMO USARE ANCHE IL RANDOMICO PER DARE UNA CASISTICA ALLA FUGA
					System.out.println("Sei riuscito a scappare! La tua avventura continua...");
					return; //NON BREAK COSI SI ESCE DIRETTAMENTE DAL CICLO 
				default:
						System.out.println("Scelta non valida. Riprova.");
						//BREAK NEL DEFAULT SI METTE PER FARLO TORNARE NEL WHILE, SONO VARI BLOCCHI,
						//NELLA PROGRAMMAZIONE MODULARE E A OGGETTI E' BUONA PRATICA INSERIRLO
						break;
				}
				
			}
	
			//CONTROLLO IN CASO DI SCONFITTA GIOCATORE
			if(vitaGiocatore <= 0) {
				System.out.println("Sei stato sconfitto dalla Paperella di Gomma");
				System.out.println("\nGAME OVER!");
				//USCIAMO DAL GIOCO
				System.exit(0);
			}
			//CODICE ESEGUITO IN CASO DI VITTORIA
			System.out.println("Hai sconfitto la Paperella di Gomma! Continua la tua avventura...");
			
			//CALCOLO ESPERIENZA E GESTIONE LIVELLI
			//MINIMO 10 PUNTI
			int xpGuadagnati = 55;
			esperienzaGiocatore += xpGuadagnati;
			int moneteGuadagnate = 15;
			monete += moneteGuadagnate;
			System.out.println("Hai guadagnato " + xpGuadagnati + " punti esperienza e hai trovato ben " + moneteGuadagnate + " monete!");
			
			//RICHIAMA LA FUNZIONE PER IL LIVELLO
			verificaLivelloSuccessivo();
	
	
	
}



}

package java_23_05.GestionaleJet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Gestionale {
	
	//ArrayList
	public ArrayList<Jet> jets = new ArrayList<>();
	public ArrayList<Offerta> offerte = new ArrayList<>();
	public ArrayList<Servizi> serviziJets = new ArrayList<>();
	public ArrayList<Noleggio> noleggi = new ArrayList<>();
	public ArrayList<Cliente> clienti = new ArrayList<>();

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	
	//METODI
	public void visualizzaJet() {
		for(int i = 0; i < jets.size(); i++) {
			System.out.print((i + 1) + ") " + jets.get(i));
			System.out.println();
		}
	}

	public void aggiungiServizi(Servizi servizi) {
		serviziJets.add(servizi);
	}
	
	//DA IMPLEMENTARE IN PRINCIPALE
	public void visualizzaJetDisponibili() {
		
		for(int i = 0; i < jets.size(); i++) {
			
			if(jets.get(i).getQuantita() > 0) {
			System.out.print(jets.get(i));
			System.out.println();
			}
		}
	}
	
	public void aggiungiJet(Jet jet) {
		jets.add(jet);
	}
	
	public void rimuoviJet(int idJet) {
		jets.remove(idJet);
			System.out.println("Jet rimosso con successo!");
	}
	
	public ArrayList<Jet> getJets(){
		return jets;
	}
	
	public ArrayList<Offerta> getOfferte(){
		return offerte;
	}
	
	public void rimuoviNoleggio(int idNoleggio) {
		noleggi.remove(idNoleggio);
			System.out.println("Noleggio rimosso con successo!");
	}
	
	public void aggiungiNoleggio(Noleggio noleggio) {

		Jet jet = noleggio.getJet();
		if(jet.getQuantita() > 0) {
		noleggi.add(noleggio);
		
		System.out.println("Noleggio inserito con successo!");
	} else {
		System.out.println("Jet non disponibile per il noleggio!");
	}
	}
	
//	JetNoleggiati(): Permette di visualizzare la lista dei jet noleggiati
//	ordinati per data di noleggio, con i relativi dettagli(Cliente, ecc..).

	public void jetNoleggiati() throws ParseException{

		// ordinamento dei noleggi per data di inizio
		for (int i = 0; i < noleggi.size(); i++) {
			for (int j = i + 1; j <  noleggi.size(); j++) {
				
				

				// conversione delle date: stringhe in date
				Date dataInizio = noleggi.get(i).getDataInizio();
				Date dataInizio2 = noleggi.get(j).getDataInizio();
	
				if (dataInizio.before(dataInizio2)) {
					Noleggio temp = noleggi.get(i);
					noleggi.set(i, noleggi.get(j));
					noleggi.set(j, temp);
				}

			}
		}
		

		// stampa dei noleggi ordinati

		for(int i = 0; i < noleggi.size(); i++) {				
			Date dataFine = noleggi.get(i).getDataFine();
				Date dataAttuale = new Date();
				if(dataFine.after(dataAttuale)) {
			System.out.print((i + 1) + ") " + noleggi.get(i));
			System.out.println();
		}
	}
	}
	
//	PrenotazioniPassate(): Permette di visualizzare uno storico delle
//	prenotazioni. CONTROLLARE PER UN CONTROLLO SU DATA FINE ANTECEDENTE A QUELLA
	//ATTUALE. OPPURE SOLO DATI FITTIZI ANTECEDENTI

	public void prenotazioniPassate() throws ParseException{
		for(int i = 0; i < noleggi.size(); i++) {
			
			Date dataFine = noleggi.get(i).getDataFine();
			Date dataAttuale = new Date();
			if(dataFine.before(dataAttuale)) {
				System.out.print(noleggi.get(i));
				System.out.println();
			}

		}
	}
	
	public void ricercaJetNome(String nomeJet) {
		for(int i = 0; i< jets.size(); i++) {
			if(jets.get(i).getNome().equalsIgnoreCase(nomeJet)) {
				System.out.println(jets.get(i));
			}
		}
	}
	
	
	public void ricercaJetServizi(String nomeServiziJet) {
		for(int i = 0; i < jets.size(); i++) {
			for(int j = 0; j < serviziJets.size(); j++) {

				if(jets.get(i).getServiziJet().get(j).getServizi().equalsIgnoreCase(nomeServiziJet)) {
					System.out.println(jets.get(i));
				}
			}
			
		}
	}
	
	public void ricercaOfferta(String offerta) {
		for(int i = 0; i < offerte.size(); i++) {
			String scontoJet = String.valueOf(jets.get(i).getOffertaJet().getSconto());
			if(scontoJet.equalsIgnoreCase(offerta)) {
				System.out.print(jets.get(i));
			} else {
				System.out.print("Non sono disponibili offerte di questo tipo al momento!");
			}
		}
	}

    //stampa clienti
    public void visualizzaClienti() {
        for (int i = 0; i < clienti.size(); i++) {
            System.out.println((i+1)+") " + clienti.get(i));
        }

    }

	public void ricercaNoleggioCliente (String nomeCliente) {
        if (clienti.isEmpty()) {
            System.out.println("Non ci sono Clienti da visualizzare!");
        } else {
        for(int i = 0; i < noleggi.size(); i++) {
             if(noleggi.get(i).getCliente().getNomeCliente().equalsIgnoreCase(nomeCliente)) {
                System.out.println(noleggi.get(i));
            }
        }}
    }

	public void aggiungiCliente(Cliente cliente) {
        clienti.add(cliente);
    }
	
	//OFFERTA
	
	public void visualizzaOfferte() {
        for(int i = 0; i < offerte.size(); i++) {
                System.out.print((i+1)+") "+ offerte.get(i));
                System.out.println();

        }
    }
	
	public void aggiungiOfferta(Offerta offerta) {
        offerte.add(offerta);
    }
	
	
	
}
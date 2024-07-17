package java_22_05.supermercato;

import java.util.ArrayList;

public class Supermercato {

    		// array list
	
    
    
    private ArrayList<Prodotto> prodotti = new ArrayList<>();
    private ArrayList<Offerta> offerte = new ArrayList<>();


    public void aggiungiProdotto(Prodotto prodotto){
        prodotti.add(prodotto);

    }

    public void visualizzaProdotti(){
        for(int i = 0; i < prodotti.size(); i++){
            System.out.println((i + 1) + ". " + prodotti.get(i)); 
        }
    }

    public ArrayList<Prodotto> getProdotti() {
        return prodotti;
    }
    // ------------------------------------------

    public ArrayList<Offerta> getOfferte() {
        return offerte;
    }


    public void aggiungiOfferta(Offerta offerta) {
    	offerte.add(offerta);
    }

    public void modificaOfferta(int idOfferta, Offerta offerta) {
        offerte.set(idOfferta, offerta);
    }

    public void modificaOfferta(int idOfferta, double sconto, String dataInizio, String dataFine) {
    Offerta offerta = offerte.get(idOfferta);
    offerta.setSconto(sconto);
    offerta.setDataInizio(dataInizio);
    offerta.setDataFine(dataFine);
    }
    
    public void rimuoviOfferta(int idOfferta) {
        offerte.remove(idOfferta);
        System.out.println("\nOfferta rimossa con successo!");

    }

    // ricerca per nome
    public void ricercaNome (String nomeProdotto) {
        if (offerte.isEmpty()) {
            System.out.println("Non ci sono prodotti da visualizzare!");
        } else {
        for( int i = 0; i < offerte.size(); i++) {
             if(offerte.get(i).getProdotto().getNome().equalsIgnoreCase(nomeProdotto)) {
                System.out.println(offerte.get(i));
            }
        }}
    }
    
    // ricerca per categoria
    public void ricercaCategoria (String categoriaProdotto) {

        
        if (offerte.isEmpty()) {
            System.out.println("Non ci sono Categorie da visualizzare!");
        } else {
        for( int i = 0; i < offerte.size(); i++) {
             if(offerte.get(i).getProdotto().getCategoria().equalsIgnoreCase(categoriaProdotto)) {
                System.out.println(offerte.get(i));
            }}
        }
    }

    
    public void mostraOfferte(){
        for(int i = 0; i < offerte.size(); i++){
            System.out.println((i + 1) + ". " + offerte.get(i)); 
        }
    }
    
}

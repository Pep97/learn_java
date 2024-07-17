package java_23_05.GestionaleJet;

import java.util.List;

public class Jet {

    //attributi
    String nome;
    double prezzo;
    int posti;
    int quantita;
    List<Servizi> serviziJet;
    Offerta offertaJet;
    //personale?

    //metodi
//    public Jet(String nome, double prezzo, int posti, int quantita, Servizi serviziJet, Offerta offertaJet) {
//        this.nome= nome;
//        this.prezzo = prezzo;
//        this.posti = posti;
//        this.quantita = quantita;
//        this.serviziJet = serviziJet;
//        this.offertaJet = offertaJet;
//    }
    
    //COSTRUTTORE SENZA OFFERTE E SERVIZI
    public Jet(String nome, double prezzo, int posti, int quantita, List<Servizi> serviziJet) {
        this.nome= nome;
        this.prezzo = prezzo;
        this.posti = posti;
        this.quantita = quantita;
        this.serviziJet = serviziJet;
//        this.offertaJet = offertaJet;
    }

    //metodi Getter
    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public int getPosti() {
        return posti;
    }

    public int getQuantita() {
        return quantita;
    }

   public List<Servizi> getServiziJet() {
       return serviziJet;
   }
    
    // public String getServiziJet() {
    //     return servizi;
    // }
    
    public Offerta getOffertaJet() {
        return offertaJet;
    }
    
    //metodi Setter

      public void setNome(String nome) {
          this.nome = nome;
      }

      public void setPrezzo(double prezzo) {
          this.prezzo = prezzo;
      }

      public void setPosti(int posti) {
          this.posti = posti;
      }

      public void setQuantita(int quantita) {
          this.quantita = quantita;
      }

     public void setServiziJet(List<Servizi> serviziJet) {
         this.serviziJet = serviziJet;
     }
      
    //   public void setServiziJet(String servizi) {
    //       this.servizi = servizi;
    //   }
      
      public void setOffertaJet(Offerta offertaJet) {
          this.offertaJet = offertaJet;
      }
      
      //metodo to string
      public String toString() {
          return nome + " | prezzo: " + prezzo + " | posti: " + posti + " | Jet presenti nell'Hangar: " + quantita;
      }
}
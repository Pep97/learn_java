package java_23_05.GestionaleJet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Noleggio {

	Cliente cliente;
    Jet jet;
    Date dataInizio;
    Date dataFine;
    int passeggeri;
    List<Servizi> serviziNoleggio;
    Offerta offerta;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    public Noleggio(Cliente cliente, Jet jet, Date dataInizio, Date dataFine, int passeggeri, List<Servizi> serviziNoleggio, Offerta offerta) {
        this.cliente = cliente;
        this.jet = jet;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.passeggeri = passeggeri;
        this.serviziNoleggio = serviziNoleggio;
        this.offerta = offerta;
    }

    // metodi getter
    public Cliente getCliente() {
        return cliente;
    }

    public Jet getJet() {
        return jet;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public int getPasseggeri() {
        return passeggeri;
    }

    public List<Servizi> getServiziNoleggio() {
        return serviziNoleggio;
    }
    
    public Offerta getOfferta() {
    	return offerta;
    }

    // metodi setter
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setJet(Jet jet) {
        this.jet = jet;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public void setPasseggeri(int passeggeri) {
        this.passeggeri = passeggeri;
    }

    public void setServiziNoleggio(List<Servizi> serviziNoleggio) {
        this.serviziNoleggio = serviziNoleggio;
    }
    
    public void setOfferta(Offerta offerta) {
    	this.offerta = offerta;
    }

    @Override
    public String toString() {
        StringBuilder servizi = new StringBuilder();
        for (Servizi servizio : serviziNoleggio) {
            servizi.append(servizio.getServizi()).append(" | ");
        }
        if (servizi.length() == 0) {
            servizi.append("Nessun servizio selezionato | ");
        }

        String personale = passeggeri <= 10 ? "1 Pilota e 2 Assistenti di Bordo" : "2 Piloti e 4 Assistenti di Bordo";

        String dataInizioString = sdf.format(dataInizio);
        String dataFineString = sdf.format(dataFine);


        return cliente + " | Jet: " + jet.getNome() + " | data inizio: " + dataInizioString + " | data fine: " + dataFineString +
                " | Servizi: " + servizi + "Passeggeri: " + passeggeri + " | Il personale necessario per questo volo sarà composto da " + personale + " | " + offerta;
    }

}
	
	
	
	
	
	
	
	

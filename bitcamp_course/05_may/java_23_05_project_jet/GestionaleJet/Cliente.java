package java_23_05.GestionaleJet;

public class Cliente {
    String nomeCliente;
    String email;

       //costruttore
    public Cliente(String nomeCliente, String email) {
        this.nomeCliente = nomeCliente;
        this.email = email;
    }

    //getter
    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getEmail() {
        return email;
    }


    //setter
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    //tostring
    public String toString() {
        return nomeCliente + " | email: " + email;
    }


}
package java_21_05_objects.generatore_coppie;

import java.util.Arrays;

public class Gruppo {

    // attributi

    private String nome_gruppo;
    private String[] elementi;
    private int contatore_elementi;
    private String[] coppie;

    

    // costruttore

    public Gruppo(String nome_gruppo, String[] elementi, String[] coppie){
        this.nome_gruppo = nome_gruppo;
        this.elementi = elementi;
        this.contatore_elementi = elementi.length;
        this.coppie = coppie;
    }

    public Gruppo(String nome_gruppo, String[] elementi){
        this.nome_gruppo = nome_gruppo;
        this.elementi = elementi;
    }

    public Gruppo(String[] elementi){
        this.elementi = elementi;
    }

    // metodi

    public String get_nome_gruppo(){
        return nome_gruppo;
    }

    public void set_nome_gruppo(String nome_gruppo){
        this.nome_gruppo = nome_gruppo;
    }

    public String[] get_elementi(){
        return elementi;
    }

    public void set_elementi(String[] elementi){
        this.elementi = elementi;
    }

    public void stampaInfo(){
        System.out.println("Nome Gruppo: " + nome_gruppo + "\nArray: " + Arrays.toString(elementi));
    }
    
}

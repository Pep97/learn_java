
var lista_numeri_telefono = [
    {
        nome: "Gianni",
        cognome: "Rossi",
        numero_di_telefono: 4484793287
    },
    {
        nome: "Mario",
        cognome: "Bianchi",
        numero_di_telefono: 4484793287
    }
];


// funzione per aggiungere un libro alla lista

function aggiungiNuovoNumero(event){

    // evitiamo il comportamento predefinito di submit del form che ricarica la pagina
    event.preventDefault();

    // recupera i dati dell'utente

    var nome = document.getElementById("input_nome").value;
    var cognome = document.getElementById("input_cognome").value;
    var numero_di_telefono = document.getElementById("input_telefono").value;

    // crea un nuovo oggetto libro

    var nuovoNumero = {
        nome: nome,
        cognome: cognome,
        numero_di_telefono: numero_di_telefono
    };

    // aggiungi il nuovo libro all'array libri

    lista_numeri_telefono.push(nuovoNumero);

    // aggiorna la lista dei libri sul documento
    aggiungiNumeriAllaPagina();

    // resetta i campi del form
    document.getElementById("form_aggiungi_numero").reset();

};

//funzione per creare e aggiungere elementi html alla lista dei libri

//funzione per creare e aggiungere elementi html alla lista dei libri

function aggiungiNumeriAllaPagina(){

    var listaNumeriElement = document.getElementById("lista-numeri");

    // svuota la lista dei libri

    listaNumeriElement.innerHTML = "";

    // cicliamo sull'array libri ed inseriamo un nuovo elemento li

    lista_numeri_telefono.forEach(function(nuovo_utente){ 
        // "nuovo_utente" in questo caso é un nome arbitrario, potrebbe essere qualsiasi cosa. l'utilitá 
        // é di passare un singolo elemento alla funzione forEach e rappresenta un singolo elemento dell'array libri

        // crea elemento li
        var listItem = document.createElement("li");

        // dai volore al testo dell'elemento li
        listItem.textContent = nuovo_utente.nome + " - " + nuovo_utente.cognome + " - " + nuovo_utente.numero_di_telefono;
        
        // aggiungi l'elemento li alla lista
        listaNumeriElement.appendChild(listItem); // Qui è stato corretto il nome della variabile

    })

}

// Chiamata della funzione di scrittura su HTML tramite EventListener

document.addEventListener("DOMContentLoaded", function(){
    aggiungiNumeriAllaPagina();

    // aggiunta di un eventListener per intercettare il submit

    document.getElementById("form_aggiungi_numero").addEventListener("submit", aggiungiNuovoNumero);

});
// prima definisci l'evento e poi la funzione da chiamare
// DOMContentLoaded è un evento che viene lanciato quando il documento è stato completamente caricato e analizzato, senza attendere lo stile, le immagini e gli iframe per completare il caricamento.

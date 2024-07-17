
var libri = [
    {
        titolo: "Il signore degli anelli",
        autore: "J.R.R. Tolkien",
        annoPubblicazione: 1954
    },
    {
        titolo: "Harry Potter e la pietra filosofale",
        autore: "J.K. Rowling",
        annoPubblicazione: 1997
    },
    {
        titolo: "1984",
        autore: "George Orwell",
        annoPubblicazione: 1949
    }
];


// funzione per aggiungere un libro alla lista

function aggiungiNuovoLibro(event){

    // evitiamo il comportamento predefinito di submit del form che ricarica la pagina
    event.preventDefault();

    // recupera i dati dell'utente

    var titolo = document.getElementById("input_titolo").value;
    var autore = document.getElementById("input_autore").value;
    var annoPubblicazione = document.getElementById("input_anno").value;

    // crea un nuovo oggetto libro

    var nuovoLibro = {
        titolo: titolo,
        autore: autore,
        annoPubblicazione: annoPubblicazione
    };

    // aggiungi il nuovo libro all'array libri

    libri.push(nuovoLibro);

    // aggiorna la lista dei libri sul documento
    aggiungiLibriAllaPagina();

    // resetta i campi del form
    document.getElementById("form_aggiungi_libro").reset();

};

//funzione per creare e aggiungere elementi html alla lista dei libri

function aggiungiLibriAllaPagina(){

    var listaLibriElement = document.getElementById("lista-libri");

    // svuota la lista dei libri

    listaLibriElement.innerHTML = "";

    // cicliamo sull'array libri ed inseriamo un nuovo elemento li

    libri.forEach(function(libro){ 
        // "libro" in questo caso é un nome arbitrario, potrebbe essere qualsiasi cosa. l'utilitá 
        // é di passare un singolo elemento alla funzione forEach e rappresenta un singolo elemento dell'array libri

        // crea elemento li
        var listItem = document.createElement("li");

        // dai volore al testo dell'elemento li
        listItem.textContent = libro.titolo + " - " + libro.autore + " - " + libro.annoPubblicazione;
        
        // aggiungi l'elemento li alla lista
        listaLibriElement.appendChild(listItem);

    })

}

// Chiamata della funzione di scrittura su HTML tramite EventListener

document.addEventListener("DOMContentLoaded", function(){
    aggiungiLibriAllaPagina();

    // aggiunta di un eventListener per intercettare il submit

    document.getElementById("form_aggiungi_libro").addEventListener("submit", aggiungiNuovoLibro);

});
// prima definisci l'evento e poi la funzione da chiamare
// DOMContentLoaded è un evento che viene lanciato quando il documento è stato completamente caricato e analizzato, senza attendere lo stile, le immagini e gli iframe per completare il caricamento.

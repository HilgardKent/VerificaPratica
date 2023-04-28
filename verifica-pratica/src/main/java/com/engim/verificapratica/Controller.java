package com.engim.verificapratica;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private static Sorteggio sorteggio = new Sorteggio();
    //es1
    @GetMapping(value="/aggiungi")
    public void aggiungi(@RequestParam(value="nome") String name,@RequestParam(value="nazione") String nazione){
        sorteggio.aggiungi(name,nazione);
    }
    //es2
    @GetMapping(value="/seleziona")
    public List<Squadra> getSquadre(@RequestParam(value="nazione") String nazione){
        List<Squadra> squadre = sorteggio.getSquadre();
        Sorteggio squadreNazione = new Sorteggio();
        squadre = sorteggio.getSquadre();
        for(Squadra squadra : squadre){
            if(squadra.getNazione() == nazione){
                squadreNazione.aggiungi(squadra.getNome(), squadra.getNazione());
            }
        }
        return squadreNazione.getSquadre();
    }
    //es3
    @GetMapping(value="/seleziona")
    public List<Squadra> getDoppioSquadre(){
        List<Squadra> squadre = sorteggio.getSquadre();
        Sorteggio squadreNazione = new Sorteggio();
        String nazione = sorteggio.next().getNazione();
        String nome = sorteggio.next().getNome();
        squadreNazione.aggiungi(nome,nazione);
        for(Squadra squadra : squadre){
            String nazione1 = sorteggio.next().getNazione();
            String nome1 = sorteggio.next().getNome();
            if(!(nazione.equals(nazione1))){
                squadreNazione.aggiungi(nome1,nazione1);
            }
        }
        return squadreNazione.getSquadre();
    }
    //es4
    @GetMapping(value="/torneo")
    public List<Squadra> getSquadreTorneo(){
        List<Squadra> squadre = sorteggio.getSquadre();
        Sorteggio torneoSquadre = new Sorteggio();
        if(squadre.size()==)

            return torneoSquadre.getSquadre();
    }

    /*
    * ES 1: get ("/add?nome=n&nazione=m") che aggiunge al sorteggio una squadra con nome n e nazione m (utilizzare
    * la classe Sorteggio) - 15 p
    *
    * ES 2: get ("/listaSquadre?nazione=n") che restituisce la lista delle squadre di nazione n - 20 p
    *
    * ES 3: get ("/sorteggia") che restituisce 2 squadre di nazioni diverse (utilizzare la classe Sorteggio, il metodo
    * next. Consiglio: dopo aver sorteggiato la prima, continuare a sorteggiare finché la seconda
    * non è di una nazione diversa) - 20 p
    *
    * ES 4: implementare il sorteggio delle squadre di una fase finale di un torneo a eliminazione diretta.
    * Creare il metodo sorteggiaPartite che:0
    * - controlla se il numero di squadre aggiunte è una potenza di 2. Se non lo è lancia una RuntimeException.
    * - Finché ci sono squadre non sorteggiate: sorteggia 2 squadre e le inserisce in un oggetto della classe Partita (da creare)
    * - restituisce la lista di Partite.
    * creare get ("/getPartite") che restituisce la lista appena creata - 30 p
    * */

}

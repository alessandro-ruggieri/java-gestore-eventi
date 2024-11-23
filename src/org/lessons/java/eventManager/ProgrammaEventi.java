package org.lessons.java.eventManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProgrammaEventi {
    private String titolo;
    private List<Evento> eventi;

    // Costruttore
    public ProgrammaEventi(String titolo) {
        if (titolo == null || titolo.isBlank()) {
            throw new IllegalArgumentException("Il titolo del programma non può essere nullo o vuoto.");
        }
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    // Metodo per aggiungere un evento
    public void aggiungiEvento(Evento evento) {
        if (evento == null) {
            throw new IllegalArgumentException("L'evento da aggiungere non può essere nullo.");
        }
        eventi.add(evento);
    }

    // Metodo per ottenere eventi in una certa data
    public List<Evento> getEventiPerData(LocalDate data) {
        List<Evento> eventiInData = new ArrayList<>();
        for (Evento evento : eventi) {
            if (evento.getData().equals(data)) {
                eventiInData.add(evento);
            }
        }
        return eventiInData;
    }

    // Metodo per contare il numero di eventi
    public int getNumeroEventi() {
        return eventi.size();
    }

    // Metodo per svuotare la lista di eventi
    public void svuotaEventi() {
        eventi.clear();
    }

    // Metodo per ottenere una stringa con gli eventi ordinati per data
    public String getEventiOrdinati() {
        // Ordiniamo gli eventi usando Comparator.comparing
        eventi.sort(Comparator.comparing(Evento::getData));

        String risultato = "Programma: " + titolo + "\n";
        for (Evento evento : eventi) {
            risultato += evento.toString() + "\n"; 
        }
        return risultato;
    }

    @Override
    public String toString() {
        return "ProgrammaEventi{" +
                "titolo='" + titolo + '\'' +
                ", numero di eventi=" + eventi.size() +
                '}';
    }
}
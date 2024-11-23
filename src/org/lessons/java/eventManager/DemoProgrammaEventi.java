package org.lessons.java.eventManager;

import java.time.LocalDate;

public class DemoProgrammaEventi {
    public static void main(String[] args) {
        // Creazione del programma eventi
        ProgrammaEventi programma = new ProgrammaEventi("Eventi Estate 2025");

        // Creazione e aggiunta di alcuni eventi
        try {
            Evento evento1 = new Evento("Festa in spiaggia", LocalDate.of(2025, 7, 15), 100);
            Evento evento2 = new Evento("Sagra del paese", LocalDate.of(2025, 8, 20), 200);
            Evento evento3 = new Evento("Notte delle stelle", LocalDate.of(2025, 7, 15), 50);

            programma.aggiungiEvento(evento1);
            programma.aggiungiEvento(evento2);
            programma.aggiungiEvento(evento3);

            // Stampa del numero di eventi
            System.out.println("\nNumero totale di eventi: " + programma.getNumeroEventi());

            // Ricerca di eventi in una data specifica
            LocalDate dataRicerca = LocalDate.of(2025, 7, 15);
            System.out.println("\nEventi del " + dataRicerca + ":");
            for (Evento evento : programma.getEventiPerData(dataRicerca)) {
                System.out.println(evento);
            }

            // Stampa del programma completo ordinato per data
            System.out.println("\nEventi ordinati per data:");
            System.out.println(programma.getEventiOrdinati());

            // Svuotamento della lista di eventi
            programma.svuotaEventi();
            System.out.println("\nIl programma è stato svuotato. Eventi attuali: " + programma.getNumeroEventi());

        } catch (IllegalArgumentException e) {
            System.err.println("Errore: " + e.getMessage());
        }
    }
}

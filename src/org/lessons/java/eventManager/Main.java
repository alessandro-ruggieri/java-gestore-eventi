package org.lessons.java.eventManager;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // 1. Creazione del nuovo evento
            System.out.println("Benvenuto! Inserisci i dati per creare un nuovo evento.");

            System.out.print("Titolo dell'evento: ");
            String titolo = scanner.nextLine();

            System.out.println("Inserisci la data dell'evento:");
            System.out.print("Anno (es. 2024): ");
            int anno = scanner.nextInt();
            System.out.print("Mese (1-12): ");
            int mese = scanner.nextInt();
            System.out.print("Giorno (1-31): ");
            int giorno = scanner.nextInt();
            LocalDate dataEvento = LocalDate.of(anno, mese, giorno);

            System.out.print("Numero di posti totali: ");
            int postiTotali = scanner.nextInt();
            scanner.nextLine(); // Necessario per evitare l'input vuoto al prossimo scanner.nextLine

            // Passo tutti i parametri al costruttore di Evento che effettua i dovuti controlli
            Evento evento = new Evento(titolo, dataEvento, postiTotali);
            System.out.println("\nEvento creato con successo!");
            System.out.println("Dettagli evento: " + evento);

            // 2. Prenotazioni
            System.out.print("\nVuoi effettuare prenotazioni? (S/N): ");
            String rispostaPrenotazioni = scanner.nextLine();
            if (rispostaPrenotazioni.equalsIgnoreCase("S")) {
                boolean inputValido = false;
                while (!inputValido) {
                    System.out.print("Quante prenotazioni vuoi fare? ");
                    int prenotazioni = scanner.nextInt();
                    scanner.nextLine(); // Necessario per evitare l'input vuoto al prossimo scanner.nextLine

                    if (prenotazioni == 0) {
                        System.out.println("Nessuna prenotazione effettuata.");
                        inputValido = true;
                    } else if (prenotazioni < 0) {
                        System.err.println("Errore: il numero di prenotazioni non può essere negativo.");
                    } else if (prenotazioni > (evento.getPostiTotali() - evento.getPostiPrenotati())) {
                        System.err.println("Errore: non ci sono abbastanza posti disponibili per soddisfare la tua richiesta.");
                    } else {
                        for (int i = 0; i < prenotazioni; i++) {
                            evento.prenota();
                        }
                        System.out.println("Prenotazioni effettuate con successo!");
                        inputValido = true;
                    }
                }

                System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
                System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
            }

            // 3. Disdette
            System.out.print("\nVuoi disdire prenotazioni? (S/N): ");
            String rispostaDisdette = scanner.nextLine();
            if (rispostaDisdette.equalsIgnoreCase("S")) {
                boolean inputValido = false;
                while (!inputValido) {
                    System.out.print("Quante disdette vuoi effettuare? ");
                    int disdette = scanner.nextInt();
                    scanner.nextLine(); // Necessario per evitare l'input vuoto al prossimo scanner.nextLine

                    if (disdette == 0) {
                        System.out.println("Nessuna disdetta effettuata.");
                        inputValido = true;
                    } else if (disdette < 0) {
                        System.err.println("Errore: il numero di disdette non può essere negativo.");
                    } else if (disdette > evento.getPostiPrenotati()) {
                        System.err.println("Errore: non ci sono abbastanza prenotazioni da disdire.");
                    } else {
                        for (int i = 0; i < disdette; i++) {
                            evento.disdici();
                        }
                        System.out.println("Disdette effettuate con successo!");
                        inputValido = true;
                    }
                }

                System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
                System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
            }

            System.out.println("\nGrazie per aver usato il sistema di gestione eventi!");

        } catch (IllegalArgumentException e) {
            System.err.println("Errore durante la creazione dell'evento: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Errore generico: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
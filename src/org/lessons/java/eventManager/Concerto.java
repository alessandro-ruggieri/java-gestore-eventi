package org.lessons.java.eventManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
    private LocalDateTime dataEOra; 
    private double prezzo;          

    // Costruttore
    public Concerto(String titolo, LocalDateTime dataEOra, int postiTotali, double prezzo) {
        super(titolo, dataEOra.toLocalDate(), postiTotali); 

        if (dataEOra == null || dataEOra.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Data e ora non possono essere nulli o passati.");
        }
        this.dataEOra = dataEOra;

        if (prezzo < 0) {
            throw new IllegalArgumentException("Il prezzo non può essere negativo.");
        }
        this.prezzo = prezzo;
    }

    // Getter e setter
    public LocalDateTime getDataEOra() {
        return dataEOra;
    }

    public void setDataEOra(LocalDateTime dataEOra) {
        if (dataEOra == null || dataEOra.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Data e ora non possono essere nulli o passati.");
        }
        this.dataEOra = dataEOra;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        if (prezzo < 0) {
            throw new IllegalArgumentException("Il prezzo non può essere negativo.");
        }
        this.prezzo = prezzo;
    }

    // Metodo per restituire data e ora formattata
    public String getDataEOraFormattata() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataEOra.format(formatter);
    }

    // Metodo per restituire il prezzo formattato
    public String getPrezzoFormattato() {
        return String.format("%.2f€", prezzo);
    }

    // Override del metodo toString
    @Override
    public String toString() {
        return getDataEOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
    }
}

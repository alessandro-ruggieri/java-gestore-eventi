package org.lessons.java.eventManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati;
	
	
	Evento(String titolo, LocalDate data, int postiTotali) {
		this.postiPrenotati = 0;
		
		if (titolo == null || titolo.isBlank()) {
			throw new IllegalArgumentException("Il titolo non può essere nullo o vuoto.");
		} else {
			this.titolo = titolo;	
		} 
		
		if (data == null || data.isBefore(LocalDate.now())) {
	        throw new IllegalArgumentException("Data non valida. Inserire una data futura.");
	    } else {
	    	this.data = data;
	    }
	    
		
		if (postiTotali <= 0) {
			throw new IllegalArgumentException("Attenzione, il numero di posti totali disponibili deve essere maggiore di 0.");
		} else {
			this.postiTotali = postiTotali;
		}
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		if (titolo == null || titolo.isBlank()) {
            throw new IllegalArgumentException("Il titolo non può essere nullo o vuoto.");
        } else {
		this.titolo = titolo;
        }
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		if (data == null || data.isBefore(LocalDate.now())) {
	        throw new IllegalArgumentException("Data non valida. Inserire una data futura.");
	    } else {
	    	this.data = data;
	    }
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	public void prenota() {
		  if (data.isBefore(LocalDate.now())) {
	            System.out.println("Non puoi prenotare un evento già passato.");
	        } else if (postiPrenotati >= postiTotali) {
	            System.out.println("Non ci sono più posti disponibili.");
	        } else {
	            postiPrenotati++;
	            System.out.println("Prenotazione effettuata con successo!");
	        }
	}
	
	public void disdici() {
		if (data.isBefore(LocalDate.now())) {
            System.out.println("Non puoi disdire un evento già passato.");
        } else if (postiPrenotati == 0) {
            System.out.println("Non ci sono prenotazioni da disdire.");
        } else {
            postiPrenotati--;
            System.out.println("Disdetta effettuata con successo!");
        }
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formattaData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Data: " + data.format(formattaData) + " - Titolo: " + titolo;
	}
	
}

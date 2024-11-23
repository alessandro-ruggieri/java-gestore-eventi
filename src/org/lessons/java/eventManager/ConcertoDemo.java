package org.lessons.java.eventManager;

import java.time.LocalDateTime;

public class ConcertoDemo {
    public static void main(String[] args) {
        try {
            Concerto concerto = new Concerto(
                "Concerto Rock",
                LocalDateTime.of(2024, 12, 25, 21, 30),
                150,
                59.99
            );

            System.out.println("Dettagli del concerto:");
            System.out.println(concerto); // 
        } catch (IllegalArgumentException e) {
            System.err.println("Errore: " + e.getMessage());
        }
    }
}
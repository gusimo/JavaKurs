package com.codeflix;

import java.util.Scanner;

public class Main {

    private static Scanner input;

    public static void main(String[] args) {
        // Zuerst holen wir alle Variablen vom Anwender ab
        // Dazu wird die Hilfsklasse Scanner benötigt. Details zu Klassen folgen später, sie könne hier wie ein
        // eigener Variablen-Typ angesehen werden.

        input = new Scanner(System.in);

        int quotient = getQuotient();
        int counter = getCounter();
        boolean descending = getDescending();

        if (descending) {
            for (int i = counter; i > 0; i--) {
                if (i % quotient == 0) {
                    System.out.println(i);
                }
            }
        } else {
            for (int i = 1; i <= counter; i++) {
                if (i % quotient == 0) {
                    System.out.println(i);
                }
            }
        }

    }

    public static int getQuotient() {
        System.out.print("Wie ist der Teiler? ");
        int quotient = input.nextInt();

        // Prüfung der Eingabe und abbruch des Programms bei Fehlern
        if (quotient < 1 || quotient > 99) {
            programError("Der Teiler darf nur zwischen 1 und 99 liegen.");
        }

        return quotient;
    }

    public static int getCounter() {
        System.out.print("Bis wohin wird gezählt? ");
        int counter = input.nextInt();

        if (counter < 1) {
            programError("Der Teiler darf nur zwischen 1 und 99 liegen.");
        }

        return counter;
    }

    public static boolean getDescending() {
        System.out.print("Soll Rückwärts ausgegeben werden? (N/j)");
        String decision = input.next();

        // Gib den Standardwert aus, wenn der User nichts eingibt oder N
        if (decision.length() == 0 || decision.equalsIgnoreCase("n")) {
            return false;
        }

        if (decision.equalsIgnoreCase("j")) {
            return true;
        }

        // Wenn es weder ja noch nein ist, werfen wir einen Fehler
        programError("Geben Sie j oder n ein.");

        return false;
    }

    public static void programError(String message) {
        System.out.println("FEHLER:" + message);
        System.exit(1);
    }
}

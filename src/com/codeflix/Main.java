package com.codeflix;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int limit = 600;

        Date start = new Date();
        System.out.print(String.format("f(%d) = ", limit));
        // System.out.println(fibonacci(limit));
        System.out.println(fibonacciFast(limit));
        Date end = new Date();
        System.out.println((end.getTime() - start.getTime()) / 1000 + " Sekunden");
    }

    // Der einfache Ansatz. Nachteil: Die Berechnung wird immer und immer wiederholt, das frisst Zeit.
    public static long fibonacci(int n) {
        if (n==1 || n == 2) {
            return 1;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }

    // Die Hashmap ist wie ein Inhaltsverzeichnis, in diesem Fall findet man zu einem Integer einen passenden Long-Wert
    private static HashMap<Integer, Long> fibonacciCache = new HashMap<>();

    // Hier werden die vorherigen Ergebnisse zwischengespeichert, dadurch wird CPU Aufwand gegen Speicherverbrauch
    // getauscht und die Berechnung wird immens schneller.
    public static long fibonacciFast(int n) {

        if (n==1 || n == 2) {
            return 1;
        }

        // Schauen wir in den Cache, ob es schon ein ergebnis gibt
        if (fibonacciCache.containsKey(n)) {
            return fibonacciCache.get(n);
        }

        // Berechnen wir den Wert neu, benutzen dabei jedoch auch unseren Cache.
        long result = fibonacciFast(n-1) + fibonacciFast(n-2);

        // Neue Ergebnisse legen wir in den Cache
        fibonacciCache.put(n, result);

        return result;
    }

}

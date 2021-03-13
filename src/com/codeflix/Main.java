package com.codeflix;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        var arr= getRandomArray();

        // wir müssen speichern, welche Zahlen wir schon gesehen haben.
        // Dazu wird eine dynamische Liste erzeugt, welche sich ähnlich wie ein Array verhält, man aber die Größe
        // nicht vorab festlegen muss.
        ArrayList<Integer> uniqueList = new ArrayList<>();

        // Wir iterieren über das Array
        for (int item: arr ) {
            // Wir prüfen, ob unsere Liste den Eintrag des Arrays noch nicht enthält, fügen es dann ein
            if( ! uniqueList.contains(item)) {
                uniqueList.add(item);
            }
        }

        System.out.println(String.format("Unterschiedliche Einträge: %d", uniqueList.stream().count()));

    }

    public static int[] getRandomArray() {
        // Wir erzeugen einen Zufallszahlengenerator
        Random rd = new Random();

        // Wir bereiten unser Array vor
        int[] arr = new int[10];

        // Wir füllen jedes Feld des Array mit einer Zufallszahl
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(20); // hier wird eine Random zahl zwischen 1 und 20 gewählt
            System.out.println(arr[i]); // Ausgabe zur Überprüfung
        }

        return arr;
    }

}

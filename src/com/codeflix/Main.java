package com.codeflix;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Zuerst legen wir die Variablen fest, sie können natürlich auch vom Benutzer abgefragt werden
        int age = 56;
        double income = 2000.00;
        boolean house = true;
        String gender = "Male";

        // Wir schließen zuers die Altersgrenzen aus
        if ( age < 18 || ( house && age > 70 ) || ( !house && age > 55 ) ) {
            System.out.println("Das Alter passt nicht");
            return;
        }

        // Dann bestimmen wir das Alter, bis zu dem gerechnet werden darf
        int maximumAge = 55;
        if (house) {
            if (gender.equalsIgnoreCase("male")) {
                maximumAge = 70;
            }
            if (gender.equalsIgnoreCase("female")) {
                maximumAge = 74;
            }
        }

        // Jetzt bestimmen wir den Kreditbetrag
        int maximumMonths = (maximumAge - age) * 12;
        double maxCredit = maximumMonths * income;
        
        System.out.println(String.format("%.2f Euro", maxCredit));
    }
}

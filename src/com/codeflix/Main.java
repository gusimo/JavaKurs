package com.codeflix;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String mitarbeiterName1 = "Ellen Lang";
        int mitarbeiterGehalt1 = 20;
        boolean mitarbeiterTeilzeit1 = false;
        int mitarbeiterUrlaubstage1 = 30;

        String mitarbeiterName2 = "Rainer Zufall";
        int mitarbeiterGehalt2 = 22;
        boolean mitarbeiterTeilzeit2 = true;
        int mitarbeiterUrlaubstage2 = 30;

        String mitarbeiterName3 = "Volker Racho";
        int mitarbeiterGehalt3 = 25;
        boolean mitarbeiterTeilzeit3 = false;
        boolean mitarbeiterManagement3 = true;
        int mitarbeiterUrlaubstage3 = 30;

        rechneGehalt(mitarbeiterName1, mitarbeiterGehalt1, mitarbeiterTeilzeit1, false);
        rechneGehalt(mitarbeiterName2, mitarbeiterGehalt2, mitarbeiterTeilzeit2, false);
        rechneGehalt(mitarbeiterName3, mitarbeiterGehalt3, mitarbeiterTeilzeit3, mitarbeiterManagement3);

    }

    private static double rechneGehalt(String name, int gehalt, boolean teilzeit, boolean management) {
        int stunden = teilzeit ? 20 : 40;
        double individualGehalt = management ? gehalt * 1.2 : gehalt;
        double result = stunden * individualGehalt;

        System.out.println(String.format("Das Gehalt für %s ist %.2f", name, result));

        return result;
    }
}

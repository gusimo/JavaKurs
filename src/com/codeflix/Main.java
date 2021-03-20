package com.codeflix;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Mitarbeiter> meineMitarbeiter = new ArrayList<>();

        meineMitarbeiter.add(new Mitarbeiter("Ellen Lang", 20, false));
        meineMitarbeiter.add(new Mitarbeiter("Rainer Zufall", 22, true));
        meineMitarbeiter.add(new Manager("Volker Racho", 25, false));

        for (Mitarbeiter ma:meineMitarbeiter) {
            ma.rechneGehalt();
        }
    }
}

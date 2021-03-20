package com.codeflix;

public class Mitarbeiter {

    public String Name;
    public int Gehalt;
    public boolean Teilzeit;

    public Mitarbeiter(String name, int gehalt, boolean teilzeit) {
        Name = name;
        Gehalt = gehalt;
        Teilzeit = teilzeit;
    }

    public int stunden() {
        return this.Teilzeit ? 20 : 40;
    }

    public double individualGehalt() {
        return Gehalt;
    }

    public double rechneGehalt() {
        double result = stunden() * individualGehalt() *4;

        System.out.println(String.format("Das Gehalt für %s ist %.2f", Name, result));

        return result;
    }

}

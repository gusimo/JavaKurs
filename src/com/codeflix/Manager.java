package com.codeflix;

public class Manager extends Mitarbeiter{
    public Manager(String name, int gehalt, boolean teilzeit) {
        super(name, gehalt, teilzeit);
    }

    @Override
    public double individualGehalt() {
        return super.individualGehalt() * 1.2;
    }
}

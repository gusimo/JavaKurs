package com.codeflix;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


class MitarbeiterTests {

    @Test
    void Vollzeit() {
        Mitarbeiter ma = new Mitarbeiter("TEST", 10, false);
        assertEquals(10*40*4, ma.rechneGehalt());
    }

    @Test
    void Teilzeit() {
        Mitarbeiter ma = new Mitarbeiter("TEST", 10, true);
        assertEquals(10*20*4, ma.rechneGehalt());
    }

}


package com.codeflix;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> lotto = new ArrayList<>();
        Random random = new Random();

        while (lotto.stream().count() < 6) {
            int ball = random.nextInt(49);

            if (!lotto.contains(ball)) {
                lotto.add(ball);
            }
        }

        Collections.sort(lotto);

        for (int i=0; i < lotto.stream().count(); i++) {
            if (i >0) {
                System.out.print(", ");
            }

            System.out.print(lotto.get(i));
        }
    }
}

package com.codeflix;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            if (i % 4 == 0 || i % 7 == 0) {
                if (i % 4 == 0) {
                    System.out.print("Fizz");
                }
                if (i % 7 == 0) {
                    System.out.print("Buzz");
                }

                System.out.println("");
            } else {
                System.out.println(i);
            }
        }
    }
}

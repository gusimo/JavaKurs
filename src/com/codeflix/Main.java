package com.codeflix;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Die ist unser vorgegebener String. Die \ müssen verdoppelt werden, weil diese in fast allen
        // Programmiersprachen ein Sonderzeichen einleiten. \n steht zum Beispiel für eine neue Zeile.
        String myString = "C:\\Downloads\\Testtabelle_2020_12_31.csv";

        // Wir suchen mit lastIndexOf die position des letzten Backslash. Der String verhält sich hier so wie
        // ein Array aus Buchstaben
        int lastBackslashPosition = myString.lastIndexOf("\\");

        // Nun kopieren wir den Teilstring ab der Position hinter dem letzten Backslash. So erhalten wir den Dateinamen.
        String fullFilename = myString.substring(lastBackslashPosition + 1);

        // Das Datum besteht aus Zahlen, diese Konvertieren wir zuerst in einen passenden String
        String currentDateString = String.format("%d_%02d_%02d",
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );

        // Nun ersetzen wir das Datum
        fullFilename = fullFilename.replace("2020_12_31", currentDateString );

        // Mit Substring und der Länge des Strings trennen wir die Dateiendung ab
        String fileName = fullFilename.substring(0,fullFilename.length()-4);
        String fileExtension = fullFilename.substring(fullFilename.length()-3,fullFilename.length());


        System.out.println(fullFilename);
        System.out.println("Dateiname: " + fileName);
        System.out.println("Dateiendung: " + fileExtension);
    }
}

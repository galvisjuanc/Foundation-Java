package jcgc.play.util;

import jcgc.play.content.Genre;

import java.util.Scanner;

public class ScannerUtils {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static String getText(String message) {
        System.out.println(message + ": ");
        return SCANNER.nextLine();
    }

    public static int getInt(String message) {
        System.out.print(message + ": ");

        while(!SCANNER.hasNextInt()) {
            System.out.println("Not a valid option --> " + message + ": ");
            SCANNER.next();
        }

        int value = SCANNER.nextInt();
        SCANNER.nextLine();
        return value;
    }

    public static double getDouble(String message) {
        System.out.println(message + ": ");

        while(!SCANNER.hasNextDouble()) {
            System.out.println("Not a valid option --> " + message + ": ");
            SCANNER.next();
        }

        double value = SCANNER.nextDouble();
        SCANNER.nextLine();
        return value;
    }

    public static Genre getGenre(String message) {
        while (true) {
            System.out.println(message + "... Options: ");
            for(Genre genre : Genre.values()) {
                System.out.println("- " + genre.name());
            }

            System.out.println("Which one? --> ");
            String genreInput = SCANNER.nextLine();

            try {
                return Genre.valueOf(genreInput.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Not a valid genre --> " + message);
            }
        }
    }
}

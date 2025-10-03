package jcgc.play.util;

import java.util.Scanner;

public class ScannerUtils {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static String getText(String message) {
        System.out.println(message + ": ");
        return SCANNER.nextLine();
    }

    public static int getInt(String message) {
        System.out.println(message + ": ");

        int value = SCANNER.nextInt();
        SCANNER.nextLine();
        return value;
    }

    public static double getDouble(String message) {
        System.out.println(message + ": ");

        double value = SCANNER.nextDouble();
        SCANNER.nextLine();
        return value;
    }
}

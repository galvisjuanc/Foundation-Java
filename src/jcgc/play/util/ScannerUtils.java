package jcgc.play.util;

import java.util.Scanner;

public class ScannerUtils {

    public static Scanner scanner = new Scanner(System.in);

    public String getText(String message) {
        System.out.println(message + ": ");
        return scanner.nextLine();
    }

    public int getInt(String message) {
        System.out.println(message + ": ");

        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}

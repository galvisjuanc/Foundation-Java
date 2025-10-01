package jcgc.play.util;

import java.util.Scanner;

public class ScannerUtils {

    public static Scanner scanner = new Scanner(System.in);

    public String getText(String message) {
        System.out.println(message + ": ");
        return scanner.nextLine();
    }
}

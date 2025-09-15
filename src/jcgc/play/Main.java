package jcgc.play;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World 😁");

        Scanner sc = new Scanner(System.in);
        System.out.println("Cuál es tu nombre?: ");

        String name = sc.nextLine();
        System.out.println("Hola " + name + ", esto es jcgc play!");

    }
}

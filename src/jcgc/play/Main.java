package jcgc.play;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("JCGC Play 😎");

        Scanner sc = new Scanner(System.in);
        System.out.println("Cuál es tu nombre?: ");

        String name = sc.nextLine();
        System.out.println("Hola " + name + ", esto es jcgc play!");

        System.out.println(name + ", ¿cuantos años tienes?");
        int age = sc.nextInt();

        if (age >= 18) {
            System.out.println(name + ", puedes ver contenido de adultos por ser mayor de edad");
        } else {
            System.out.println("No puedes ver este contenido. Tienes prohibido el acceso");
        }

    }
}

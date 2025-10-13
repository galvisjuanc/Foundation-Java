package jcgc.play;

import jcgc.play.content.Movie;

public class MainStackHeap {
    public static void main(String[] args) {
        Movie movieLionKing = new Movie("El Rey Leon", 135, "Animada");
        Movie movieHarryPotter = new Movie("Harry Poter", 200, "Ciencia Ficción");

        movieLionKing = movieHarryPotter;
        movieLionKing.title = "Spiderman";

        System.out.println("LionKing: " + movieLionKing.title);
        System.out.println("Harry Potter: " + movieHarryPotter.title);
    }
}

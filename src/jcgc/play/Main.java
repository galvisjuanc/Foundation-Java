package jcgc.play;

import jcgc.play.content.Movie;
import jcgc.play.platform.User;

public class Main {

    public static void main(String[] args) {
        System.out.println("JCGC Play 😎");

        Movie movie = new Movie();
        movie.title = "El señor de los anillos";
        movie.description = "Mi preciosoooooo!";
        movie.releaseYear = 2001;
        movie.genre = "Fantasia";
        movie.giveScore(4.7);

        User user = new User();
        user.name = "Juan";

        System.out.println(movie.getTechnicalDatasheet());
        user.watch(movie);

    }
}

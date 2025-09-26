package jcgc.play;

import jcgc.play.content.Movie;
import jcgc.play.platform.User;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        System.out.println("JCGC Play 😎");

        Movie movie = new Movie();
        movie.title = "El señor de los anillos";
        movie.description = "Mi preciosoooooo!";
        movie.releaseDate = LocalDate.of(2001, 1, 1);
        movie.genre = "Fantasia";
        movie.giveScore(4.7);
        movie.duration = 120;

        User user = new User();
        user.name = "Juan";

        System.out.println(movie.getTechnicalDatasheet());
        user.watch(movie);

        long durationLong = movie.duration;
        System.out.println("Duration in Long: " + durationLong);

        int calificationInt = (int) movie.score;
        System.out.println("Calification integer: " + calificationInt);

    }
}

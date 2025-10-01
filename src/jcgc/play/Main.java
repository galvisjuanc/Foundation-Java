package jcgc.play;

import jcgc.play.content.Movie;
import jcgc.play.platform.User;
import jcgc.play.util.ScannerUtils;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        System.out.println("JCGC Play 😎");

        String name = ScannerUtils.getText("Content Name");
        String genre = ScannerUtils.getText("Genre");
        int duration = ScannerUtils.getInt("Duration");
        double score = ScannerUtils.getDouble("Score");

        Movie movie = new Movie();
        movie.title = name;
        movie.description = "Mi preciosoooooo!";
        movie.releaseDate = LocalDate.of(2001, 1, 1);
        movie.genre = genre;
        movie.giveScore(score);
        movie.duration = duration;

        User user = new User();
        user.name = "Juan";

        System.out.println(movie.getTechnicalDatasheet());
        user.watch(movie);

        long durationLong = movie.duration;
        System.out.println("Duration in Long: " + durationLong);

        int calificationInt = (int) movie.score;
        System.out.println("Calification integer: " + calificationInt);

        int prizeNumber = (int) Long.parseLong("25");

        System.out.println("Prize number: " + prizeNumber);

    }
}

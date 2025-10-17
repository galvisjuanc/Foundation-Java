package jcgc.play;

import jcgc.play.content.Movie;
import jcgc.play.platform.Platform;
import jcgc.play.platform.User;
import jcgc.play.util.ScannerUtils;

public class Main {

    public static final String PLATFORM_NAME = "JCGC Play 😎";
    public static final String VERSION = "1.0.0";

    public static void main(String[] args) {
        System.out.println(PLATFORM_NAME + " v" + VERSION);

        Platform platform = new Platform(PLATFORM_NAME);

        String name = ScannerUtils.getText("Content Name");
        String genre = ScannerUtils.getText("Genre");
        int duration = ScannerUtils.getInt("Duration");
        double score = ScannerUtils.getDouble("Score");

        Movie movie = new Movie(name, duration, genre, score);
        platform.addMovie(movie);

        System.out.println("Element Size of the list: " + platform.getMovies().size());

        User user = new User("Juan", "juang@hotmail.com");

        System.out.println(movie.getTechnicalDatasheet());
        platform.showTitle();
        user.watch(movie);
    }
}

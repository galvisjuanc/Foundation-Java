package jcgc.play;

import jcgc.play.content.Movie;
import jcgc.play.platform.Platform;
import jcgc.play.util.ScannerUtils;

public class Main {

    public static final String PLATFORM_NAME = "JCGC Play 😎";
    public static final String VERSION = "1.0.0";

    public static final int ADD = 1;
    public static final int SHOW_EVERYTHING = 2;
    public static final int LOOK_TITLE = 3;
    public static final int DELETE = 4;
    public static final int EXIT = 5;

    public static void main(String[] args) {
        Platform platform = new Platform(PLATFORM_NAME);
        System.out.println(PLATFORM_NAME + " v" + VERSION);

        while (true) {
            int optionChosen = ScannerUtils.getInt("""
                    Choose an option:
                    1. Add Content.
                    2. Show Everything.
                    3. Look for Title.
                    4. Delete.
                    5. Exit.
                    
                    Option 
                    """);

            System.out.println("Chosed Option: " + optionChosen);

            switch (optionChosen) {
                case ADD -> {

                    String name = ScannerUtils.getText("Content Name");
                    String genre = ScannerUtils.getText("Genre");
                    int duration = ScannerUtils.getInt("Duration");
                    double score = ScannerUtils.getDouble("Score");

                    platform.addMovie(new Movie(name, duration, genre, score));
                }
                case SHOW_EVERYTHING -> platform.showTitles();
                case LOOK_TITLE -> {

                }
                case DELETE -> {

                }

                case EXIT -> System.exit(0);
            }
        }

        /*

        System.out.println("Element Size of the list: " + platform.getMovies().size());

        User user = new User("Juan", "juang@hotmail.com");

        System.out.println(movie.getTechnicalDatasheet());

        platform.showTitle();
        user.watch(movie);*/
    }
}

package jcgc.play;

import jcgc.play.content.Movie;
import jcgc.play.platform.Platform;
import jcgc.play.util.ScannerUtils;

import java.util.List;

public class Main {

    public static final String PLATFORM_NAME = "JCGC Play 😎";
    public static final String VERSION = "1.0.0";

    public static final int ADD = 1;
    public static final int SHOW_EVERYTHING = 2;
    public static final int LOOK_TITLE = 3;
    public static final int LOOK_GENRE = 4;
    public static final int LOOK_POPULAR_MOVIES = 5;
    public static final int DELETE = 8;
    public static final int EXIT = 9;

    public static void main(String[] args) {
        Platform platform = new Platform(PLATFORM_NAME);
        System.out.println(PLATFORM_NAME + " v" + VERSION);

        loadMovies(platform);
        System.out.println("More than " + platform.getTotalDuration() + " minutes of content! \n");

        while (true) {
            int optionChosen = ScannerUtils.getInt("""
                    Choose an option:
                    1. Add Content.
                    2. Show Everything.
                    3. Look for Title.
                    4. Look for Genre.
                    5. Look for Popular Movies.
                    8. Delete.
                    9. Exit.
                    
                    Option -->
                    """);

            switch (optionChosen) {
                case ADD -> {
                    String name = ScannerUtils.getText("Content Name");
                    String genre = ScannerUtils.getText("Genre");
                    int duration = ScannerUtils.getInt("Duration");
                    double score = ScannerUtils.getDouble("Score");

                    platform.addMovie(new Movie(name, duration, genre, score));
                }

                case SHOW_EVERYTHING -> {
                    List<String> showMovieTitles = platform.showTitles();
                    showMovieTitles.forEach(System.out::println);
                }

                case LOOK_TITLE -> {
                    String lookTitle = ScannerUtils.getText("Name of the movie by title to look for: ");
                    Movie movie = platform.lookForTitle(lookTitle);

                    if (movie != null) {
                        System.out.println(movie.getTechnicalDatasheet());
                    } else {
                        System.out.println(lookTitle + " does not exist inside the platform --> " + platform.getName());
                    }
                }

                case LOOK_GENRE -> {
                    String lookGenre = ScannerUtils.getText("Name of the Genre we're looking for: ");

                    List<Movie> moviesByGenre = platform.lookForGenre(lookGenre);
                    System.out.println(moviesByGenre.size() + " found for this genre: " + lookGenre);
                    moviesByGenre.forEach(contentMovies -> System.out.println(contentMovies.getTechnicalDatasheet() + "\n"));
                }

                case LOOK_POPULAR_MOVIES -> {
                    int quantity = ScannerUtils.getInt("Quantity of movies to look for: ");
                    List<Movie> popularMovies = platform.getPopularMovies(quantity);

                    popularMovies.forEach(contentMovies -> System.out.println(contentMovies.getTechnicalDatasheet() + "\n"));
                }

                case DELETE -> {
                    String titleToDelete = ScannerUtils.getText("Name of the movie by title to delete: ");
                    Movie movie = platform.lookForTitle(titleToDelete);

                    if (movie != null) {
                        platform.deleteMovie(movie);
                        System.out.println("The movie has been deleted from the platform. --> " + movie.getTitle());
                    } else  {
                        System.out.println(titleToDelete + " does not exist inside the platform --> " + platform.getName());
                    }
                }

                case EXIT -> System.exit(0);
            }
        }
    }

    private static void loadMovies(Platform platform) {
        platform.addMovie(new Movie("Shrek", 90, "Comedy", 4));
        platform.addMovie(new Movie("Inception", 148, "Science Fiction"));
        platform.addMovie(new Movie("Titanic", 195, "Drama", 4.6));
        platform.addMovie(new Movie("John Wick", 110, "Action", 4.2));
        platform.addMovie(new Movie("El Conjuro", 120, "Thriller", 3.0));
        platform.addMovie(new Movie("Finding Nemo", 100, "Comedy", 4.3));
        platform.addMovie(new Movie("Interstellar", 169, "Science Fiction", 5));
        platform.addMovie(new Movie("Joker", 130, "Drama", 4.7));
        platform.addMovie(new Movie("Toy Story", 85, "Animada",5));
        platform.addMovie(new Movie("Avengers: Endgame", 181, "Action", 4.8));
    }
}

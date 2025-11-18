package jcgc.play;

import jcgc.play.content.*;
import jcgc.play.exception.MovieExistException;
import jcgc.play.platform.Platform;
import jcgc.play.util.FileUtils;
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
    public static final int PLAY = 6;
    public static final int LOOK_FOR_TYPE = 7;
    public static final int LOOK_FOR_GENRES = 8;
    public static final int DELETE = 8;
    public static final int EXIT = 9;

    public static void main(String[] args) {
        Platform platform = new Platform(PLATFORM_NAME);
        System.out.println(PLATFORM_NAME + " v" + VERSION);

        loadMovies(platform);
        System.out.println("More than " + platform.getTotalDuration() + " minutes of content movies! \n");

        while (true) {
            int optionChosen = ScannerUtils.getInt("""
                    Choose an option:
                    1. Add Content.
                    2. Show Everything.
                    3. Look for Title.
                    4. Look for Genre.
                    5. Look for Popular Movies.
                    6. Play.
                    7. Look for type.
                    8. Delete.
                    9. Exit.
                    
                    Option -->
                    """);

            switch (optionChosen) {
                case ADD -> {
                    int contentType = ScannerUtils.getInt("What type of content do you want to add?\n1. Movie.\n2. Documental. ");

                    String name = ScannerUtils.getText("Content Name");
                    Genre genre = ScannerUtils.getGenre("Genre");
                    int duration = ScannerUtils.getInt("Duration");
                    double score = ScannerUtils.getDouble("Score");

                    try {
                        if (contentType == 1) {
                            platform.addMovie(new Content(name, duration, genre, score));
                        } else {
                            String narrator = ScannerUtils.getText("Narrator Name: ");
                            platform.addMovie(new Documental(name, duration, genre, score, narrator));
                        }
                    } catch (MovieExistException e) {
                        System.out.println(e.getMessage());
                    }

                }

                case SHOW_EVERYTHING -> {
                    List<SummaryContent> showMovieTitles = platform.getSummaryContents();
                    showMovieTitles.forEach(summaryContent -> System.out.println(summaryContent.toString()));
                }

                case LOOK_TITLE -> {
                    String lookTitle = ScannerUtils.getText("Name of the movie by title to look for: ");
                    Content content = platform.lookForTitle(lookTitle);

                    if (content != null) {
                        System.out.println(content.getTechnicalDatasheet());
                    } else {
                        System.out.println(lookTitle + " does not exist inside the platform --> " + platform.getName());
                    }
                }

                case LOOK_GENRE -> {
                    Genre lookGenre = ScannerUtils.getGenre("Name of the Genre we're looking for: ");

                    List<Content> moviesByGenre = platform.lookForGenre(lookGenre);
                    System.out.println(moviesByGenre.size() + " found for this genre: " + lookGenre);
                    moviesByGenre.forEach(contentMovies -> System.out.println(contentMovies.getTechnicalDatasheet() + "\n"));
                }

                case LOOK_POPULAR_MOVIES -> {
                    int quantity = ScannerUtils.getInt("Quantity of movies to look for: ");
                    List<Content> popularContents = platform.getPopularMovies(quantity);

                    popularContents.forEach(contentMovies -> System.out.println(contentMovies.getTechnicalDatasheet() + "\n"));
                }

                case PLAY -> {
                    String playTitle = ScannerUtils.getText("Name of the movie by title to play: ");
                    Content content = platform.lookForTitle(playTitle);

                    if (content != null) {
                        platform.playMovie(content);
                        System.out.println("The movie has been deleted from the platform. --> " + content.getTitle());
                    } else  {
                        System.out.println(playTitle + " does not exist.");
                    }
                }

                case LOOK_FOR_TYPE -> {
                    int contentType = ScannerUtils.getInt("What type of content do you want to look for?\n1. Movie.\n2. Documental. ");

                    if(contentType == 1) {
                        List<Movie> movieList = platform.getAllMovies();
                        movieList.forEach(contentMovies -> System.out.println(contentMovies.getTechnicalDatasheet() + "\n"));
                    } else {
                        List<Documental> documentalList = platform.getAllDocumentals();
                        documentalList.forEach(contentDocumental -> System.out.println(contentDocumental.getTechnicalDatasheet() + "\n"));
                    }
                }

                case DELETE -> {
                    String titleToDelete = ScannerUtils.getText("Name of the movie by title to delete: ");
                    Content content = platform.lookForTitle(titleToDelete);

                    if (content != null) {
                        platform.deleteMovie(content);
                        System.out.println("The movie has been deleted from the platform. --> " + content.getTitle());
                    } else  {
                        System.out.println(titleToDelete + " does not exist inside the platform --> " + platform.getName());
                    }
                }

                case EXIT -> System.exit(0);
            }
        }
    }

    private static void loadMovies(Platform platform) {
        platform.getMovies().addAll(FileUtils.readContentMovies());
    }
}

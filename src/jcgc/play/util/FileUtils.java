package jcgc.play.util;

import jcgc.play.content.Genre;
import jcgc.play.content.Movie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static final String FILE_NAME = "content.txt";
    public static final String SEPARATOR = "|";

    public static void writeContent(Movie movieContent) {
        String line = String.join(SEPARATOR,
                movieContent.getTitle(),
                String.valueOf(movieContent.getDuration()),
                movieContent.getGenre().name(),
                String.valueOf(movieContent.getScore()),
                movieContent.getReleaseDate().toString()
        );

        System.out.println(line);
    }

    public static List<Movie> readContentMovies() {
        List<Movie> moviesFromFileContent = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));

            lines.forEach(line -> {
                String[] data = line.split("\\" + SEPARATOR);

                if (data.length == 5) {
                    String title = data[0];
                    int duration = Integer.parseInt(data[1]);
                    Genre genre = Genre.valueOf(data[2].toUpperCase());
                    double score = data[3].isBlank() ? 0 : Double.parseDouble(data[3]);
                    LocalDate releaseDate = LocalDate.parse(data[4]);

                    Movie movie = new Movie(title, duration, genre, score);
                    movie.setReleaseDate(releaseDate);

                    moviesFromFileContent.add(movie);
                }

            });
        } catch (IOException e) {
            System.out.println("Error reading content.txt");
        }

        return moviesFromFileContent;
    }
}

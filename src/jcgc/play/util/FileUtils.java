package jcgc.play.util;

import jcgc.play.content.Documental;
import jcgc.play.content.Genre;
import jcgc.play.content.Content;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static final String FILE_NAME = "content.txt";
    public static final String SEPARATOR = "|";

    public static void writeContent(Content movieContent) {
        String line = String.join(SEPARATOR,
                movieContent.getTitle(),
                String.valueOf(movieContent.getDuration()),
                movieContent.getGenre().name(),
                String.valueOf(movieContent.getScore()),
                movieContent.getReleaseDate().toString()
        );

        String finalLine;

        if(movieContent instanceof Documental documental) {
            finalLine = "DOCUMENTAL" + SEPARATOR + line + SEPARATOR + documental.getNarrator();
        } else {
            finalLine = "MOVIE" + SEPARATOR + line;
        }

        try {
            Files.writeString(Paths.get(FILE_NAME),
                    line + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Error writing the file. " + e.getMessage());
        }
    }

    public static List<Content> readContentMovies() {
        List<Content> moviesFromFileContent = new ArrayList<>();

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

                    Content content = new Content(title, duration, genre, score);
                    content.setReleaseDate(releaseDate);

                    moviesFromFileContent.add(content);
                }

            });
        } catch (IOException e) {
            System.out.println("Error reading content.txt");
        }

        return moviesFromFileContent;
    }
}

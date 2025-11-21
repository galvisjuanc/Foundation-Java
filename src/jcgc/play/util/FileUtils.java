package jcgc.play.util;

import jcgc.play.content.Documental;
import jcgc.play.content.Genre;
import jcgc.play.content.Content;
import jcgc.play.content.Movie;

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
                    finalLine + System.lineSeparator(),
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

                String typeContent = data[0];

                if(("MOVIE".equals(typeContent) && data.length == 6) ||
                        ("DOCUMENTAL".equals(typeContent) && data.length == 7)) {

                    String title = data[1];
                    int duration = Integer.parseInt(data[2]);
                    Genre genre = Genre.valueOf(data[3].toUpperCase());
                    double score = data[4].isBlank() ? 0 : Double.parseDouble(data[4]);
                    LocalDate releaseDate = LocalDate.parse(data[5]);

                    Content content;

                    if("MOVIE".equals(typeContent)) {
                        content = new Movie(title, duration, genre, score);
                    } else {
                        String narrator = data[6];
                        content = new Documental(title, duration,genre,score,narrator);
                    }

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

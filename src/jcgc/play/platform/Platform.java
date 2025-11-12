package jcgc.play.platform;

import jcgc.play.content.Genre;
import jcgc.play.content.Movie;
import jcgc.play.content.SummaryContent;
import jcgc.play.exception.MovieExistException;
import jcgc.play.util.FileUtils;

import java.util.*;

public class Platform {
    private String name;
    private List<Movie> movies;
    private Map<Movie, Integer> moviesMapViews;

    public Platform(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
        this.moviesMapViews = new HashMap<>();
    }

    public void addMovie(Movie movie) {

        Movie movieContent = this.lookForTitle(movie.getTitle());

        if (movieContent != null) {
            throw new MovieExistException(movie.getTitle());
        }

        FileUtils.writeContent(movie);
        this.movies.add(movie);
    }

    public void playMovie(Movie movie) {
        int actualCounter = moviesMapViews.getOrDefault(movie, 0);
        System.out.println(movie.getTitle() + " has been played " +  actualCounter + " times.");

        this.viewerCounter(movie);
        movie.play();
    }

    private void viewerCounter(Movie movie) {
        int actualCounter = moviesMapViews.getOrDefault(movie, 0);
        moviesMapViews.put(movie, actualCounter + 1);
    }

    public List<String> showTitles() {
        return movies.stream()
                .map(Movie::getTitle)
                .toList();
    }

    public List<SummaryContent> getSummaryContents() {
        return movies.stream()
                .map(mc -> new SummaryContent(mc.getTitle(), mc.getDuration(), mc.getGenre()))
                .toList();
    }

    public void deleteMovie(Movie movie) {
        this.movies.remove(movie);
    }

    public Movie lookForTitle(String title) {
        return movies.stream()
                .filter(movieContent -> movieContent.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public List<Movie> lookForGenre(Genre genre) {
        return movies.stream()
                .filter(movieContent -> movieContent.getGenre().equals(genre))
                .toList();
    }

    public int getTotalDuration() {
        return movies.stream()
                .mapToInt(Movie::getDuration)
                .sum();
    }

    public List<Movie> getPopularMovies(int quantity) {
        return movies.stream()
                .sorted(Comparator.comparing(Movie::getScore).reversed())
                .limit(quantity)
                .toList();
    }

    public String getName() {
        return name;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}

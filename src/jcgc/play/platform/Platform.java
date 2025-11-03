package jcgc.play.platform;

import jcgc.play.content.Movie;

import java.util.ArrayList;
import java.util.List;

public class Platform {
    private String name;
    private List<Movie> movies;

    public Platform(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

    public List<String> showTitles() {
        return movies.stream()
                .map(Movie::getTitle)
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

    public List<Movie> lookForGenre(String genre) {
        return movies.stream()
                .filter(movieContent -> movieContent.getGenre().equalsIgnoreCase(genre))
                .toList();
    }

    public int getTotalDuration() {
        return movies.stream()
                .mapToInt(Movie::getDuration)
                .sum();
    }

    public String getName() {
        return name;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}

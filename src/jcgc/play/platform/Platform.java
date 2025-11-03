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

    public void showTitles() {
        movies.forEach(movieContent -> System.out.println(movieContent.getTitle()));
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

    public String getName() {
        return name;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}

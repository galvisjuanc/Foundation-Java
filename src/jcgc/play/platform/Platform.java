package jcgc.play.platform;

import jcgc.play.content.Movie;

import java.util.List;

public class Platform {
    private String name;
    private List<Movie> movies;

    public Platform(String name) {
        this.name = name;
    }

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

    public String getName() {
        return name;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}

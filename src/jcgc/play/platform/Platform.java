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

    public void showTitle() {
        for (Movie movie : this.movies) {
            System.out.println(movie.getTitle());
        }
    }

    public String getName() {
        return name;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}

package jcgc.play.platform;

import jcgc.play.content.Movie;

public class User {

    public String name;
    public String email;

    public void watch(Movie movie) {
        movie.play();
    }
}

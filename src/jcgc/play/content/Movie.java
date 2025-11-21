package jcgc.play.content;

public class Movie extends Content{
    public Movie(String title, int duration, Genre genre, double score) {
        super(title, duration, genre, score);
    }

    @Override
    public void play() {
        System.out.println("Reproduciendo la pelicula: " + getTitle());
    }
}

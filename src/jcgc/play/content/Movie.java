package jcgc.play.content;

import java.time.LocalDate;

public class Movie {

    public String title;
    public String description;
    public int duration;
    public String genre;
    public LocalDate releaseDate;
    public double score;
    public boolean available;

    public Movie(String title, int duration, String genre) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.releaseDate = LocalDate.now();
        this.available = true;
    }

    public Movie(String title, int duration, String genre, double score) {
        this(title, duration, genre);
        this.giveScore(score);
    }

    public void play() {
        System.out.println("Playing: " + title);
    }

    public String getTechnicalDatasheet() {
        return title + " (" + releaseDate.getYear() + ")\n" +
                "Genre: " + genre + "\n" +
                "Score: " + score + "/5";
    }

    public void giveScore(double score) {
        if ( score >= 0 && score <= 5)
            this.score = score;
    }

    public boolean isPopular() {
        return score >= 4;
    }
}

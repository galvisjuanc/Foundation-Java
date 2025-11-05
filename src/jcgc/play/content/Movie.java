package jcgc.play.content;

import java.time.LocalDate;

public class Movie {

    private String title;
    private String description;
    private int duration;
    private Genre genre;
    private LocalDate releaseDate;
    private double score;
    private boolean available;

    public Movie(String title, int duration, Genre genre) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.releaseDate = LocalDate.now();
        this.available = true;
    }

    public Movie(String title, int duration, Genre genre, double score) {
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

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

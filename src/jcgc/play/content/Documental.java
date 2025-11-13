package jcgc.play.content;

public class Documental extends Content {

    private String narrator;

    public Documental(String title, int duration, Genre genre) {
        super(title, duration, genre);
    }

    public Documental(String title, int duration, Genre genre, double score, String narrator) {
        super(title, duration, genre, score);
        this.narrator = narrator;
    }

    public String getNarrator() {
        return narrator;
    }
}

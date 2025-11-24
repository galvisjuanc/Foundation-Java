package jcgc.play.content;

public class Documental extends Content implements Promocionable {

    private String narrator;

    public Documental(String title, int duration, Genre genre) {
        super(title, duration, genre);
    }

    @Override
    public void play() {
        System.out.println("Reproduciendo el documental: " + getTitle() + " narrado por " + getNarrator());
    }

    public Documental(String title, int duration, Genre genre, double score, String narrator) {
        super(title, duration, genre, score);
        this.narrator = narrator;
    }

    public String getNarrator() {
        return narrator;
    }

    @Override
    public String promocionar() {
        return "Discover the documental : " + this.getTitle() + " narrado por " + this.getNarrator();
    }
}

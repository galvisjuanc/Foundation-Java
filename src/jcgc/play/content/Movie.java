package jcgc.play.content;

public class Movie {

    public String title;
    public String description;
    public int duration;
    public String genre;
    public int releaseYear;
    public double score;
    public boolean available;

    public void play() {
        System.out.println("Playing: " + title);
    }

    public String getTechnicalDatasheet() {
        return title + " (" + releaseYear + ")\n" +
                "Genre: " + genre + "\n" +
                "Score: " + score + "/5";
    }

    public void giveScore(double score) {
        if ( score >= 0 && score <= 5)
            this.score = score;
    }
}
